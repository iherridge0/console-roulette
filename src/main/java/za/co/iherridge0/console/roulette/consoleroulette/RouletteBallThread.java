package za.co.iherridge0.console.roulette.consoleroulette;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.iherridge0.console.roulette.consoleroulette.repository.GameRepository;

public class RouletteBallThread extends Thread {

	private static final Logger log = 
			LoggerFactory.getLogger(RouletteBallThread.class);
	
	GameRepository gameService;

	public void run() {
		log.info("Running a new thread");
		Random r = new Random();
		
		while(true) {
			int ball = r.nextInt(35)+1;
		
			log.info("Roulette ball landed on number: " + ball);
			
			try {
				Thread.sleep(30000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
				log.debug(e.getMessage());
			}
		}
	}
	
	public void setGameService(GameRepository gameService) {
		this.gameService = gameService;
	}
	
}
