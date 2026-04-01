public class BankApp {
    public static void main(String[] args) throws InsufficientFundsException {
        BankAccount b = new BankAccount(500.0);
        try {
            b.withdraw(200.0);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            b.withdraw(400.0);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            b.withdraw(100.0);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

    }





}
