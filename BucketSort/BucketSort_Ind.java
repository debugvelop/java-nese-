import java.io.*;
import java.util.*;
import java.security.SecureRandom;

public class BucketSort_Ind{
    private static TreeMap<Character,ArrayList<String>> mainbucket=new TreeMap<Character,ArrayList<String>>();
    private static String[] result;

    public static void main(String[] args){
        int option=0,count=0,length=0;
        while(option!=4){
            System.out.println("This is a demo of Bucket Sort");
            System.out.println("1. Generate Strings");
            System.out.println("2. View Strings");
            System.out.println("3. Sort Strings");
            System.out.println("4. Exit");
            System.out.print("Mode : ");
            Scanner modeInput= new Scanner(System.in);
            option=modeInput.nextInt();
            switch(option){
                case 1:
                    System.out.print("How many characters you want? ");
                    Scanner lenInput= new Scanner(System.in);
                    length=lenInput.nextInt();
                    System.out.print("How many strings you want? ");
                    Scanner countInput= new Scanner(System.in);
                    count=countInput.nextInt();
                    try{
                        readStrings(count,length);
                    } catch(FileNotFoundException e){}
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    showStrings(count);
                    System.out.println();
                    break;
                case 3:
                    sortStrings();
                    System.out.println();
                    break;
                case 4:
                    modeInput.close();
                    break;
                default:
                    System.out.println("Wrong input");
                    System.out.println();
            }
        }
    }

    private static void readStrings(int count,int length) throws FileNotFoundException{
        String value;
        Character key;
        int x=count;
        while(x>=1){
            value=generateStrings(length);
            key=Character.toLowerCase(value.charAt(0));
            if(mainbucket.get(key)==null){
                mainbucket.put(key,new ArrayList<String>());
            }
            mainbucket.get(key).add(value);
            --x;
        }
        System.out.println("Strings has been generated");
    }

    private static String generateStrings(int length){
        String listRandom="aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
        StringBuffer RandomStr=new StringBuffer(length);
        SecureRandom secRandom=new SecureRandom();
        for(int x=0;x<length;x++){
            RandomStr.append(listRandom.charAt(secRandom.nextInt(listRandom.length())));
        }
        return RandomStr.toString();
    }

    private static void showStrings(int count){
        int x=0,y;
        result=new String[count];
        for(Map.Entry<Character,ArrayList<String>> itr:mainbucket.entrySet()){
            ArrayList<String> temp = itr.getValue();
            int z=temp.size()-1;
            y=0;
            while(z>=0){
                result[x++]=temp.get(y++);
                z--;
            }
        }
        for(String res:result){
            System.out.println(res);
        }
    }

    private static void sortStrings(){
        for(Map.Entry<Character,ArrayList<String>> itr:mainbucket.entrySet()){
            Collections.sort(itr.getValue());
        }
        System.out.println("Strings has been sorted");
    }
}