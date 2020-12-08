import java.util.*;
import javax.swing.*;

import javax.swing.JOptionPane;

public class User {
    private String name;
    private ArrayList<Book> borrowed = new ArrayList<Book>();
    JFrame f = new JFrame();
    User(String name) {
        this.name = name;
    }
    ArrayList<Book> getBorrowed() {
        return borrowed;
    }
    String getName() {
        return name;
    }
    void showBorrowed() {
        if(borrowed.isEmpty()) {
            JOptionPane.showMessageDialog(f, "You haven't borrowed any books!", "LibSys", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        int i = 1;
        String s ="";
        for(Book b: borrowed) {
            s += i++ + ". " + b.getName() + "\n";
        }
        JOptionPane.showMessageDialog(f, 
            s,
         "LibSys",
          JOptionPane.PLAIN_MESSAGE);
    }
    void borrowBook() {
        ArrayList<Book> B1 = LibraryList.getAvailableBooks();
        String[] B = new String[B1.size()];
        int i = 0;
        for(Book b: B1) {
            B[i++] = b.getName();
        }
        if(B1.size()==0) {
            JOptionPane.showMessageDialog(f, "No available books", "LibSys", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(borrowed.size() == 3) {
            JOptionPane.showMessageDialog(f, "You cannot borrow more than 3 books!", "LibSys", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Object[] possibilities = B;
        String s = (String)JOptionPane.showInputDialog(
                    f,
                    "Select the book you want to borrow",
                    "LibSys",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    possibilities[0]);
        for(Book b: B1) {
            if(s == b.getName()){
                int choice = B1.indexOf(b);
                B1.get(choice).borrowBook(name);
                borrowed.add(B1.get(choice));
                JOptionPane.showMessageDialog(f, "You have borrowed:" + (B1.get(choice).getName()) + "\nThank you for borrowing!", "LibSys", JOptionPane.PLAIN_MESSAGE);
                break;
            }
        }
    }
    void returnBook() {
        if (borrowed.size() == 0) {
            JOptionPane.showMessageDialog(f, "You have no books to return!", "LibSys", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String[] B = new String[borrowed.size()];
        int i = 0;
        for(Book b: borrowed) {
            B[i++] = b.getName();
        }
        String[] possibilities = B;
        String s = (String)JOptionPane.showInputDialog(
                    f,
                    "Select the book you want to return",
                    "LibSys",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    possibilities[0]);
        for(Book b: borrowed) {
            if(s == b.getName()){
                int choice = borrowed.indexOf(b);
                LibraryList.returnBook(borrowed.get(choice));
                JOptionPane.showMessageDialog(f, "You have returned: " + (borrowed.get(choice).getName()) + "\nCome again!", "LibSys", JOptionPane.PLAIN_MESSAGE);
                borrowed.remove(choice);  
                break;
            }
        }
    }
    void displayBooks() {
        ArrayList<Book> Books = LibraryList.getBooks();
        String s = ""; int i=1;
        for(Book b: Books) {
            s += i++ + ". " + b.getName() + (b.isAvailable()?" ++Available":b.getBorrower().equals("")?" --Unavailable":" --Borrowed by: " + b.getBorrower()) + "\n";
        }
        JOptionPane.showMessageDialog(f, 
            s,
         "LibSys",
          JOptionPane.PLAIN_MESSAGE);
    }
}