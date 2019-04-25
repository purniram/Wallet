public class SavingsWallet implements Wallet {

    private int actBalance;
    private boolean isOverdrawEnabled;
    private int overDraw;

    public  SavingsWallet(int money, int overDraw , boolean isOverdrawEnabled)
    {
        this.actBalance = money;
        this.overDraw = overDraw;
        this.isOverdrawEnabled = isOverdrawEnabled;
    }

    public  SavingsWallet(int money, boolean isOverdrawEnabled)
    {
        this.actBalance = money;
        this.overDraw = 0;
        this.isOverdrawEnabled = isOverdrawEnabled;
    }

    @Override
    public long addMoney(long money) {

        System.out.println ("Adding " + money + " to the wallet.....");
        actBalance += money;

        System.out.println ( "successfully added " + money);
        showBalance();
        return (actBalance );


    }

    @Override
    public int removeMoney(long money) {

        System.out.println ("Trying to withdraw " + money + " from the wallet.....");
        if (actBalance >= money) {
            actBalance -= money;
            System.out.println ("Successfully withdrawn "+ money);
            showBalance();
            return 1;
        }
        else if ( (actBalance+overDraw) >= money)
        {
            actBalance -= money;
            System.out.println ("Successfully withdrawn "+ money);
            showBalance();
            return 0;
        }
        else {
            if(isOverdrawEnabled)
            System.out.println ( "Could not withdraw as the balance plus overdraw " +
                    "is less than the amount to be withdrawn");
             else
                 System.out.println ( "Could not withdraw as the balance is not sufficient");
            showBalance();
            return -1;
        }
    }

    @Override
    public long getBalance() {
        return actBalance;
    }

    public void setBalance (int money) {
         this.actBalance = money;
    }

    public void showBalance ()
    {
        System.out.println ( "Balance as of now : " +getBalance());
    }
}
