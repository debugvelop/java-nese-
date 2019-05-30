import java.util.*;
import java.io.*;

public class PhoneBookMap{
    static File phonebook= new File("phonebook.txt");
    static TreeMap<String,String> maindata = new TreeMap<String,String>();
    static boolean isitsorted=false;
    static Scanner userInput;
    
    public static void main(String[] args){
        int menu=0;
        while(menu!=4){
            System.out.println("PhoneBook Manager");
            System.out.println("1. View PhoneBook");
            System.out.println("2. Sort PhoneBook");
            System.out.println("3. Search PhoneBook");
            System.out.println("4. Exit");
            System.out.print("Mode: ");
            userInput = new Scanner(System.in);
            menu = userInput.nextInt();
            switch(menu){
                case 1:
                    try {
                        System.out.println();
                        showPhoneBook();
                        System.out.println();
                    } catch (FileNotFoundException e) {}
                    break;
                case 2:
                    try {
                        sortPhoneBook();
                        isitsorted=true;
                        System.out.println();
                    } catch (FileNotFoundException e) {}
                    break;
                case 3:
                    try {
                        searchPhoneBook();
                        System.out.println();
                    } catch (FileNotFoundException e) {}
                    break;
                default:
                    userInput.close();
                    break;
            }
        }
    }

    public static void showPhoneBook() throws FileNotFoundException{
        if(!isitsorted){
            Scanner phonedata= new Scanner(phonebook);
            while(phonedata.hasNextLine()){
                if(phonedata.hasNext("[A-Za-z]+")){
                    System.out.print(phonedata.next()+" ");
                }
                do{
                    if(phonedata.hasNext("[0-9]+")){
                        System.out.print(phonedata.next()+" ");
                    }
                }while(phonedata.hasNext("[0-9]+"));
                System.out.println();
            }
            phonedata.close();
        }
        else{
            for(Map.Entry<String,String> count:maindata.entrySet()){    
                System.out.println(count.getKey()+" "+count.getValue());
            }
        }
    }

    public static void sortPhoneBook() throws FileNotFoundException{
        Scanner phonedata= new Scanner(phonebook);
        while(phonedata.hasNextLine()){
            String phonename="",phonenumber="";
            if(phonedata.hasNext("[A-Za-z]+")){
                phonename=phonedata.next();
            }
            do{
                if(phonedata.hasNext("[0-9]+")){
                    phonenumber=phonedata.next()+" "+phonenumber;
                }
            }while(phonedata.hasNext("[0-9]+"));
            maindata.put(phonename,phonenumber);
        }
        System.out.println("PhoneBook has been sorted");
        phonedata.close();
    }

    public static void searchPhoneBook() throws FileNotFoundException{
        System.out.print("Contact name  : ");
        Scanner phonedata= new Scanner(phonebook);
        userInput = new Scanner(System.in);
        String query= userInput.next();
        while(phonedata.hasNextLine()){
            String phonename="",phonenumber="";
            if(phonedata.hasNext("[A-Za-z]+")){
                phonename=phonedata.next();
            }
            do{
                if(phonedata.hasNext("[0-9]+")){
                    phonenumber=phonedata.next()+" "+phonenumber;
                }
            }while(phonedata.hasNext("[0-9]+"));
            maindata.put(phonename,phonenumber);
        }
        if(maindata.containsKey(query)){
            System.out.println("Contact number: "+maindata.get(query));
        }
        else{
            System.out.println("Contact not found");
        }
        phonedata.close();
    }
}