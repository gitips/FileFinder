import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class finder {

	static String whatYouAreLookingFor = "2222.c";
	static int iterations = 0;
	static String path = "/volumes/info/file.txt";
	static String commandList = "/Users/asdf/desktop/bruh/practice/commando.txt";
	static String modifiedPath = "/";
	static String destination = "/volumes/info";
	//String in = "";
	static fileReader read = new fileReader(path);
	static Scanner sc = new Scanner(System.in);
	static FileList list = new FileList();
	static ArrayList<String> content = read.readFile(commandList);
	static RunShellCommand shell = new RunShellCommand();
	static PrintWriter outputStreamFile;
	static PrintWriter outputStreamCommandFile;
	//list.ListDir("/");
	public finder(String path) {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		//System.out.println(shell.RunCommand("cd /applications/Intel Power Gadget/powerlog"));
		try{
			outputStreamFile = new PrintWriter(path);
			outputStreamCommandFile = new PrintWriter(commandList);
			//System.out.println(list.ListDir(modifiedPath));
			
			//shell.RunCommand("./commando.sh");
			//./file.sh runs terminal commands from text file

			treeSearch(list.ListDir(modifiedPath),modifiedPath, null);
			for(int i = 0;i<content.size();i++){
				outputStreamCommandFile.println(content.get(i));
			}
			//}
			outputStreamFile.close();//closes and saves
			outputStreamCommandFile.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		sc.close();
	}
	public static void treeSearch(ArrayList<String> contents, String path, String nameOfDir){
		String onlyFileName = null;
		for(int i = 0; i<contents.size();i++){
			iterations++;
			System.out.println("!!!!!!!!!!!!!!!!!!!iterations: "+iterations+"\narray size: "+ contents.size());
			//System.out.println();

			onlyFileName = list.ListDir(modifiedPath).get(i).substring(modifiedPath.length());
			//System.out.println(onlyFileName);
			System.out.println("For Loop Count: "+i);
			System.out.println("Path: "+modifiedPath);
			System.out.println("Name of File: "+onlyFileName);
			if(onlyFileName.contains(".")){//if its a file
				System.out.println("Found a File");
				if(onlyFileName.contains(whatYouAreLookingFor)){//if its what you are looking for
					outputStreamCommandFile.println("cd /");
					outputStreamCommandFile.println("cd ../../..");
					outputStreamCommandFile.println("cd "+ modifiedPath);
					outputStreamCommandFile.println("cp "+modifiedPath+onlyFileName+" "+destination);
					outputStreamCommandFile.flush();
					shell.RunCommand("pwd");
					shell.RunCommand("cat "+"/Users/asdf/desktop/bruh/practice/commando.txt > "
							    + " "+"/Users/asdf/desktop/bruh/practice/commando.sh");
					shell.RunCommand("./commando.sh");
					System.out.println("/////k//////////Ran copy command//////////////////////");
				}//run command that copies and paste
			}
			else{//assumes its a directory
		//System.out.println("Found a dirctory "+"\n"+shell.RunCommand("cd "+modifiedPath+onlyFileName).size()+ modifiedPath+onlyFileName);
				System.out.println("Found a directory");
				String md2 = modifiedPath;
				modifiedPath += onlyFileName;//change directory
				if(list.ListDir(modifiedPath).size()!=0){//double checks if it is a directory
					treeSearch(list.ListDir(modifiedPath),modifiedPath, onlyFileName);//do again, but one directory below
				}
				else{
					modifiedPath = md2;
				}
				
				
			}

		}
		//return to old path
		modifiedPath = modifiedPath.substring(0, modifiedPath.length()-nameOfDir.length());
	}
}

