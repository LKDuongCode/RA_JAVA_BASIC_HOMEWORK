package hw03;

public class Runing implements Runnable{
    private SharedResource resource;
    private String name;

    public Runing(SharedResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " bắt đầu in: ");
        resource.printAlphabet();
        System.out.println("Thread " + name + " kết thúc.\n");
    }
}
