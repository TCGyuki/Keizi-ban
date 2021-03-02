//C:\RJP_WEB\WEB-INF\classes\tera>javac -cp C:\RJP_WEB\WEB-INF\classes DBAccess.java
package tera;

import java.util.ArrayList;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;
import java.sql.Date;

import tera.newLine;

public class DBAccess{
	//selectデータの格納先
	/*
	private ArrayList<ResBean> db = new ArrayList<ResBean>();
	//servlet転送用
	public ArrayList<ResBean> getData(){
		return db;
	}

	private ArrayList<ThreadBean> db2 = new ArrayList<ThreadBean>();

	public ArrayList<ThreadBean> getData2(){
		return db2;
	}
	*/

	newLine nl = new newLine();

	public ArrayList<ThreadBean> selectThid(String Thread_ID,ArrayList<ThreadBean> list){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"TB_MASTER","TBPASS");
				String sql=" SELECT Thread_ID,Thread_Title,Thread_Date,Thread_User FROM Thread WHERE Thread_ID="+Thread_ID+"";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			list.clear();

			while(rs.next()){
				ThreadBean tb = new ThreadBean();
				String ti=rs.getString (1);	//1列目のデータを取得
				String tt=rs.getString(2);	//2列目のデータを取得
				String td=rs.getString(3);	//3列目のデータを取得
				String tu=rs.getString(4);
            	tb.setThreadID(ti);
				tb.setThreadTitle(tt);
				tb.setThreadDate(td);
				tb.setThreadUser(tu);
				list.add(tb);
			
            }		

			//Oracleから切断する
            cn.close();
        }catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<ThreadBean> threadSelect(ArrayList<ThreadBean> threads){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"TB_MASTER","TBPASS");
			//System.out.println("接続完了");
			
			//select文
			String sql=" SELECT Thread_ID,Thread_Title,Thread_Date,Thread_User FROM Thread ORDER BY TO_NUMBER(Thread_ID)";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);
			threads.clear();
//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				ThreadBean tb = new ThreadBean();
				String ti=rs.getString (1);	//1列目のデータを取得
				String tt=rs.getString(2);	//2列目のデータを取得
				String td=rs.getString(3);	//3列目のデータを取得
				String tu=rs.getString(4);
            	tb.setThreadID(ti);
				tb.setThreadTitle(tt);
				tb.setThreadDate(td);
				tb.setThreadUser(tu);
				threads.add(tb);
				/*int Date = Integer.parseInt(Res_Date);*/
            }		
            //確認用	
			//System.out.println("Res_User"+"\t"+"Res_ID"+"\t"+"Res_Date");
			//System.out.println(Res_User+"\t"+Res_ID+"\t"+Res_Date);
			

			
			//Oracleから切断する
			cn.close();

			//System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return threads;
	}

    public void threadInsert(String Thread_Title,String Thread_User){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"TB_MASTER","TBPASS");
			//System.out.println("接続完了");
			
			//Insert文
			String sql=" INSERT INTO Thread VALUES(T_ID_SEQ.NEXTVAL,'" + Thread_Title + "',SYSDATE,'" + Thread_User + "')";
			/*
			String sql="INSERT INTO Thread (Thread_ID,Thread_Title,Thread_Date,Thread_User) VALUES(T_ID_SEQ.NEXTVAL";
            String sql2=")";
            Thread_Title = ",'" + Thread_Title + "'";
            Thread_User = ",'" + Thread_User + "'";
			*/

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			int in=st.executeUpdate(sql);

			//Oracleから切断する
			cn.close();

			//System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<ResBean> resSelect(String t_id,ArrayList<ResBean> responses){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"TB_MASTER","TBPASS");
			//System.out.println("接続完了");
			
			//select文
			String sql=" SELECT Res_ID,Res_User,Res_Date,Res_comment FROM Response WHERE Thread_ID="+t_id+" ORDER BY TO_NUMBER(Res_ID)";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);
			responses.clear();
			//カーソルを一行だけスクロールし、データをフェッチする

			int count = 0;
			while(rs.next()){
				ResBean rb = new ResBean();
				String ri=rs.getString (1);	//2列目のデータを取得
				String ru=rs.getString(2);	//3列目のデータを取得
				String rd=rs.getString(3);	//4列目のデータを取得
            	String rc=rs.getString(4);	//5列目のデータを取得
            	//int RU = Integer.parseInt(Res_User);
            	//int RI = Integer.parseInt(Res_ID);

				count += 1;//レスでId表示用に作成
				ri = Integer.toString(count);

				rc = nl.htmlEscape(rc);

				rb.setResID(ri);
				rb.setResUser(ru);
				rb.setResDate(rd);
				rb.setResComment(rc);
				responses.add(rb);
            }		
            //確認用	
			//System.out.println("Res_User"+"\t"+"Res_ID"+"\t"+"Res_Date"+"/t"+Res_comment);
			//System.out.println(Res_User+"\t"+Res_ID+"\t"+Res_Date+"/t"+Res_comment);
			

			
			//Oracleから切断する
			cn.close();

			//System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return responses;
	}

    public void resInsert(String Thread_ID,String Res_User,String Res_comment){
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"TB_MASTER","TBPASS");
			//System.out.println("接続完了");
			
			//Insert文
			String sql=" INSERT INTO Response VALUES('" + Thread_ID + "',R_ID_SEQ.NEXTVAL,'" + Res_User + "',SYSDATE,'" + Res_comment + "')";
			/*String sql="INSERT INTO Response(Res_ID,Res_User,Res_Date,Res_comment) VALUES(R_ID_SEQ.NEXTVAL";
            String sql2=")";
            Res_User = ",'" + Res_User + "'";
            Res_comment = ",'" + Res_comment + "'";
			*/

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			int rs=st.executeUpdate(sql);

			//Oracleから切断する
			cn.close();

			//System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<ThreadBean> threadSearch(String Thread_Title,ArrayList<ThreadBean> threadResult){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"TB_MASTER","TBPASS");
				String sql=" SELECT Thread_ID,Thread_Title,Thread_Date,Thread_User FROM Thread WHERE Thread_Title Like '%"+Thread_Title+"%' ORDER BY TO_NUMBER(Thread_ID)";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			threadResult.clear();

			while(rs.next()){
				ThreadBean tb = new ThreadBean();
				String ti=rs.getString (1);	//1列目のデータを取得
				String tt=rs.getString(2);	//2列目のデータを取得
				String td=rs.getString(3);	//3列目のデータを取得
				String tu=rs.getString(4);
            	tb.setThreadID(ti);
				tb.setThreadTitle(tt);
				tb.setThreadDate(td);
				tb.setThreadUser(tu);
				threadResult.add(tb);
				
            }		

			//Oracleから切断する
            cn.close();
        }catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return threadResult;
	}
	public ArrayList<ResBean> newList(ArrayList<ResBean> list){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"TB_MASTER","TBPASS");
			//System.out.println("接続完了");
			
			//select文
			String sql=" select * from ( select * FROM Response order by Res_Date desc ) where rownum <=10";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);
			list.clear();
			//カーソルを一行だけスクロールし、データをフェッチする

			
			while(rs.next()){
				ResBean rb = new ResBean();
				String ti=rs.getString(1);
				String ru=rs.getString(3);
				String rd=rs.getString(4);
				String rc=rs.getString(5);
				rb.setThreadID(ti);
				rb.setResUser(ru);
				rb.setResDate(rd);
				rb.setResComment(rc);
				list.add(rb);
            }

			
			//Oracleから切断する
			cn.close();

			//System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
