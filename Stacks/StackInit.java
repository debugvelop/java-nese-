public class StackInit extends RevString{
    private char[] stack;
    private int length,x;

    public StackInit(int length){
        this.length=length;
        stack=new char[length];
        this.x=length;
    }

    public void push(char query){
        stack[--x]=query;
    }

    public char pop(){
        return stack[x++];
    }
}