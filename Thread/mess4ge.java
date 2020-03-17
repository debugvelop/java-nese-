class RunThread implements Runnable{
    private Thread thread;
    private String threadName;
    
    RunThread(String name){
       threadName = name;
       System.out.println(threadName + " created");
    }
    
    public void run(){
       System.out.println(threadName + " run");
       try{
           System.out.println(threadName + ": Adhit - 18284");
           Thread.sleep(30);
       } catch(InterruptedException e){
          System.out.println(threadName + " interrupted");
       }
       System.out.println(threadName + " exiting");
    }
    
    public void start(){
       System.out.println(threadName + " started");
       if(thread == null){
          thread = new Thread(this, threadName);
          thread.start();
       }
    }
 }
 
 public class mess4ge{
    public static void main(String args[]){
       RunThread R1 = new RunThread("Thread_1");
       RunThread R2 = new RunThread("Thread_2");
       RunThread R3 = new RunThread("Thread_3");
       RunThread R4 = new RunThread("Thread_4");
       R1.start();
       R2.start();
       R3.start();
       R4.start();
    }   
 }