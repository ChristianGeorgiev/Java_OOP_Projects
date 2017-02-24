package ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private long money;
    private List<Product> products;

    public Person(String name, long money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
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

    public long getMoney() {
        return this.money;
    }

    private void setMoney(long money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts(){
        return Collections.unmodifiableList(this.products);
    }

    public void addProduct(Product product){
        if (product.getPrice() > this.getMoney()){
            throw new IllegalArgumentException(this.getName() + " can't afford " + product.getName());
        }
        this.products.add(product);
        this.setMoney(this.getMoney() - product.getPrice());
    }

    @Override
    public String toString(){
        if (this.getProducts().size() > 0) {
            return String.format("%s - %s", this.getName(), String.join(", ", this.getProducts().toString()).substring(1, String.join(", ", this.getProducts().toString()).length() - 1));
        }else {
            return this.getName() + " - Nothing bought";
        }
    }
}