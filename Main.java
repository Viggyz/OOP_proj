import java.util.*;
import javax.swing.*;

public class Main {
    static JFrame f = new JFrame();
    static ArrayList<User> Users = new ArrayList<User>();
    static void login(){
        String name = "";
        try {
            name = JOptionPane.showInputDialog(f, "Enter your name", "LibSys", JOptionPane.PLAIN_MESSAGE).strip();
        }
        catch (NullPointerException e) {
            System.exit(1);
        }
        
        if (name.equals("") || name.length() < 3 || name.length() > 20) {
            JOptionPane.showMessageDialog(f, "Enter a valid name that has 3-20 characters", "LibSys", JOptionPane.ERROR_MESSAGE);
            login();
        }
        for(User U: Users) {
            if(U.getName().equals(name)) {
                homepage(U);
                return;
            }
        }
            User U1 = new User(name);
            Users.add(U1);
            homepage(U1); 
    }
    static void homepage(User U){
        Object[] options = {"Borrow Book","Return Book","Book List","Show Borrowed", "Logout"};
        int choice = JOptionPane.showOptionDialog(f, "Choose one of the following options", "LibSys", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        switch(choice+1) {
            case 1: U.borrowBook(); break;
            case 2: U.returnBook(); break;
            case 3: U.displayBooks(); break;
            case 4: U.showBorrowed(); break;
            case 5: login(); break;
            default: System.exit(1);
        }
        homepage(U);
    }

    public static void main(String args[]) {
        LibraryList.initialize();
        login();
    }
}
