import java.io.*;
import java.util.*;

public class fileReader {
	public fileReader(String path) {
		readFile(path);//"/Users/jaime/desktop/file.txt"
		// The name of the file to open.
	}
	public ArrayList<String> readFile(String path){
		String fileName = path;

		// This will reference one line at a time
		String line = null;
		ArrayList<String> content = new ArrayList<String>();

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				content.add(line);
			}   
			//System.out.println(line);
			// Always close files.
			bufferedReader.close();  
			
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'"); 
			
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");                  
			// Or we could just do this: 
			// ex.printStackTrace();
		}
		return content;
		
	}
}


