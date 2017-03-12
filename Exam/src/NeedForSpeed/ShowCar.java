package NeedForSpeed;

public class ShowCar extends Car {
    private static final int DEFAULT_STARS = 0;
    private static final String SHOW_TYPE = "Show";
    private long stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, SHOW_TYPE, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = DEFAULT_STARS;
    }

    private long getStars() {
        return stars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("%d *", this.getStars()));
        return sb.toString();
    }

    @Override
    public void addAddOn(String addOn) {

    }

    @Override
    public void addStars(int stars) {
        this.stars += stars;
    }
}
