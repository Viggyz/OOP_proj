import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UI extends Frame {
    JFrame f = new JFrame();
    JLabel l1,l2;
    JButton b1,b2,b3,b4;
    JList<String> list;
    String name;
    String login() {
        return JOptionPane.showInputDialog(f,"Enter name","LibSys",JOptionPane.PLAIN_MESSAGE);
    }
    void homepage(User U,BookList B)  {
        /*Object[] options = {
            "Borrow Book",
            "Return Book",
            "Booklist",
            "Logout"
        };
        JLabel l1,l2;  
        int n = JOptionPane.showOptionDialog(f, "Choose and action from the options below", "LibSys", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return n+1;*/
        boolean flag = false;
        l1 = new JLabel("Choose and action from the options below");
        l1.setBounds(50,25,250,50);

        b1 = new JButton("Borrow Book");
        b1.setBounds(50,80,150,40);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                U.borrowBook(B);
            }
        });
        b2 = new JButton("Return Book");
        b2.setBounds(210,80,150,40);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                U.returnBook(B);
            }
        });
        b3 = new JButton("Book List");
        b3.setBounds(370,80,150,40);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                B.displayBookList();
            }
        });
        b4 = new JButton("Logout");
        b4.setBounds(530,80,150,40);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });

        l2 = new JLabel("Books Borrowed");
        l2.setBounds(50,140,100,20);

        f.add(l1);f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(l2);
        JLabel[] ls = new JLabel[U.getBorrowed().size()];
        int i = 0;
        for(int b=0;b<U.getBorrowed().size();b++) {
            ls[b] = new JLabel("--" + U.getBorrowed().get(b).getName());
            ls[b].setBounds(50,170+i,200,20);
            i++;
            f.add(ls[b]);
            
        }
        //f.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        f.setSize(750,400);  
        f.setLayout(null);//using no layout manager  
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    public static void main(String args[]) {
        UI U = new UI();
        System.out.println(U.name);
    }
}
