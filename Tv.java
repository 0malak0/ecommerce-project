public class Tv extends Product implements Shippable {
    private boolean isShippable;
    private double weight;
     
    public Tv(String name, double price, int stock,boolean isShippable, double weight) {
        super(name, price, stock);
        this.isShippable = isShippable;
        this.weight = weight;
        
    }

    public double getWeight() {
        return weight;
    }
    @Override
    public boolean getIsShippable() {
        return isShippable;
    }
}
