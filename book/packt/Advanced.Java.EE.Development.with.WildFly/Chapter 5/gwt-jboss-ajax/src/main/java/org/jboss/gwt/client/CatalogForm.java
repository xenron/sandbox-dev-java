package org.jboss.gwt.client;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.*;

import java.lang.Exception;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CatalogForm implements EntryPoint {

	/**
	 * This is the entry point method.
	 */

	ArrayList<String> arrayList;
	HashMap<String, ArrayList<String>> catalogHashMap;

	public void onModuleLoad() {

		final Button button = new Button("Submit");
		final Label label1 = new Label("Catalog ID");
		final Label label2 = new Label("Journal");
		final Label label3 = new Label("Publisher");
		final Label label4 = new Label("Edition");
		final Label label5 = new Label("Title");
		final Label label6 = new Label("Author");
		final Label label7 = new Label();

		final TextBox textBox1 = new TextBox();
		final TextBox textBox2 = new TextBox();
		final TextBox textBox3 = new TextBox();
		final TextBox textBox4 = new TextBox();
		final TextBox textBox5 = new TextBox();
		final TextBox textBox6 = new TextBox();

		arrayList = new ArrayList<String>();

		arrayList.add(0, "catalog1");
		arrayList.add(1, "Oracle Magazine");
		arrayList.add(2, "Oracle Publishing");
		arrayList.add(3, "May-June 2006");
		arrayList.add(4, "Tuning Your View Objects");
		arrayList.add(5, "Steve Muench");

		catalogHashMap = new HashMap<String, ArrayList<String>>();
		catalogHashMap.put("catalog1", arrayList);

		arrayList = new ArrayList<String>();

		arrayList.add(0, "catalog2");
		arrayList.add(1, "Oracle Magazine");
		arrayList.add(2, "Oracle Publishing");
		arrayList.add(3, "July-August 2006");
		arrayList.add(4, "Evolving Grid Management");
		arrayList.add(5, "David Baum");

		catalogHashMap.put("catalog2", arrayList);

		textBox1.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {

				try {

					String catalogId = textBox1.getText();
					if (catalogHashMap.containsKey(catalogId)) {
						ArrayList<String> arraylist = (ArrayList<String>) catalogHashMap
								.get(catalogId);
						label7.setText("Catalog Id is not Valid");
						textBox2.setText((String) arraylist.get(1));
						textBox3.setText((String) arraylist.get(2));
						textBox4.setText((String) arraylist.get(3));
						textBox5.setText((String) arraylist.get(4));
						textBox6.setText((String) arraylist.get(5));
						button.setEnabled(false);

					}

					else {
						if (catalogId != "") {
							label7.setText("Catalog Id is Valid");
							textBox2.setText("");
							textBox3.setText("");
							textBox4.setText("");
							textBox5.setText("");
							textBox6.setText("");
							button.setEnabled(true);
						}

					}

				} catch (Exception e) {
				}

			}
		});

		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				String catalogId = textBox1.getText();
				arrayList = new ArrayList<String>();

				arrayList.add(0, catalogId);
				arrayList.add(1, textBox2.getText());
				arrayList.add(2, textBox3.getText());
				arrayList.add(3, textBox4.getText());
				arrayList.add(4, textBox5.getText());
				arrayList.add(5, textBox6.getText());
				catalogHashMap.put(catalogId, arrayList);

			}
		});

		RootPanel.get("label1").add(label1);
		RootPanel.get("label2").add(label2);
		RootPanel.get("label3").add(label3);
		RootPanel.get("label4").add(label4);
		RootPanel.get("label5").add(label5);
		RootPanel.get("label6").add(label6);
		RootPanel.get("textBox1").add(textBox1);
		RootPanel.get("textBox2").add(textBox2);
		RootPanel.get("textBox3").add(textBox3);
		RootPanel.get("textBox4").add(textBox4);
		RootPanel.get("textBox5").add(textBox5);
		RootPanel.get("textBox6").add(textBox6);
		RootPanel.get("button").add(button);
		RootPanel.get("label7").add(label7);
	}
} 

