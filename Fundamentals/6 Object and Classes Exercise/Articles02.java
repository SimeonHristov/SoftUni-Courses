package com.company.Exercise06ObjectClasses;

import java.util.ArrayList;
import java.util.Scanner;

public class Articles02 {

    static class articleClass {
        String title;
        String content;
        String author;

        public articleClass(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }


        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }


        public void renameTitle(String title) {
            this.title = title;
        }

        public void editContent(String content) {
            this.content = content;
        }

        public void changeAuthors(String author) {
            this.author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());

        }

        ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleData = scanner.nextLine().split(", ");
        String articleTitle = articleData[0];
        String articleContent = articleData[1];
        String articleAuthor = articleData[2];
        articleClass articleClass = new articleClass(articleTitle, articleContent, articleAuthor);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(": ");
            String command = tokens[0];
            switch (command){
                case "Edit":
                    articleClass.editContent(tokens[1]);
                    break;
                case "ChangeAuthor":
                    articleClass.changeAuthors(tokens[1]);
                    break;
                case "Rename":
                    articleClass.renameTitle(tokens[1]);
                    break;
            }

        }

        System.out.println(articleClass.toString());
    }
}
