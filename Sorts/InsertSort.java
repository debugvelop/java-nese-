import java.util.*;
import java.io.*;

public class InsertSort{
    private static File randomNum=new File("randomNumber500k.txt");
    private static long[] mainArray;
    public static void main(String[] args){
        System.gc();
        int count=0;
        Scanner inputLength=new Scanner(System.in);
        int length=inputLength.nextInt();
        mainArray=new long[length];
        try {
            Scanner inputNum=new Scanner(randomNum);
            while(inputNum.hasNextByte()){
                mainArray[count++]=inputNum.nextLong();
            }
            inputNum.close();
            long start=System.nanoTime();
            insertSort(mainArray);
            long end=System.nanoTime();
            for(long e:mainArray){
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

    private static void insertSort(long[] array){
        for(int counter=1;counter<array.length;counter++){
            int anticounter=counter-1;
            long temp=array[counter];
            while(anticounter>=0){
                if(array[anticounter]>temp){
                    array[anticounter+1]=array[anticounter];
                    anticounter--;
                }
                else{
                    break;
                }
            }
            array[anticounter+1]=temp;
        }
    }
}