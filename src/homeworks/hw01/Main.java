package homeworks.hw01;

public class Main {
    public static void main(String[] args) {
        Account acc1 = Account.getInstance();
        Account acc2 = Account.getInstance();

        acc1.setName("duong");
        acc2.setAge(20);

        System.out.println("acc1: " + acc1.getName() + ", " + acc1.getAge());
        System.out.println("acc2: " + acc2.getName() + ", " + acc2.getAge());

        System.out.println("acc1 == acc2: " + (acc1 == acc2));
    }
}
