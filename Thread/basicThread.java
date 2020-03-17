class RunThread implements Runnable{
   private Thread thread;
   private String threadName;
   
   RunThread(String name){
      threadName = name;
      System.out.println("Creating " + threadName);
   }
   
   public void run(){
      System.out.println("Running " + threadName);
      try{
         for(int iterate = 3; iterate > 0; iterate--){
            System.out.println(threadName + ", " + iterate);
            Thread.sleep(30);
         }
      } catch(InterruptedException e){
         System.out.println(threadName + " interrupted.");
      }
      System.out.println(threadName + " exiting.");
   }
   
   public void start(){
      System.out.println("Starting " + threadName );
      if(thread == null){
         thread = new Thread(this, threadName);
         thread.start();
      }
   }
}

public class basicThread{
   public static void main(String args[]){
      RunThread R1 = new RunThread("Thread_1");
      R1.start();
      
      RunThread R2 = new RunThread("Thread_2");
      R2.start();
   }   
}