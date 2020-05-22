package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DirectoryTest {
	
	static LocalDateTime localTime = LocalDateTime.now();
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		Directory root = new Directory(null, "root", 0, localTime);
		Directory applications = new Directory(root, "applications", 0, localTime);
		Directory home = new Directory(root, "home", 0, localTime);
		Directory code = new Directory(home, "code", 0, localTime);
		File a = new File(applications, "a", 1300, localTime);
		File b = new File(applications, "b", 350, localTime);
		File c = new File(home, "c", 500, localTime);
		File d = new File(home, "d", 700, localTime);
		File e = new File(code, "e", 70, localTime);
		File f = new File(code, "f", 130, localTime);
		//creation of files and adding root dir
		FileSystem.getFileSystem().addRootDir(root);
		
	}
	
	private String[] dirToStringArray(Directory d) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(), 
				Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				optionalDirectory.isPresent()?d.getParent().getName():null, 
						Integer.toString(d.getTotalSize()),
						Integer.toString(d.countChildren())};
		return directorystring;
	}


	
	@Test
	void testretDirectoryandFiles() {
		FileSystem f = FileSystem.getFileSystem();
		assertSame("home", f.getRootDirs().get(0).findByName_Directory("home").getName());
		assertSame("root", f.getRootDirs().get(0).findByName_Directory("root").getName());
		assertSame("applications", f.getRootDirs().get(0).findByName_Directory("applications").getName());
		assertSame("code", f.getRootDirs().get(0).findByName_Directory("code").getName());
		assertSame("a", f.getRootDirs().get(0).findByName_File("a").getName());
		assertSame("f", f.getRootDirs().get(0).findByName_File("f").getName());
	} 
	
	@Test
	void testforDirectoryandfiles() {
		FileSystem f = FileSystem.getFileSystem();
		assertTrue(f.getRootDirs().get(0).findByName_Directory("root").isDirectory());
		assertTrue(f.getRootDirs().get(0).findByName_Directory("home").isDirectory());
		assertTrue(f.getRootDirs().get(0).findByName_Directory("home").isDirectory());
		assertTrue(f.getRootDirs().get(0).findByName_Directory("code").isDirectory());
		assertFalse(f.getRootDirs().get(0).findByName_File("a").isDirectory());
		assertFalse(f.getRootDirs().get(0).findByName_File("b").isDirectory());
		assertFalse(f.getRootDirs().get(0).findByName_File("c").isDirectory());
		assertFalse(f.getRootDirs().get(0).findByName_File("d").isDirectory());
		assertFalse(f.getRootDirs().get(0).findByName_File("e").isDirectory());
		assertFalse(f.getRootDirs().get(0).findByName_File("f").isDirectory());
	}
	
	@Test
	public void verifyDirectoryEqualityCode() { 
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "200", "2" };
		Directory actual = f.getRootDirs().get(0).findByName_Directory("code");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	void testdirectoryfilenumbers() {
		FileSystem f = FileSystem.getFileSystem();
		assertSame("a", f.getRootDirs().get(0).findByName_Directory("applications").getFiles().get(0).getName());
		assertSame("b", f.getRootDirs().get(0).findByName_Directory("applications").getFiles().get(1).getName());
		assertSame("c", f.getRootDirs().get(0).findByName_Directory("home").getFiles().get(0).getName());
		assertSame("d", f.getRootDirs().get(0).findByName_Directory("home").getFiles().get(1).getName());
		assertSame("e", f.getRootDirs().get(0).findByName_Directory("code").getFiles().get(0).getName());
		assertSame("f", f.getRootDirs().get(0).findByName_Directory("code").getFiles().get(1).getName());
	}
	@Test
	public void verifyDirectoryEqualityHome() { 
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "1400", "3" };
		Directory actual = f.getRootDirs().get(0).findByName_Directory("home");
		assertArrayEquals(expected,dirToStringArray(actual));

	
	
	
	
	}
	@Test
	void testsubfilesandfoldersnumber() {
		FileSystem f = FileSystem.getFileSystem();
		assertEquals(2, f.getRootDirs().get(0).findByName_Directory("root").countChildren());
		assertEquals(2, f.getRootDirs().get(0).findByName_Directory("applications").countChildren());
		assertEquals(3, f.getRootDirs().get(0).findByName_Directory("home").countChildren());
		assertEquals(2, f.getRootDirs().get(0).findByName_Directory("code").countChildren());
	}
	
	
	@Test
	public void verifyDirectoryEqualityApplications() { 
		FileSystem f = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1650", "2" };
		Directory actual = f.getRootDirs().get(0).findByName_Directory("applications");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	
}

