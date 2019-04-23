import java.util.*;
import java.io.*;

public class HeapTrain{
    public static void main(String[] args){
        int[] input={1,3,5,4,6,13,10,9,8,15,17};
        boolean stop=false;
        Heaps fooHeap=new Heaps(input.length);
        for(int e:input){
            fooHeap.inHeap(e);
        }
        while(!stop){
            System.out.println("Heap Operation Menu");
            System.out.println("1. Max Heap O(NlogN)");
            System.out.println("2. Min Heap O(NlogN)");
            System.out.println("3. Max Heap O(N)");
            System.out.println("4. Min Heap O(N)");
            System.out.println("5. Sort Max Heap");
            System.out.println("6. Sort Min Heap");
            System.out.println("7. Exit");
            System.out.print("Menu ");
            Scanner option=new Scanner(System.in);
            int choose=option.nextInt();
            switch(choose){
                case 1:
                    fooHeap.maxHeapLog();
                    fooHeap.showHeap();
                    break;
                case 2:
                    fooHeap.minHeapLog();
                    fooHeap.showHeap();
                    break;
                case 3:
                    fooHeap.maxHeapN();
                    fooHeap.showHeap();
                    break;
                case 4:
                    fooHeap.minHeapN();
                    fooHeap.showHeap();
                    break;
                case 5:
                    fooHeap.sortHeapAsc();
                    fooHeap.showHeap();
                    break;
                case 6:
                    fooHeap.sortHeapDes();
                    fooHeap.showHeap();
                    break;
                default:
                    stop=true;
                    option.close();
                    break;
            }
            System.out.println();
        }
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
        resultHeap=dataHeap.clone();
        int limit=(length-1)/2;
        for(int count=0;count<limit;count++){
            buildMinHeapLog(count,(count*2)+1,resultHeap);
            buildMinHeapLog(count,(count*2)+2,resultHeap);
        }
    }

    public void minHeapN(){
        resultHeap=dataHeap.clone();
        int start=(length-2)/2;
        int status;
        do{
            status=buildMinHeapN(start,resultHeap);
        }while(status!=0);
    }

    private void rebuildMax(int root,int[] heaps){
        int left=(root*2)+1;
        int right=(root*2)+2;
        if(left<=heaps.length-1){
            if(heaps[left]>heaps[right] && heaps[left]!=0){
                swapValue(root,left,heaps);
                rebuildMax(left,heaps);
            }
            else if(heaps[left]<heaps[right] && heaps[right]!=0){
                swapValue(root,right,heaps);
                rebuildMax(right,heaps);
            }
        }
    }

    private void rebuildMin(int root,int[] heaps){
        int left=(root*2)+1;
        int right=(root*2)+2;
        if(left<=heaps.length-1){
            if(heaps[left]<heaps[right] && heaps[left]!=0){
                swapValue(root,left,heaps);
                rebuildMin(left,heaps);
            }
            else if(heaps[left]>heaps[right] && heaps[right]!=0){
                swapValue(root,right,heaps);
                rebuildMin(right,heaps);
            }
        }
    }

    public int removeMax(){
        int pop;
        int index=0;
        pop=resultHeap[0];
        resultHeap[0]=0;
        for(int count=resultHeap.length-1;count>=0;count--){
            if(resultHeap[count]!=0){
                index=count;
                break;
            }
        }
        swapValue(0,index,resultHeap);
        rebuildMax(0,resultHeap);
        return pop;
    }

    public int removeMin(){
        int pop;
        int index=0;
        pop=resultHeap[0];
        resultHeap[0]=0;
        for(int count=resultHeap.length-1;count>=0;count--){
            if(resultHeap[count]!=0){
                index=count;
                break;
            }
        }
        swapValue(0,index,resultHeap);
        rebuildMin(0,resultHeap);
        return pop;
    }

    public void sortHeapAsc(){
        maxHeapN();
        int[] store=new int[resultHeap.length];
        for(int count=0;count<store.length;count++){
            store[count]=removeMax();
        }
        resultHeap=store.clone();
    }

    public void sortHeapDes(){
        minHeapN();
        int[] store=new int[resultHeap.length];
        for(int count=0;count<store.length;count++){
            store[count]=removeMin();
        }
        resultHeap=store.clone();
    }
}