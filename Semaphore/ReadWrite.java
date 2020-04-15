public class ReadWrite{
    private static int numOfReader=2;
    private static int numOfWriter=2;

    public static void main(String args[]){
        Database server=new Database();
        Reader[] readArray=new Reader[numOfReader];
        Writer[] writeArray=new Writer[numOfWriter];
        for(int count=0;count<numOfReader;count++){
            readArray[count]=new Reader(count, server);
            readArray[count].setPriority(1);
            readArray[count].start();
        }
        for(int count=0;count<numOfWriter;count++){
            writeArray[count]=new Writer(count,server);
            writeArray[count].setPriority(1);
            writeArray[count].start();
        }
    }
}

class Reader extends Thread{
    private Database server;
    private int readerID;

    public Reader(int reader, Database db){
        readerID=reader;
        server=db;
    }

    public void run(){
        int readCount;
        while(true){
            Database.hold();
            System.out.println("Reader "+readerID+" wants to read");
            readCount=server.startread();
            System.out.println("Reader "+readerID+" is reading (Read Count = "+readCount+")");
            Database.hold();
            System.out.println("Reader "+readerID+" is done reading");
            readCount=server.finishread();
        }
    }
}

class Writer extends Thread{
    private Database server;
    private int writerID;

    public Writer(int writer, Database db){
        writerID=writer;
        server=db;
    }

    public void run(){
        while(true){
            System.out.println("Writer "+writerID+" is sleeping");
            Database.hold();
            System.out.println("Writer "+writerID+" wants to write");
            server.startwrite();
            System.out.println("Writer "+writerID+" is writing");
            Database.hold();
            System.out.println("Writer "+writerID+" is done writing");
            server.finishwrite();
        }
    }
}

class Database{
    private int num_of_reader;
    private static final int duration=5;
    Semaphore db;
    Semaphore mutex;

    public Database(){
        num_of_reader=0;
        db=new Semaphore(1);
        mutex=new Semaphore(1);
    }

    public static void hold(){
        int sleepTime=(int)(duration*Math.random());
        try {
            Thread.sleep(sleepTime*1000);
        } catch (InterruptedException e) {}
    }

    public int startread(){
        mutex.close();
        ++num_of_reader;
        if(num_of_reader==1){
            db.close();
        }
        mutex.open();
        return num_of_reader;
    }

    public int finishread(){
        mutex.close();
        --num_of_reader;
        if(num_of_reader==0){
            db.open();
        }
        mutex.open();
        System.out.println("Reader count = "+num_of_reader);
        return num_of_reader;
    }

    public void startwrite(){
        db.close();
    }

    public void finishwrite(){
        db.open();
    }
}

final class Semaphore{
    private int value;

    public Semaphore(){
        value=0;
    }

    public Semaphore(int inputValue){
        value=inputValue;
    }

    public synchronized void close(){
        while(value<=0){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        value--;
    }

    public synchronized void open(){
        ++value;
        notify();
    }
}