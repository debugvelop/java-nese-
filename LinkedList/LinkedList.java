import java.util.*;

public class LinkedList extends PhoneBookList{
    public Node first;

    public LinkedList(){
        first=null;
    }

    public Boolean isEmpty(){
        return (first==null);
    }

    public int getLength(){
        Node temp=first;
        int index=1;
        while(temp!=null){
            index++;
            temp=temp.next;
        }
        return index;
    }

    public void insertFirst(String inputdata){
        Node temp=new Node(inputdata);
        temp.next=first;
        temp.prev=null;
        first=temp;
    }

    public void insert(String inputdata){
        if(first!=null){
            Node temp=first;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new Node(inputdata);
            temp.next.prev=temp;
        }
        else{
            insertFirst(inputdata);
        }
    }

    public void deleteFirst(){
        first=first.next;
    }

    public void deleteLast(){
        Node temp=first;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }

    public void showList() throws NullPointerException{
        Node temp=first;
        while(temp!=null){
            System.out.println(temp.phonedata);
            temp=temp.next;
        }
    }

    public String searchList(String query) throws NullPointerException{
        Node temp=first;
        int mid=getLength()/2,step=0;
        Boolean found=false;
        while(step<mid){
            temp=temp.next;
            step++;
        }
        Scanner readtemp=new Scanner(temp.phonedata);
        String check=readtemp.next("[A-Za-z]+");
        String printnum="";
        int stats=check.compareToIgnoreCase(query);
        if(stats==0){
            do{
                if(readtemp.hasNext("[0-9]+")){
                    printnum=printnum+" "+readtemp.next();
                }
            }while(readtemp.hasNext("[0-9]+"));
            found=true;
            return printnum;
        }
        else if(stats>0){
            while(temp.prev!=null){
                temp=temp.prev;
                readtemp=new Scanner(temp.phonedata);
                check=readtemp.next("[A-Za-z]+");
                printnum=readtemp.next("[0-9]+");
                stats=check.compareToIgnoreCase(query);
                if(stats==0){
                    do{
                        if(readtemp.hasNext("[0-9]+")){
                            printnum=printnum+" "+readtemp.next();
                        }
                    }while(readtemp.hasNext("[0-9]+"));
                    found=true;
                    return printnum;
                }
            }
        }
        else{
            while(temp.next!=null){
                temp=temp.next;
                readtemp=new Scanner(temp.phonedata);
                check=readtemp.next("[A-Za-z]+");
                printnum=readtemp.next("[0-9]+");
                stats=check.compareToIgnoreCase(query);
                if(stats==0){
                    do{
                        if(readtemp.hasNext("[0-9]+")){
                            printnum=printnum+" "+readtemp.next();
                        }
                    }while(readtemp.hasNext("[0-9]+"));
                    found=true;
                    return printnum;
                }
            }
        }
        if(found==false){
            printnum="Not found";
        }
        return printnum;
    }

    public void addTo(String query,String newData){
        Node temp=first;
        int mid=getLength()/2,step=0;
        Boolean found=false;
        while(step<mid){
            temp=temp.next;
            step++;
        }
        Scanner readtemp=new Scanner(temp.phonedata);
        String check=readtemp.next("[A-Za-z]+");
        int stats=check.compareToIgnoreCase(query);
        if(stats==0){
            temp.phonedata=check+" "+newData;
            found=true;
            System.out.println("Contact numbers are saved");
        }
        else if(stats>0){
            while(temp.prev!=null){
                temp=temp.prev;
                readtemp=new Scanner(temp.phonedata);
                check=readtemp.next("[A-Za-z]+");
                stats=check.compareToIgnoreCase(query);
                if(stats==0){
                    temp.phonedata=check+" "+newData;
                    found=true;
                    System.out.println("Contact numbers are saved");
                }
            }
        }
        else{
            while(temp.next!=null){
                temp=temp.next;
                readtemp=new Scanner(temp.phonedata);
                check=readtemp.next("[A-Za-z]+");
                stats=check.compareToIgnoreCase(query);
                if(stats==0){
                    temp.phonedata=check+" "+newData;
                    found=true;
                    System.out.println("Contact numbers are saved");
                }
            }
        }
        if(found==false){
            System.out.println("Contact not exist");
        }
    }
}