public class Main {

    public static void main(String[] args) {

        SavingsWallet wallet1 = new SavingsWallet(0, 200, true);

        wallet1.addMoney(500);

        int status = wallet1.removeMoney(700);

        System.out.println("Final Account Balance: " + wallet1.getBalance());


    }
}
