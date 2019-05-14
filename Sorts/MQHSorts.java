import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class MQHSorts{
    private static File randomNum=new File("randomNumber500k.txt");
    private static int[] mainArray;
    public static void main(String[] args){
        boolean stop=false;
        System.out.println("Merge-Quick-Heap Sort");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Heap Sort");
        System.out.print("Menu ");
        Scanner option=new Scanner(System.in);
        int choose=option.nextInt();
        switch(choose){
            case 1:
                mergeSort();
                break;
            case 2:
                quickSort();
                break;
            case 3:
                heapSort();
                break;
            default:
                stop=true;
                option.close();
                break;
        }
    }

    public static void mergeSort(){
        System.gc();
        System.out.print("Data size = ");
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
            msort(mainArray);
            long end=System.nanoTime();
            System.out.println("Time Elapsed = "+TimeUnit.NANOSECONDS.toMillis(end-start)+" ms");
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

    private static void msort(int[] array){
        spliter(0,array.length-1,array);
    }

    public static void quickSort() throws NoSuchElementException{
        System.gc();
        System.out.print("Data size = ");
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
            qsort(mainArray);
            long end=System.nanoTime();
            System.out.println("Time elapsed = "+TimeUnit.NANOSECONDS.toMillis(end-start)+" ms");
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

    private static void qsorter(int[] array,int low,int high){
        if(low<high){
            int part=partitioner(array,low,high);
            qsorter(array,low,part-1);
            qsorter(array,part+1,high);
        }
    }

    private static void qsort(int[] array){
        int high=array.length;
        qsorter(array,0,high-1);
    }

    public static void heapSort() throws NoSuchElementException{
        System.gc();
        System.out.print("Data size = ");
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
            hsort(mainArray);
            long end=System.nanoTime();
            System.out.println("Time elapsed = "+TimeUnit.NANOSECONDS.toMillis(end-start)+" ms");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        inputLength.close();
        System.gc();
    }
    
    private static void hsort(int[] heaps){
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