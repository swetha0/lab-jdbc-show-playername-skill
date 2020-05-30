package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	 public Skill getSkillBylD(int id) throws SQLException, Exception
	 {
		 String sql = "SELECT * FROM SKILLS ORDER BY NAME ASC";
		 PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(sql);
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next())
		 {
			 if(id == rs.getInt("ID"))
			 { 
				 int id1 = rs.getInt("ID");
				 String name = rs.getString("NAME");
				 System.out.println("Id: " + id1);
				 System.out.println("Name: " + name);
				 Skill skill = new Skill(id1, name);
				 return skill;
			 }
		 }
		 return null;
	 }
}