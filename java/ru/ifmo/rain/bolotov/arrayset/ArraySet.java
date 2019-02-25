package ru.ifmo.rain.bolotov.arrayset;


import java.io.Serializable;
import java.util.*;


public class ArraySet<T> extends AbstractSet<T> implements SortedSet<T> {

    private List<T> list;
    private Comparator<? super T> comparator;
   

    public ArraySet() {
        list = Collections.emptyList();
    }

    public ArraySet(Collection<? extends T> c) {
        this(c, null);
    }


    public ArraySet(Collection<? extends T> c, Comparator<? super T> cmp) {
        Set<T> set = new TreeSet<>(cmp);
        set.addAll(c);
        list = new ArrayList<>(set);
        comparator = cmp;
    }

    private ArraySet(List<T> c, Comparator<? super T> cmp) {
        list = c;
        comparator = cmp;
        //test15 has passed, but wtf how to fix this without private constructor ?
    }

    public ArraySet(Comparator<? super T> cmp) {
        list = Collections.emptyList();
        comparator = cmp;
    }

    @Override
    public Iterator<T> iterator() {
        return Collections.unmodifiableList(list).iterator();
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        if (list.size() == 0) {
            return new ArraySet<>(comparator);
        }

        int start = getIndex(fromElement);
        int finish = getIndex(toElement);

        if (start == -1 || finish == -1 || start > finish) {
            return new ArraySet<>(comparator);
        }

        return new ArraySet<>(list.subList(start, finish), comparator);
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        if (list.size() == 0) {
            return new ArraySet<>(comparator);
        }
        return subSet(list.get(0), toElement);
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        int index = Collections.binarySearch(list, fromElement, comparator);
        if (index < 0) {
            index = -index - 1;
        }
        return new ArraySet<>(list.subList(index, list.size()), comparator);
    }

    @Override
    public T first() {
        checkNonEmpty();
        return list.get(0);
    }

    @Override
    public T last() {
        checkNonEmpty();
        return list.get(list.size() - 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        return (Collections.binarySearch(list, (T) Objects.requireNonNull(o), comparator) >= 0);
    }

    private int getIndex(T t) {
        int index = Collections.binarySearch(list, t, comparator);
        if (index < 0) {
            index = -index -1;
        }


        return  index;

    }

    private void checkNonEmpty() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("ArraySet is empty");
        }
    }
}