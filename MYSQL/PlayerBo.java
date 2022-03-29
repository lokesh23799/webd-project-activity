package com.ltts.playerproject.bo;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;



import com.ltts.playerproject.model.Player;
public class PlayerBo {
	Scanner sc=new Scanner(System.in);
	public boolean insertPlayer(Player p)throws Exception
	{

		//DB logic

		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","123456789");

		Statement st= con.createStatement();
		
		boolean b =st.execute("INSERT into team VALUE('"+p.getTeamName()+"','"+p.getPlayername()+"',"+p.getRuns()+","+p.getWickets()+",'"+p.getSkills()+"',"+p.getPlayerNo()+")");

		con.close();

		return b;
	}
	public List<Player> getAllPlayers()throws Exception{

		List<Player> al=new ArrayList<Player>();

		//DB Logic

		//Class.forName()

		Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","123456789");

		PreparedStatement ps=c.prepareStatement("select * from team");

		ResultSet rs=ps.executeQuery();

		while(rs.next()) {

			al.add(new Player(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getString(5),rs.getInt(6)));

		}

		c.close();

		return al;

	}
	public List<Player> getPlayerbySkill()throws Exception{
		System.out.println("Enter Search Skills");
		String Skills=sc.nextLine();

		List<Player> al=new ArrayList<Player>();

		Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","123456789");

		PreparedStatement ps=c.prepareStatement("select * from team where Skill='"+Skills+"'");

		ResultSet rs=ps.executeQuery();

		while(rs.next()) {

			al.add(new Player(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getString(5),rs.getInt(6)));

		}

		c.close();

		return al;

	}
	public boolean updatePlayer(Player p)throws Exception{
		System.out.println("Enter Player no for Change");
		String pid=sc.nextLine();

		

		//DB Logic

		//Class.forName()

		Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","123456789");

        Statement st= co.createStatement();
		
		boolean z =st.execute("UPDATE team SET TeamName='"+p.getTeamName()+"',PlayerName='"+p.getPlayername()+"',Runs="+p.getRuns()+",Wickets="+p.getWickets()+",Skill='"+p.getSkills()+"',PlayerNumaber="+p.getPlayerNo()+" where PlayerNumaber="+pid+"");

		co.close();

		return z;

	}
	public boolean deletePlayer()throws Exception{
		System.out.println("Enter Player no for Delete");
		String pid=sc.nextLine();

		

		//DB Logic

		//Class.forName()

		Connection co=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","123456789");

        Statement st= co.createStatement();
		
		boolean z1 =st.execute("DELETE FROM team WHERE Playernumber="+pid+"");

		co.close();

		return z1;
	
}
		
		

    

}


