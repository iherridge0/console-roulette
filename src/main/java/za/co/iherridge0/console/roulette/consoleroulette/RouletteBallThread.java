package za.co.iherridge0.console.roulette.consoleroulette;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.iherridge0.console.roulette.consoleroulette.entity.Game;
import za.co.iherridge0.console.roulette.consoleroulette.entity.Player;
import za.co.iherridge0.console.roulette.consoleroulette.helper.CSVHelper;
import za.co.iherridge0.console.roulette.consoleroulette.helper.GameHelper;
import za.co.iherridge0.console.roulette.consoleroulette.repository.GameRepository;
import za.co.iherridge0.console.roulette.consoleroulette.repository.PlayerRepository;

public class RouletteBallThread extends Thread {

	private static final Logger log = 
			LoggerFactory.getLogger(RouletteBallThread.class);
	
	GameRepository gameService;
	
	PlayerRepository playerRepository;
	
	private static final String file = "C:\\roulette\\scores";

	public void run() {
		log.info("Running a new thread");
		Random r = new Random();
		
		while(true) {
			/**
			 * Generates a random number between 1 and 36
			 */
			int ball = r.nextInt(35)+1;
			System.out.println("");
			System.out.println("Number: " + ball);
			System.out.println(paddingRight("Player", 12) + paddingLeft("Bet", 5) + paddingLeft("Outcome", 9) +  paddingLeft("Winnings", 10));
			System.out.println("---");
			
			List<Game> games = gameService.findAll();
			
			/**
			 * Filters out all the old games
			 */
			List<Game> newGames = games.stream().filter(game->!game.hasPlayed()).collect(Collectors.toList());
			
			GameHelper gameHelper = new GameHelper();
			for(Game newGame: newGames) {
				Game playedGame = gameHelper.getGameResult(newGame, ball);
				gameService.save(playedGame);
				
				List<Player> players = playerRepository.findAll();
				for(Player player: players) {
					if(player.getName().equals(playedGame.getName())) {
						double totalWon = player.getTotalWon();
						totalWon = totalWon + playedGame.getWinnings();
						
						double totalBet = player.getTotalBet();
						totalBet = totalBet + playedGame.getBetAmount();
						
						player.setTotalBet(totalBet);
						player.setTotalWon(totalWon);
						playerRepository.save(player);
						CSVHelper csvHelper = new CSVHelper();
						csvHelper.saveToCSV(file, players);
					
					}
				}
				System.out.print(paddingRight(playedGame.getName(), 12));
				System.out.print(paddingLeft(playedGame.getBet(), 5));
				System.out.print(paddingLeft(String.valueOf(playedGame.getOutcome()==0?"LOSE":"WIN"), 9));
				System.out.println(paddingLeft(String.valueOf(playedGame.getWinnings()), 10));
			}
			System.out.println("");
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
	
	
	public void setPlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	public String paddingRight(String string, int columnWidth) {
		String padding = "";
		for(int x = 0; x < columnWidth - string.length(); x++ ) {
			padding = padding + " ";
		}
		
		return string + padding;
	}
	
	public String paddingLeft(String string, int columnWidth) {
		String padding = "";
		for(int x = 0; x < columnWidth - string.length(); x++ ) {
			padding = padding + " ";
		}
		
		return padding + string;
	}

	public void setGameService(GameRepository gameService, PlayerRepository playerService) {
		this.gameService = gameService;
		this.playerRepository = playerService;
	}


	
}
