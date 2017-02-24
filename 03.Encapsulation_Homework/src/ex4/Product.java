package ex4;

public class Product {
    private String name;
    private long price;

    public Product(String name, long price){
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public long getPrice() {
        return this.price;
    }

    private void setPrice(long price) {
        if (price < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
