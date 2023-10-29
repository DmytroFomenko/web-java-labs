package model;

public class Smartphone {
    public String name;
    public String processor;
    public int performance;
    public int price;

    public Smartphone(String name, String processor, int performance, int price) {
        this.name = name;
        this.processor = processor;
        this.performance = performance;
        this.price = price;
    }

    public String getPerformance() {
        return Integer.toString(performance);
    }

    public String getPrice() {
        return Integer.toString(price);
    }

    @Override
    public String toString() {
        return name + " ("  + processor + ", " + performance + ")";
    }
}
