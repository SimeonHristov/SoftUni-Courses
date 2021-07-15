package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService,BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //printAllBooksAfterYear(2000);
        //printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //printAllAuthorsAndNumberOfTheirBooks();
        //pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
        System.out.println("Please provide exercise number: ");

        int exerciseNum = Integer.parseInt(bufferedReader.readLine());

        switch (exerciseNum) {
            case 1 -> booksTitlesByAgeRestriction();
            case 2 -> golderBook();
            case 3 -> booksByPrice();
            case 4 -> NotReleasedBooksByYear();
            case 5 -> findAllBooksBeforeDate();
            case 6 -> authorSearch();
            case 7 -> bookSearch();
            case 8 -> bookTitlesSearchByAuthorName();
            case 9 -> countBooksWithLongTitle();
            case 10-> totalBookCopies();
//            case 11 -> exerciseEleven();
//            case 12 -> exerciseTwelve();
//            case 13 -> exerciseThirteen();
            }

    }

    private void totalBookCopies() {
        authorService
                .findTotalBookCopiesByAuthor()
                .forEach(System.out::println);
    }

    private void countBooksWithLongTitle() throws IOException {
        System.out.println("Enter title length: ");
        int len = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService
                .findCountOfBooksWithTitleLongerThan(len));

    }

    private void bookTitlesSearchByAuthorName() throws IOException {
        System.out.println("Enter string");
        String input = bufferedReader.readLine();

        bookService
                .findAllBookTitlesByAuthor(input)
                .forEach(System.out::println);
    }

    private void bookSearch() throws IOException {
        System.out.println("Enter string: ");
        String input = bufferedReader.readLine().toUpperCase();

        bookService
                .findBooksByString(input)
                .forEach(System.out::println);
    }

    private void authorSearch() throws IOException {
        System.out.println("Enter letter: ");
        String input = bufferedReader.readLine();

        authorService
                .findAuthors(input)
                .forEach(System.out::println);
    }

    private void findAllBooksBeforeDate() throws IOException {
        System.out.println("Enter date: ");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService
                .findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);
    }

    private void NotReleasedBooksByYear() throws IOException {
        System.out.println("Enter year: ");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService
                .findAllNotReleasedBooksByYear(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService
                .findAllBookTitleWithPriceLessThan5OrMoreThan40()
                .forEach(System.out::println);
    }

    private void golderBook() {
        bookService
                .findAllGoldenBooksWithLessThan5000()
                .forEach(System.out::println);
    }

    private void booksTitlesByAgeRestriction() throws IOException {
        System.out.println("Enter age restriction: ");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());

        bookService.
                findAllBookTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
