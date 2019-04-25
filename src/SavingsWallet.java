public class SavingsWallet implements Wallet {

    private int actBalance;
    private boolean isOverdrawEnabled;
    private int overDrawLimit;

    // default constructor


    //constructor for overdraw limit
    public SavingsWallet(int money, int overDrawLimit, boolean isOverdrawEnabled) {
        this.actBalance = money;
        this.overDrawLimit = overDrawLimit;
        this.isOverdrawEnabled = isOverdrawEnabled;
    }

    public SavingsWallet(int money, boolean isOverdrawEnabled) {
        this.actBalance = money;
        this.overDrawLimit = 0;
        this.isOverdrawEnabled = isOverdrawEnabled;
    }


    @Override
    public long addMoney(long money) {

        System.out.println("Adding " + money + " to the wallet.....");
        actBalance += money;

        System.out.println("successfully added " + money);
        showBalance();
        return (actBalance);


    }

    @Override
    public int removeMoney(long money) {

        System.out.println("Trying to withdraw " + money + " from the wallet.....");
        int status = -1;

        //if no overdraw facility
        if (!isOverdrawEnabled) {
            if (actBalance >= money) {
                deductBalance(money);
                System.out.println("Money withdrawn successfully");
                status = 1;

            } else {
                status = -1;
                System.out.println("Could not withdraw as the balance is not sufficient");
            }

        }

        //if the account has a overdraw facility, the total amount he can withdraw is "accountbalance+overdrawlimit
        else {
            if ((actBalance + overDrawLimit) >= money) {
                deductBalance(money);
                System.out.println("Money withdrawn successfully with withdraw limit");
                status = 1;
            } else {
                System.out.println("Could not withdraw as the balance is not sufficient");
                status = -1;
            }
        }

            showBalance();
            return status;  // not used for now. might be needed later
        }


        //withdrawing money
        private void deductBalance ( long money){

            actBalance -= money;

        }


        //account balance at any given time
        @Override
        public long getBalance () {
            return actBalance;
        }

        public void setBalance ( int money){
            this.actBalance = money;
        }

        //printing the balance to console
        public void showBalance ()
        {
            System.out.println("Balance as of now : " + getBalance());
        }
    }
