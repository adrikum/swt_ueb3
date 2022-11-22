/*
 * (c) 2013-2021  Heinrich Hussmann und Uwe Aßmann, TU Dresden
 */

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Achtung! Einige der Methoden sind fehlerhaft und müssen repariert werden.
 */
public class SimpleLinkedList<E> extends AbstractCollection<E> implements Collection<E> {
    private class Elem {
        private E elem;
        private Elem next;

        public Elem(E elem, Elem next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Elem start = null;
    private Elem end = null;
    private int size = 0;

    @Override
    public boolean add(E o) {
        Elem e = new Elem(o, null);
        if (start == null) {
            start = e;
        }
        if (end != null) {
            end.next = e;
        }
        end = e;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private class Iter implements Iterator<E> {
        private Elem current;
        private Elem prev;
        private boolean removed;

        public Iter() {
            prev = null;
            current = new Elem(null, start);
            removed = false;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if(!removed) prev = current;
            else removed = false;
            Elem testing = current;
            current = current.next;
            return current.elem;
        }

        @Override
        public void remove() {
            if(removed || prev == null) {
                throw new IllegalStateException("current element was already removed");
            } else if(current == start) {
                start = start.next;
            }

            prev.next = current.next;
            removed = true;
            size--;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        boolean first = true;

        for(E e : this) {
            if(first) first = false;
            else str.append(", ");
            str.append(e);
        }

        str.append("]");
        return str.toString();
    }
}
