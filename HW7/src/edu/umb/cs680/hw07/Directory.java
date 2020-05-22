package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
	
	private LinkedList<FSElement> child;

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		if(parent != null)
			parent.appendChild(this);
	}
	
	public LinkedList<FSElement> getChildren() {
		return child;
	}


	public void appendChild(FSElement child) {
		if(this.child == null) {
			this.child = new LinkedList<FSElement>();
		}
		this.child.add(child);
	}


	public int countChildren() {
		return getChildren().size();
	}

	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> directories = new LinkedList<Directory>();
		for(FSElement s : getChildren()) {
			if(s instanceof Directory)
				directories.add((Directory) s);
		}
		return directories;	
	}
	public LinkedList<File> getFiles() {
		LinkedList<File> files = new LinkedList<File>();
		for(FSElement s : getChildren()) {
			if(s instanceof File)
				files.add((File) s);
		}
		return files;
	}



	
	public int getTotalSize() {
		int sizetotal = 0;
		for(FSElement s : getChildren()) {
			if(s instanceof Directory)
				sizetotal += ((Directory) s).getTotalSize();
			else
				sizetotal += s.getSize();
		}
		return sizetotal;
	}
	

	@Override
	public boolean isDirectory() {
		return true;
	}
	
	
	
	
	
	

	public Directory findByName_Directory(String dirName) {
		Directory namedirectory = null;
		if(dirName.equals(getName()))
			namedirectory = this;
		else {
			for(Directory dir : getSubDirectories()) {
				if(namedirectory == null) {
					namedirectory = dir.findByName_Directory(dirName);
					if(dirName.equals(dir.getName())) {
						namedirectory = dir;
						break;
					}
				}
			}
		}
		return namedirectory;
	}
	
	public File findByName_File(String nameoffile) {
		File namedfile = null;
		for(File f : getFiles()) {
			if(nameoffile.equals(f.getName()))
				namedfile = f;
		}
		if(namedfile == null) {
			for(Directory dir : getSubDirectories()) {
				namedfile = dir.findByName_File(nameoffile);
				if(namedfile != null)
					break;
			}
		}
		return namedfile;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Directory scan complete...");
	}
}
