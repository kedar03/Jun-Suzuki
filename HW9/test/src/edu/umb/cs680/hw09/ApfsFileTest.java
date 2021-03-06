package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.APFS;
import edu.umb.cs680.hw09.ApfsDirectory;
import edu.umb.cs680.hw09.ApfsFile;

class ApfsFileTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 12, 0, 0);
private String[] arraystringforfile(ApfsFile Elementforfs) {
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
	String[] informationoffile = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(), 
			Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(), 
			optionalDirectory.isPresent()?Elementforfs.getParent().getName():null, Elementforfs.getOwnerName(),Elementforfs.getLastModified().toString()};
	return informationoffile;
}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void initialize() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "kedar", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "kedar", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "kedar", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "kedar", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 700, localTime, "kedar", localTime);
		ApfsFile c = new ApfsFile(home, "c", 800, localTime, "kedar", localTime);
		ApfsFile d = new ApfsFile(home, "d", 80, localTime, "kedar", localTime);
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "kedar", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "kedar", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "kedar", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "kedar", localTime, b);
	}
	
	
	@Test
	public void verifyFileEqualityfile() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "e", "700", localTime.toString(), "code", "kedar", localTime.toString() };
		ApfsFile actual = root.findByName_File("e");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	@Test
	void testfordir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertTrue(root.findByName_Directory("root").isDirectory());
		assertTrue(root.findByName_Directory("home").isDirectory());
		assertTrue(root.findByName_Directory("applications").isDirectory());
		assertTrue(root.findByName_Directory("code").isDirectory());
		assertFalse(root.findByName_File("a").isDirectory());
		assertFalse(root.findByName_File("b").isDirectory());
		assertFalse(root.findByName_File("c").isDirectory());
		assertFalse(root.findByName_File("d").isDirectory());
		assertFalse(root.findByName_File("e").isDirectory());
		assertFalse(root.findByName_File("f").isDirectory());
	}
	
	@Test
	public void verifyFileEqualityforA() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications", "kedar", localTime.toString() };
		ApfsFile actual = root.findByName_File("a");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	
	@Test
	public void verifyFileEqualityforB() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications", "kedar", localTime.toString() };
		ApfsFile actual = root.findByName_File("b");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	
	@Test
	public void verifyFileEqualityforC() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "c", "800", localTime.toString(), "home", "kedar", localTime.toString() };
		ApfsFile actual = root.findByName_File("c");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	@Test
	public void verifyFileEqualityforD() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "d", "80", localTime.toString(), "home", "kedar", localTime.toString() };
		ApfsFile actual = root.findByName_File("d");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	
	
	@Test
	public void verifyFileEqualityforE() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "e", "700", localTime.toString(), "code", "kedar", localTime.toString() };
		ApfsFile actual = root.findByName_File("e");
		assertArrayEquals(expected,arraystringforfile(actual));
	}
	@Test
	public void verifyFileEqualityforF() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "f", "870", localTime.toString(), "code", "kedar", localTime.toString() };
		ApfsFile actual = root.findByName_File("f");
		assertArrayEquals(expected,arraystringforfile(actual));
	}

}
