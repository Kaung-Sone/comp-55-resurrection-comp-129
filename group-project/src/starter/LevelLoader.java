package starter;

import java.io.File;
import java.util.*;

// Singleton class with eager initialization
// https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
public class LevelLoader {
	
	private static final LevelLoader instance = new LevelLoader();
	private static List<Level> levels;
	
	private LevelLoader() {
		levels = new ArrayList<Level>();
		createLevelsFromDirectory();
	}
	
	public static LevelLoader getInstance() {
		return instance;
	}
	
	public void rescanForLevels() {
		levels.clear();
		createLevelsFromDirectory();
	}

	// This routine returns an array of Strings consisting of the level names. If there are no levels, returns an empty array
	public String[] getLevelNames() {
		String[] levelNames = new String[levels.size()];
		int levelsCount = levels.size();
		for (int i = 0; i < levelsCount; i++) {
			levelNames[i] = levels.get(i).getLevelName();
		}
		
		return levelNames;
	}
	
	
	// This routine returns a 'Level' object if the level with provided name is found. Otherwise, returns null
	public Level getLevelByName(String levelName) {
		for (Level l : levels) {
			if (l.getLevelName().equals(levelName)) {
				return l;
			}
		}
		return null;
	}
	

	//	This routine scans the 'levels' directory for subdirectories and parses each subdirectory into a Level object. The Level objects can then be retrieved via a method.
	private void createLevelsFromDirectory() {
//		Scan the 'levels' directory for subdirectories
		File levelsDirectory = new File("../media/levels");
		File levelsSubdirectories[] = levelsDirectory.listFiles(file -> file.isDirectory());
		
//		For each subdirectory...
		for (File subdirectory : levelsSubdirectories) {
//		    Scan for files
			File filesInSubdirectory[] = subdirectory.listFiles(file -> file.isFile());
			
//		    Verify if a .tmx, .png and a .tsx file exists
			File tmxFile = null;
			File pngFile = null;
			File tsxFile = null;
			boolean requiredFilesExist = true;
			
			for (File file : filesInSubdirectory) {
				if (file.getName().endsWith(".tmx")) {
					tmxFile = file;
				} else if (file.getName().endsWith(".png")) {
					pngFile = file;
				} else if (file.getName().endsWith(".tsx")) {
					tsxFile = file;
				} else {
					requiredFilesExist = false;
					break;
				}
			}
			
//		    If the files exist
			if (requiredFilesExist) {
//		        Create a Level object with the files
				Level temp = new Level(
					"/levels/" + subdirectory.getName() + "/" + tmxFile.getName(),
					"/levels/" + subdirectory.getName() + "/" + pngFile.getName(),
					subdirectory.getName()
				);
				
//		        Store the newly created object
				levels.add(temp);
				System.out.println("Level \"" + subdirectory.getName() + "\" has been loaded");
			}
//		    Else
			else {
//		        Log a warning message saying that the current subdirectory is skipped due to missing files
				System.out.println("Level \"" + subdirectory.getName() + "\" does not have the required files and is not loaded");
			}

		}
	}

}