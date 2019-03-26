import java.util.*;
import java.io.*;

public class TepuMenuMystery{
    public static void main(String[] args){
        System.out.println("Let's do the test!");
        Scanner inputmain=new Scanner(System.in);
        String inmain=inputmain.next();
        while(inmain!="D"){
            switch(inmain){
                case "A":
                    sumplus();
                case "B":
                    decmin();
                case "C":
                    plydiv();
                default:
                    break;
            }
        }
    }

    public static void sumplus(){
        Scanner inputsumplus;
        Scanner input1,input2;
        System.out.print("Type first number= ");
        input1=new Scanner(System.in);
        int a=input1.nextInt();
        System.out.print("Type second number= ");
        input2=new Scanner(System.in);
        int b=input1.nextInt();
        int result=a+b;
        System.out.println("Result            = "+result);
        inputsumplus=new Scanner(System.in);
        String inmain=inputsumplus.next();
        while(inmain!="D"){
            switch(inmain){
                case "A":
                    sumplus();
                case "B":
                    decmin();
                case "C":
                    plydiv();
                default:
                    break;
            }
        }
    }

    public static void decmin(){
        Scanner inputdecmin;
        Scanner input1,input2;
        System.out.print("Type first number= ");
        input1=new Scanner(System.in);
        int a=input1.nextInt();
        System.out.print("Type second number= ");
        input2=new Scanner(System.in);
        int b=input1.nextInt();
        int result=a-b;
        System.out.println("Result            = "+result);
        inputdecmin=new Scanner(System.in);
        String inmain=inputdecmin.next();
        while(inmain!="D"){
            switch(inmain){
                case "A":
                    sumplus();
                case "B":
                    decmin();
                case "C":
                    plydiv();
                default:
                    break;
            }
        }
    }

    public static void plydiv(){
        Scanner inputplydiv;
        Scanner input1,input2;
        System.out.print("Type first number= ");
        input1=new Scanner(System.in);
        int a=input1.nextInt();
        System.out.print("Type second number= ");
        input2=new Scanner(System.in);
        int b=input1.nextInt();
        int result=a*b-a/b;
        System.out.println("Result            = "+result);
        inputplydiv=new Scanner(System.in);
        String inmain=inputplydiv.next();
        while(inmain!="D"){
            switch(inmain){
                case "A":
                    sumplus();
                case "B":
                    decmin();
                case "C":
                    plydiv();
                default:
                    break;
            }
        }
    }
}