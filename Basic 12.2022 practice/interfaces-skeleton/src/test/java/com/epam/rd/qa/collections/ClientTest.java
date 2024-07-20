package com.epam.rd.qa.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    static final Deposit[] DEPOSITS = new Deposit[]{
            new SpecialDeposit(new BigDecimal("1000.1"), 35),
            new SpecialDeposit(new BigDecimal("1000.1"), 36),
            new SpecialDeposit(new BigDecimal("1000"), 35),
            new SpecialDeposit(new BigDecimal("1000"), 36),
            new SpecialDeposit(new BigDecimal("1"), 1),
            new LongDeposit(new BigDecimal("3000"), 35),
            new LongDeposit(new BigDecimal("3000"), 36),
            new LongDeposit(new BigDecimal("2999.99"), 36),
            new LongDeposit(new BigDecimal("2999.99"), 35),
            new LongDeposit(new BigDecimal("1"), 1),
    };

    @Test
    void testDefaultConstructor() throws ReflectiveOperationException {
        Class<Client> clientClass = Client.class;
        Field depositsField = clientClass.getDeclaredField("deposits");
        Client client = new Client();
        depositsField.setAccessible(true);
        int length = Array.getLength(depositsField.get(client));
        assertEquals(10, length, "The length of 'deposits' field " +
                "must be 10");
    }

    @Test
    void testConstructorWithParameter() throws ReflectiveOperationException {
        Class<Client> clientClass = Client.class;
        Field depositsField = clientClass.getDeclaredField("deposits");
        Client client = new Client(DEPOSITS);
        depositsField.setAccessible(true);
        int length = Array.getLength(depositsField.get(client));
        assertEquals(DEPOSITS.length, length, "The length of 'deposits' field " +
                "must be " + DEPOSITS.length);
        assertThrows(IllegalArgumentException.class, () -> new Client(null));
        assertThrows(IllegalArgumentException.class, () -> new Client(new Deposit[]{}));
    }

    @Test
    void testAddDeposit() {
        Client client = new Client();
        for (Deposit deposit : DEPOSITS) {
            assertTrue(client.addDeposit(deposit));
        }
        assertFalse(client.addDeposit(DEPOSITS[0]));
        assertFalse(client.addDeposit(DEPOSITS[0]));
    }

    @Test
    void testIterator() {
        Deposit[] expected = generateDeposits(5, 2).toArray(Deposit[]::new);
        List<Deposit> actual = new ArrayList<>();
        Client client = new Client(expected);
        for (Deposit deposit : client) {
            actual.add(deposit);
        }
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    void testSort() {
        Deposit[] deposits = generateDeposits(5, 2).toArray(Deposit[]::new);
        Client client = new Client();
        for(Deposit deposit : deposits) {
            client.addDeposit(deposit);
        }
        client.sortDeposits();
        List<Deposit> actual = new ArrayList<>();
        for (Deposit deposit : client) {
            actual.add(deposit);
        }
        Deposit[] expected = generateSortedDeposits(5, 2).toArray(Deposit[]::new);
        assertArrayEquals(expected, actual.toArray());
    }

    @ParameterizedTest
    @MethodSource("casesCountPossibleToProlongDeposit")
    void testCountPossibleToProlongDeposit(Client client, int expected) {
        int actual = client.countPossibleToProlongDeposit();
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesCountPossibleToProlongDeposit() {
        return Stream.of(
                Arguments.of(new Client(generateDeposits(10, 5).toArray(Deposit[]::new)), 7),
                Arguments.of(new Client(generateDeposits(7, 15).toArray(Deposit[]::new)), 3)
        );
    }

    static Stream<Deposit> generateDeposits(int limit, int seed) {
        Random r = new Random(seed);
        return r.ints(limit, 5, 40)
                .mapToObj(v -> v % 2 == 0
                        ? new SpecialDeposit(new BigDecimal(v + ""), v)
                        : new LongDeposit(new BigDecimal(v + ""), v));
    }

    static Stream<Deposit> generateSortedDeposits(int limit, int seed) {
        Random r = new Random(seed);
        return r.ints(limit, 5, 40).map(i -> -i)
                .sorted().map(i -> -i)
                .mapToObj(v -> v % 2 == 0
                        ? new SpecialDeposit(new BigDecimal(v + ""), v)
                        : new LongDeposit(new BigDecimal(v + ""), v));
    }
}