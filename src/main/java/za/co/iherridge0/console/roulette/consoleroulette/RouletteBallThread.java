package za.co.iherridge0.console.roulette.consoleroulette;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.iherridge0.console.roulette.consoleroulette.entity.Game;
import za.co.iherridge0.console.roulette.consoleroulette.helper.GameHelper;
import za.co.iherridge0.console.roulette.consoleroulette.repository.GameRepository;

public class RouletteBallThread extends Thread {

	private static final Logger log = 
			LoggerFactory.getLogger(RouletteBallThread.class);
	
	GameRepository gameService;

	public void run() {
		log.info("Running a new thread");
		Random r = new Random();
		
		while(true) {
			/**
			 * Generates a random number between 1 and 36
			 */
			int ball = r.nextInt(35)+1;
			log.info("Roulette ball landed on number: " + ball);
			
			List<Game> games = gameService.findAll();
			List<Game> newGames = games.stream().filter(game->game.getRolled() == 0).collect(Collectors.toList());
			
			GameHelper gameHelper = new GameHelper();
			
			for(Game newGame: newGames) {
				Game playedGame = gameHelper.getGameResult(newGame, ball);
				gameService.save(playedGame);
			}
			
			try {
				Thread.sleep(10000L);
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
