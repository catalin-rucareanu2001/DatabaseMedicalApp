package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Java2SQL {
	
public void ExecuteWrite(String command,
		String url,
		String user,
		String password)
{
try {

Connection conection=DriverManager.getConnection(url, user, password);

//System.out.println("conected");
//String sql=command;

Statement statement=conection.createStatement();


int rows=statement.executeUpdate(command);

if (rows>0) {
	System.out.println("rows modified");
}
else {
	System.out.println("no such rows found");
}

conection.close();

} catch (SQLException e) {
System.out.println("oops,error ocured");
e.printStackTrace();
}
}

public String ReadNVals(String command,
		   int nr,
		   String url,
		   String user,
		   String password)
{
	String out="";
try {

Connection conection=DriverManager.getConnection(url, user, password);

//System.out.println("conected");
//String sql=command;

Statement statement=conection.createStatement();


ResultSet result=statement.executeQuery(command);


while(result.next())
{
	  for(int i=1;i<=nr;i++)
      {
      out = out+result.getString(i);
      }
	  out=out+"\n";
}

conection.close();

} catch (SQLException e) {
System.out.println("oops,error ocured");
e.printStackTrace();
}
return out;
}

public int getCod(String command,
		   String column,
		   String url,
		   String user,
		   String password)
{
	int codAdr=-1;
try {

Connection conection=DriverManager.getConnection(url, user, password);

//System.out.println("conected");
//String sql=command;

Statement statement=conection.createStatement();


ResultSet result=statement.executeQuery(command);


while(result.next())
{


 codAdr=result.getInt(column);
 //System.out.println(codAdr);

}

conection.close();

} catch (SQLException e) {
System.out.println("oops,error ocured");
e.printStackTrace();
}
return codAdr;
}

public int getTopCodAdr(
		   String url,
		   String user,
		   String password)
{
	int codAdr=-1;
try {

Connection conection=DriverManager.getConnection(url, user, password);

//System.out.println("conected");
//String sql=command;

Statement statement=conection.createStatement();


ResultSet result=statement.executeQuery("select top 1 codAddr from [MedicFamilie].[dbo].[Adresa] order by codAddr desc;");


while(result.next())
{


codAdr=result.getInt("codAddr");

}

conection.close();

} catch (SQLException e) {
System.out.println("oops,error ocured");
e.printStackTrace();
}
return codAdr;
}

public String getPasswd(String command,
		   String condition,
		   String url,
		   String user,
		   String password)
{
	String Passwd="";
try {

Connection conection=DriverManager.getConnection(url, user, password);

//System.out.println("conected");
//String sql=command;

Statement statement=conection.createStatement();


ResultSet result=statement.executeQuery(command);


while(result.next())
{
	Passwd=result.getString(condition);
}

conection.close();

} catch (SQLException e) {
System.out.println("oops,error ocured");
e.printStackTrace();
}
return Passwd;
}

}
