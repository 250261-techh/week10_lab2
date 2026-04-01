public class BankAccount {
    private double balance;
    public BankAccount(double balance){
        this.balance=balance;
    }
    public void withdraw(double amount) throws InsufficientFundsException {

        if (balance<amount){
            double sh=balance-amount;
            throw new InsufficientFundsException("\nInsufficient funds, you are short by "+(sh*-1));
        }
        else{
            this.balance-=amount;
            System.out.print("Withdrew: "+amount);
            System.out.print(" Remaining balance: "+this.balance);
        }

    }
}
