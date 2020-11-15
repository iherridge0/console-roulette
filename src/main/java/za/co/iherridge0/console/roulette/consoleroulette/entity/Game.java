package za.co.iherridge0.console.roulette.consoleroulette.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Game")
public class Game {
	
	@Id
	@GeneratedValue
	private long id;
	
	private Date date;
	
	private String name;
	
	private String bet;
	
	private double betAmount;
	
	private int rolled;
	
	private int outcome;
	
	private double winnings;
	
	private boolean played;
	
	protected Game() {
		
	}

	public Game(String name, String bet, double betAmount) {
		super();
		this.date = new Date();
		this.name = name;
		this.bet = bet;
		this.betAmount = betAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBet() {
		return bet;
	}

	public void setBet(String bet) {
		this.bet = bet;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

	public int getRolled() {
		return rolled;
	}

	public void setRolled(int rolled) {
		this.rolled = rolled;
	}

	public int getOutcome() {
		return outcome;
	}

	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}

	public double getWinnings() {
		return winnings;
	}

	public void setWinnings(double winnings) {
		this.winnings = winnings;
	}

	public boolean hasPlayed() {
		return played;
	}

	public void setPlayed(boolean played) {
		this.played = played;
	}

	
}