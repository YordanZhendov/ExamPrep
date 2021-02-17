package bakery;

public class Main {
    public static void main(String[] args) {

        Bakery bakery=new Bakery("Barny",10);
        Employee employee=new Employee("Stephan",40,"Bulgaria");
        System.out.println(employee);


        bakery.add(employee);

        System.out.println(bakery.remove("Employee name"));

        Employee secondEmployee = new Employee("Mark", 34, "UK");
        bakery.add(secondEmployee);

        Employee oldestEmployee=bakery.getOldestEmployee();
        System.out.println(oldestEmployee);

        Employee getEmployee=bakery.getEmployee("Stephan");
        System.out.println(getEmployee);

        System.out.println(bakery.getCount());
        System.out.println(bakery.report());

    }
}
