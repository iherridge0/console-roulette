package za.co.iherridge0.console.roulette.consoleroulette.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import za.co.iherridge0.console.roulette.consoleroulette.entity.Player;

public class CSVHelper {

	public List<Player> csvToPlayers(String file) {
		List<Player> players = new ArrayList<>();
		try(BufferedReader in = new BufferedReader(new FileReader(file))) {
			String str;
			 while ((str = in.readLine()) != null) {
			        String[] splitStr = str.split(",");
			        Player player;
			        String name = splitStr[0]; 
			        if(splitStr.length > 1) {
			        	double totalBet = Double.valueOf(splitStr[1].trim());
			        	double totalWon = Double.valueOf(splitStr[2].trim());
			        	player = new Player(name, totalBet, totalWon);
			        } else {
			        	player = new Player(name);
			        }
			        players.add(player);
			 }
			return players;
		} catch (IOException e) {
		    System.out.println("File Read Error");
		    return null;
		}
	}
	
	public void saveToCSV(String file, List<Player> players) {

		try {
			File oldFile = new File(file);
			oldFile.delete();
			File newFile = new File(file);
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(newFile, true));
			for(Player player: players) {
				fileWriter.append(player.getName() + ", ");
				fileWriter.append(String.valueOf(player.getTotalWon()) + ", ");
				fileWriter.append(String.valueOf(player.getTotalBet()) + "\n");
			}
			fileWriter.close();
		} catch (IOException e) {
		    System.out.println("File Read Error");
		}
		
	}
	
}
