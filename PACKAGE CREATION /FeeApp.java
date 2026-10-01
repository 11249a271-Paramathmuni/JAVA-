CASE STUDY:

  "  ADD A THIRD PACKAGE COM.SCSVMV.FEE.REPORT THAT PRINTS THE TABLE,AND LET FEE APP ONLY CALL IT "

  PROGRAME :

import com.scsvmv.fee.model.Student;
import com.scsvmv.fee.report.FeeReport;

public class FeeApp {

    public static void main(String[] args) {

        Student[] s = {
            new Student("Meena", "BE"),
            new Student("Ravi", "ME"),
            new Student("Anu", "BSc")
        };

        FeeReport.print(s);
    }
}


SAAPMLE INPUT: 
  Meena BE
  Ravi ME
  Anu BSc

  
SAMPLE OUTPUT:
NAME     COURSE       FEE
Meena    BE          75000.00
Ravi     ME          60000.00
Anu      BSc         40000.00
Total fee = 175000.00
