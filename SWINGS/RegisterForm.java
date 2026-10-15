CASE STUDY:
  STUDENT REGISTRATION FORM:

PROGRAM;
CASE STUDY:
  ADD ACLEAR BUTTON THAT EMPTIES EVERY FEILD

  PROGRAM::
  
import javax.swing.*;
import java.awt.*;

public class RegisterForm {
    public static void main(String[] args) {
        JFrame f = new JFrame("Student Registration");
        f.setLayout(new FlowLayout());

        JTextField name = new JTextField(14);

        JComboBox<String> br = new JComboBox<>(
            new String[]{"CSE", "IT", "ECE"}
        );

        JRadioButton m = new JRadioButton("Male", true);
        JRadioButton fe = new JRadioButton("Female");

        ButtonGroup g = new ButtonGroup();
        g.add(m);
        g.add(fe);

        JButton sub = new JButton("Submit");
        JButton clear = new JButton("Clear");
        JLabel out = new JLabel(" ");

        f.add(new JLabel("Name"));
        f.add(name);
        f.add(new JLabel("Branch"));
        f.add(br);
        f.add(m);
        f.add(fe);
        f.add(sub);
        f.add(clear);
        f.add(out);

        sub.addActionListener(e -> {
            if (name.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    f, "Name cannot be empty"
                );
            } else {
                out.setText(
                    name.getText() + " | " +
                    br.getSelectedItem() + " | " +
                    (m.isSelected() ? "Male" : "Female")
                );
            }
        });

        clear.addActionListener(e -> {
            name.setText("");
            br.setSelectedIndex(0);
            m.setSelected(true);
            out.setText(" ");
        });

        f.setSize(320, 220);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

INPUT:
Name: Ravi
Branch: CSE
Gender: Male

  OUTPUT:
  Case 1: After clicking Submit
  Ravi | CSE | Male


  Case 2: After clicking Clear
  Name: [empty]
  Branch: CSE (default selection)
  Gender: Male (default selection)
  Output: [empty]


  Case 3: Submit with an empty name
  
  Name cannot be empty


A message dialog appears.


  Result:
The program registers student details and displays them when Submit is clicked. The Clear button resets all fields to their initial states and removes the displayed output.
