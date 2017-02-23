package ex4;

public class Employee extends Person {
    private static final String DEFAULT_EMAIL = "n/a";

    private Double salary;
    private String position;
    private String email = DEFAULT_EMAIL;

    public Employee(String name, double salary, String position){
        super(name);
        this.salary = salary;
        this.position = position;
    }

    public Employee(String name, double salary, String position, String email){
        super(name);
        this.salary = salary;
        this.position = position;
        this.email = email;
    }

    public Employee(String name, double salary, String position, String email, int age){
        super(name, age);
        this.salary = salary;
        this.position = position;
        this.email = email;
    }

    public Employee(String name, double salary, String position, int age){
        super(name, age);
        this.salary = salary;
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %s %d", this.getName(), this.salary, this.email, this.getAge());
    }
}
