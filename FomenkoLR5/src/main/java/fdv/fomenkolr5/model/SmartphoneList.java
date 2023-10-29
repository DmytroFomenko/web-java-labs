package fdv.fomenkolr5.model;


import java.util.ArrayList;

public class SmartphoneList extends ArrayList<Smartphone> {
    public SmartphoneList() {
    }

    public SmartphoneList(int num) {
        this.add(new Smartphone(1, "Xiaomi", "Redmi Note 7", 30, 200));
        this.add(new Smartphone(2, "OnePlus", "Nord 2 CE", 38, 260));
        this.add(new Smartphone(3, "Realme", "GT Neo 2", 76, 370));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Smartphone List");
        for (Smartphone e : this) {
            sb.append(System.lineSeparator()).append(e.toString());
        }
        return sb.toString();
    }
}
