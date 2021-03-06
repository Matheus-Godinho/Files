package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Item;
import model.entities.UpdatedItem;

public class Program {
	
	public static void createFile(File folder, File file) throws IOException {
		new File(folder.getPath()).mkdir();
		new File(file.getPath()).createNewFile();
	}
	
	public static void writeFile(List<Item> items, BufferedWriter bw) throws IOException {
		for (Item i: items) {
			bw.write(i.toString());
			bw.newLine();
		}
	}
	
	public static List<String[]> readFile(BufferedReader br) throws IOException {
		List<String[]> lines;
		String[] itemData;
		String line;
		
		lines = new ArrayList<>();
		line = br.readLine();
		while (line != null) {
			System.out.printf("%s%n", line);
			itemData = line.split(",");
			lines.add(itemData);
			line = br.readLine();
		}
		return lines;
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
			
			List<Item> items;
			
			items = new ArrayList<>();	
			items.add(new Item("TV LED", 1290.99, 1));
			items.add(new Item("Video Game Chair", 350.50, 3));
			items.add(new Item("Iphone X", 900.00, 2));
			items.add(new Item("Samsung Galaxy 9", 850.00, 2));
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()))) {
				writeFile(items, bw);
			}
			items.clear();
			
			List<String[]> lines;
			
			try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
				System.out.printf("%n%s data:%n", file.getName());
				lines = readFile(br);
			}
			for (String[] l: lines)
				items.add(new UpdatedItem(l[0], Double.parseDouble(l[1]), Integer.parseInt(l[2])));
			
			folder = new File(folder.getPath() + "\\out");
			file = new File(folder.getPath() + "\\summary.csv");
			createFile(folder, file);
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()))) {
				writeFile(items, bw);
			}
			try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
				System.out.printf("%n%s data:%n", file.getName());
				readFile(br);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		sc.close();
		
	}

}


