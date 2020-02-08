package fr.cnam.tp5;

import java.util.TreeSet;

public class SetSet extends TreeSet<Integer> implements Set {
    @Override
    public int cardinal() {
        return this.size();
    }

    @Override
    public boolean contains(int e) {
        return this.contains((Integer) e);
    }

    @Override
    public void add(int e) {
        this.add((Integer) e);
    }

    @Override
    public void remove(int e) {
        this.remove((Integer) e);
    }

    @Override
    public int min() {
        Integer min = null;
        for (int e : this) {
            if (min == null || e < min) {
                min = e;
            }
        }
        if (min == null) {
            min = 0;
        }
        return min;
    }
}
