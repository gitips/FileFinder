import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fileWriter {
	public static void main(String[] args){
		String fileLocation = "/Users/jaime/desktop/file.txt";
		String in = null;
		Scanner sc = new Scanner(System.in);
		try{
			PrintWriter outputStream = new PrintWriter(fileLocation);
			while(in != "//END"){
				outputStream.println(in = sc.nextLine());//saves to RAM
				outputStream.flush();//saves to file
			}
			outputStream.close();//closes and saves

		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
