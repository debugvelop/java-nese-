import java.util.*;
import java.security.*;
//Alexius Adhitya K_18/424179/PA/181284

public class HashTask{
    public static void main(String[] args){
        Hash fooHash=new Hash(2);
        boolean stop=false;
        while(!stop){
            System.out.println("Hash Operation Menu");
            System.out.println("1. Input");
            System.out.println("2. Search");
            System.out.println("3. Exit");
            System.out.print("Menu ");
            Scanner option=new Scanner(System.in);
            int choose=option.nextInt();
            switch(choose){
                case 1:
                    System.gc();
                    int counter=1;
                    boolean isPrime;
                    int size;
                    Scanner inSize;
                    do{
                        System.out.print("Table size (Prime number): ");
                        inSize=new Scanner(System.in);
                        size=inSize.nextInt();
                        isPrime=checkPrime(size);
                    }while(!isPrime);
                    System.out.println();
                    boolean isSmaller;
                    int data;
                    Scanner inData;
                    do{
                        System.out.print("Data count (<=Table size): ");
                        inData=new Scanner(System.in);
                        data=inData.nextInt();
                        isSmaller=true;
                        if(data>size){
                            isSmaller=false;
                        }
                    }while(!isSmaller);
                    fooHash=new Hash(size);
                    SecureRandom randomer=new SecureRandom();
                    while(counter<=data){
                        fooHash.hashIn(randomer.nextInt(999999999));
                        ++counter;
                    }
                    fooHash.rehashIn();
                    System.out.println();
                    fooHash.showHash();
                    System.out.println();
                    System.out.print("Probing Attempt: ");
                    System.out.printf("%.3f",fooHash.probeStats());
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Query: ");
                    Scanner inQuery=new Scanner(System.in);
                    int query=inQuery.nextInt();
                    if(fooHash.searchHash(query)==true){
                        System.out.println("Data found!");
                    }
                    else{
                        System.out.println("Data not found!");
                    }
                    break;
                default:
                    stop=true;
                    option.close();
                    break;
            }
            System.out.println();
        }
    }

    private static boolean checkPrime(int query){
        boolean isPrime=true;
        if(query==0 || query==1){
            isPrime=false;
        }
        else if(query==2 || query==3){
            isPrime=true;
        }
        else{
            for(int div=2;div<=query/2;div++){
                if(query%div==0){
                    isPrime=false;
                    break;
                }
            }
        }
        return isPrime;
    }
}

class Hash extends HashTest{
    private int[] hashTable;
    private ArrayList queue=new ArrayList();
    private int length;
    private int qLine=0;
    private float dataIn=0;
    private float probeTry=0;

    public Hash(int length){
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
        if(hashTable[input%length]==0){
            hashTable[input%length]=input;
        }
        else{
            queueIn(input);
        }
    }

    public void rehashIn(){
        dataIn=queue.size();
        for(int counter=0;counter<queue.size();counter++){
            int e=(int) queue.get(counter);
            linearHandle(e,e%length);
        }
        queue.clear();
    }

    private void queueIn(int input){
        queue.add(input);
    }

    private void linearHandle(int input,int pos){
        boolean stop=false;
        while(!stop){
            ++probeTry;
            pos++;
            if(hashTable[pos%length]==0){
                hashTable[pos%length]=input;
                stop=true;
            }
        }
    }

    public float probeStats(){
        float stats=probeTry/dataIn;
        return stats;
    }

    public boolean searchHash(int query){
        boolean found=false;
        int pos=query%length;
        if(hashTable[pos]==query){
            found=true;
        }
        else{
            int count=length-1;
            while(count>=0){
                if(++pos>length-1){
                    pos=pos%length;
                }
                if(hashTable[pos]==query){
                    found=true;
                    break;
                }
                --count;
            }
        }
        return found;
    }
}