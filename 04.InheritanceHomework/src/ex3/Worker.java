package ex3;

public class Worker extends Human{
    private double weekSalary;
    private int workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay){
        super(firstName,lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private double getWeekSalary(){
        return this.weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private int getWorkHoursPerDay(){
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(int workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }


    @Override
    protected void setLastName(String lastName){
        if (!Character.isUpperCase(lastName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    private double calcSalaryPerHour(){
        double salaryPerDay = this.getWeekSalary() / 7.0;
        return salaryPerDay / this.getWorkHoursPerDay();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s%n", super.getFirstName()));
        sb.append(String.format("Last Name: %s%n", super.getLastName()));
        sb.append(String.format("Week Salary: %.2f%n", this.getWeekSalary()));
        sb.append(String.format("Hours per day: %d%n", this.getWorkHoursPerDay()));
        sb.append(String.format("Salary per hour: %.2f%n", calcSalaryPerHour()));

        return sb.toString();
    }
}
