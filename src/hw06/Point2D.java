package hw06;

public class Point2D {
    //atb
    double x;
    double y;

    // cst
    public Point2D (double x, double y){
        this.x = x;
        this.y = y;
    }

    // mt
    public double getX (){
        return this.x;
    }

    public double getY (){
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceTo (Point2D p){
        return Math.sqrt((p.x - this.x)*(p.x - this.x) + (p.y - this.y)*(p.y - this.y));
    }

    public void displayPoint (){
        System.out.println("("+this.x+","+this.y+")");
    }
}
