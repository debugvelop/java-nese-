import java.util.*;
//This hash algorithm uses modulo hash and open-addressing collision handle (Quadratic and Linear Probing)

public class HashTest{
    public static void main(String[] args){
        Hashes fooHash=new Hashes(2);
        boolean stop=false;
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
                    int counter=1;
                    System.out.print("Table size: ");
                    Scanner inSize=new Scanner(System.in);
                    int size=inSize.nextInt();
                    System.out.print("Data count: ");
                    Scanner inData=new Scanner(System.in);
                    int data=inData.nextInt();
                    fooHash=new Hashes(size);
                    fooHash.showHash();
                    while(counter<=data){
                        fooHash.hashIn(counter*2);
                        ++counter;
                    }
                    fooHash.showHash();
                    break;
                case 2:
                    System.out.print("Value: ");
                    Scanner inValue=new Scanner(System.in);
                    int value=inValue.nextInt();
                    fooHash.hashIn(value);
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
            System.out.println();
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

    public void hashIn(int input){
        if(hashTable[input%length]==0){
            hashTable[input%length]=input;
        }
        else{
            try{
                quadracticHandle(input,input%length);
            }catch(ArrayIndexOutOfBoundsException e){
                linearprobeHandle(input,input%length);
            }
        }
    }

    private void quadracticHandle(int input,int pos){
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
                    nextIn=nextIn%length;
                }
                if(hashTable[nextIn]==0){
                    hashTable[nextIn]=input;
                    stop=true;
                }
            }
            ++index;
        }
    }

    private void linearprobeHandle(int input,int pos){
        boolean stop=false;
        while(!stop){
            if(++pos>length-1){
                pos=pos%length;
            }
            if(hashTable[pos]==0){
                hashTable[pos]=input;
                stop=true;
            }
        }
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