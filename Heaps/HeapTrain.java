import java.util.*;
import java.io.*;

public class HeapTrain{
    public static void main(String[] args){
        int[] input={1,3,5,4,6,13,10,9,8,15,17};
        Heaps fooHeap=new Heaps(input.length);
        for(int e:input){
            fooHeap.inHeap(e);
        }
        fooHeap.maxHeapLog();
        fooHeap.showHeap();
        fooHeap.minHeapLog();
        fooHeap.showHeap();
        fooHeap.maxHeapN();
        fooHeap.showHeap();
        fooHeap.minHeapN();
        fooHeap.showHeap();
    }
}

class Heaps extends HeapTrain{
    private int[] dataHeap;
    private int[] resultHeap;
    private int length,value,x=0;

    public Heaps(int length){
        this.length=length;
        dataHeap=new int[length];
        resultHeap=new int[length];
    }

    public void inHeap(int value){
        this.value=value;
        dataHeap[x++]=value;
    }

    private void printHeap(int[] heaps){
        for(int e:heaps){
            System.out.print(e+" ");
        }
        System.out.println();
    }

    public void showInput(){
        printHeap(dataHeap);
    }

    public void showHeap(){
        printHeap(resultHeap);
    }

    private int maxValue(int[] heaps){
        int top=heaps[0],count=0;
        while(count<length){
            if(top<heaps[count]){
                top=heaps[count];
            }
            count++;
        }
        return top;
    }

    private int minValue(int[] heaps){
        int down=heaps[0],count=0;
        while(count<length){
            if(down>heaps[count]){
                down=heaps[count];
            }
            count++;
        }
        return down;
    }

    private int getIndex(int value,int[] heaps){
        int count=0;
        while(count<length){
            if(heaps[count]==value){
                break;
            }
            count++;
        }
        return count;
    }

    private void swapValue(int index1,int index2,int[] heaps){
        int temp=heaps[index1];
        heaps[index1]=heaps[index2];
        heaps[index2]=temp;
    }

    private void buildMaxHeapLog(int root,int node,int[] heaps){
        if(heaps[root]<heaps[node]){
            swapValue(root,node,heaps);
        }
        if(root!=0){
            buildMaxHeapLog((root-1)/2,root,heaps);
        }
    }

    private int buildMaxHeapN(int root,int[] heaps){
        int left=(root*2)+1;
        int right=(root*2)+2;
        int stop=0;
        if(heaps[left]>heaps[right]){
            if(heaps[root]<heaps[left]){
                swapValue(root,left,heaps);
                stop++;
            }
        }
        else{
            if(heaps[root]<heaps[right]){
                swapValue(root,right,heaps);
                stop++;
            }
        }
        if(root!=0){
            buildMaxHeapN((root-1),heaps);
        }
        return stop;
    }

    private void buildMinHeapLog(int root,int node,int[] heaps){
        if(heaps[root]>heaps[node]){
            swapValue(root,node,heaps);
        }
        if(root!=0){
            buildMinHeapLog((root-1)/2,root,heaps);
        }
    }

    private int buildMinHeapN(int root,int[] heaps){
        int left=(root*2)+1;
        int right=(root*2)+2;
        int stop=0;
        if(heaps[left]<heaps[right]){
            if(heaps[root]>heaps[left]){
                swapValue(root,left,heaps);
                stop++;
            }
        }
        else{
            if(heaps[root]>heaps[right]){
                swapValue(root,right,heaps);
                stop++;
            }
        }
        if(root!=0){
            buildMinHeapN((root-1),heaps);
        }
        return stop;
    }

    public void maxHeapLog(){
        resultHeap=dataHeap.clone();
        int limit=(length-1)/2;
        for(int count=0;count<limit;count++){
            buildMaxHeapLog(count,(count*2)+1,resultHeap);
            buildMaxHeapLog(count,(count*2)+2,resultHeap);
        }
    }

    public void maxHeapN(){
        resultHeap=dataHeap.clone();
        int start=(length-2)/2;
        int status;
        do{
            status=buildMaxHeapN(start,resultHeap);
        }while(status!=0);
    }

    public void minHeapLog(){
        resultHeap=dataHeap;
        int limit=(length-1)/2;
        for(int count=0;count<limit;count++){
            buildMinHeapLog(count,(count*2)+1,resultHeap);
            buildMinHeapLog(count,(count*2)+2,resultHeap);
        }
    }

    public void minHeapN(){
        resultHeap=dataHeap;
        int start=(length-2)/2;
        int status;
        do{
            status=buildMinHeapN(start,resultHeap);
        }while(status!=0);
    }

    public void sortHeapAsc(){
    }

    public void sortHeapDes(){
    }
}