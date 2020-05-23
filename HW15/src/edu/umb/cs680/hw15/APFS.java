package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

public class APFS extends FileSystem{

	private static APFS instance = null;
	
	private APFS() {};
	@Override
	protected FSElement createDefaultRoot() {
		LocalDateTime localTime = LocalDateTime.of(2020, 05, 22, 0, 0);
		ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "kedar", localTime);
		return root;
	}
	public static APFS getAPFSFileSystem() {
		if(instance==null)
			instance = new APFS ();
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println("Success from APFS.");
	}
}
