package hw07;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[50];
        int curIndex = 0;

        students[curIndex++] = new Student("Nguyen Van A", "SV123", 3.5);

        students[curIndex++] = new GraduateStudent("Le Thi B", "GS456", 3.9,"AI in Healthcare", "Dr. Pham Van C");

        students[curIndex++] = new Student("Tran Van C", "SV789", 2.8);

        students[curIndex++] = new GraduateStudent("Pham Thi D", "GS321", 3.7, "Data Science", "Dr. Nguyen Van E");

        System.out.println("Student: ");
        for (int i = 0; i < curIndex; i++) {
            System.out.println(students[i].getDetails());
        }
    }
}
