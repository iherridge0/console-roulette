package za.co.iherridge0.console.roulette.consoleroulette;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import za.co.iherridge0.console.roulette.consoleroulette.helper.CSVHelper;

@Component
public class ConsoleRouletteCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(ConsoleRouletteCommandLineRunner.class);
	
	private static final String file = "C:\\roulette\\scores";
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("STARTING CONSOLE ROULETTE");
		
		
		log.info("Test: reading from file: " + file);
		CSVHelper csvHelper = new CSVHelper();
		List<String> names = csvHelper.csvtoStrings(file);
		
		names.forEach(s->System.out.println(s));
	}

}
