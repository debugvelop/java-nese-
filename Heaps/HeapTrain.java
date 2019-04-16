import java.util.*;
import java.io.*;

public class HeapTrain{
    public static void main(String[] args){
        Heaps fooHeap=new Heaps(5);
        fooHeap.inHeap(97);
        fooHeap.inHeap(53);
        fooHeap.inHeap(78);
        fooHeap.inHeap(46);
        fooHeap.inHeap(82);
        //System.out.print(fooHeap.maxValue()+" "+fooHeap.minValue());
    }
}

class Heaps extends HeapTrain{
    private int[] dataHeap;
    private int length,value,count,x=0;

    public Heaps(int length){
        this.length=length;
        dataHeap=new int[length];
    }

    public void inHeap(int value){
        this.value=value;
        dataHeap[x++]=value;
    }

    public int outHeap(){
        return dataHeap[--x];
    }

    public int maxValue(){
        int top=0;
        count=0;
        while(count<length){
            if(top<dataHeap[count]){
                top=dataHeap[count];
            }
            count++;
        }
        return top;
    }

    public int minValue(){
        int down=dataHeap[0];
        count=0;
        while(count<length){
            if(down>dataHeap[count]){
                down=dataHeap[count];
            }
            count++;
        }
        return down;
    }
}