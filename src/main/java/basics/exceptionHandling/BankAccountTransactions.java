package basics.exceptionHandling;


public class BankAccountTransactions {

    private double currentBalance = 1000;
    private final double minimumBalance = 100;

    public void withdrawAmount(double amountToWithdraw) throws BankAccountException, MinimumBalanceException {

        if(amountToWithdraw <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be a valid input");
        }

        if(amountToWithdraw > currentBalance) {
            throw new BankAccountException("Insufficient balance " + currentBalance);
        }

        double postBalance = currentBalance - amountToWithdraw;



        if(postBalance < minimumBalance) {
            throw new MinimumBalanceException("Minimum balance required Rs "+ minimumBalance +" please choose another amount Rs "+amountToWithdraw);
        }

        currentBalance -= amountToWithdraw;

        System.out.println("Withdrawal successfully. Remaining balance Rs "+currentBalance);
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public static void main(String[] args) {

        BankAccountTransactions bankAccount = new BankAccountTransactions();

        try {
            bankAccount.withdrawAmount(899);
        } catch (BankAccountException bae) {
            System.out.println("Exception occurred "+bae.getMessage());
        } catch (MinimumBalanceException mbe) {
            System.out.println("Exception occurred "+mbe.getMessage());
        } catch (IllegalArgumentException iae) {
            System.out.println("Exception occurred "+iae.getMessage());
        }

    }

}
