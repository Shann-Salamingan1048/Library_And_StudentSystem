package Project_LibraryIOOP;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library extends BooksEnum implements BorrowOrBuy {
    Scanner scan = new Scanner(System.in);
    private int School_ID;
    private String Book_user_name;
    private int User_age;
    Books Book1 = Books.Book1;
    Books Book2 = Books.Book2;
    Books Book3 = Books.Book3;
    Books Book4 = Books.Book4;

    public void setSchool_ID(int school_id) {
        this.School_ID = school_id;
    }

    public int getSchool_ID() {
        return School_ID;
    }

    public void setBook_user_name(String book_user_name) {
        this.Book_user_name = book_user_name;
    }

    public String getBook_user_name() {
        return Book_user_name;
    }
    public void setUser_age(int user_age){
        this.User_age = user_age;
    }
    public int getUser_age(){
        return User_age;
    }


    Library() {
        this.School_ID = 0;
        this.Book_user_name = "Unknown";
        this.User_age = 0;
    }

    Library(int user_age, String book_user_name, int school_ID) {
        this.School_ID = school_ID;
        this.Book_user_name = book_user_name;
        this.User_age = user_age;
    }

    @Override
    public void BorrowBook() {
        boolean true_or_false = true;
        while(true_or_false) {
            if (User_age >= 9) {
                System.out.println("Choose");
                System.out.println("1. Book1");
                System.out.println("2. Book2");
                System.out.println("3. Book3");
                System.out.println("4. Book4");
                try {
                    int ChooseBook = scan.nextInt();
                    System.out.println();
                    switch (ChooseBook) {
                        case 1:
                            borrowBookDetails(Book1);
                            true_or_false = false;
                            break;
                        case 2:
                            borrowBookDetails(Book2);
                            true_or_false = false;
                            break;
                        case 3:
                            borrowBookDetails(Book3);
                            true_or_false = false;
                            break;
                        case 4:
                            borrowBookDetails(Book4);
                            true_or_false = false;
                            break;
                        default:
                            Try_again(2);
                            break;
                    }
                } catch (InputMismatchException ie) {// for mismatch input like int and you inputted a string or double or etc on it
                    Try_again(1);
                }
            }
            else if (User_age >= 1) {
                System.out.println("Too young to borrow");
                true_or_false = false;
            }
            else {
                System.out.println("Can not borrow because Unknown age");
                true_or_false = false;
            }
        }
    }
    private void Try_again(int default_or_catch){
        if(default_or_catch == 1) { // for catch
            System.out.println("It must be a number or an integer");
            handle_delay(1.5);
            System.out.println("Try Again");
            scan.nextLine();// Clear the invalid input from the scanner
            handle_delay(1.5);
        }
        else if(default_or_catch == 2){ // for default
            System.out.println("Out of Option");
            handle_delay(1.5);
            System.out.println("Try Again");
            scan.nextLine();// Clear the invalid input from the scanner
            handle_delay(1.5);
        }
    }

    private void borrowBookDetails(Books book) { // making it private so that it cannot be access in main
        System.out.println("You have borrowed " + "\u001B[31m"+ book + "\u001B[0m"); // red and reset
        /*
         Foreground (Text) Colors:
        Black: \u001B[30m
        Red: \u001B[31m
        Green: \u001B[32m
        Yellow: \u001B[33m
        Blue: \u001B[34m
        Magenta: \u001B[35m
        Cyan: \u001B[36m
        White: \u001B[37m

        Background Colors:
        Black: \u001B[40m
        Red: \u001B[41m
        Green: \u001B[42m
        Yellow: \u001B[43m
        Blue: \u001B[44m
        Magenta: \u001B[45m
        Cyan: \u001B[46m
        White: \u001B[47m

        Reset All Formatting and Colors: \u001B[0m
        */
        System.out.printf("%-20s%-20s%n", "Title:", book.getBook_name());
        System.out.printf("%-20s%-20d%n", "Book Number:", book.getBook_number());
        System.out.printf("%-20s%-20s%n", "Borrower name:", "\u001B[34m" + Book_user_name + "\u001B[0m");
        System.out.printf("%-20s%-20d%n", "ID:", School_ID);
        System.out.printf("%-20s%-20d%n", "Age:", User_age);
    }
    private void handle_delay(double seconds){
        int millisec = (int) (seconds * 1000);
        try {
            Thread.sleep(millisec); // Sleep for 1.5 seconds
        } catch (InterruptedException ex) {
            System.out.println("Thread sleep interrupted");
        }
    }

    @Override
    public void BuyBook(int Money) {
        boolean true_or_false = true;
        while(true_or_false) {
            System.out.println("Choose");
            System.out.println("1. Book1");
            System.out.println("2. Book2");
            System.out.println("3. Book3");
            System.out.println("4. Book4");
            try {
                int ChooseBook = scan.nextInt();
                System.out.println();
                switch (ChooseBook) {
                    case 1:
                        buyBookDetails(Book1, Money);
                        true_or_false = false;
                        break;
                    case 2:
                        buyBookDetails(Book2, Money);
                        true_or_false = false;
                        break;
                    case 3:
                        buyBookDetails(Book3, Money);
                        true_or_false = false;
                        break;
                    case 4:
                        buyBookDetails(Book4, Money);
                        true_or_false = false;
                        break;
                    default:
                        Try_again(2);
                        break;
                }
            } catch (InputMismatchException ie) {// for mismatch input like int and you inputted a string on it
                Try_again(1);
            }
        }
    }

    private void buyBookDetails(Books book, int Money) {
        if (Money >= book.getBook_price()) {
            System.out.println("You have bought " + book);
            System.out.printf("%-20s%-20s%n", "Title:", book.getBook_name());
            System.out.printf("%-20s%-20d%n", "Book Number:", book.getBook_number());
            System.out.printf("%-20s%-20s%n", "Borrower name:", Book_user_name);
            System.out.printf("%-20s%-20d%n", "ID:", School_ID);
            System.out.printf("%-20s%-20d%n", "Age:", User_age);
            System.out.printf("%-20s%-20d%n", "Money:", Money);
            System.out.printf("%-20s%-20d%n", "Price of Book:", book.getBook_price());
            System.out.printf("%-20s%-20d%n", "Change:", (Money - book.getBook_price()));
        } else {
            System.out.println("Money insufficient");
            System.out.println("The " + book + " cost " + book.getBook_price());
        }
    }
}
