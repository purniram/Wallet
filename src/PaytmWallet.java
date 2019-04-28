public class PaytmWallet extends OnlineWallet {



    public PaytmWallet(int money) {
        super(money);
    }

    @Override
    public void transferMoney(Wallet source, Wallet dest, int money) {

        source.removeMoney(money);
        dest.addMoney(money);
    }
}
