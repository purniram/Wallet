public abstract class OnlineWallet implements Wallet {

    private int actBalance;
    private boolean isOverdrawEnabled;
    private int overDrawLimit;

    public OnlineWallet(int money) {
        this.actBalance = money;
    }

    @Override
    public long addMoney(long money) {
        System.out.println("Adding " + money + " to the wallet.....");
        actBalance += money;
        return actBalance;
    }

    @Override
    public int removeMoney(long money) {
        deductBalance(money);
        return actBalance;
    }

    @Override
    public long getBalance() {
        return actBalance;
    }

    public abstract void transferMoney(Wallet source, Wallet dest, int money);

    private void deductBalance ( long money){

        actBalance -= money;

    }

}
