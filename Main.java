import java.util.Scanner;

// Mahmoud Hamdy Mohamed Mostafa 2001300
public class Main {
    public static void main(String[] args) { // main method
        System.out.println("Tests for Vector class");
        Vector v0 = new Vector(); // Empty constructor
        v0.print(); // Print vector in both representations
        Vector v1 = new Vector(3, 4); // Constructor with arguments
        v1.print();
        System.out.println(v1.getX() + " " + v1.getY() + " " + v1.magnitude() + " " +
                v1.angle()); // Getter methods
        v1.setX(5); // Setter methods
        v1.setY(8);
        v1.print();
        Vector added = Vector.add(new Vector(1, 2), new Vector(2, 1)); // Add two vectors
        added.print();
        Vector subbed = Vector.sub(new Vector(1, 2), new Vector(0, 1)); // Sub two vector
        subbed.print();
        Vector[] vec_array = {new Vector(5, 5), new Vector(10, 10)}; // Average magnitude
        System.out.println(average_vector_magnitude(vec_array));

        Line line1 = new Line(0, 0, 3, 4); // Create line
        line1.print(); // Print line info

        System.out.println("\nTests for MyStringBuffer");
        MyStringBuffer myString = new MyStringBuffer("HelloWorld"); // Create string
        myString.print(); // Print string
        System.out.println(myString.length()); // Print length
        System.out.println(myString.indexOf('e')); // Print index of e
        myString.erase(2, 2); // erase 2 letters startings from index 2
        myString.print();
        myString.insert(2, "ww"); // Insert ww at index 2
        myString.print();

        System.out.println("\nTests for MyString"); // Same as above
        MyString myString2 = new MyString("HelloWorld");
        myString2.print();
        System.out.println(myString2.length());
        System.out.println(myString2.indexOf('e'));
        myString2.erase(2, 2);
        myString2.print();
        myString2.insert(2, "ww");
        myString2.print();
    }

    static double average_vector_magnitude(Vector[] array) { // Get average magnitude of vector array
        double total = 0; // Initialize variable 'total'
        for (Vector vector : array) { // Loop over array
            total += vector.magnitude(); // Add magnitude to total
        }
        return total / array.length; // Calculate and return average
    }
}

class Vector {
    private double x;
    private double y;
    Scanner input = new Scanner(System.in);

    Vector() {
        x = 0;
        y = 0;
    }

    Vector(double x_inp, double y_inp) {
        x = x_inp;
        y = y_inp;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    void setX(double x_inp) {
        x = x_inp;
    }

    void setY(double y_inp) {
        y = y_inp;
    }

    double magnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    double angle() {
        return Math.atan(y / x);
    }

    void print() {
        System.out.println("Vector: (" + x + "i + " + y + "j).");
        System.out.println("Vector: (" + magnitude() + " [" + angle() + "])");
    }

    static Vector add(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y+v2.y);
    }

    static Vector sub(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y);
    }

    void read(double x_inp, double y_inp) {
        System.out.println("Enter new X component:");
        x = input.nextDouble();
        System.out.println("Enter new Y component:");
        y = input.nextDouble();
    }
}

class Point {
    private double x;
    private double y;

    Point() {
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    void print() {
        System.out.println("Point X: " + x + ", Point Y: " + y);
    }
}

class Line {
    private Point point;
    private Vector vector;

    Line(){
    }

    Line(Point point, Vector vector) {
        this.point = point;
        this.vector = vector;
    }

    Line(double x1, double y1, double x2, double y2) {
        point = new Point(x1, y1);
        vector = new Vector(x2 - x1, y2 - y1);
    }

    void print() {
        System.out.printf("Line starts at (%f, %f), direction is [%f, %f]\n",
                point.getX(), point.getX(), vector.getX(), vector.getY());
    }
}

class MyStringBuffer {
    char[] array;

    MyStringBuffer() {
    }

    MyStringBuffer(String inp) {
        array = inp.toCharArray();
    }

    void print() {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+"");
        }
        System.out.println();
    }

    int length() {
        return array.length;
    }

    int indexOf(char c) {
        for (int i=0; i<array.length;i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }

    void erase(int index, int length) {
        char[] updated = new char[array.length - length];
        for (int i=0; i<index;i++) {
            updated[i] = array[i];
        }
        for (int i=index; i<array.length-length;i++) {
            updated[i] = array[i+length];
        }
        array = updated;
    }

    void insert(int index, String str) {
        char[] updated = new char[array.length + str.length()];
        for (int i=0; i<index;i++) {
            updated[i] = array[i];
        }
        for (int i=index; i<index+str.length();i++) {
            updated[i] = str.charAt(i-index);
        }
        for (int i=index+str.length(); i<updated.length;i++) {
            updated[i] = array[i-str.length()];
        }
        array = updated;
    }
}

class MyString {
    char[] array;

    MyString() {
    }

    MyString(String inp) {
        array = inp.toCharArray();
    }

    void print() {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+"");
        }
        System.out.println();
    }

    int length() {
        return array.length;
    }

    int indexOf(char c) {
        for (int i=0; i<array.length;i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }

    void erase(int index, int length) {
        char[] updated = new char[array.length - length];
        for (int i=0; i<index;i++) {
            updated[i] = array[i];
        }
        for (int i=index; i<array.length-length;i++) {
            updated[i] = array[i+length];
        }
        array = updated;
    }

    void insert(int index, String str) {
        char[] updated = new char[array.length + str.length()];
        for (int i=0; i<index;i++) {
            updated[i] = array[i];
        }
        for (int i=index; i<index+str.length();i++) {
            updated[i] = str.charAt(i-index);
        }
        for (int i=index+str.length(); i<updated.length;i++) {
            updated[i] = array[i-str.length()];
        }
        array = updated;
    }
}

//class Book {
//    Book() {
//        id = last_id + 1;
//        last_id++;
//    }
//
//    Book(String title, LocalDate release_date, double price) {
//        id = last_id + 1;
//        last_id++;
//        this.title = title;
//        this.release_date = release_date;
//        this.price = price;
//    }
//
//    static private int last_id = 0;
//    private int id;
//    private String title;
//    private LocalDate release_date;
//    private double price;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public LocalDate getRelease_date() {
//        return release_date;
//    }
//
//    public void setRelease_date(LocalDate release_date) {
//        this.release_date = release_date;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//}

//class TextBook extends Book {
//    int number_of_pages;
//    TextBook(String title, LocalDate release_date, double price, int number_of_pages) {
//        super(title, release_date, price);
//        this.number_of_pages = number_of_pages;
//    }
//
//    void print() {
//        System.out.printf("Textbook title: %s, ID: %d, Price: %f, Release Date: %s, Number of pages: %d \n",
//                getTitle(), getId(), getPrice(), getRelease_date(), number_of_pages);
//    }
//}

//class AudioBook extends Book {
//    double length;
//    AudioBook(String title, LocalDate release_date, double price, int length) {
//        super(title, release_date, price);
//        this.length = length;
//    }
//
//    void print() {
//        System.out.printf("Textbook title: %s, ID: %d, Price: %f, Release Date: %s, Length in minutes: %f \n",
//                getTitle(), getId(), getPrice(), getRelease_date(), length);
//    }
//}

//    Scanner input = new Scanner(System.in);
//    TextBook text1 = new TextBook("Text Book title 1", LocalDate.of(2023, 01, 01), 10, 100);
//    AudioBook audio1 = new AudioBook("Audio Book title 1", LocalDate.of(2023, 02, 02), 20, 300);
//        System.out.println("Enter number of books:");
//                int num_of_books = input.nextInt();
//                Book[] books = new Book[num_of_books];
//                for (int i=0; i<num_of_books; i++) {
//        System.out.println("Enter book type:");
//        String type = input.nextLine();
//        System.out.println("Enter book title:");
//        String title = input.nextLine();
//        System.out.println("Enter year of release:");
//        int year = input.nextInt();
//        System.out.println("Enter month of release:");
//        int month = input.nextInt();
//        System.out.println("Enter day of release:");
//        int day = input.nextInt();
//        System.out.println("Enter book price:");
//        double price = input.nextDouble();
//        if (type == "text") {
//        System.out.println("Enter number of pages:");
//        int number_of_pages = input.nextInt();
//        } else if (type == "audio") {
//        System.out.println("Enter audio book length in minutes:");
//        double length = input.nextDouble();
//        }
//        System.out.println("Enter book type:");
//
//        }