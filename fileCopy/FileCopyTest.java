package homework.fileCopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
	public static void main(String[] args) {
		File f = new File("folder_1");
		File nf = new File("newFolder");
		fileCopy(f,nf);
	}

	public static void fileCopy(File sourceFile, File destFile) {
		File[] fArr = sourceFile.listFiles();
		for (File fbuf : fArr) {
			if (fbuf.isDirectory()) {
				
				fileCopy(fbuf,destFile);
			} else {
				StringBuffer sb = new StringBuffer(destFile+"/");
				sb.append(fbuf.getParent());
				System.out.println("new file is: "+sb);
				BufferedInputStream bis=null;
				BufferedOutputStream bos=null;
				
				try {
					byte[] b_buf = new byte[10000];
					int count = 0;
					bis = new BufferedInputStream(new FileInputStream(fbuf.getPath()));
					new File(sb.toString()).mkdirs();
					sb.append("/"+fbuf.getName());
					bos = new BufferedOutputStream(new FileOutputStream(sb.toString()));
					while((count = bis.read(b_buf))>0) {
						bos.write(b_buf,0,count);
					}
				} 
				catch(FileNotFoundException e) {
					
					e.printStackTrace();
				}
				catch (IOException e) {
					
					e.printStackTrace();
				} finally {
					try {
						bis.close();
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
