import java.util.*;

public class Main {
    Scanner Sc = new Scanner(System.in);
    String name;
    ArrayList<User> Users = new ArrayList<User>();
    BookList B = new BookList();
    UI UI1 = new UI();
    void login(){
        /*System.out.println("Enter your name:");
        name = Sc.next();*/
        name = UI1.login();
        if(Users.stream().anyMatch(i -> i.getName().equals(name))) {
            for( User U2: Users) {
                if(U2.getName().equals(name)) {
                    System.out.println("Welcome " + name);
                    homepage(U2);
                }
            }
        }
        else {
            User U1 = new User(name);
            Users.add(U1);
            System.out.println("Welcome " + name);
            homepage(U1);
        } 
    }
    void homepage(User U){
        UI1.homepage(U,B);
    }

    public static void main(String args[]) {
        Main M = new Main();
        M.login();
    }
}
