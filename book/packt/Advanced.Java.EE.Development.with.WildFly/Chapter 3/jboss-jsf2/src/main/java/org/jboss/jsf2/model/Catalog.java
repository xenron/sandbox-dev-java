package org.jboss.jsf2.model;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.model.ResultSetDataModel;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.sql.*;

@ManagedBean(name = "catalog")
public class Catalog {
	private HtmlForm form1;
	private HtmlInputText inputText1;
	private HtmlOutputLabel outputLabel1;
	private HtmlCommandButton commandButton1;
	private HtmlDataTable dataTable1;
	private UIColumn column1;
	private UIColumn column2;
	private UIColumn column3;
	private UIColumn column4;
	private UIColumn column5;
	private UIColumn column6;
	private Statement stmt;
	private Connection connection;
	private ResultSet rs;

	private HtmlOutputText errorMsg;

	public void setForm1(HtmlForm form1) {
		this.form1 = form1;
	}

	public HtmlForm getForm1() {
		return form1;
	}

	public void setInputText1(HtmlInputText inputText1) {
		this.inputText1 = inputText1;
	}

	public HtmlInputText getInputText1() {
		return inputText1;
	}

	public void setErrorMsg(HtmlOutputText errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HtmlOutputText getErrorMsg() {
		return errorMsg;
	}

	public void setOutputLabel1(HtmlOutputLabel outputLabel1) {
		this.outputLabel1 = outputLabel1;
	}

	public HtmlOutputLabel getOutputLabel1() {
		return outputLabel1;
	}

	public void setCommandButton1(HtmlCommandButton commandButton1) {
		this.commandButton1 = commandButton1;
	}

	public HtmlCommandButton getCommandButton1() {
		return commandButton1;
	}

	public void setDataTable1(HtmlDataTable dataTable1) {
		this.dataTable1 = dataTable1;
	}

	public HtmlDataTable getDataTable1() {
		return dataTable1;
	}

	public void setColumn1(UIColumn column1) {
		this.column1 = column1;
	}

	public UIColumn getColumn1() {
		return column1;
	}

	public void setColumn2(UIColumn column2) {
		this.column2 = column2;
	}

	public UIColumn getColumn2() {
		return column2;
	}

	public void setColumn3(UIColumn column3) {
		this.column3 = column3;
	}

	public UIColumn getColumn3() {
		return column3;
	}

	public void setColumn4(UIColumn column4) {
		this.column4 = column4;
	}

	public UIColumn getColumn4() {
		return column4;
	}

	public void setColumn5(UIColumn column5) {
		this.column5 = column5;
	}

	public UIColumn getColumn5() {
		return column5;
	}

	public void setColumn6(UIColumn column6) {
		this.column6 = column6;
	}

	public UIColumn getColumn6() {
		return column6;
	}

	public String commandButton1_action() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/test";

			connection = DriverManager.getConnection(url, "root", "mysql");

			stmt = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery((String) inputText1.getValue());

			HtmlDataTable dataTable1 = new HtmlDataTable();
			dataTable1.setBorder(5);
			dataTable1.setCellpadding("1");
			dataTable1.setVar("journalcatalog");
			ResultSetDataModel dataModel = new ResultSetDataModel();

			dataModel.setWrappedData(rs);

			this.setDataTable1(dataTable1);

			UIColumn column1 = new UIColumn();
			UIColumn column2 = new UIColumn();
			UIColumn column3 = new UIColumn();
			UIColumn column4 = new UIColumn();
			UIColumn column5 = new UIColumn();
			UIColumn column6 = new UIColumn();

			this.setColumn1(column1);
			this.setColumn2(column2);
			this.setColumn3(column3);
			this.setColumn4(column4);
			this.setColumn5(column5);
			this.setColumn6(column6);

			errorMsg = new HtmlOutputText();
			HtmlOutputText headerComponent = new HtmlOutputText();
			headerComponent.setValue("CatalogId");
			column1.setHeader(headerComponent);
			headerComponent = new HtmlOutputText();
			headerComponent.setValue("Journal");
			column2.setHeader(headerComponent);
			headerComponent = new HtmlOutputText();
			headerComponent.setValue("Publisher");
			column3.setHeader(headerComponent);
			headerComponent = new HtmlOutputText();
			headerComponent.setValue("Edition");
			column4.setHeader(headerComponent);
			headerComponent = new HtmlOutputText();
			headerComponent.setValue("Title");
			column5.setHeader(headerComponent);
			headerComponent = new HtmlOutputText();
			headerComponent.setValue("Author");
			column6.setHeader(headerComponent);

			HtmlOutputText column1Text = new HtmlOutputText();

			FacesContext fCtx = FacesContext.getCurrentInstance();
			ELContext elCtx = fCtx.getELContext();
			ExpressionFactory ef = fCtx.getApplication().getExpressionFactory();
			ValueExpression ve = ef.createValueExpression(elCtx,
					"#{journalcatalog.catalogid}", String.class);

			column1Text.setValueExpression("value", ve);

			column1.getChildren().add(column1Text);

			HtmlOutputText column2Text = new HtmlOutputText();

			ve = ef.createValueExpression(elCtx, "#{journalcatalog.journal}",
					String.class);
			column2Text.setValueExpression("value", ve);

			column2.getChildren().add(column2Text);
			HtmlOutputText column3Text = new HtmlOutputText();

			ve = ef.createValueExpression(elCtx, "#{journalcatalog.publisher}",
					String.class);
			column3Text.setValueExpression("value", ve);

			column3.getChildren().add(column3Text);
			HtmlOutputText column4Text = new HtmlOutputText();

			ve = ef.createValueExpression(elCtx, "#{journalcatalog.edition}",
					String.class);
			column4Text.setValueExpression("value", ve);

			column4.getChildren().add(column4Text);
			HtmlOutputText column5Text = new HtmlOutputText();

			ve = ef.createValueExpression(elCtx, "#{journalcatalog.title}",
					String.class);
			column5Text.setValueExpression("value", ve);

			column5.getChildren().add(column5Text);
			HtmlOutputText column6Text = new HtmlOutputText();

			ve = ef.createValueExpression(elCtx, "#{journalcatalog.author}",
					String.class);
			column6Text.setValueExpression("value", ve);

			column6.getChildren().add(column6Text);

			dataTable1.setValue(dataModel);

		} catch (SQLException e) {
			errorMsg.setValue(e.getMessage());

			return "error";

		} catch (ClassNotFoundException e) {
			errorMsg.setValue(e.getMessage());

			return "error";
		} finally {

		}
		return "output";
	}
}
