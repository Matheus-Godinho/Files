package application;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	
	public static void createFile(File folder, File file) throws IOException {
		new File(folder.getPath()).mkdir();
		new File(file.getPath()).createNewFile();
	}

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		File folder, file;
		
		try {
			System.out.printf("Enter a folder path for the file creation: ");
			folder = new File(sc.next());
			file = new File(folder.getPath() + "\\file.csv");
			createFile(folder, file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		sc.close();
		
	}

}
