USE CASE::

REMOVE SYNCHRONIZED AND LOOK FOR A REPEATED 'LEFT'= NUMBER OR A NEGATIVE ONE

  PROGRAM:
class Seats {
    private int available = 10;

   
    void book(String counter) {
        if (available > 0) {
            available--;
            System.out.println(counter + " booked seat. Left = " + available);
        } else {
            System.out.println(counter + " -> HOUSE FULL");
        }
    }
}

public class Booking {
    public static void main(String[] args) {

        Seats s = new Seats();

        for (int i = 1; i <= 3; i++) {
            String name = "Counter-" + i;

            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    s.book(name);
                }
            }).start();
        }
    }
}

INPUT:
No input
  OUTPUT:
Counter-1 booked seat. Left = 9
Counter-2 booked seat. Left = 8
Counter-3 booked seat. Left = 7
Counter-1 booked seat. Left = 6
Counter-2 booked seat. Left = 5
Counter-3 booked seat. Left = 4
Counter-1 booked seat. Left = 3
Counter-2 booked seat. Left = 2
Counter-3 booked seat. Left = 1
Counter-1 booked seat. Left = 0
Counter-2 -> HOUSE FULL
Counter-3 -> HOUSE FULL
