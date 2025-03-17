package hw04;

public class Shape {
    public double area (){
        return 0;
    }

    public  double area (double radius){
        return (Math.PI * Math.pow(radius,2));
    }

    public double area (double width, double height){
        return (width * height);
    }
}
