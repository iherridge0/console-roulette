package za.co.iherridge0.console.roulette.consoleroulette;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import za.co.iherridge0.console.roulette.consoleroulette.entity.Player;
import za.co.iherridge0.console.roulette.consoleroulette.helper.CSVHelper;
import za.co.iherridge0.console.roulette.consoleroulette.repository.PlayerRepository;

@Component
public class ConsoleRouletteCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(ConsoleRouletteCommandLineRunner.class);
	
	private static final String file = "C:\\roulette\\scores";
	
	@Autowired
	PlayerRepository playerService;
	
	@Override
	public void run(String... args) throws Exception {
		
		//STARTING CONSOLE ROULETTE
		
		//"Test: reading from file: " + file);
		CSVHelper csvHelper = new CSVHelper();
		List<String> names = csvHelper.csvtoStrings(file);
		for(String name: names) {
			Player player = new Player(name);
			playerService.save(player);
		 
		}
	}

}
