package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsLinkTest {
	
	static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
	private String[] stringelementforfs(FSElement Elementforfs) {
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
		String[] informationoffs = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(), 
				Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(), 
				optionalDirectory.isPresent()?Elementforfs.getParent().getName():null};
		return informationoffs;
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
	public void testforhome() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "home", "0", localTime.toString(), "root" };
		ApfsDirectory actual = root.findByName_Directory("home");
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	
	@Test
	public void verifyTargetEqualitya() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications" };
		// this needs to return true for applications as b is a  part of applications but still returning false.
		ApfsFile actual = root.findByName_File("a");
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	@Test
	public void verifyTargetEqualityB() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications" };
		// this needs to return true for applications as b is a  part of applications but still returning false.
		ApfsFile actual = root.findByName_File("b");
		assertArrayEquals(expected,stringelementforfs(actual));
	}

}

