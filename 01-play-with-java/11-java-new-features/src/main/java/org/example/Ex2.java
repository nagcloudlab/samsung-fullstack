package org.example;

// default & static methods in interfaces


import java.util.Comparator;
import java.util.function.Consumer;

interface Collection<E>{
    void add( E e);
    void clear();
}

interface List<E> extends Collection<E>{
    void add(int index, E e);
    void remove(int index);
    default void forEach(Consumer<? super E> action){
    }
    static <E> List<E> of(E... elements){
        return null;
    }
}

interface Set<E> extends Collection<E>{
    void remove(E e);
}

abstract  class AbstractList<E> implements List<E>{
    @Override
    public void clear() {
        System.out.println("AbstractList.clear()");
    }
}

class ArrayList<E> extends AbstractList<E> implements List<E>{
    @Override
    public void add(E e) {
        System.out.println("ArrayList.add(E e)");
    }

    @Override
    public void add(int index, E e) {
        System.out.println("ArrayList.add(int index, E e)");
    }

    @Override
    public void remove(int index) {
        System.out.println("ArrayList.remove(int index)");
    }
}

class LinkedList<E> extends AbstractList<E> implements List<E>{
    @Override
    public void add(E e) {
        System.out.println("LinkedList.add(E e)");
    }

    @Override
    public void add(int index, E e) {
        System.out.println("LinkedList.add(int index, E e)");
    }

    @Override
    public void remove(int index) {
        System.out.println("LinkedList.remove(int index)");
    }
}

public class Ex2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(0, 20);
        list.remove(0);
        list.clear();

        list = new LinkedList<>();
        list.add(30);
        list.add(0, 40);
        list.remove(0);
        list.clear();

        list.forEach(item -> System.out.println(item));

        List.of(10, 20, 30, 40, 50).forEach(item -> System.out.println(item));


        Comparator<Integer> asc = (o1, o2) -> o1 - o2;
        Comparator<Integer> desc = asc.reversed();


    }
}
