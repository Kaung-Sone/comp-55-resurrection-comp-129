package starter;

import java.io.File;

// Singleton class with eager initialization
// https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
public class LevelLoader {
	
	private static final LevelLoader instance = new LevelLoader();
	
	private LevelLoader() {
		createLevelsFromDirectory();
	}
	
	public static LevelLoader getInstance() {
		return instance;
	}
	
	public void rescanForLevels() {
		createLevelsFromDirectory();
	}
	
	//	This routine scans the 'levels' directory for subdirectories and parses each subdirectory into a Level object. The Level objects can then be retrieved via a method.
	private void createLevelsFromDirectory() {
//		Scan the 'levels' directory for subdirectories
		File levelsDirectory = new File("../media/levels");
		File levelsSubdirectories[] = levelsDirectory.listFiles(file -> file.isDirectory());
		
//		For each subdirectory...
		for (File subdirectory : levelsSubdirectories) {
			System.out.println("Found subdirectory: " + subdirectory.getName());
//		    Scan for files
//		    Verify if a .tmx, .png and a .tsx file exists
//		    If the files exist
//		        Create a Level object with the files
//		        Store the newly created object
//		    Else
//		        Log a warning message saying that the current subdirectory is skipped due to missing files
		}
	}

}