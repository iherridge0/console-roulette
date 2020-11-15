package za.co.iherridge0.console.roulette.consoleroulette;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import za.co.iherridge0.console.roulette.consoleroulette.entity.Game;
import za.co.iherridge0.console.roulette.consoleroulette.entity.Player;
import za.co.iherridge0.console.roulette.consoleroulette.helper.CSVHelper;
import za.co.iherridge0.console.roulette.consoleroulette.repository.GameRepository;
import za.co.iherridge0.console.roulette.consoleroulette.repository.PlayerRepository;

@Component
public class ConsoleRouletteCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(ConsoleRouletteCommandLineRunner.class);
	
	private static final String file = "C:\\roulette\\scores";
	
	@Autowired
	PlayerRepository playerService;
	
	@Autowired
	GameRepository gameService;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Starts the Roulette Thread that calculates a new random number between 1 - 36 every 30seconds
		RouletteBallThread thread = new RouletteBallThread();
		thread.setGameService(gameService);
		thread.start();
		
		//"Test: reading from file: " + file);
		CSVHelper csvHelper = new CSVHelper();
		List<String> names = csvHelper.csvtoStrings(file);
		for(String name: names) {
			Player player = new Player(name);
			playerService.save(player);
		}
		
		while(true) {
			
			Scanner scan = new Scanner(System.in); 
			String name = scan.next(); 
			String bet = scan.next();
			double amount = scan.nextDouble();
			
			Game game = new Game(name, bet, amount);
			gameService.save(game);
		}
		
	}
}
