import net.codejava.sql.Java2SQL;

public class Adder {
	
	public static void main(String[] args) {
		Java2SQL joc=new Java2SQL();
		
		String url="jdbc:sqlserver://CATUTA-THE-GREA\\SQLEXPRESS;databadeName=data";
		String user="sa";
		String password="catuta-314AC";
		
		String table="[MedicFamilie].[dbo].[Adresa]";
		String command;

		//command="Select * from "+table;
		//joc.ExecuteRead(command, url, user, password);
		//command="Insert into "+table+"values ('Ana',67)";
		//joc.ExecuteWrite(command, url, user, password);
		command="Select codAddr from "+table+"where Localitate='k' And strada='k'";
		int val;
		//val=joc.getCodAdr(command, url, user, password);
		val=joc.getTopCodAdr( url, user, password);
		System.out.println(val);
	}
}
