RESULT REPORT FROM A FILE 
 RESULT OF THE FILE 
USE CASE:
PRINT THE TOPPER NAME AS WELL:
  PROGRAM:

  
import java.io.*;

public class ResultReport {
    public static void main(String[] args) {

        int pass = 0, fail = 0, total = 0, n = 0;
        String topper = "";
        int highest = 0;

        try (
            BufferedReader br = new BufferedReader(
                new FileReader("student.txt"));
            PrintWriter pw = new PrintWriter("result.txt")
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] f = line.split(",");
                int m = Integer.parseInt(f[2]);

                total += m;
                n++;

               
                if (m > highest) {
                    highest = m;
                    topper = f[1];
                }

                if (m >= 50) {
                    pass++;
                    pw.println(f[1] + " PASS");
                } else {
                    fail++;
                    pw.println(f[1] + " FAIL");
                }
            }

            pw.println("Passed : " + pass);
            pw.println("Failed : " + fail);
            pw.printf("Average : %.2f%n", (double) total / n);

            pw.println("Topper : " + topper);
            pw.println("Topper Mark : " + highest);

            System.out.println(
                "result.txt created. Passed " + pass +
                ", failed " + fail);
            System.out.println(
                "Topper : " + topper + " (" + highest + ")");

        } catch (IOException e) {
            System.out.println("File error : " + e.getMessage());
        }
    }
}

INPUT:
101,Aravind,78
102,Divya,91
103,Karthik,45

OUTPUT:
result.txt created. Passed 2, failed 1
Topper : Divya (91)

OUTPUT.TXT:
 Aravind PASS
Divya PASS
Karthik FAIL
Passed : 2
Failed : 1
Average : 71.33
Topper : Divya
Topper Mark : 91
