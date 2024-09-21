
public class Clone {
    private final Object[] variable;
    public Clone( Object[] c){
        this.variable = c;
    } 
    public void test() throws ReturnException{
        int ct =0; 
        while (ct < this.variable.length){
            if(this.variable[ct] == null){
                throw new ReturnException("There is a null variable in this array");
            }
            ct++;
        }
    }
    
}
