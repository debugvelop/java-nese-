import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class SelectSort{
    private static File randomNum=new File("randomNumber500k.txt");
    private static int[] mainArray;
    public static void main(String[] args){
        System.gc();
        Scanner inputLength=new Scanner(System.in);
        int length=inputLength.nextInt();
        mainArray=new int[length];
        try {
            Scanner inputNum=new Scanner(randomNum);
            for(int counter=0;counter<length;counter++){
                mainArray[counter]=inputNum.nextInt();
            }
            inputNum.close();
            long start=System.nanoTime();
            selectSort(mainArray);
            long end=System.nanoTime();
            /*for(int e:mainArray){
                System.out.print(e+" ");
            }*/
            System.out.println(TimeUnit.NANOSECONDS.toMillis(end-start)+" ms");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        inputLength.close();
        System.gc();
    }

    private static void selectSort(int[] array){
        for(int counter=0;counter<array.length;counter++){
            int min=counter;
            for(int index=counter+1;index<array.length;index++){
                if(array[min]>array[index]){
                    min=index;
                }
            }
            int temp=array[counter];
            array[counter]=array[min];
            array[min]=temp;
        }
    }
}