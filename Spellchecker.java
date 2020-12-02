import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;


public class Spellchecker {
	ArrayList<String> wordList = new ArrayList<String>();
	HashSet mySet = new HashSet();
	//Creates a Spellchecker based on a dictionary given at creation.  dictionaryFileName is the name
	// of the file where the dictionary is to be found.  
	public Spellchecker(String dictionaryFileName, boolean ds1) throws FileNotFoundException
	{
		File file = new File (dictionaryFileName);
		Scanner sc = new Scanner(file);
		if (ds1==true)
			while (sc.hasNext() == true)
				mySet.add(sc.next());
		else
			while (sc.hasNext() == true)
				wordList.add(sc.next());
	}

	// Searches the file given by textFileName for all spelling errors, and outputs
	// every word in that file that's not found in the dictionary to the file given by
	// outputFileName.
	public void findErrors (String textFileName, String outputFileName, boolean ds1) throws FileNotFoundException
	{
		File file = new File (textFileName);
		Scanner sc = new Scanner(file);
		String errors = "";
		if (ds1==true)
			while (sc.hasNext() == true)
				if (mySet.contains(sc.next()) == false)
					errors += sc.next();
				//Searches for spelling errors
				//Outputs every word not found in the dictionary to outputFileName				
		else
			while (sc.hasNext() == true)
				if (wordList.contains(sc.next()) == false)
					errors += sc.next();		
		File errorHolder = new File (outputFileName);
		PrintWriter errorWriter = new PrintWriter (outputFileName);
		
	}
}
