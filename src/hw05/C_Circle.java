package hw05;

public class C_Circle implements I_Colorable{
    double radius;
    String color;

    C_Circle(double radius){
        this.radius = radius;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
