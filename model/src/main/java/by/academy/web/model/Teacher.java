package by.academy.web.model;

public class Teacher extends Person {
    private int salary;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
