APPLICATION:
CASE STUDY

  PROGRAME:


class Boarder {
    String name;
    int days;

    Boarder(String n, int d) {
        name = n;
        days = d;
    }

    double bill() {
        double amount = days * 85.0;

        if (days < 26) {
            amount = amount - (amount * 0.10);
        }

        return amount;
    }
}

public class MessBill {
    public static void main(String[] args) {

        Boarder[] list = {
            new Boarder("Rahul", 20),
            new Boarder("Priya", 27),
            new Boarder("Sanjay", 24)
        };

        double total = 0;

        System.out.println("NAME       DAYS     BILL");

        for (Boarder b : list) {
            System.out.printf("%-10s %4d %8.2f%n",
                    b.name, b.days, b.bill());
            total += b.bill();
        }

        System.out.printf("Total collection = Rs. %.2f%n", total);
    }
}



 SAMPLE INPUT:
  Rahul 20
  Priya 27
  Sanjay 24

  SAMPLE OUTPUT:
 NAME       DAYS     BILL
Rahul        20  1530.00
Priya        27  2295.00
Sanjay       24  1836.00
Total collection = Rs. 5661.00
  
