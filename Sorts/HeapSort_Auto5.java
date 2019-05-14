import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class HeapSort_Auto5{
    private static File randomNum=new File("randomNumber500k.txt");
    private static int[] mainArray;
    public static void main(String[] args) throws FileNotFoundException,UnsupportedEncodingException{
        File resultTime=new File("timeResultHeap.txt");
        PrintWriter inTime= new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultTime),"UTF-8")),false);
        Scanner inputLength=new Scanner(System.in);
        int length=inputLength.nextInt();
        mainArray=new int[length];
        for(int repeat=0;repeat<5;repeat++){
            System.gc();
            try {
                Scanner inputNum=new Scanner(randomNum);
                for(int counter=0;counter<length;counter++){
                    mainArray[counter]=inputNum.nextInt();
                }
                inputNum.close();
                long start=System.nanoTime();
                heapSort(mainArray);
                long end=System.nanoTime();
                inTime.println(TimeUnit.NANOSECONDS.toMillis(end-start)+" ms");
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            inputLength.close();
            System.gc();
        }
        inTime.close();
    }
    
    private static void heapSort(int[] heaps){
        for(int counter=(heaps.length/2)-1;counter>=0;counter--){
            buildMinHeap(counter,heaps.length,heaps);
        }
        for(int counter=heaps.length-1;counter>=0;counter--){
            int temp=heaps[0];
            heaps[0]=heaps[counter];
            heaps[counter]=temp;
            buildMinHeap(0,counter,heaps);
        }
    }

    private static void buildMinHeap(int root,int limit,int[] heaps){
        int ref=root;
        int left=(2*root)+1;
        int right=(2*root)+2;
        if(left<limit && heaps[left]>heaps[root]){
            root=left;
        }
        if(right<limit && heaps[right]>heaps[root]){
            root=right;
        }
        if(root!=ref){
            int temp=heaps[root];
            heaps[root]=heaps[ref];
            heaps[ref]=temp;
            buildMinHeap(root,limit,heaps);
        }
    }
}