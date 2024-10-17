
import java.io.File;
import java.util.Scanner;





public class pra27 {
    public static void main(String[] args) {
        // File myFile = new File("this.txt");
        // try
        // {
        //     myFile.createNewFile();
        // }
        // catch(Exception e)
        // {
        //     System.out.println("error");
        // }

        //Write in file...
        // try {
        //     FileWriter myfile = new FileWriter("this.txt");
        //     myfile.write("hii,i am harsh kotadiya..../n jhhbuy8behv irb");
        //     myfile.close();
        // } catch (Exception e) {
        //     System.out.println("errrrr" + e);
        // }

        //reading a file

        File myFile = new File("this.txt");
        try{
            Scanner sc = new Scanner(myFile);
            while(sc.nextLine() != null)
            {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
        catch(Exception e)
        {

        }

    }
}
