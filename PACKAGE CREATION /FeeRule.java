CASE STUDY:

  "  ADD A THIRD PACKAGE COM.SCSVMV.FEE.REPORT THAT PRINTS THE TABLE,AND LET FEE APP ONLY CALL IT "
 
  PROGRAME:
package com.scsvmv.fee.service;

public class FeeRule {
    public static double fee(String course) {
        if (course.equals("BE")) return 75000;
        if (course.equals("ME")) return 60000;
        return 40000;
    }
}
