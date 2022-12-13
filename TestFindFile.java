
public class TestFindFile {
	

	public static void main(String[] args) {
		//TODO: Change this to your own Desktop's path
		String currentDir = "C:\\Users\\Joey\\Desktop";
		
		
		
		//Two files to search for
		String fileToFind = "Collin Schedule - Fall 2021.xlsx";
		String file2 = "catfish.txt";
		
		//Call your recursive function to see if they exist
		String pathOfFile = FindFile.recursiveFind(file2, currentDir);
		String pathOfFile2 = FindFile.recursiveFind(fileToFind, currentDir);
		
		//Print paths for both of these
		if(pathOfFile.compareTo("")==0) {System.out.println("File DNE.");}
		else	System.out.println(pathOfFile);
		
		if(pathOfFile2.compareTo("")==0) {System.out.println("File DNE.");}
		else	System.out.println(pathOfFile2);
	}

}
