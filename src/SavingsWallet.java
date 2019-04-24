public class SavingsWallet implements Wallet {

    private long actBalance;
    long overDraw= 100;

    public void SavingsWallet(long money)
    {
        this.actBalance = money;
    }

    @Override
    public long addMoney(long money) {

        actBalance += money;
        return (actBalance );
    }

    @Override
    public long removeMoney(long money) {


        if (actBalance >= money) {
            actBalance -= money;
            return actBalance;
        }
        else if ( (actBalance+overDraw) >= money)
        {
            actBalance -= money;
            return (0);
        }
        else
            return (-1);

    }

    @Override
    public long getBalance() {
        return actBalance;
    }

    public void setBalance (long money) {
         this.actBalance = money;
    }
}
