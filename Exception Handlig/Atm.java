USECASE:
ATM WITHDRAWA
  L
CATCH THE TWO EXCEPTIONS SEPERATELY AND GIVE A DIFFERENT MESSAGE:

PROGRAM:
class InvalidAmountException extends Exception {
    InvalidAmountException(String m) {
        super(m);
    }
}

class LowBalanceException extends Exception {
    LowBalanceException(String m) {
        super(m);
    }
}

public class Atm {

    static double balance = 5000;

    static void withdraw(double amt)
            throws InvalidAmountException, LowBalanceException {

        if (amt % 100 != 0)
            throw new InvalidAmountException(
                amt + " is not a multiple of 100");

        if (amt > balance)
            throw new LowBalanceException(
                "Balance is only " + balance);

        balance -= amt;

        System.out.println(
            "Dispensed " + amt + ", balance " + balance);
    }

    public static void main(String[] args) {

        double[] tries = {2000, 350, 9000, 1500};

        for (double a : tries) {

            try {
                withdraw(a);
            }
            catch (InvalidAmountException e) {
                System.out.println(
                    "Invalid Withdrawal : " + e.getMessage());
            }
            catch (LowBalanceException e) {
                System.out.println(
                    "Insufficient Balance : " + e.getMessage());
            }
        }
    }
}

INPUT:
2000
350
9000
1500
  
OUTPUT:
Dispensed 2000.0, balance 3000.0
Invalid Withdrawal : 350.0 is not a multiple of 100
Insufficient Balance : Balance is only 3000.0
Dispensed 1500.0, balance 1500.0
