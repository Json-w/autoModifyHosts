package com.jsonwang.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * this class is use to write the resource to the targetFile which the default
 * value is the host file path.
 */
public class FileOperator {
	private File targetFile = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");
	private InputStream resource;

	public FileOperator() {

	}

	public void setTargetFile(File file) {
		// TODO Auto-generated method stub
		this.targetFile = file;
	}

	public void setResource(InputStream inputStream) {
		this.resource = inputStream;
	}

	public void wirte() {
		OutputStream out = null;
		try {
			out = new FileOutputStream(targetFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int b;
		try {
			while ((b = resource.read()) != -1) {
				out.write(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			close();
		}
	}

	private void close() {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
