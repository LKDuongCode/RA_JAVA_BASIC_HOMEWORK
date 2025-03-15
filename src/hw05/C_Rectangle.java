package hw05;

public class C_Rectangle implements I_Colorable{
    double length;
    double width;
    String color;

    public C_Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void setColor(String color){
        this.color = color;
    }
}
