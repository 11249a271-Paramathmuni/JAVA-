
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentApp {

    static void run(String sql, Object... v) {
        try (Connection c = Db.open();
             PreparedStatement p = c.prepareStatement(sql)) {

            for (int i = 0; i < v.length; i++)
                p.setObject(i + 1, v[i]);

            if (sql.trim().toUpperCase().startsWith("SELECT")) {
                try (ResultSet rs = p.executeQuery()) {
                    boolean found = false;

                    while (rs.next()) {
                        found = true;
                        System.out.println(rs.getString(1) + " "
                                + rs.getString(2) + " "
                                + rs.getInt(3));
                    }

                    if (!found)
                        System.out.println("No student found.");
                }
            } else {
                System.out.println(p.executeUpdate()
                        + " row(s) affected.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void showTable() {
        String sql = "SELECT * FROM student";

        try (Connection c = Db.open();
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet rs = p.executeQuery()) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"Register No", "Name", "Marks"}, 0);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("reg_no"),
                        rs.getString("name"),
                        rs.getInt("marks")
                });
            }

            JTable table = new JTable(model);
            JScrollPane pane = new JScrollPane(table);

            JFrame frame = new JFrame("Student Records");
            frame.add(pane, BorderLayout.CENTER);
            frame.setSize(500, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students (JTable)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Register number: ");
                    String reg = sc.nextLine();

                    System.out.print("Student name: ");
                    String name = sc.nextLine();

                    System.out.print("Marks: ");
                    int marks = sc.nextInt();
                    sc.nextLine();

                    run("INSERT INTO student VALUES (?, ?, ?)",
                            reg, name, marks);
                    break;

                case 2:
                    System.out.print("Register number to search: ");
                    reg = sc.nextLine();

                    run("SELECT * FROM student WHERE reg_no = ?", reg);
                    break;

                case 3:
                    System.out.print("Register number: ");
                    reg = sc.nextLine();

                    System.out.print("New marks: ");
                    marks = sc.nextInt();
                    sc.nextLine();

                    run("UPDATE student SET marks = ? WHERE reg_no = ?",
                            marks, reg);
                    break;

                case 4:
                    System.out.print("Register number to delete: ");
                    reg = sc.nextLine();

                    run("DELETE FROM student WHERE reg_no = ?", reg);
                    break;

                case 5:
                    showTable();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
