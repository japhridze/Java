package com.epam.rd.autocode.collection.array;

import java.util.Optional;

public class SimpleArrayListImpl implements SimpleArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final double INCREASE_LOAD_FACTOR = 0.75;
    private static final double DECREASE_LOAD_FACTOR = 0.4;
    private Object[] elements;
    private int size;

    public SimpleArrayListImpl() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean add(Object element) {
        if (element == null) {
            throw new NullPointerException("The list cannot contain null elements.");
        }
        if (size >= elements.length * INCREASE_LOAD_FACTOR) {
            increaseCapacity();
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    @Override
    public Optional<Object> remove(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null; // help GC
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public boolean decreaseCapacity() {
        if (size <= elements.length * DECREASE_LOAD_FACTOR) {
            int newCapacity = size * 2;
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
            return true;
        }
        return false;
    }

    private void increaseCapacity() {
        int newCapacity = (int) (elements.length * 2 * INCREASE_LOAD_FACTOR);
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}