package util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class JDBCUTIL {

	public static final String driver="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/bom";
	public static final String user="root";
	public static final String psw="root";
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet re=null;

	
	public Connection getcon()
	{
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, psw);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeAll()
	{
		try
		{
			if(ps!=null)ps.close();
			if(con!=null) con.close();
			if(re!=null)re.close();
		} 
		catch (Exception e) {
			e.printStackTrace();


		}
		
	}
	public boolean update(String sql, ArrayList<Object> list )
	{
		int num=0;
		con=getcon();
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			if(list!=null){
				
				
				for(int i=0;i<list.size();i++)
				{
					ps.setObject(i+1,  list.get(i));
				}
			}
			 num=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return num>0;
		
		
	}
	public boolean add(String sql,Object...obj)
	{
		int num=0;
		con=getcon();
		try {
			ps= con.prepareStatement(sql);
			if(obj!=null){
				
				
				for(int i=0;i<obj.length;i++)
				{
					ps.setObject(i+1,  obj[i]);
				}
			}
			 num=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			closeAll();
		}
		return num>0;
		
		
	}
	public ResultSet select(String sql,Object...obj)
	{
	
		con=getcon();
		try {
			ps= con.prepareStatement(sql);
			if(obj!=null){
				
				
				for(int i=0;i<obj.length;i++)
				{
					ps.setObject(i+1,  obj[i]);
				}
			}
			 re=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
		
		
	}

	
	
	
}
