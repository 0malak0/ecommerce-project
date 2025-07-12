public class Cheese extends Product implements Expirable, Shippable {
        private boolean isShippable;
            private boolean isExpired;
    private double weight;

    public Cheese(String name, double price,int stock, boolean isShippable, boolean isExpred,double weight) {
        super(name, price,stock);
        this.isShippable = isShippable;
        this.isExpired = isExpred;
        this.weight = weight;
    }
   
    public double getWeight() {
        return weight;
    }
    @Override
    public boolean getIsShippable() {
        return isShippable;
    }
    @Override
    public boolean getIsExpired(){
        return isExpired;
    }
}
