package Main;

public class Bank {
    private static final int creationYear = 2020;
    private final int bankID = 10;
    private static int customersAmount = 0;

    private String name;
    private int money;

    private Bank() {

    }

    private Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    private static String data() {
        return "creation year is " + creationYear + " '\n' the amount of customers is " + customersAmount;
    }

    private static String getData() {
        return "The data is empty";
    }

    private static String getData(String name) {
        return "The name of the bank is " + name;
    }

    private  String getData(int money, String name) {
        return "The name of the bank is " + name + " and the money of the bank is " + money;
    }

    private static String getData(String name, int money) {
        return "The name of the bank is + " + name + " and the money of the bank is + " + money;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Bank bank1 = new Bank("name", 100);
        bank.name = "something";
        bank.money = 123;

        System.out.println(Bank.getData());
        System.out.println(Bank.getData(bank.name));
        System.out.println(bank1.getData(bank1.money, bank1.name));

        System.out.println(Bank.creationYear);
        System.out.println("The bank id is " + bank1.bankID);
        System.out.println(++Bank.customersAmount);
    }
}
