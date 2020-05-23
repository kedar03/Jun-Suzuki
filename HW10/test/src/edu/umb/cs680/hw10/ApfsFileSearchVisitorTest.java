package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AfpsFileSearchVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
private String[] arraystringfordirectory(ApfsFile f) {
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(f.getParent());
	String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), 
			Integer.toString(f.getSize()), f.getCreationTime().toString(), 
			optionalDirectory.isPresent()?f.getParent().getName():null, f.getOwnerName(),f.getLastModified().toString()};
	return fileInfo;
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
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "kedar", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "kedar", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "kedar", localTime, applications);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "kedar", localTime, b);
	}
	
	
	
	@Test
	public void verifyFileEqualityA() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications", "kedar", localTime.toString() };
		apfsvisior.setFileName("a");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyFileEqualityB() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications", "kedar", localTime.toString() };
		apfsvisior.setFileName("b");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	public void verifyFileEqualityC() {
		ApfsFileSearchVisitor apfsvisior = new ApfsFileSearchVisitor();
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "false", "c", "800", localTime.toString(), "home", "kedar", localTime.toString() };
		apfsvisior.setFileName("c");
		root.accept(apfsvisior);
		ApfsFile actual = apfsvisior.getFile();
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	
	

}
