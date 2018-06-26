/**
 * 
 */
package com.main.java.zipit;

/**
 * @author ManishKumar_Roy
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipIt {
	public static void main(String[] a) throws Exception {
		//zipFolder("C:\\Users\\manishkumar_roy\\Desktop\\Docs", "C:\\Users\\manishkumar_roy\\Desktop\\Docs.zip");
		zipIt("C:\\Users\\manishkumar_roy\\Desktop\\Docs", "C:\\Users\\manishkumar_roy\\Desktop\\Docs.zip");
	}

	static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;

		fileWriter = new FileOutputStream(destZipFile);
		zip = new ZipOutputStream(fileWriter);

		addFolderToZip("", srcFolder, zip);
		zip.flush();
		zip.close();
	}

	static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
			throws Exception {

		File folder = new File(srcFile);
		if (folder.isDirectory()) {
			addFolderToZip(path, srcFile, zip);
		} else {
			byte[] buf = new byte[1024];
			int len;
			FileInputStream in = new FileInputStream(srcFile);
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
			while ((len = in.read(buf)) > 0) {
				zip.write(buf, 0, len);
			}
		}
	}

	static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
			throws Exception {
		File folder = new File(srcFolder);

		for (String fileName : folder.list()) {
			if (path.equals("")) {
				addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
			} else {
				addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
			}
		}
	}

	static private void zipIt(String srcFolder, String destZipFile) throws Exception{

		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;

		fileWriter = new FileOutputStream(destZipFile);
		zip = new ZipOutputStream(fileWriter);

		File folder = new File(srcFolder);

		for (String fileName : folder.list()) {

			byte[] buf = new byte[1024];
			int len;
			FileInputStream in = new FileInputStream(srcFolder+"/"+fileName);
			zip.putNextEntry(new ZipEntry(fileName));
			while ((len = in.read(buf)) > 0) {
				zip.write(buf, 0, len);
			}
		}
		
		zip.flush();
		zip.close();
	}
}
