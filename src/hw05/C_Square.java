package hw05;

public class C_Square implements I_Colorable{
    double edge;
    String color;

    public C_Square(double edge) {
        this.edge = edge;
    }

    @Override
    public void setColor(String color){
        this.color = color;
    }
}
