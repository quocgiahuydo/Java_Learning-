public class Test {
    public static void main(String[] args){
    Object[] test = {1,1231,null,"String", null};
    Clone variable = new Clone (test);
    try{
        variable.test();
        System.out.println("There is no error");
    }
    catch(ReturnException e){
        System.out.println(e);
    }
    finally{
        System.out.println("That's all");
        System.exit(1);
    }
    }
}
