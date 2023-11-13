package main;

import book.Book;
import book.BookUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть к-сть книг, що хочете занести до таблиці: ");
        final int N = scanner.nextInt();
        scanner.nextLine(); // Clearing the newline
        Book[] books = new Book[N];

        for (int i = 0; i < books.length; i++) {
            books[i] = new Book();
            books[i].inputDataFromConsole();
        }

        BookUtils.firstTable(books);
        BookUtils.secondTable(books);
        BookUtils.thirdTable(books);

        scanner.close();
    }
}
