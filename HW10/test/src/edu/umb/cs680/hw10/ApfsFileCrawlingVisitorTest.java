package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AfspFileCrawlingVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
private String[] arraystringfordirectory(ArrayList<ApfsFile> files) {
	String[] filesInDir = new String[files.size()];
	int i = 0;
	for(ApfsFile f : files) {
		filesInDir[i] = f.getName();
		i++;
	}
	return filesInDir;
}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "kedar", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "kedar", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "kedar", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "kedar", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 700, localTime, "kedar", localTime);
		ApfsFile c = new ApfsFile(home, "c", 800, localTime, "kedar", localTime);
		ApfsFile d = new ApfsFile(home, "d", 80, localTime, "kedar", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "kedar", localTime, applications);
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "kedar", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "kedar", localTime);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "kedar", localTime, b);
	}
	
	
	@Test
	void checkFilesUnderHome() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory home = root.findByName_Directory("home");
		home.accept(visitor);
		String[] expected = {"e","f","c","d"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	
	
	@Test
	void test_Files_Root() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		root.accept(visitor);
		String[] expected = {"a","b","e","f","c","d"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	void test_Files_Applcations() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory system = root.findByName_Directory("applications");
		system.accept(visitor);
		String[] expected = {"a","b"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	@Test
	void test_Files_Code() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		ApfsDirectory pictures = root.findByName_Directory("code");
		pictures.accept(visitor);
		String[] expected = {"e","f"};
		ArrayList<ApfsFile> actual= visitor.getFiles();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	
}

