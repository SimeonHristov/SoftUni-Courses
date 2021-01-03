package com.company.Exercise06ObjectClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArticlesExercise04Ver2 {
    static class articleClass {
        String title;
        String content;
        String author;

        public articleClass(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<articleClass> allArticles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] articleData = scanner.nextLine().split(", ");
            String articleTitle = articleData[0];
            String articleContent = articleData[1];
            String articleAuthor = articleData[2];

            articleClass articleClass = new articleClass(articleTitle, articleContent, articleAuthor);
            allArticles.add(articleClass);

        }

        String orderBy = scanner.nextLine();
        switch (orderBy){
            case "title":
                allArticles.sort(Comparator.comparing(articleClass::getTitle));
                break;
            case "content":
                allArticles.sort(Comparator.comparing(articleClass::getContent));
                break;
            case "author":
                allArticles.sort(Comparator.comparing(articleClass::getAuthor));
                break;
        }

        for (articleClass allArticle : allArticles) {
            System.out.println(allArticle.toString());
        }
    }
}

