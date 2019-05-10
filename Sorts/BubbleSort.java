import java.util.*;
import java.io.*;

public class BubbleSort{
    private static File randomNum=new File("randomNumber.txt");
    private static int[] mainArray;
    public static void main(String[] args){
        System.gc();
        int count=0;
        Scanner inputLength=new Scanner(System.in);
        int length=inputLength.nextInt();
        mainArray=new int[length];
        try {
            Scanner inputNum=new Scanner(randomNum);
            while(inputNum.hasNextLine()){
                mainArray[count++]=inputNum.nextInt();
            }
            inputNum.close();
            long start=System.nanoTime();
            bubbleSort(mainArray);
            long end=System.nanoTime();
            for(int e:mainArray){
                System.out.print(e+" ");
            }
            System.out.println();
            System.out.println(end-start+" ns");
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        inputLength.close();
        System.gc();
    }

    private static void bubbleSort(int[] array){
        for(int counter=0;counter<array.length;counter++){
            for(int incounter=0;incounter<(array.length-counter)-1;incounter++){
                if(array[incounter]>array[incounter+1]){
                    int temp=array[incounter];
                    array[incounter]=array[incounter+1];
                    array[incounter+1]=temp;
                }
            }
        }
    }
}