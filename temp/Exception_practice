public class Test {
    public static void main(String[] args){
        Object[] c ={4,"Hello","888",null};
        Clone test = new Clone (c);
        boolean conditon = true;
        while(conditon){
        try {
        test.test();
        System.out.println("The system is working normal");
        }
        catch (ReturnException e) {
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("That's alll");
            System.exit(1);
        }
    }
}
}


