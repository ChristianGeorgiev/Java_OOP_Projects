package ex9;

public class Child {
    private String name;
    private String birthDay;

    public Child(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString(){
        return String.format("%s %s%n", this.getName(), this.getBirthDay());
    }
}
