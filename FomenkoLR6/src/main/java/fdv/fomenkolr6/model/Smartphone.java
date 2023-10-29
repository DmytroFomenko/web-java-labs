package fdv.fomenkolr6.model;


import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Fomenko D.V.
 */
public class Smartphone implements Serializable {

    // id, company,	model, performance, price
    private int id;
    private String company;
    private String model;
    private int performance;
    private double price;


    public Smartphone() {
    }

    public Smartphone(int id, String company, String model, int performance, double price) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.performance = performance;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {this.company = company;}


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "[Smartphone " + id + "] ---"
                + " Company: " + company
                + " | Model: " + model
                + " | Performance: " + performance + "% of the max"
                + " | Prise: " + price + "$" /*+ '\n'*/;
    }

    public String toStringForFile() {

        return "Company: " + company
                + ", Model: " + model
                + ", Performance: " + performance + "% of the max"
                + ", Prise: " + price
                + "$" + '\n';
    }

    public Smartphone(Scanner scan, String promptText) {
        System.out.println("\n" + promptText);
        System.out.print("Input company ===> ");
        this.company = scan.nextLine();

        System.out.print("Input model ===> ");
        this.model = scan.nextLine();

        boolean isOK;
        do {
            System.out.print("Input performance ===> ");
            try {
                String performance = scan.nextLine();
                this.performance = Integer.parseInt(performance);
                if (this.performance >= 0 && this.performance <= 100) {
                    isOK = true;
                } else {
                    isOK = false;
                    System.out.println("Performance must be between 0-100(%)");
                }
            } catch (NumberFormatException e) {
                //this.performance = 0;
                System.out.println("Performance must be an integer");
                isOK = false;
            }
        } while (!isOK);


        do {
            System.out.print("Input price ===> ");
            try {
                String price = scan.nextLine();
                this.price = Double.parseDouble(price);
                if (this.price >= 0) {
                    isOK = true;
                } else {
                    isOK = false;
                    System.out.println("Prise must be above 0 or equals 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Price must be a double");
                isOK = false;
            }
        } while (!isOK);
    }

    public Smartphone(Scanner scan) {
        System.out.println("\nInput key data of Smartphone");
        System.out.print("Input company ===> ");
        this.company = scan.nextLine();

        System.out.print("Input model ===> ");
        this.model = scan.nextLine();

        boolean isOK;
        do {
            System.out.print("Input performance ===> ");
            try {
                String performance = scan.nextLine();
                this.performance = Integer.parseInt(performance);
                if (this.performance >= 0 && this.performance <= 100) {
                    isOK = true;
                } else {
                    isOK = false;
                    System.out.println("Performance must be between 0-100(%)");
                }
            } catch (NumberFormatException e) {
                //this.performance = 0;
                System.out.println("Performance must be an integer");
                isOK = false;
            }
        } while (!isOK);



        do {
            System.out.print("Input price ===> ");
            try {
                String price = scan.nextLine();
                this.price = Double.parseDouble(price);
                if (this.price >= 0) {
                    isOK = true;
                } else {
                    isOK = false;
                    System.out.println("Prise must be above 0 or equals 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Price must be a double");
                isOK = false;
            }
        } while (!isOK);
    }

    public Smartphone(Scanner scan, boolean model) {
        System.out.println("\nInput key data of Smartphone");

        this.company = "";

        System.out.print("Input model of smartphone ===> ");
        this.model = scan.nextLine();

        this.performance = 0;

        this.price = 0;

    }
}


