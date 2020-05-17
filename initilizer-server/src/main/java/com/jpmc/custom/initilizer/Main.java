package com.jpmc.custom.initilizer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

	public static void main(String [] args) throws IOException {
		
		FileInputStream f = new FileInputStream("asserts/demo.zip");
        ZipInputStream zip = new ZipInputStream(new BufferedInputStream(f));
        ZipEntry e =  zip.getNextEntry();
        System.out.println(e.getName());
        e =  zip.getNextEntry();
        System.out.println(e.getName());
/*      zip.putNextEntry(new ZipEntry("initilizer/"));
        zip.putNextEntry(new ZipEntry("initilizer/initilizer-server/"));
        zip.putNextEntry(new ZipEntry("initilizer/initilizer-ui/"));
        zip.putNextEntry(new ZipEntry("initilizer/initilizer-web/"));
        zip.putNextEntry(new ZipEntry("initilizer/pom.xml"));*/
        zip.close();
	}
}
