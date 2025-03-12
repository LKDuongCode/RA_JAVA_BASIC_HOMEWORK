package hw07;

public class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation (double a, double b, double c){
        this.a = a;
        this.b = b;
         this.c = c;
    }

    public double getDiscriminant (){
        return (Math.pow(b,2) - (4*a*c));
    }

    public boolean hasRealRoots(){
        if (this.getDiscriminant() >= 0){
            return true;
        }else {
            return false;
        }
    }

    public double getRoot1 (){
        if (hasRealRoots()){
            return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
        }else {
            return Double.NaN;
        }
    }

    public double getRoot2 (){
        if (hasRealRoots()){
            return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
        }else {
            return Double.NaN;
        }
    }

    public void display (){
        if (hasRealRoots()){
            System.out.println("x1 = " + getRoot1());
            System.out.println("x2 = " + getRoot2());
        }else {
            System.out.println("phương trình không có nghiệm thực.");
        }
    }




}
