package ch9.dbviewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;
 
 


import Utils.SpringUtils;

public class DBViewer {

	@Resource
	private DataSource dataSource;
	private DatabaseMetaData dbMD;
	private List<String> tableList;

	public void showTables() throws SQLException {
		if (tableList != null) {
			for (String table : tableList)
				System.out.println(table);
			return;
		} else
			tableList = new ArrayList<String>();
		if (dataSource == null)
			dataSource = (DataSource) SpringUtils.getBean("dataSource");
		dbMD = dataSource.getConnection().getMetaData();
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = "t_%";
		String[] types = null;
		ResultSet rs = dbMD.getTables(catalog, schemaPattern, tableNamePattern,
				types);
		int col = 0;
		while (rs.next()) {
			String tbName = rs.getString(3);
			tableList.add(tbName);
			System.out.print(tbName + "\t");
			col++;
			if (col % 5 == 0)
				System.out.println();
		}
		System.out.println();
	}

	public void scanTable(String tbName) throws SQLException {
		if (!tableList.contains(tbName)) {
			System.out
					.println("please check the tableName , it does not exists!");
			return;
		}
		//show tables
		Statement ps = dataSource.getConnection().createStatement();
		ResultSet rs = ps.executeQuery("SELECT * FROM " + tbName);
        //System.out.println("No rows for this table!");
		ResultSetMetaData rsmeta = (ResultSetMetaData) rs.getMetaData();
		int colCount = rsmeta.getColumnCount();
		for (int i = 1; i <= colCount; i++) {
				  if(i%4==0)
					  System.out.print(rsmeta.getColumnName(i) + "\n");
				  else
					  System.out.print(rsmeta.getColumnName(i) + "\t");
		   } 
		System.out.println();
		 int rcount = 0;
		while(rs.next())
		{
		   for (int i = 1; i < colCount+1; i++) {
			  if(colCount%4==0) 
			   System.out.print( rs.getObject(i).toString() + "\n");
			  else 
		       System.out.print( rs.getObject(i).toString() + "\t");
		   }
		   System.out.println();
		   rcount++;
		}
		if(rcount==0) System.out.println("not rows for this table:" + tbName);
		rcount =0;
	}

	public static void main(String[] args) throws IOException, SQLException {
		DBViewer dbv = new DBViewer();
		System.out
				.println("*******************************************************************");
		System.out
				.println("usage:please input the table name you want to check");
		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));
		
		dbv.showTables();
		System.out.println("Please input the table name you want to view:");
		String tbName = bfr.readLine();
		while (!tbName.equals("exit")) {
			  dbv.scanTable(tbName);
			System.out.println("Please input the table name you want to view:");
			tbName = bfr.readLine();
		}
		System.out
				.println("*******************************************************************");
	}

}
