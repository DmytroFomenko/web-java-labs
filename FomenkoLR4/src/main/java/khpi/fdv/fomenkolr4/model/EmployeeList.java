package khpi.fdv.fomenkolr4.model;


import java.util.ArrayList;

public class EmployeeList extends ArrayList<Employee> {

    private static final long serialVersionUID = 1L;

    private static EmployeeList instance;
    public String value;

    private EmployeeList() {

    }

    public static EmployeeList getInstance() {
        if (instance == null) {
            instance = new EmployeeList();
            instance.add(new Employee(1,"Mykhaylo",55,2));
            instance.add(new Employee(2,"Dmytro",80,2));
            instance.add(new Employee(3,"Semen",45,2));
            instance.add(new Employee(4,"Mykyta",30,1));
            instance.add(new Employee(5,"Andriy",69,1));
            instance.add(new Employee(6,"Vlad",26,2));
            instance.add(new Employee(7,"Denys",22,2));
            instance.add(new Employee(8,"Oleksiy",40,0));
            instance.add(new Employee(9,"Rosyslav",62,0));
            instance.add(new Employee(10,"Bogdan",50,2));
            instance.add(new Employee(11,"Kyrylo",99,1));
            instance.add(new Employee(12,"Eduard",35,2));
        }
        return instance;
    }

}

