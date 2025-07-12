public class Product {
private String name;
private double price;
private int stock;

public Product(String name, double price, int stock) {
    this.name = name;
    this.price = price;
  this.stock = stock;
}
public void setStock(int stock) {
    this.stock = stock;
}

public String getName() {
    return name;
}
public Double getPrice() {
    return price;
}
public int getStock() {
    return stock;
}}
