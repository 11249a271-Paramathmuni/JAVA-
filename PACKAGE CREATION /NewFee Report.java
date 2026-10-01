CASE STUDY:

  " ADD A THIRD PACKAGE COM.SCSVMV.FEE.REPORT THAT PRINTS THE TABLE,AND LET FEE APP ONLY CALL IT "

  PROGRAME::

  package com.scsvmv.fee.report;

import com.scsvmv.fee.model.Student;
import com.scsvmv.fee.service.FeeRule;

public class FeeReport {

    public static void print(Student[] students) {
        double total = 0;

        System.out.println("NAME     COURSE       FEE");

        for (Student x : students) {
            double f = FeeRule.fee(x.course);

            System.out.printf("%-8s %-10s %10.2f%n",
                    x.name, x.course, f);

            total += f;
        }

        System.out.printf("Total fee = %.2f%n", total);
    }
}

