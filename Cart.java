import java.util.*;
public class Cart {
    private Customer customer;
    private Map<Product, Integer> products = new HashMap<>();


    public Cart(Customer customer) {
        this.customer = customer;
        
    }
    public Customer getCustomer() {
        return customer;
    }
    
    public void addProduct(Product product,int quantity) {

             products.put( product, quantity);
    }
  public void shipmentNotice() {
    for (Map.Entry<Product, Integer> entry : products.entrySet()) {
        Product product = entry.getKey();
        int quantity = entry.getValue();

        System.out.print(product.getName() + " - Quantity: " + quantity);

        if (product instanceof Shippable) {
            Shippable shippable = (Shippable) product;
            System.out.print(" - Weight: " + shippable.getWeight() + " kg");
        }

        System.out.println(); 
    }
}
public Map<Product, Integer> getProducts() {
    return products;
}
public double calculateTotalWeight() {
    double totalWeight = 0.0;

    for (Map.Entry<Product, Integer> entry : products.entrySet()) {
        Product product = entry.getKey();
        int quantity = entry.getValue();

        if (product instanceof Shippable) {
            Shippable shippable = (Shippable) product;
            totalWeight += shippable.getWeight() * quantity;
        }
    }

    return totalWeight;
}

   
}

