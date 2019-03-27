import java.io.*;
import java.util.*;

public class BucketSort{
    private static TreeMap<Character,ArrayList<String>> mainbucket=new TreeMap<Character,ArrayList<String>>();
    private static File source=new File("stringsupdown.txt");
    private static String[] result;

    public static void main(String[] args){
        int option=0,count,length;
        try {
            readStrings();
        } catch (FileNotFoundException e) {}
        while(option!=3){
            System.out.println("This is a demo of Bucket Sort");
            System.out.println("1. View Strings");
            System.out.println("2. Sort Strings");
            System.out.println("3. Exit");
            System.out.print("Mode : ");
            Scanner modeInput= new Scanner(System.in);
            option=modeInput.nextInt();
            switch(option){
                case 1:
                    System.out.println();
                    showStrings();
                    System.out.println();
                    break;
                case 2:
                    sortStrings();
                    System.out.println();
                    break;
                default:
                    modeInput.close();
                    break;
            }
        }
    }

    private static void readStrings() throws FileNotFoundException{
        Scanner sourceRead=new Scanner(source);
        String value;
        Character key;
        while(sourceRead.hasNextLine()){
            value=sourceRead.next();
            key=Character.toLowerCase(value.charAt(0));
            if(mainbucket.get(key)==null){
                mainbucket.put(key,new ArrayList<String>());
            }
            mainbucket.get(key).add(value);
        }
        sourceRead.close();
    }

    private static void showStrings(){
        for(Map.Entry<Character,ArrayList<String>> itr:mainbucket.entrySet()){
            System.out.print(itr.getKey()+": ");
            for(String x:itr.getValue()){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    private static void sortStrings(){
        for(Map.Entry<Character,ArrayList<String>> itr:mainbucket.entrySet()){
            Collections.sort(itr.getValue());
        }
        System.out.println("Strings has been sorted");
    }
}