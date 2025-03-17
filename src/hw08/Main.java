package hw08;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[10];
        int curIdx = 0;

        products[curIdx++] = new Product("p",0);
        products[curIdx++] = new Electronic("e",300);
        products[curIdx++] = new Clothing("c",200);
        products[curIdx++] = new Food("f",100);

        for(int i = 0; i < curIdx; i++) {
            System.out.println(products[i].name + " - " + products[i].price+ " ====");
            System.out.println(products[i].getFinalPrice());
            System.out.println(products[i].getFinalPrice(200));
        }
    }
}
