public class Main {

    public static void main(String[] args) {

        SavingsWallet wallet1 = new SavingsWallet(0, 200, true);

        wallet1.addMoney(500);

        int status = wallet1.removeMoney(700);

        System.out.println("Final Account Balance: " + wallet1.getBalance());


        //new Wallets created to check online wallet
        OnlineWallet paytmWallet1 = new PaytmWallet(1000);
        OnlineWallet paytmWallet2 = new PaytmWallet(2000);

        paytmWallet1.transferMoney(paytmWallet1, paytmWallet2, 500);

        System.out.println ("paytmWallet1 balance: "+paytmWallet1.getBalance());
        System.out.println ("paytmWallet2 balance: "+paytmWallet2.getBalance());

    }
}
