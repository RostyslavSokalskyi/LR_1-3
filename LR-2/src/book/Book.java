package book;

import java.util.Scanner;

public class Book {
    private int id;
    private static int nextId = 1;
    private String name;
    private String author;
    private String publisher;
    private int yearOfPublication;
    private int nPage;
    private double price;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getAuthor() {
        return author;
    }


    public String getPublisher() {
        return publisher;
    }


    public int getYearOfPublication() {
        return yearOfPublication;
    }


    public int getnPage() {
        return nPage;
    }


    public double getPrice() {
        return price;
    }


    public Book() {
        this.id = nextId++;
    }


    public void inputDataFromConsole() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Книга №" + id + ": ");
        name = scan.nextLine();
        System.out.print("Автор книги: ");
        author = scan.nextLine();
        System.out.print("Видавництво: ");
        publisher = scan.nextLine();
        System.out.print("Рік видання: ");
        yearOfPublication = scan.nextInt();
        System.out.print("К-сть сторінок: ");
        nPage = scan.nextInt();
        System.out.print("Ціна: ");
        price = scan.nextDouble();
        System.out.print("\n\n");
    }

    @Override
    public String toString() {
        return String.format("| %-2d | %-30s | %-20s | %-20s | %-11d |%-15d| %-6.2f |",
                id, name, author, publisher, yearOfPublication, nPage, price);
    }

}
