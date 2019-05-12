import java.util.*;
import java.security.*;
//This hash algorithm uses table-size modulo function and open-addressing collision handler (Quadratic,Linear Probing,Double Hashes)

public class HashTest{
    public static void main(String[] args){
        Hashes fooHash=new Hashes(2);
        boolean stop=false;
        Scanner inMethod;
        String method;
        while(!stop){
            System.out.println("Hash Operation Menu");
            System.out.println("1. Demo");
            System.out.println("2. Input");
            System.out.println("3. Search");
            System.out.println("4. Remove");
            System.out.println("5. Exit");
            System.out.print("Menu ");
            Scanner option=new Scanner(System.in);
            int choose=option.nextInt();
            switch(choose){
                case 1:
                    System.gc();
                    int counter=1;
                    System.out.print("Table size: ");
                    Scanner inSize=new Scanner(System.in);
                    int size=inSize.nextInt();
                    System.out.print("Data count: ");
                    Scanner inData=new Scanner(System.in);
                    int data=inData.nextInt();
                    System.out.print("Collision Method (L,Q,D): ");
                    inMethod=new Scanner(System.in);
                    method=inMethod.next();
                    fooHash=new Hashes(size);
                    SecureRandom randomer=new SecureRandom();
                    while(counter<=data){
                        fooHash.hashIn(randomer.nextInt(999),method);
                        ++counter;
                    }
                    fooHash.showHash();
                    System.out.println(fooHash.clusterCheck());
                    break;
                case 2:
                    System.out.print("Value: ");
                    Scanner inValue=new Scanner(System.in);
                    int value=inValue.nextInt();
                    System.out.print("Collision Method (L,Q,D): ");
                    inMethod=new Scanner(System.in);
                    method=inMethod.next();
                    fooHash.hashIn(value,method);
                    fooHash.showHash();
                    break;
                case 3:
                    System.out.print("Query: ");
                    Scanner inQuery=new Scanner(System.in);
                    int query=inQuery.nextInt();
                    System.out.println(fooHash.searchHash(query));
                    break;
                case 4:
                    System.out.print("Value: ");
                    Scanner outValue=new Scanner(System.in);
                    int remove=outValue.nextInt();
                    fooHash.hashOut(remove);
                    fooHash.showHash();
                    break;
                default:
                    stop=true;
                    option.close();
                    break;
            }
        }
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

    public void hashIn(int input,String method){
        if(hashTable[input%length]==0){
            hashTable[input%length]=input;
        }
        else{
            if(method=="L"){
                linearHandle(input,input%length);
            }
            else if(method=="Q"){
                quadracticHandle(input,input%length);
            }
            else if(method=="D"){
                doubleHash(input,input%length);
            }
            else{
                linearHandle(input,input%length);
            }
        }
    }

    private void quadracticHandle(int input,int pos){
        boolean stop=false;
        int counter=1;
        while(!stop){
            int index=(pos+(int) Math.pow(counter,2))%length;
            if(hashTable[index]==0){
                hashTable[index]=input;
                stop=true;
            }
            counter++;
        }
    }

    private void linearHandle(int input,int pos){
        boolean stop=false;
        while(!stop){
            pos++;
            if(hashTable[pos%length]==0){
                hashTable[pos%length]=input;
                stop=true;
            }
        }
    }

    private void doubleHash(int input,int pos){
        boolean stop=false;
        int counter=1;
        int key1=input%11;
        int key2=input%7;
        while(!stop){
            int index=(key1+(counter*(7-key2)))%length;
            if(hashTable[index]==0){
                hashTable[index]=input;
                stop=true;
            }
            counter=counter+2;
        }
    }

    public int clusterCheck(){
        int cluster=0;
        boolean flip=false;
        for(int counter=0;counter<hashTable.length;counter++){
            if(hashTable[counter]!=0 && !flip){
                ++cluster;
                flip=true;
            }
            else if(hashTable[counter]==0){
                flip=false;
            }
        }
        return cluster;
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

    public void hashOut(int remove){
        int pos=remove%length;
        if(hashTable[pos]==remove){
            hashTable[pos]=0;
        }
        else{
            int count=length-1;
            while(count>=0){
                if(++pos>length-1){
                    pos=pos%length;
                }
                if(hashTable[pos]==remove){
                    hashTable[pos]=0;
                    break;
                }
                --count;
            }
        }
    }
}