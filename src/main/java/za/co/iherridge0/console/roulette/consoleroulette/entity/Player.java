package za.co.iherridge0.console.roulette.consoleroulette.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private double totalBet;
	
	private double totalWon;
	
	protected Player() {
		
	}
	
	public Player(String name) {
		super();
		this.name = name;
	}
	
	public Player(String name, double totalBet, double totalWon) {
		super();
		this.name = name;
		this.totalBet = totalBet;
		this.totalWon = totalWon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalBet() {
		return totalBet;
	}

	public void setTotalBet(double totalBet) {
		this.totalBet = totalBet;
	}

	public double getTotalWon() {
		return totalWon;
	}

	public void setTotalWon(double totalWon) {
		this.totalWon = totalWon;
	}

}
