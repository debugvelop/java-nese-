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
            System.out.println("1. Max Heap");
            System.out.println("2. Min Heap");
            System.out.println("3. Sort Max Heap");
            System.out.println("4. Sort Min Heap");
            System.out.println("5. Exit");
            System.out.print("Menu ");
            Scanner option=new Scanner(System.in);
            int choose=option.nextInt();
            switch(choose){
                case 1:
                    fooHeap.maxHeap();
                    fooHeap.showHeap();
                    break;
                case 2:
                    fooHeap.minHeap();
                    fooHeap.showHeap();
                    break;
                case 3:
                    fooHeap.sortHeapAsc();
                    fooHeap.showHeap();
                    break;
                case 4:
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

    private void buildMinHeap(int root,int limit,int[] heaps){
        int ref=root;
        int left=(2*root)+1;
        int right=(2*root)+2;
        if(left<limit && heaps[left]<heaps[root]){
            root=left;
        }
        if(right<limit && heaps[right]<heaps[root]){
            root=right;
        }
        if(root!=ref){
            int temp=heaps[root];
            heaps[root]=heaps[ref];
            heaps[ref]=temp;
            buildMinHeap(root,limit,heaps);
        }
    }

    private void buildMaxHeap(int root,int limit,int[] heaps){
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
            swapValue(root,ref,resultHeap);
            buildMaxHeap(root,limit,heaps);
        }
    }

    public void minHeap(){
        resultHeap=dataHeap.clone();
        for(int counter=length/2-1;counter>=0;counter--){
            buildMinHeap(counter,length,resultHeap);
        }
    }

    public void maxHeap(){
        resultHeap=dataHeap.clone();
        for(int counter=length/2-1;counter>=0;counter--){
            buildMaxHeap(counter,length,resultHeap);
        }
    }

    public void sortHeapAsc(){
        maxHeap();
        for(int counter=length-1;counter>=0;counter--){
            swapValue(0,counter,resultHeap);
            buildMaxHeap(0,counter,resultHeap);
        }
    }

    public void sortHeapDes(){
        minHeap();
        for(int counter=length-1;counter>=0;counter--){
            swapValue(0,counter,resultHeap);
            buildMinHeap(0,counter,resultHeap);
        }
    }
}