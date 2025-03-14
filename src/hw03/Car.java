package hw03;

import java.time.Year;

public class Car {
    private String made;
    private String model;
    private int year;

    public Car (String made, String model, int year){
        this.year = year;
        this.made = made;
        this.model = model;
    }

    //getter
    public String getMade() {
        return this.made;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    //setter
    public void setMade(String made) {
        this.made = made;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        if (year <= Year.now().getValue()){
            this.year = year;
        }else {
            System.out.println("năm sản xuất không lớn hơn năm hiện tại");
        }
    }
}
