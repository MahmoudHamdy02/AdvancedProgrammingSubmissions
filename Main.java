import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

// Mahmoud Hamdy Mohamed Mostafa 2001300
public class Main {
    public static void main(String[] args) { // main method
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of books: ");
        int num = input.nextInt();
        Book[] bookArray = new Book[num];

        for (int i=0; i < num; i ++) {
            // Discard new line character \n
            input.nextLine();
            System.out.println("Enter book " + (i+1) + " type (audio, text):");
            String type = input.nextLine();
            System.out.println("Enter book " + (i+1) + " title:");
            String title = input.nextLine();
            System.out.println("Enter book " + (i+1) + " release date (YYYY-MM-DD): ");
            String releaseDate = input.nextLine();
            System.out.println("Enter book " + (i+1) + " price:");
            double price = input.nextDouble();
            if (type.equals("audio")) {
                System.out.println("Enter book " + (i+1) + " length in minutes:");
                double minutes = input.nextDouble();
                bookArray[i] = new AudioBook(title, LocalDate.parse(releaseDate), price, minutes);
            }
            if (type.equals("text")) {
                System.out.println("Enter book "+ (i+1) + " number of pages:");
                int numOfPages = input.nextInt();
                bookArray[i] = new TextBook(title, LocalDate.parse(releaseDate), price, numOfPages);
            }
        }
        for (Book book : bookArray) {
            System.out.println(book.toString());
        }
    }
}

class Book {
    private int id;
    private String title;
    private LocalDate releaseDate;
    private double price;
    private static int currentId = 0;

    Book() {
        id = ++currentId;
    }
    Book(String title, LocalDate releaseDate, double price) {
        id = ++currentId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public LocalDate getReleaseDate() {return releaseDate;}
    public void setReleaseDate(LocalDate releaseDate) {this.releaseDate = releaseDate;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString() {
        return String.format("Book ID: %d, Title: %s, Release date: %s, Price: %f", id, title, releaseDate, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && title.equals(book.title) && releaseDate.equals(book.releaseDate);
    }
}

class TextBook extends Book {
    private int numOfPages;

    TextBook() {
        super();
    }
    TextBook(String title, LocalDate releaseDate, double price, int numOfPages) {
        super(title, releaseDate, price);
        this.numOfPages = numOfPages;
    }

    @Override
    public String toString() {
        return String.format("Book ID: %d, Title: %s, Release date: %s, Price: %f, Number of Pages: %d", super.getId(), super.getTitle(), super.getReleaseDate(), super.getPrice(), numOfPages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TextBook textBook = (TextBook) o;
        return numOfPages == textBook.numOfPages && super.getId() == textBook.getId() && super.getTitle().equals(textBook.getTitle()) && super.getReleaseDate().equals(textBook.getReleaseDate());
    }
}

class AudioBook extends Book {
    private double minutes;

    AudioBook() {
        super();
    }
    AudioBook(String title, LocalDate releaseDate, double price, double minutes) {
        super(title, releaseDate, price);
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return String.format("Book ID: %d, Title: %s, Release date: %s, Price: %f, Length in minutes: %f", super.getId(), super.getTitle(), super.getReleaseDate(), super.getPrice(), minutes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AudioBook audioBook = (AudioBook) o;
        return minutes == audioBook.minutes && super.getId() == audioBook.getId() && super.getTitle().equals(audioBook.getTitle()) && super.getReleaseDate().equals(audioBook.getReleaseDate());
    }
}