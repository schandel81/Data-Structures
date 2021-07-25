class Book {
    String bookName;
    int bookId;
    String author;
    public Book(String bookName, int bookId, String author) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.author = author;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }


}
class BookPrinter {
    Book book;
    BookPrinter(Book book) {
        this.book = book;
    }
    public void printBook() {
        System.out.println(book.getBookName());
    }
    public void printIndex() {
        //TODO: Print book Index
    }
}
public class SingleResponsibility {

}
