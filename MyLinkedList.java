import java.util.*;

public class MyLinkedList{
    public static void main(String[] args){
        LinkedList<Integer> L1= new LinkedList<Integer>();
        LinkedList<Integer> L2= new  LinkedList<Integer>();
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(7);
        L1.add(9);
        L2.add(2);
        L2.add(4);
        L2.add(6);
        L2.add(8);
        L2.add(10);
        L1.addAll(L2);
        System.out.println(L1 + " ");
        int Long=L1.size();
        for(int count1=0;count1<Long;count1++){
            for(int count2=0;count2<Long-1;count2++){
                if(L1.get(count2)>L1.get(count2+1)){
                    int temp=L1.get(count2);
                    L1.set(count2,L1.get(count2+1));
                    L1.set(count2+1,temp);
                }
            }
        }
        System.out.println(L1 + " ");
        System.out.println(L2 + " ");
    }
}