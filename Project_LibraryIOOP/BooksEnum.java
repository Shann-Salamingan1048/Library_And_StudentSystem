package Project_LibraryIOOP;

public class BooksEnum {
    enum Books{
        Book1("The Legend of the Monkey King", 256125, 642),
        Book2("The Great Hero of the galaxy", 52642,982),
        Book3("He Who Writes", 9159875,555),
        Book4("I He who was feared by fear", 82164, 489);
        private String Book_name;
        private int Book_number;
        private int Book_price;
        public void setBook_name(String book_name){
            this.Book_name = book_name;
        }
        public String getBook_name(){
            return Book_name;
        }
        public void setBook_number(int book_number){
            this.Book_number = book_number;
        }
        public int getBook_number(){
            return Book_number;
        }
        public void setBook_price(int book_price){
            this.Book_price = book_price;
        }
        public int getBook_price(){
            return Book_price;
        }
        Books(){
            this.Book_name = "Unknown";
            this.Book_number = 0;
            this.Book_price = 0;
        }
        Books(String book_name, int book_number, int book_price){
            this.Book_name = book_name;
            this.Book_number = book_number;
            this.Book_price = book_price;
        }
    }


}
