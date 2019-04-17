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

    public void printHeap(int[] heaps){
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

    public int maxValue(int[] heaps){
        int top=heaps[0],count=0;
        while(count<length){
            if(top<heaps[count]){
                top=heaps[count];
            }
            count++;
        }
        return top;
    }

    public int minValue(int[] heaps){
        int down=heaps[0],count=0;
        while(count<length){
            if(down>heaps[count]){
                down=heaps[count];
            }
            count++;
        }
        return down;
    }

    public int getIndex(int value,int[] heaps){
        int count=0;
        while(count<length){
            if(heaps[count]==value){
                break;
            }
            count++;
        }
        return count;
    }

    public void swapValue(int index1,int index2,int[] heaps){
        int temp=heaps[index1];
        heaps[index1]=heaps[index2];
        heaps[index2]=temp;
    }

    public void buildMaxLog(int root,int node,int[] heaps){
        if(heaps[root]<heaps[node]){
            swapValue(root,node,heaps);
        }
        if(root!=0){
            buildMaxLog((root-1)/2,root,heaps);
        }
    }

    public int buildMaxN(int root,int[] heaps){
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
            buildMaxN((root-1),heaps);
        }
        return stop;
    }

    public void buildMinLog(int root,int node,int[] heaps){
        if(heaps[root]>heaps[node]){
            swapValue(root,node,heaps);
        }
        if(root!=0){
            buildMinLog((root-1)/2,root,heaps);
        }
    }

    public int buildMinN(int root,int[] heaps){
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
            buildMinN((root-1),heaps);
        }
        return stop;
    }

    public void maxHeapLog(){
        resultHeap=dataHeap.clone();
        int limit=(length-1)/2;
        for(int count=0;count<limit;count++){
            buildMaxLog(count,(count*2)+1,resultHeap);
            buildMaxLog(count,(count*2)+2,resultHeap);
        }
    }

    public void maxHeapN(){
        resultHeap=dataHeap.clone();
        int start=(length-2)/2;
        int status;
        do{
            status=buildMaxN(start,resultHeap);
        }while(status!=0);
    }

    public void minHeapLog(){
        resultHeap=dataHeap;
        int limit=(length-1)/2;
        for(int count=0;count<limit;count++){
            buildMinLog(count,(count*2)+1,resultHeap);
            buildMinLog(count,(count*2)+2,resultHeap);
        }
    }

    public void minHeapN(){
        resultHeap=dataHeap;
        int start=(length-2)/2;
        int status;
        do{
            status=buildMinN(start,resultHeap);
        }while(status!=0);
    }
}