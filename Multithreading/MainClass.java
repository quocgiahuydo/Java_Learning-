

public class MainClass {
    public static void main(String[] args){
        //Threadtest mything = new Threadtest();

        //Threadtest mything2 = new Threadtest();//Create the thread mything2 ==> run thread 2 
        /*mything.start();
        mything2.start();
         */
        //These using the extends Thread method
        //2) We can also use implement to run the test 
        System.out.println("Ending here maybe");
        for(int i =0; i<5; i++){
            Threadtest test = new Threadtest(i);
            Thread main_Thread = new Thread(test);// create the number of thread depended on the number of loop
            main_Thread.start(); // run all of it //
            try {
                main_Thread.join();
            } catch (Exception e) {
            }
        }
    }    
}
