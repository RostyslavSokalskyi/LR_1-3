package book;

import java.util.Objects;
import java.util.Scanner;

public class BookUtils {
    public static void printTablesInfo() {
        System.out.format("| %-2s | %-30s | %-20s | %-20s | %-11s | %-15s | %-6s |%n",
                "№", "Назва", "Автор", "Видавництво", "Рік видання", "К-сть сторінок", "Ціна");
    }

    public static void createTable(Book book) {
        System.out.format("| %-2d | %-30s | %-20s | %-20s | %-11d |%-15d| %-6f |%n", book.getId(), book.getName(), book.getAuthor(), book.getPublisher(), book.getYearOfPublication(), book.getnPage(), book.getPrice());

    }

    public static void firstTable(Book[] book) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть автора, список книг якого ви хочете вивести: ");
        String author = scanner.nextLine();

        int count = 0;
        for (Book value : book) {
            if (Objects.equals(author, value.getAuthor()) && count == 0) {
                count++;
                System.out.println("Таблиця книг " + author + ":");
                printTablesInfo();
                createTable(value);
            } else if (Objects.equals(author, value.getAuthor())) {
                createTable(value);
            }
        }
        if (count == 0) System.out.println("Книг " + author + "не знайдено");


    }

    public static void secondTable(Book[] book) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть видавництво, книжки якого ви хочете отримати: ");
        String publisher = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < book.length; i++) {
            if (Objects.equals(publisher, book[i].getPublisher()) & count == 0) {
                count++;
                System.out.println("Таблиця книг " + publisher + ":");
                printTablesInfo();
                createTable(book[i]);
            } else if (Objects.equals(publisher, book[i].getPublisher())) {
                createTable(book[i]);
            }
        }
        if (count == 0) System.out.println("Книг видавництва \"" + publisher + "\" не знайдено");


    }

    public static void thirdTable(Book[] book) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Книги від якого року ви хочете отримати: ");
        int yearOfPublication = scanner.nextInt();

        int count = 0;
        for (int i = 0; i < book.length; i++) {
            if (yearOfPublication < book[i].getYearOfPublication() & count == 0) {
                count++;
                System.out.println("Книги випущені після " + yearOfPublication + "року: ");
                printTablesInfo();
                createTable(book[i]);
            } else if (yearOfPublication < book[i].getYearOfPublication()) {
                createTable(book[i]);
            }
        }
        if (count == 0) System.out.println("Книг, що випущені після " + yearOfPublication + "р. не знайдено");
    }
}
