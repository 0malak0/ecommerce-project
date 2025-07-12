

public class App {
    public static void main(String[] args) throws Exception {
        Cheese cheese = new Cheese("Cheddar", 100, 5, true, true, 1.0);
        Tv tv = new Tv("Samsung", 499.99,3,  true, 15.0);
        Customer customer1 = new Customer("123", 1000.0, "Malak");

       
        Cart cart1 = new Cart(customer1);
        cart1.addProduct( cheese, 2);
        
        cart1.addProduct( tv, 1);
        cart1.shipmentNotice();
        System.out.println("Total Weight: " + cart1.calculateTotalWeight() + " Kg");
        CheckOutService.checkout(customer1, cart1);
    }
}
