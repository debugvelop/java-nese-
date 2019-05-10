import java.util.*;
import java.io.*;

public class SelectSort{
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
            selectSort(mainArray);
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