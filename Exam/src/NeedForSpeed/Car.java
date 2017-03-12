package NeedForSpeed;

public abstract class Car {
    private String brand;
    private String model;
    private String type;
    private long yearOfProduction;
    private long horsepower;
    private long acceleration;
    private long suspension;
    private long durability;
    private long overallPerformance;
    private long enginePerformance;
    private long suspensionPerformance;

    private boolean isParked;
    private boolean isRacing;

    protected Car(String brand, String model, String type, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setType(type);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
        this.enginePerformance = calcEnginePerf();
        this.suspensionPerformance = calcSuspensionPerf();
        this.overallPerformance = calcOverallPerf();
        this.isParked = false;
        this.isRacing = false;
    }

    protected long calcOverallPerf(){
        return (this.getHorsepower() / this.getAcceleration()) + (this.getSuspension() + this.getDurability());
    }

    public abstract void addAddOn(String addOn);
    public abstract void addStars(int stars);

    protected void tuneHPandSusp(int tuneIndex){
        this.horsepower += tuneIndex;
        this.suspension += (tuneIndex * 50) / 100;
        this.enginePerformance = calcEnginePerf();
        this.suspensionPerformance = calcSuspensionPerf();
        this.overallPerformance = calcOverallPerf();
    }

    protected void decreaseDurability(int laps, int length){
        this.setDurability(this.getDurability() - (laps * (length*length)));
        this.enginePerformance = calcEnginePerf();
        this.suspensionPerformance = calcSuspensionPerf();
        this.overallPerformance = calcOverallPerf();
    }

    protected long calcSuspensionPerf() {
        return this.getSuspension() + this.getDurability();
    }

    protected long calcEnginePerf() {
        return this.getHorsepower() / this.getAcceleration();
    }

    protected long getOverallPerformance() {
        return this.overallPerformance;
    }

    protected long getEnginePerformance() {
        return this.enginePerformance;
    }

    protected long getSuspensionPerformance() {
        return this.suspensionPerformance;
    }

    protected String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }

    protected String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    protected String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    protected long getYearOfProduction() {
        return this.yearOfProduction;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    protected long getHorsepower() {
        return this.horsepower;
    }

    private void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected long getAcceleration() {
        return this.acceleration;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    protected long getSuspension() {
        return this.suspension;
    }

    private void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    protected long getDurability() {
        return this.durability;
    }

    private void setDurability(long durability) {
        this.durability = durability;
    }

    protected boolean isParked() {
        return this.isParked;
    }

    protected void setParked(boolean parked) {
        isParked = parked;
    }

    protected boolean isRacing() {
        return this.isRacing;
    }

    protected void setRacing(boolean racing) {
        isRacing = racing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d%n", this.getBrand(), this.getModel(), this.getYearOfProduction()));
        sb.append(String.format("%d HP, 100 m/h in %d s%n", this.getHorsepower(), this.getAcceleration()));
        sb.append(String.format("%d Suspension force, %d Durability%n", this.getSuspension(), this.getDurability()));
        return sb.toString();
    }
}
