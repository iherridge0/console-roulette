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
	
	private double amountWon;
	
	private int rolled;
	
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

	public double getAmountWon() {
		return amountWon;
	}

	public void setAmountWon(double amountWon) {
		this.amountWon = amountWon;
	}

	public int getRolled() {
		return rolled;
	}

	public void setRolled(int rolled) {
		this.rolled = rolled;
	}

	
}