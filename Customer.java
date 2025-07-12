public class Customer {
    private String Id;
    private double balance;
    private String name;

    public Customer(String Id, double balance, String name) {
        this.Id = Id;
        this.balance = balance;
        this.name = name;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getId() {
        return Id;}
    public double getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }


}
