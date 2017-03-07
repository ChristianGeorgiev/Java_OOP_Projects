package ex3;

public abstract class Food {
    private String type;
    private int quantity;

    public Food(String type, int quantity) {
        this.setType(type);
        this.setQuantity(quantity);
    }

    protected String getType() {
        return this.type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    protected int getQuantity() {
        return this.quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
