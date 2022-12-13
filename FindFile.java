import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FindFile {
	
	private static ArrayList<String> getDirs(String currentDir)
	{
		// ------------------------------------------------------------
		// Returns a list of directories inside of a directory
		// Precondition: currentDir is the Directory you are checking
		// inside for directories.
		// Postcondition: returns ArrayList containing all directories inside
		// of a given directory, otherwise an empty ArrayList if none.
		// ------------------------------------------------------------
		
		//TODO: Create File object to hold directory contents
		
		File dir = new File(currentDir);							// Create java file from path
		
		//TODO: Do a directory listing (see File's documentation on 
		//		how to do this. You'll want to keep directory listing 
		//		in a structure like an array for now. You'll iterate
		//		through it later.	
		
		String[] allPaths = dir.list();								// Store all files and directories into array
		
		//TODO: Create a different structure to hold only list of directories
		//		Hint: Is there a structure I might've mentioned
		//		in the specifications PDF that can dynamically grow
		//		based on the # of items?
		//		Hint2: See function's return type. :)
		
		ArrayList<String> allDirs = new ArrayList<String>();
		
		//TODO: If directory listing results in null for the array
		//		(i.e., your first data structure), simply
		//		return the second (empty) data structure.
		

		//Note that this for-loop iterates through your first
		//array structure and saves items if they're a directory.
		//You'll hold these in your second data structure that 
		//dynamically grows.	
		
		for(int i = 0; i < allPaths.length; i++)
		{
						
			// TODO: If current item is hidden system file 
			//		(starts with "."), skip it. 
			
			
			if(allPaths[i].startsWith(".")) {						// Ignore hidden system files
				continue;
			}
			
			// TODO: If current item is directory, add to your structure
			//		created above for holding the directories. 

			String fullPath = currentDir + "\\" + allPaths[i];		// Create path string with file name string
			File f = new File(fullPath);							// Make java file using path
			
			if(f.isDirectory()) {									// Check if java file is a directory
				allDirs.add(allPaths[i]);							// If so, add to allDirs ArrayList
			}
			
			
		}
		
		//TODO: Sort dirs in ascending order, since
		// the system puts them in a weird order.

		allDirs.sort(String::compareToIgnoreCase);					// Sort all directories alphabetically
		
		//TODO: Return data structure holding the directories list.
				
		return allDirs;												// Return all directories ArrayList
	}
	
	private static ArrayList<String> getFiles(String currentDir)
	{
		// ---------------------------------------------------------
		// Returns a list of files inside of a directory
		// Precondition: currentDir is the Directory you are checking
		// inside for files.
		// Postcondition: returns ArrayList containing all files inside
		// of a given directory, otherwise an empty ArrayList if none.
		// ---------------------------------------------------------
		
		//TODO: Create File object to hold directory contents
		
		File dir = new File(currentDir);							// Create java file from path
		
		//TODO: Do a directory listing (see File's documentation on 
		//		how to do this. You'll want to keep directory listing 
		//		in a structure like an array for now. You'll iterate
		//		through it later.
		
		String[] allPaths = dir.list();								// Store all files and directories into array
		
		//TODO: Create a different structure to hold only list of files.
		//		Hint: Is there a structure I might've mentioned
		//		in the specifications PDF that can dynamically grow
		//		based on the # of items? 
		//		Hint2: See function's return type. :)
		
		ArrayList<String> allFiles = new ArrayList<String>();
		
		//TODO: If directory listing results in null for the array
		//		(i.e., your first data structure), simply
		//		return the second (empty) data structure.
		
		//Note that this for-loop iterates through your first
		//array structure and saves items if they're a directory.
		//You'll hold these in your second data structure that 
		//dynamically grows.
		
		for(int i = 0; i < allPaths.length; i++)
		{
			// TODO: If current item is hidden system file 
			//		(starts with "."), skip it. 
			
			if(allPaths[i].startsWith(".")) {						// Ignore hidden system files
				continue;
			}
			
			// TODO: If current item is file, add to your structure
			//		created above for holding the files. 
			
			String fullPath = currentDir + "\\" + allPaths[i];		// Create path string with file name string
			File f = new File(fullPath);							// Make java file using path
			
			if(f.isFile()) {										// Check if java file is a file
				allFiles.add(allPaths[i]);							// If so, add to allFiles ArrayList
			}
			
		}

		//TODO: Return data structure holding the files list.		
		
		allFiles.sort(String::compareToIgnoreCase);					// Sort all files alphabetically
		
		return allFiles;											// Return all files ArrayList
	}
	
	public static String recursiveFind(String fileToFind, String thisDir)
	{
		// ----------------------------------------------------------
		// Returns a string containing a path to the first instance of
		// a given file.
		// Precondition: fileToFind is a string containing the name of
		// the file you are searching for. thisDir is the directory you
		// are looking inside for the file.
		// Postcondition: returns String of the path to the file if found
		// otherwise returns empty string.
		// ----------------------------------------------------------
		
		String pathToReturn = "";
		
		//TODO: Create two ArrayList data structures
		//		To hold (1) your list of directories and
		//				(2) your list of files. 
		//		You'll need to call your functions defined above to
		//		populate these.
		
		ArrayList<String> dirsList = getDirs(thisDir);								// Get all directories in this directory
		ArrayList<String> filesList = getFiles(thisDir);							// Get all files in this directory
		
		
		// TODO: Implement base case -- we know this is the case
		//		 when there are no more subdirectories.
		
		if(dirsList.size()==0)														// If no directories
		{
			for(String s : filesList) {
				if(s.equals(fileToFind)) {											// Check remaining files for target file
					return thisDir + "\\" + s;										// Return path of target file if found
				} 
			}
			return "";																// Otherwise return empty string
		} else {																	// If there are remaining directories..
			for (String s : filesList) {
				if(s.equals(fileToFind)) {											// Check each file for target file
					return thisDir + "\\" + s;										// Return path of target file if found
				} 
			}
			
			for (String s : dirsList) {												// Go through remaining directories
				if(pathToReturn.compareTo("")==0) {
					pathToReturn = recursiveFind(fileToFind, thisDir + "\\" + s);	// Call recursive case looking for target and storing in pathToReturn
				}
			}
		}
		
		//TODO: Implement recursive case. Note that you'll likely
		//		need one or more if/else tests to cover all cases.
		//		Make sure you consider all file-directory combinations.
		
		
		
		//If nothing's found, return empty string.
		return pathToReturn;														// Return path (if found) or empty string
	}
}
