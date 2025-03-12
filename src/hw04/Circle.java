package hw04;

public class Circle {
    double radius;

    public Circle (){
        this.radius = 1.0;
    }

    public Circle (double radius){
        this.radius = radius;
    }

    public double getArea (){
        return (Math.PI * this.radius);
    }

    public double getCircumference (){
        return ((2*Math.PI)*this.radius);
    }

    public void display (){
        System.out.println("radius = " + this.radius);
        System.out.println("area = " + getArea());
        System.out.println("circumference = " + getCircumference());
    }
}
