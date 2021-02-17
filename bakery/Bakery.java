package bakery;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;


    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    public boolean remove(String employeeName) {
        for (Employee employee : employees) {
            return employee.getName().equals(employeeName);
        }
        return true;
    }

    public Employee getOldestEmployee() {
        employees.sort(Comparator.comparing(Employee::getAge).reversed());
        return employees.get(0);
    }

    public Employee getEmployee(String name) {
        Employee currEmployee = null;
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                return currEmployee=employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public StringBuilder report() {
        StringBuilder stringBuilder= new StringBuilder();

        String bakeryName = "Employees working at Bakery " + this.name+":";
        stringBuilder.append(bakeryName);
        stringBuilder.append(System.getProperty("line.separator"));
        for (Employee employee : employees) {
            stringBuilder.append(employee.toString());
            stringBuilder.append(System.getProperty("line.separator"));
        }

        return stringBuilder;
    }
}
