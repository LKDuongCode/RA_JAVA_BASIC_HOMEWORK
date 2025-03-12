package hw05;

import java.util.Scanner;

public class Vector2D {
    Scanner sc = new Scanner(System.in);
    double x;
    double y;

    public Vector2D (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double calculateMagnitude (){
        return (Math.sqrt(x*x + y*y));
    }

    public Vector2D add (Vector2D vt){
        return new Vector2D(this.x + vt.x, this.y + vt.y);
    }

    public Vector2D subtract (Vector2D vt){
        return new Vector2D(this.x - vt.x, this.y - vt.y);
    }

    public double dotProduct (Vector2D vt){
        return ((this.x * vt.x) + (this.y * vt.y));
    }

    public void displayVector(){
        System.out.println("(" + this.x + "," + this.y + ")");
    }
}
