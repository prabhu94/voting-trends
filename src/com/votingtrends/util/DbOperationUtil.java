package com.votingtrends.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.votingtrends.model.Vote;

public class DbOperationUtil {

	public static int insertVote(Vote vote) throws SQLException{
		ConnUtil cu =  new ConnUtil();
		Connection conn = null;
		int count =0 ;
		try {
			conn = ConnUtil.getOracleConnection();
			String sql = "insert into voting_data(name,vote) values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println(vote.getName()+" this is the name");
			System.out.println(vote.getVote()+" this is the vote");

			System.out.println(pstmt.toString());
			pstmt.setString(1,vote.getName());
			pstmt.setInt(2,vote.getVote());
			count = pstmt.executeUpdate();
			System.out.println("Insert Successful" );
			ConnUtil.closeDbConnection(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public static List<Vote> displayVotes(){
		List<Vote> anslist = new ArrayList<Vote>();
		ConnUtil cu =  new ConnUtil();
		Connection conn = null;
		int count =0 ;
		try {
			conn = ConnUtil.getOracleConnection();
			String sql = "select max(vl.item_name) as phone,count(*) as count from voting_data vd, vote_lookup vl where vl.id = vd.VOTE group by vd.VOTE order by count desc";
			 PreparedStatement pstmt=conn.prepareStatement(sql);
		        ResultSet rs=pstmt.executeQuery();  
		        while(rs.next()){
		        	Vote v = new Vote();
		        	v.setPhone(rs.getString("phone"));
		        	v.setCount(rs.getInt("count"));
		        	anslist.add(v);
		        }
			System.out.println("Display Successful" );
			for(int i = 0; i < anslist.size() ; i++){
				System.out.println("Row :" + anslist.get(i).getPhone() + " " + anslist.get(i).getCount());
			}
			ConnUtil.closeDbConnection(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anslist;
	}
	/*	public static void main(String args[]){
			String name = "Prabhat";
			int vote = 1;
			
			Vote v = new Vote();
			v.setVote(vote);
			v.setName(name);
			
			try {
				insertVote(v);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	*/}
