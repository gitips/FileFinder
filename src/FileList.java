import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileList {
	
    public static void main(String[] args) throws IOException {
    	
    }
public ArrayList<String> ListDir(String Path){
	ArrayList<String> file = new ArrayList<String>();
	try{
	String dirName = Path;
    Files.list(new File(dirName).toPath())
            //.limit(10)
            .forEach(path -> {
                file.add(path.toString());
                //System.out.println(path);
            });
	}catch(IOException e){
		
	}
	return file;
}
}