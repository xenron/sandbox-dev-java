package catalog.managed;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;
import org.apache.myfaces.trinidad.context.RequestContext;

import org.apache.myfaces.trinidad.component.*;

public class Catalog {
	private UIXForm f1;
	private UIXDocument d1;
	private UIXPanel pfl1;
	private UIXInput input1;
	private UIXInput input2;
	private UIXGroup g1;
	private UIXInput input3;
	private UIXInput input4;
	private UIXInput input5;
	private UIXInput input6;
	private UIXInput input7;
	private UIXCommand cb1;
	private UIXCommand cb2;
	 

	private String catalogId;
	private String journal;
	private String publisher;
	private String edition;
	private String title;
	private String author;
	private java.sql.Connection conn;
	private Statement stmt;
	private ResultSet rs;

	 

	public void setF1(UIXForm f1) {
		this.f1 = f1;
	}

	public UIXForm getF1() {
		return f1;
	}

	public void setD1(UIXDocument d1) {
		this.d1 = d1;
	}

	public UIXDocument getD1() {
		return d1;
	}

	public void setPfl1(UIXPanel pfl1) {
		this.pfl1 = pfl1;
	}

	public UIXPanel getPfl1() {
		return pfl1;
	}

	public void setInput1(UIXInput input1) {
		this.input1 = input1;
	}

	public UIXInput getInput1() {
		return input1;
	}

	public void setInput2(UIXInput input2) {
		this.input2 = input2;
	}

	public UIXInput getInput2() {
		return input2;
	}

	public void setG1(UIXGroup g1) {
		this.g1 = g1;
	}

	public UIXGroup getG1() {
		return g1;
	}

	public void setInput3(UIXInput input3) {
		this.input3 = input3;
	}

	public UIXInput getInput3() {
		return input3;
	}

	public void setInput4(UIXInput input4) {
		this.input4 = input4;
	}

	public UIXInput getInput4() {
		return input4;
	}

	public void setInput5(UIXInput input5) {
		this.input5 = input5;
	}

	public UIXInput getInput5() {
		return input5;
	}

	public void setInput6(UIXInput input6) {
		this.input6 = input6;
	}

	public UIXInput getInput6() {
		return input6;
	}

	public void setInput7(UIXInput input7) {
		this.input7 = input7;
	}

	public UIXInput getInput7() {
		return input7;
	}

	public void setCb1(UIXCommand cb1) {
		this.cb1 = cb1;
	}

	public UIXCommand getCb1() {
		return cb1;
	}

	public void setCb2(UIXCommand cb2) {
		this.cb2 = cb2;
	}

	 
	 

	public UIXCommand getCb2() {
		return cb2;
	}

	public String cb1_action() {
		try {

			 catalogId = (String) input1.getValue();

			 journal = (String) input2.getValue();

			 publisher = (String) input3.getValue();

			 edition = (String) input4.getValue();

			 title = (String) (input5.getValue());

			 author = (String) (input6.getValue());

			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource ds = (javax.sql.DataSource) initialContext
					.lookup("jdbc/OracleDS");
			conn = ds.getConnection();

			stmt = conn.createStatement();
			String sql = "INSERT INTO JournalCatalog VALUES(" + "\'"
					+ catalogId + "\'" + "," + "\'" + journal + "\'" + ","
					+ "\'" + publisher + "\'" + "," + "\'" + edition + "\'"
					+ "," + "\'" + title + "\'" + "," + "\'" + author + "\'"
					+ ")";

			stmt.execute(sql);

		} catch (NamingException e) {
			System.err.println(e.getMessage());
			return "error";
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return "error";
		} finally {
			try {

				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

		return "persisted";
	}

	public String cb2_action1() {
		 
		RequestContext requestContext = RequestContext.getCurrentInstance();
		try {

			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource ds = (javax.sql.DataSource) initialContext
					.lookup("jdbc/OracleDS");
			conn = ds.getConnection();
			String catalogId = (String) input7.getValue();
			System.out.println(catalogId);
			stmt = conn.createStatement();
			// Obtain result set

			String query = "SELECT * from JournalCatalog WHERE CATALOGID="
					+ "'" + catalogId + "'";
			rs = stmt.executeQuery(query);

			rs.next();
			requestContext.getPageFlowScope().put("CatalogIdLabel", "Catalog ID:");
			requestContext.getPageFlowScope().put("JournalLabel", "Journal:");
			requestContext.getPageFlowScope().put("PublisherLabel", "Publisher:");
			requestContext.getPageFlowScope().put("EditionLabel", "Edition:");
			requestContext.getPageFlowScope().put("TitleLabel", "Title:");
			requestContext.getPageFlowScope().put("AuthorLabel", "Author:");
			
			catalogId = rs.getString("CATALOGID");

			requestContext.getPageFlowScope().put("catalogId", catalogId);

			journal = rs.getString("JOURNAL");

			requestContext.getPageFlowScope().put("journal", journal);

			publisher = rs.getString("PUBLISHER");

			requestContext.getPageFlowScope().put("publisher", publisher);

			edition = rs.getString("EDITION");
			requestContext.getPageFlowScope().put("edition", edition);

			title = rs.getString("TITLE");
			requestContext.getPageFlowScope().put("title", title);

			author = rs.getString("AUTHOR");
			requestContext.getPageFlowScope().put("author", author);
			 
		} catch (NamingException e) {
			System.err.println(e.getMessage());
			return "error";
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return "error";
		} finally {
			try {

				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return "catalogentry";
	}
}
