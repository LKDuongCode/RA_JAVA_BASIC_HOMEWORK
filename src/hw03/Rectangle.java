package hw03;

import java.util.Scanner;

public class Rectangle {

    double length;
    double width;

    public Rectangle (double length, double width){
        this.length = length;
        this.width = width;
    }

    public Rectangle (){
        this.width = 1;
        this.length = 1;
    }

    public double getArea (){
        return (this.length*this.width);
    }

    public double getPerimeter() {
        return ((this.length+this.width)*2);
    }

    public void display (){
        System.out.println("length = " + this.length);
        System.out.println("width = " + this.width);
        System.out.println("perimeter = "+ getPerimeter());
        System.out.println("area = "+ getArea());
    }
}
