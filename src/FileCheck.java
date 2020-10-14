import java.io.*;

public class FileCheck implements IFileCheck {

    public boolean fileExists(String srcFileName, Administrator admin) {
    	if (srcFileName != null) { // Check <src>
			//System.out.println("Counting Characters in: srcFilename = '" + srcFilename + "'");
			admin.srcFile = new File(srcFileName);
			if (!admin.srcFile.canRead()) {
				System.out.println("Cannot open File '" + srcFileName + "'");
				return false;
			}
			else {
				admin.filesList.add(srcFileName);
				System.out.println("[OK] Filename = '" + srcFileName + "'");
				return true;
			}
		}
		return false;
    }   
}