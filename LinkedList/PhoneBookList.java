import java.util.*;
import java.io.*;

public class PhoneBookList{
    static File phonebook= new File("phonebook.txt");
    static TreeMap <String,String> maindata = new TreeMap <String,String> ();
    static LinkedList phonemain= new LinkedList();
    public static void main(String[] args){
        int userInput=0;
        try {
            readPhoneBook();
        } catch (FileNotFoundException e) {}
        while(userInput!=6){
            System.out.println("PhoneBook Manager");
            System.out.println("1. View PhoneBook");
            System.out.println("2. Search PhoneBook");
            System.out.println("3. Add Contact Number");
            System.out.println("4. Edit Contact Number");
            System.out.println("5. Delete Contact Number");
            System.out.println("6. Exit");
            System.out.print("Mode: ");
            Scanner Input1 = new Scanner(System.in);
            userInput= Input1.nextInt();
            switch(userInput){
                case 1:
                    try {
                        System.out.println();
                        phonemain.showList();
                        System.out.println();
                    } catch (NullPointerException e) {}
                    break;
                case 2:
                    System.out.print("Contact name  : ");
                    Scanner Input2= new Scanner(System.in);
                    String query=Input2.next();
                    System.out.println("Contact number: "+phonemain.searchList(query));
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Contact name    : ");
                    Scanner Input3= new Scanner(System.in);
                    String aName=Input3.next();
                    addPhoneBook(aName);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Contact name    : ");
                    Scanner Input4= new Scanner(System.in);
                    String eName=Input4.next();
                    editPhoneBook(eName);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Contact name    : ");
                    Scanner Input5= new Scanner(System.in);
                    String dName=Input5.next();
                    removePhoneBook(dName);
                    System.out.println();
                    break;
                default:
                    Input1.close();
                    break;
            }
        }
    }

    public static void readPhoneBook() throws FileNotFoundException{
        Scanner phoneread= new Scanner(phonebook);
        while(phoneread.hasNextLine()){
            String phonename="",phonenumber="";
            if(phoneread.hasNext("[A-Za-z]+")){
                phonename=phoneread.next();
            }
            do{
                if(phoneread.hasNext("[0-9]+")){
                    phonenumber=phonenumber+phoneread.next()+" ";
                }
            }while(phoneread.hasNext("[0-9]+"));
            maindata.put(phonename,phonenumber);
        }
        phoneread.close();

        for(Map.Entry count:maindata.entrySet()){    
            phonemain.insert(count.getKey()+" "+count.getValue());
        }
    }

    public static void addPhoneBook(String query){
        String[] edit=new String[100];
        String getEdit=phonemain.searchList(query);
        String newData="";
        Scanner inEdit=new Scanner(getEdit);
        int put=0,x=0,y=1;
        do{
            edit[put]=inEdit.next();
            put++;
        }while(inEdit.hasNext("[0-9]+"));
        for(x=0;x<put;x++){
            System.out.println("Contact number "+y+": "+edit[x]);
            y++;
        }
        System.out.println();
        System.out.print("Add new number  : ");
        Scanner Input6=new Scanner(System.in);
        String addnum=Input6.next();
        System.out.println();
        edit[put]=addnum;
        put++;y=1;
        for(x=0;x<put;x++){
            System.out.println("Contact number "+y+": "+edit[x]);
            newData=newData+" "+edit[x];
            y++;
        }
        phonemain.addTo(query,newData);
    }

    public static void editPhoneBook(String query){
        String[] edit=new String[100];
        String getEdit=phonemain.searchList(query);
        String newData="";
        Scanner inEdit=new Scanner(getEdit);
        int put=0,x=0,y=1;
        do{
            edit[put]=inEdit.next();
            ++put;
        }while(inEdit.hasNext("[0-9]+"));
        for(x=0;x<put;x++){
            System.out.println("Contact number "+y+": "+edit[x]);
            y++;
        }
        System.out.println();
        System.out.print("Number index    : ");
        Scanner Input7=new Scanner(System.in);
        int edIndex=Input7.nextInt();
        System.out.print("Replace with    : ");
        Scanner Input71=new Scanner(System.in);
        String ednum=Input71.next();
        System.out.println();
        edit[edIndex-1]=ednum;
        y=1;
        for(x=0;x<put;x++){
            System.out.println("Contact number "+y+": "+edit[x]);
            newData=newData+" "+edit[x];
            y++;
        }
        phonemain.addTo(query,newData);
    }

    public static void removePhoneBook(String query){
        String[] edit=new String[100];
        String getEdit=phonemain.searchList(query);
        String newData="";
        Scanner inEdit=new Scanner(getEdit);
        int put=0,x=0,y=1;
        do{
            edit[put]=inEdit.next();
            ++put;
        }while(inEdit.hasNext("[0-9]+"));
        for(x=0;x<put;x++){
            System.out.println("Contact number "+y+": "+edit[x]);
            y++;
        }
        System.out.println();
        System.out.print("Number index    : ");
        Scanner Input8=new Scanner(System.in);
        int remIndex=Input8.nextInt();
        System.out.println();
        for(x=remIndex-1;x<put;x++){
            edit[x]=edit[x+1];
        }
        put--;y=1;
        for(x=0;x<put;x++){
            System.out.println("Contact number "+y+": "+edit[x]);
            newData=newData+" "+edit[x];
            y++;
        }
        phonemain.addTo(query,newData);
    }
}