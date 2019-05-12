import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class HeapSort{
    private static File randomNum=new File("randomNumber500k.txt");
    private static int[] mainArray;
    public static void main(String[] args) throws NoSuchElementException{
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
            heapSort(mainArray);
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
    
    private static void heapSort(int[] heaps){
        for(int counter=heaps.length/2-1;counter>=0;counter--){
            buildMaxHeap(0,heaps);
        }
        for(int counter=heaps.length-1;counter>=0;counter--){
            int temp=heaps[0];
            heaps[0]=heaps[counter];
            heaps[counter]=temp;
            buildMaxHeap(0,heaps);
        }
    }

    private static void buildMaxHeap(int root,int[] heaps){
        int parent=root;
        int left=(2*root)+1;
        int right=(2*root)+2;
        if(left<heaps.length && heaps[left]>heaps[root]){
            root=left;
        }
        else if(right<heaps.length && heaps[right]>heaps[root]){
            root=right;
        }
        if(root!=parent){
            int temp=heaps[parent];
            heaps[parent]=heaps[root];
            heaps[root]=temp;
            buildMaxHeap(root,heaps);
        }
    }
}