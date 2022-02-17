package org.example.desginpattern.extend;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author dragon
 * @date 2021/11/16
 */
public class ExtendProblemTest {

    public static void main(String[] args) {
        InstrumentedHashSet<Integer> set = new InstrumentedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.addAll(Arrays.asList(6, 7,  1));
        System.out.println(set.getAddCount());

    }

    public static class InstrumentedHashSet<E> extends HashSet<E> {
        // The number of attempted element insertions
        private int addCount = 0;

        public InstrumentedHashSet() {}

        public InstrumentedHashSet(int initCap, float loadFactor) {
            super(initCap, loadFactor);
        }

        @Override public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }

    }
}
