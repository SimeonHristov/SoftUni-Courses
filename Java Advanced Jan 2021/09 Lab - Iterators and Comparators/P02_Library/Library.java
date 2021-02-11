package _16_IteratorsAndComparators_LAB.P02_Library;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library implements Iterable<Book> {

    private Book[] books;

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
        }



        Iterator<Book> bookIterator = new Iterator<Book>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < books.length;
            }

            @Override
            public Book next() {
                return books[index++];
            }
        };
        return bookIterator;
    }
}
