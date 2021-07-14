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
//            case 4 -> exerciseFour(); //Employees with Salary over 50 000
//            case 5 -> exerciseFive(); //Employees from Department
//            case 6 -> exerciseSix(); //Adding a new Address and Updating Employee
//            case 7 -> exerciseSeven(); //Addresses with Employee Count
//            case 8 -> exerciseEight(); //Get Employee with Project
//            case 9 -> exerciseNine(); //Find latest 10 Projects
//            case 10-> exerciseTen(); //Increase Salaries
//            case 11 -> exerciseEleven(); //Find Employees by First Name
//            case 12 -> exerciseTwelve(); //Employees Maximum Salaries
//            case 13 -> exerciseThirteen(); //Remove Towns
            }

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
