package hw05;

public class Square extends Shape{
    double side;

    public Square (double side){
        this.side = side;
    }

    @Override
    public double area (){
        return this.side * this.side;
    }
}
