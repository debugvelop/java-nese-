import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class MergeSort{
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
            mergeSort(mainArray);
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

    private static void sorter(int low,int mid,int high,int[] array){
        int left=(mid+1)-low;
        int right=high-mid;

        int[] Left=new int[left];
        int[] Right=new int[right];

        for(int counter=0;counter<left;counter++){
            Left[counter]=array[low+counter];
        }
        for(int counter=0;counter<right;counter++){
            Right[counter]=array[mid+counter+1];
        }

        int x=0;
        int y=0;
        int z=low;
        while(x<left && y<right){
            if(Left[x]<=Right[y]){
                array[z]=Left[x];
                x++;
            }
            else{
                array[z]=Right[y];
                y++;
            }
            z++;
        }
        while(x<left){
            array[z]=Left[x];
            x++;
            z++;
        }
        while(y<right){
            array[z]=Right[y];
            y++;
            z++;
        }
    }

    private static void spliter(int low,int high,int[] array){
        if(low<high){
            int mid=low+(high-low)/2;
            spliter(low,mid,array);
            spliter(mid+1,high,array);
            sorter(low,mid,high,array);
        }
    }

    private static void mergeSort(int[] array){
        spliter(0,array.length-1,array);
    }
}