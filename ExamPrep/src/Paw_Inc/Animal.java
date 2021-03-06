package Paw_Inc;

public abstract class Animal {
    private static final boolean DEFAULT_CLEANSING_STATUS = false;

    private String name;
    private int age;
    private boolean isCleansed;

    protected Animal(String name, int age){
        this.setName(name);
        this.setAge(age);
        this.isCleansed = DEFAULT_CLEANSING_STATUS;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    protected int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public void setCleansed(boolean cleansed) {
        this.isCleansed = cleansed;
    }

    protected boolean isCleansed() {
        return this.isCleansed;
    }

    protected void cleanse(){
        this.setCleansed(true);
    }
}
