public class RevString{
    public static void main(String[] args){
        String input="kasurrusak";
        StackInit mystack=new StackInit(input.length());
        for(int x=0;x<input.length();x++){
            mystack.push(input.charAt(x));
        }
        for(int x=0;x<input.length();x++){
            System.out.print(mystack.pop());
        }
        System.out.println();
    }
}