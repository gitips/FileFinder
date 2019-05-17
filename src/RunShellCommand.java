// file: RunShellCommandFromJava.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RunShellCommand{

	public RunShellCommand() {



	}

	public ArrayList<String> RunCommand(String command){
		ArrayList<String> result = new ArrayList<String>();
		Process proc = null;
		try {
			proc = Runtime.getRuntime().exec(command);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// Read the output

		BufferedReader reader =  
				new BufferedReader(new InputStreamReader(proc.getInputStream()));

		String line = "";
		try {
			while((line = reader.readLine()) != null) {
				//System.out.print(line + "\n");
				result.add(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			proc.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(result);
		return result; 
	}
} 