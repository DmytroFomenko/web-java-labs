package khpi.fdv.fomenkolr4.model;


public class Employee {
    private int id;
    private String name;
    private int age;
    private int codVac;

    public Employee() {

    }

    public Employee(int id, String name, int age, int codVac) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.codVac = codVac;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCodVac() {
        return codVac;
    }

    public String toStringJSP() {
        return "<tr>"
                + "<td>" + name + "</td>"
                + "<td>" + age + "</td>"
                + "<td>" + codVac + "</td>"
                + "</tr>";
    }

}

