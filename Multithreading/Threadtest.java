


public class Threadtest implements Runnable{
    private int threadNumber;
    private static int counter;
    private static Object lock = new Object();
    public Threadtest(int threadNumber){
        this.threadNumber = threadNumber;
    }
    @Override
    public void run(){
        synchronized(lock){
        for(int i =0; i<5; i++){
            System.out.println("Print: "+counter + " from thread "+ this.threadNumber);
            counter++;
        }
        try {
            Thread.sleep(30);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    }   
}
