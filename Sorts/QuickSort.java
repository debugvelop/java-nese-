import java.util.*;
import java.io.*;

public class QuickSort{
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
            quickSort(mainArray);
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

    private static int partitioner(int[] array,int low,int high){
        int pivot=array[high];
        int current=(low-1);
        for(int counter=low;counter<=high-1;counter++){
            if(array[counter]<=pivot){
                current++;
                int temp=array[current];
                array[current]=array[counter];
                array[counter]=temp;
            }
        }
        int temp=array[current+1];
        array[current+1]=array[high];
        array[high]=temp;
        return (current+1);
    }

    private static void sort(int[] array,int low,int high){
        if(low<high){
            int part=partitioner(array,low,high);
            sort(array,low,part-1);
            sort(array,part+1,high);
        }
    }

    private static void quickSort(int[] array){
        int high=array.length;
        sort(array,0,high-1);
    }
}