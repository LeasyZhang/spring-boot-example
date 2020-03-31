package com.springboot.example.util;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BatchGenerator<T> implements Iterable<List<T>> {

    private final List<T> data;
    private final int batchSize;

    public BatchGenerator(List<T> data, int batchSize) {
        this.data = data;
        this.batchSize = batchSize;
    }

    class Itr implements Iterator<List<T>> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < data.size();
        }

        @Override
        public List<T> next() {
            if (cursor >= data.size()) {
                throw new NoSuchElementException();
            }
            List<T> result;
            if (cursor + batchSize < data.size()) {
                result = data.subList(cursor, cursor + batchSize);
                cursor += batchSize;
            } else {
                result = data.subList(cursor, data.size());
                cursor = data.size();
            }
            return result;
        }
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new Itr();
    }
}
