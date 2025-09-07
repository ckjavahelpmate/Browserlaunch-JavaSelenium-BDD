package com.utils;

import java.io.File;

public class CleanUtils {
	
	public static void cleanFolder(String folderName) {
        File screenshotFolder = new File(folderName);
        if (screenshotFolder.exists()) {
            for (File file : screenshotFolder.listFiles()) {
                file.delete();
            }
        }
    }

}
