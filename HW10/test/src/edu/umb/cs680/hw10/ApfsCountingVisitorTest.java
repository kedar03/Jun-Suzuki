package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AfpsCountingVisitorTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
	
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
	//count the visitors
	@Test
	void TestCountingVisitorvalue() {
		ApfsCountingVisitor count_visitor = new ApfsCountingVisitor();
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		root.accept(count_visitor);
		
		assertEquals(count_visitor.getDirNum(), 4);
		assertEquals(count_visitor.getFileNum(), 6);
		assertEquals(count_visitor.getLinkNum(), 2);
	}
	//testing code to check, need to remove later
	@Test
	void TestCountingVisitorvaluetry() {
		ApfsCountingVisitor count_visitor = new ApfsCountingVisitor();
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		root.accept(count_visitor);
		
		assertEquals(count_visitor.getDirNum(), 4);
		assertEquals(count_visitor.getFileNum(), 6);
		assertEquals(count_visitor.getLinkNum(), 2);
	}

}
