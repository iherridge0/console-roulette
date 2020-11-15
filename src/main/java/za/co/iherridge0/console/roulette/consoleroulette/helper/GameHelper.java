package za.co.iherridge0.console.roulette.consoleroulette.helper;

import za.co.iherridge0.console.roulette.consoleroulette.entity.Game;

public class GameHelper {
	
	/**
	 * This method calculates whether a game has won or lost by setting the game with the number that the ball landed on,
	 * and sets the games outcome to 1(WON) and 0(LOST)
	 * @param game
	 * @param ball
	 * @return 
	 */
	public Game getGameResult(Game game, int ball) {
		
		String bet = game.getBet().trim();
		game.setRolled(ball);
		game.setPlayed(true);
		
		if(bet.equalsIgnoreCase("EVEN")) {
			if(ball % 2 == 0) {//Ball landed on an EVEN number : WON
				game.setOutcome(1);
				double winnings = game.getBetAmount() * 2;
				game.setWinnings(winnings);
			} else { //Ball landed on a ODD number : LOST
				game .setOutcome(0);
				game.setWinnings(0);
			}
			return game;
		} else if(bet.equalsIgnoreCase("ODD")){
			if(ball % 2 == 0) {//Ball landed on an EVEN number : LOST
				game.setOutcome(0);
				game.setWinnings(0);
			} else { //Ball landed on a ODD number : WON
				game .setOutcome(1);
				double winnings = game.getBetAmount() * 2;
				game.setWinnings(winnings);
			}
			return game;
		} else {
			int betNumber = Integer.parseInt(bet);
			if(betNumber == ball) {
				game.setOutcome(1);
				double winnings = game.getBetAmount() * 36;
				game.setWinnings(winnings);	
			} else {
				game.setOutcome(0);
				game.setWinnings(0);
			}
			return game;
		}
	}

}
