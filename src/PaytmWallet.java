public class PaytmWallet extends OnlineWallet {

    int cashBackPercent = 5;

    public PaytmWallet(int money) {

        super(money);
        cashBack(this.cashBackPercent);
    }

    public PaytmWallet( int money, int cashBackPercent)
    {
        super(money);
        cashBack (cashBackPercent);

    }
    @Override
    public void transferMoney(Wallet source, Wallet dest, int money) {

        source.removeMoney(money);
        dest.addMoney(money);
    }

    @Override
    public void cashBack (int cashbackPercent)
    {
        System.out.println ( "Paytm wallet offers a cashback of "+ cashbackPercent+ "%");
    }
}
