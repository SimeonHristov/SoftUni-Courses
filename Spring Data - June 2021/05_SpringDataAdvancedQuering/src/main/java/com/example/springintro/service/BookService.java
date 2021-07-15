package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBookTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldenBooksWithLessThan5000();

    List<String> findAllBookTitleWithPriceLessThan5OrMoreThan40();

    List<String> findAllNotReleasedBooksByYear(int year);

    List<String> findAllBooksBeforeDate(LocalDate localDate);

    List<String> findBooksByString(String input);

    List<String> findAllBookTitlesByAuthor(String input);

    int findCountOfBooksWithTitleLongerThan(int len);

    int increaseCopiesByDate(LocalDate localDate, int copies);

    Book getBookByTitle(String title);

}
