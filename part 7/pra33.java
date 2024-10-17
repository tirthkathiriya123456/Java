import java.util.*;

public class pra33 implements Runnable {
    
@Override
    public void run() {
        
        System.out.println(" thread is created");
       
       

    }

    public static void main(String[] args) {

        System.out.println("Enter  the total number of the tread you want to creat :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pra33 obj = new pra33();
        for (int i = 1; i <=n; i++) {
            Thread t = new Thread(obj);
            t.start();
        }
        sc.close();
    }
}