package edu.umb.cs680.hw10;

import java.time.LocalDateTime;


public class APFS extends FileSystem{
	public static APFS getAPFSFileSystem() {
		if(classinst==null)
			classinst = new APFS ();
		return classinst;
	}
	private static APFS classinst = null;
	@Override
	protected FSElement createDefaultRoot() {
		LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
		ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "kedar", localTime);
		return root;
	}
	private APFS() {};
	
	

	
	
	public static void main(String[] args) {
		System.out.println("Success from APFS.");
	}
}
