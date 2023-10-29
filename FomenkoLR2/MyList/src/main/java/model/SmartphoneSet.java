package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class SmartphoneSet extends ArrayList<Smartphone> {

    public SmartphoneSet() {
        super();
        this.add(new Smartphone("Xiaomi Redmi Note 5", "Snapdragon 636", 22, 140));
        this.add(new Smartphone("OnePlus 10 Pro", "Snapdragon 8 Gen 1", 91, 740));
        this.add(new Smartphone("Realme GT Neo 3", "MediaTek Dimensity 8100 Max", 83, 600));
        this.add(new Smartphone("Xiaomi Poco F3", "Snapdragon 870", 76, 435));
        this.add(new Smartphone("Realme C11", "Unisoc CS9863A", 15, 110));
        this.add(new Smartphone("Google Pixel 6 Pro", "Google Tensor", 78, 950));
        this.add(new Smartphone("Samsung Galaxy S22 Ultra", "Exynos 2200", 87, 1450));
        this.add(new Smartphone("Xiaomi Poco M4 Pro", "MediaTek Dimensity 810", 43, 250));
        this.add(new Smartphone("OnePlus 9 Pro", "Snapdragon 888", 85, 680));
        this.add(new Smartphone("OnePlus Ace", "MediaTek Dimensity 8100 Max", 83, 600));
        this.add(new Smartphone("IPhone 13 Pro Max", "Apple A15 Bionic", 99, 1500));
        this.add(new Smartphone("Xiaomi 11 Ultra", "Snapdragon 888", 85, 950));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Smartphone performance:");
        for (Smartphone inst : this) {
            sb.append(inst.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
