import java.util.*;

public class HashTest{
    public static void main(String[] args){
        int counter=1;
        Hashes fooHash=new Hashes(64);
        fooHash.showHash();
        while(counter<=56){
            fooHash.hashIn(counter*4);
            ++counter;
        }
        fooHash.showHash();
    }
}

class Hashes extends HashTest{
    private int[] hashTable;
    private int length;

    public Hashes(int length){
        this.length=length;
        hashTable=new int[length];
    }

    public void showHash(){
        for(int counter=0;counter<length;counter++){
            System.out.print(hashTable[counter]+" ");
        }
        System.out.println();
    }

    public void hashIn(int input){
        if(hashTable[input%53]==0){
            hashTable[input%53]=input;
        }
        else{
            collideHandle(input,input%53);
        }
    }

    public void collideHandle(int input,int pos){
        int index=1;
        boolean stop=false;
        while(!stop){
            int nextIn=pos+(int)Math.pow(index,2);
            if(nextIn<length-1){
                if(hashTable[nextIn]==0){
                    hashTable[nextIn]=input;
                    stop=true;
                }
            }
            else{
                while(nextIn>length-1){
                    nextIn=(nextIn-1)-(length-1);
                }
                if(hashTable[nextIn]==0){
                    hashTable[nextIn]=input;
                    stop=true;
                }
            }
            ++index;
        }
    }
}