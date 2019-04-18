import java.io.*;
import java.util.*;
import java.security.SecureRandom;

public class BucketSortv2{
    private static TreeMap<Character,ArrayList<String>> mainbucket=new TreeMap<Character,ArrayList<String>>();
    private static String[] stored;

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
                    stored=new String[count];
                    inputArray(count, length);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    showStrings();
                    System.out.println();
                    break;
                case 3:
                    readArray(count);
                    sortStrings();
                    moveToArray();
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

    private static void inputArray(int count,int length){
        for(int x=0;x<count;x++){
            stored[x]=generateStrings(length);
        }
        System.out.println("Strings has been generated");
    }

    private static void showStrings(){
        for(String res:stored){
            System.out.print(res+" ");
        }
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

    private static void readArray(int count){
        String value;
        Character key;
        int x=0;
        while(x<count){
            value=stored[x];
            key=Character.toLowerCase(value.charAt(0));
            if(mainbucket.get(key)==null){
                mainbucket.put(key,new ArrayList<String>());
            }
            mainbucket.get(key).add(value);
            x++;
        }
    }

    private static void sortStrings(){
        for(Map.Entry<Character,ArrayList<String>> itr:mainbucket.entrySet()){
            Collections.sort(itr.getValue());
        }
        System.out.println("Strings has been sorted");
    }

    private static void moveToArray(){
        int x=0,y;
        for(Map.Entry<Character,ArrayList<String>> itr:mainbucket.entrySet()){
            ArrayList<String> temp = itr.getValue();
            int z=temp.size()-1;
            y=0;
            while(z>=0){
                stored[x++]=temp.get(y++);
                z--;
            }
        }
    }
}