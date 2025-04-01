package practices.begin.p3;

public class MyRunnable  implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.print(i + " ");

            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
               e.printStackTrace();
            }
        }
    }
}
