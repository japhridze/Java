package com.epam.rd.autotasks.collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage {
    private List<Box> storage = new ArrayList<>();

    @Override
    public boolean acceptBox(Box box) {
        if (box == null) throw new NullPointerException("Box cannot be null");
        return storage.add(box);
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        if (boxes == null || boxes.contains(null)) throw new NullPointerException("Boxes collection cannot be null or contain null elements");
        return storage.addAll(boxes);
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if (boxes == null || boxes.contains(null)) throw new NullPointerException("Boxes collection cannot be null or contain null elements");
        return storage.removeAll(boxes);
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        List<Box> removed = new ArrayList<>();
        for (Iterator<Box> iterator = storage.iterator(); iterator.hasNext(); ) {
            Box box = iterator.next();
            if (predicate.test(box)) {
                removed.add(box);
                iterator.remove();
            }
        }
        return removed;
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("Weight must be greater than 0");
        return searchBoxes(box -> box.getWeight() < weight);
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) {
        if (cost == null) throw new NullPointerException("Cost cannot be null");
        if (cost.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Cost must be non-negative");
        return searchBoxes(box -> box.getCost().compareTo(cost) > 0);
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        if (volume < 0) throw new IllegalArgumentException("Volume must be non-negative");
        return searchBoxes(box -> box.getVolume() >= volume);
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        List<Box> found = new ArrayList<>();
        for (Box box : storage) {
            if (predicate.test(box)) {
                found.add(box);
            }
        }
        return found;
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        if (predicate == null) throw new NullPointerException("Predicate cannot be null");
        if (newOfficeNumber <= 0) throw new IllegalArgumentException("New office number must be positive");
        for (Box box : storage) {
            if (predicate.test(box)) {
                box.setOfficeNumber(newOfficeNumber);
            }
        }
    }
}