public class pra32 implements Runnable{
    public void run(){
        System.out.println("hello world");
    }
    
    
    public static void main(String[]args)
    {
        pra32 t2=new pra32();
        Thread t1=new Thread(t2);
        t1.start();

}
 }