package hw05;

public class Circle extends Shape {
    double radius;

    public Circle (double radius){
        this.radius = radius;
    }

    @Override
    public double area (){
        return (Math.PI * Math.pow(this.radius,2));
    }
}