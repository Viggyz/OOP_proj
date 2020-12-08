import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class LibraryList {
    private static ArrayList<Book> Books = new ArrayList<Book>();
    private LibraryList() {};
    static void initialize() {
        try{
            File booklist_input_file = new File("booklist.txt");
            Scanner inp = new Scanner(booklist_input_file);
            while(inp.hasNextLine()) {
                String s = inp.nextLine();
                Books.add(new Book(s));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void returnBook(Book book) {
        for(Book b : Books) {
            if(b.getName().equals(book.getName())) {
                b.returnBook();
            }
        }
    } 

    static Book getBook(int i) {
        return Books.get(i);
    }

    static ArrayList<Book> getBooks() {
        return Books;
    }

    static ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> B = new ArrayList<Book>();
        int i=0;
        for(Book b: Books) 
            if(b.isAvailable()){
                B.add(b);i++;
            }
        return B;   
    } 
}
