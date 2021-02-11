package _16_IteratorsAndComparators_LAB.P03_ComparableBook;

import _16_IteratorsAndComparators_LAB.P02_Library.Book;

import java.util.Iterator;

public class Library implements Iterable<_16_IteratorsAndComparators_LAB.P02_Library.Book> {

    private class LibraryIterator implements  Iterator<_16_IteratorsAndComparators_LAB.P02_Library.Book>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public _16_IteratorsAndComparators_LAB.P02_Library.Book next() {
            return books[index++];
        }
    }

    private _16_IteratorsAndComparators_LAB.P02_Library.Book[] books;

    public void setBooks(_16_IteratorsAndComparators_LAB.P02_Library.Book[] books) {
        this.books = books;
    }

    public Library(_16_IteratorsAndComparators_LAB.P02_Library.Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }


}
