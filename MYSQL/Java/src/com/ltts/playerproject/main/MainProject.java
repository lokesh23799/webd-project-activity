package com.ltts.playerproject.main;
import java.util.List;
import java.util.Scanner;

import com.ltts.playerproject.bo.PlayerBo;
import com.ltts.playerproject.model.Player;


public class MainProject {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Insert\n2.view players \n3.view player by skill\n4.update player\n5.delete player");
		System.out.println("Select an Operation");
		int opt=sc.nextInt();
		
		PlayerBo pb=new PlayerBo();
		switch(opt)
		{
		case 1:
			System.out.println("Enter Team Name");
			String teamName= sc.nextLine();
			sc.nextLine();
			System.out.println("Enter Player Name");
			String playername= sc.nextLine();
			sc.nextLine();
			System.out.println("Enter Runs");
			int runs= sc.nextInt();
			System.out.println("Enter Wicket");
			int wickets= sc.nextInt();
			
			System.out.println("Enter player no");
			int playerNo= sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Skill Name");
			String skills= sc.nextLine();
			Player p1=new Player(teamName,playername,runs,wickets,skills,playerNo);
			

			boolean b=pb.insertPlayer(p1);

			if(b==false) {

				System.out.println("Value inserted...");

			}
			break;
		case 2:
			List<Player> li=pb.getAllPlayers();

			for(Player p2:li) {

				System.out.println(p2);

			}

			break;
		case 3:
			List<Player> li1=pb.getPlayerbySkill();
			for(Player p2:li1) {

				System.out.println(p2);

			}
			break;
		case 4:
			System.out.println("Enter Team Name");
			String teamName1= sc.nextLine();
			sc.nextLine();
			System.out.println("Enter Player Name");
			String playername1= sc.nextLine();
			sc.nextLine();
			System.out.println("Enter Runs");
			int runs1= sc.nextInt();
			System.out.println("Enter Wicket");
			int wickets1= sc.nextInt();
			
			System.out.println("Enter player no");
			int playerNo1= sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Skill Name");
			String skills1= sc.nextLine();
			Player p2=new Player(teamName1,playername1,runs1,wickets1,skills1,playerNo1);
			

			boolean z=pb.updatePlayer(p2);

			if(z==false) {

				System.out.println("Value updated....");

			}
			break;
		case 5:
           
			

			boolean z1=pb.deletePlayer();

			if(z1==false) {

				System.out.println("Value Deleted....");

			}
			break;
			
		}
		

	}


		}

		

 

	

