import java.util.Scanner;

class InOut_Put{
    public static void main(String[] args){
        Scanner Input= new Scanner(System.in);
        String myinput= Input.nextLine();
        Input.close();
        System.out.println(myinput);
    }
}