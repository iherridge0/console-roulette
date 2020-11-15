package za.co.iherridge0.console.roulette.consoleroulette.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

	public List<String> csvtoStrings(String file) {
		List<String> strings = new ArrayList<>();
		try(BufferedReader in = new BufferedReader(new FileReader(file))) {
			String str;
			 while ((str = in.readLine()) != null) {
			        String[] splitStr = str.split(",");
			        strings.add(splitStr[0]);
			 }
			return strings;
		} catch (IOException e) {
		    System.out.println("File Read Error");
		    return null;
		}
	}
	
	public void saveStringsToCSV(String file, List<String> strings) {

		try {
			File oldFile = new File(file);
			oldFile.delete();
			File newFile = new File(file);
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(newFile, true));
			for(int x = 0; x < strings.size(); x++) {
				fileWriter.append(strings.get(x));
			}
			fileWriter.close();
		} catch (IOException e) {
		    System.out.println("File Read Error");
		}
		
	}
	
}
