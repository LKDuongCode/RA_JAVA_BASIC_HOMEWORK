package hw06;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        int curIdx = 0;

        employees[curIdx++] = new FullTimeEmployee("duong",20,5000);
        employees[curIdx++] = new FullTimeEmployee("doan",24,5000);
        employees[curIdx++] = new PartTimeEmployee("hoang",20,6000,4);
        employees[curIdx++] = new Intern("tien",20,7000);

        for(int i = 0; i < curIdx; i++) {
            employees[i].showInfo();
            System.out.println();
        }
    }
}
