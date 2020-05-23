package edu.umb.cs680.hw12;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;



public class AlphabeticalComparatorTest {
	
	APFS fs;

	private void befor() {
		fs = APFS.getFileSystem();
		ApfsElement root = new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);

		

		ApfsElement system = new ApfsDirectory(root, "System", 0, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);
		root.appendChild(system);
		
		ApfsElement home = new ApfsDirectory(root, "Home", 0, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);
		root.appendChild(home);
		
		ApfsElement picture = new ApfsDirectory(home, "Picture", 0, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);
		home.appendChild(picture);

		ApfsFile a = new ApfsFile(system, "a.txt", 100, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);

		ApfsFile b = new ApfsFile(system, "b.txt", 200, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);

		ApfsFile c = new ApfsFile(system, "c.txt", 100, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		
		ApfsFile d = new ApfsFile(home, "d.txt", 400, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);
		home.appendChild(d);

		
		ApfsFile e = new ApfsFile(picture, "e.txt", 500, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);

		ApfsFile f = new ApfsFile(picture, "f.txt", 100, LocalDateTime.of(2020, 05, 21, 3,0), "author", null);
		
		ApfsElement x = new ApfsLink(home, "x", 0, LocalDateTime.of(2020, 05, 21, 3,0), system, "author", null);
		home.appendChild(x);

		ApfsElement y = new ApfsLink(picture, "y", 0, LocalDateTime.of(2020, 05, 21, 3,0), e, "author", null);
		
		picture.appendChild(y);
		picture.appendChild(e);
		picture.appendChild(f);
		fs.setRoot(root);

	}
	

	@Test
	public void verifyLinkEqualitySystem() {
		befor();
		LinkedList<ApfsElement> l1 = ((ApfsDirectory)fs.getRoot()).getChildren();
		String str = l1.getFirst().getName();
		LinkedList<ApfsElement> l2 = ((ApfsDirectory)fs.getRoot()).getChildren(new AlphabeticalComparator());
		String str1 = l2.getFirst().getName();
		assertNotEquals(str, str1);
	}
}

