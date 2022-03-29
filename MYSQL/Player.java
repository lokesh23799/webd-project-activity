package com.ltts.playerproject.model;
import java.util.Scanner;

public class Player {
	
	Scanner sc=new Scanner(System.in);
	private String TeamName;
	private String Playername;
	private int Runs;
	private int wickets;
	private String Skills;
	private int PlayerNo;
	
	
	public Player(String teamName, String playername, int runs, int wickets, String skills, int playerNo) {
		super();
		this.TeamName = teamName;
		this.Playername = playername;
		this.Runs = runs;
		this.wickets = wickets;
		this.Skills = skills;
		this.PlayerNo = playerNo;
	}

	public Player() {
		super();
	}

	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public String getPlayername() {
		return Playername;
	}
	public void setPlayername(String playername) {
		Playername = playername;
	}
	public int getRuns() {
		return Runs;
	}
	public void setRuns(int runs) {
		Runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		this.Skills = skills;
	}
	public int getPlayerNo() {
		return PlayerNo;
	}
	public void setPlayerNo(int playerNo) {
		PlayerNo = playerNo;
	}

	@Override
	public String toString() {
		return "Player [sc=" + sc + ", TeamName=" + TeamName + ", Playername=" + Playername + ", Runs=" + Runs
				+ ", wickets=" + wickets + ", skills=" + Skills + ", PlayerNo=" + PlayerNo + "]";
	

}
	

	

 

}


