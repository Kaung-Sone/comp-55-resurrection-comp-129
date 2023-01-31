# Super Mario Run - Lite
A group project for application developement class purely based on the old school mario.

## Overview

This new feature implements a new singleton class called `LevelLoader` to create a `Level` object for each level inside the 'level' directory.

A level is a directory that contains:
* A `.tmx` level layout file
* A `.png` image of the tileset
* A `.tsx` tileset layout file

The 'levels' directory can contain multiple levels. The new class will scan the 'levels' directory, and for each level subdirectory, it will parse its contents and create a new `Level` object for each level. The objects can be retrieved via a method.

## Pseudocode
```
This routine scans the 'levels' directory for subdirectories and parses each subdirectory into a Level object. The Level objects can then be retrieved via a method.

Scan the 'levels' directory for subdirectories
For each subdirectory...
    Scan for files
    Verify if a .tmx, .png and a .tsx file exists
    If the files exist
        Create a Level object with the files
        Store the newly created object
    Else
        Log a warning message saying that the current subdirectory is skipped due to missing files
```

## Demonstration
To observe the feature working change the level name that is inside `levelLoaderInstance.getLevelByName()` in `MainApplication.java line 54` to one of the below: 
- `OfficialLevel1`
- `smallertestlevel`
- `test`

The final line should look like this:   
```
MainApplication.java:54|  levelOne = levelLoaderInstance.getLevelByName("Your level name here");
```

These names come from the `level.*` resources that can be found under the `media` folder.
