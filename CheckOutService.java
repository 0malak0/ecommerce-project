import java.util.*;
public class CheckOutService {

    public static void checkout(Customer customer, Cart cart) {
        Map<Product, Integer> products = cart.getProducts();

        if (products.isEmpty()) {
            System.out.println(" Error: Cart is empty.");
            return;
        }

        if (hasOutOfStockProducts(products)) return;

        double subtotal = calculateSubtotal(products);
        double shippingFees = calculateShippingFees(products);
        double total = subtotal + shippingFees;

        if (customer.getBalance() < total) {
            System.out.println(" Error: Insufficient balance. Total needed: " + (int)total +
  ", available: " + (int)customer.getBalance());
            return;
        }

        customer.setBalance(customer.getBalance() - total);

        printReceipt(products, subtotal, shippingFees, total);
    }

    
    private static boolean hasOutOfStockProducts(Map<Product, Integer> products) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product.getStock() < quantity) {
                System.out.println("Error: Not enough stock for '" + product.getName() +
                                   "'. Available: " + product.getStock() + ", requested: " + quantity);
                return true;
            }
        }
        return false;
    }

    private static double calculateSubtotal(Map<Product, Integer> products) {
        double subtotal = 0.0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            subtotal += product.getPrice() * quantity;
        }
        return subtotal;
    }

    private static double calculateShippingFees(Map<Product, Integer> products) {
        double fees = 0.0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Shippable) {
                fees += 10.0 * quantity; 
            }
        }
        return fees;
    }

    private static void printReceipt(Map<Product, Integer> products, double subtotal, double shipping, double total) {
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int totalPerProduct = (int)(product.getPrice() * quantity);
            System.out.println(quantity + "x " + product.getName() + " " + totalPerProduct);
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + (int)subtotal);
        System.out.println("Shipping " + (int)shipping);
        System.out.println("Amount " + (int)total);
    }
}

