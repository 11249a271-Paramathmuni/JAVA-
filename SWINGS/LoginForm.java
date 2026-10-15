SWING CONTROLS:


  PROGRAM::
  
import javax.swing.*;
import java.awt.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login");
        f.setLayout(new FlowLayout());

        JTextField user = new JTextField(12);
        JPasswordField pass = new JPasswordField(12);
        JButton ok = new JButton("Login");
        JLabel msg = new JLabel(" ");

        f.add(new JLabel("User Name"));
        f.add(user);
        f.add(new JLabel("Password"));
        f.add(pass);
        f.add(ok);
        f.add(msg);

        ok.addActionListener(e -> {
            String pwd = new String(pass.getPassword());

            if (user.getText().equals("cse") &&
                pwd.equals("java")) {
                msg.setText("Login successful");
            } else {
                msg.setText("Invalid user or password");
            }
        });

        f.setSize(230, 180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}



INPUT:
  Enter the following login details:
The correct credentials are:
- Username: cse
- Password: java

  OUTPUT:
User Name: cse
Password:  java

Login successful

  (OR)

  User Name: abc
Password:  123

Invalid user or password

  
  Result:
The program displays a login form with username and password fields and a Login button. When clicked, it checks the entered credentials and displays the appropriate message.
