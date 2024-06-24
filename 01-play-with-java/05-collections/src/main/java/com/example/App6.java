package com.example;

import com.example.model.Book;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class App6 {
    public static void main(String[] args) {

        Set<Book> books=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getYear(),o2.getYear());
            }
        });
        books.add(new Book("Java", "Nag",2019));
        books.add(new Book("Javascript", "Indu",2019));
        books.add(new Book("Scala", "Ria",2015));
        books.add(new Book("Python", "Diya",2018));

        for(Book book:books){
            System.out.println(book);
        }

    }
}
