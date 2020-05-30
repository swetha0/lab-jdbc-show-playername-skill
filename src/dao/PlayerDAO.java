package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO
{
	public List<Player> getAllPlayers() throws SQLException, Exception
	{
		 String sql = "SELECT * FROM PLAYER1 INNER JOIN SKILL1 ON PLAYER1.SKILL_ID = SKILLS.ID ";
		 Skill skill = null;
		 PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql);
		 ResultSet rs = stmt.executeQuery();
		 //System.out.println(rs);
		 while(rs.next())
		 {
			 int id1 = rs.getInt(1);			 
			 String name = rs.getString(2);
			 String country = rs.getString(3);
			 int skillId = rs.getInt(6);
			 String skillName = rs.getString(7);
			 
			 skill = new Skill(skillId, skillName);		 
			 Player player = new Player(id1, name, country, skill);
			 List<Player> list = new ArrayList<Player>();
			 list.add(player);
			 return list;
		 }
		 return null;
	}
}
