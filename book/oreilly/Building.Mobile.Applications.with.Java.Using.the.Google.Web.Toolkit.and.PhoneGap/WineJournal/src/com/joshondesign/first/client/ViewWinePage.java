package com.joshondesign.first.client;

import com.google.gwt.user.client.ui.Label;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.widgets.*;

/**
 * Created by IntelliJ IDEA.
 * User: josh
 * Date: 11/15/11
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewWinePage extends Page {
    private HeaderPanel header;
    private ScrollPanel scroll;
    private ListPanel list;
    private VerticalPanel panel;

    public ViewWinePage(Wine wine) {
        header = new HeaderPanel();
        header.setCaption("" + wine.name);
        header.setLeftButton("Back");

        scroll = new ScrollPanel();


        list = new ListPanel();
        ListItem item = null;


        item = new ListItem();
        item.add(new Label("Name: "));
        item.add(new Label(""+wine.name));
        list.add(item);


        item = new ListItem();
        item.add(new Label("Variety: "));
        item.add(new Label(""+wine.variety));
        list.add(item);


        item = new ListItem();
        item.add(new Label("Vineyard: "));
        item.add(new Label(""+wine.vineyard));
        list.add(item);


        item = new ListItem();
        item.add(new Label("Rating: "));
        item.add(new Label(""+wine.rating));
        list.add(item);

        item = new ListItem();
        item.add(new Label("Location: "));
        item.add(new Label(""+wine.geoLat + ", " + wine.geoLon));
        list.add(item);


        item = new ListItem();
        item.add(new Label("Photo: "));
        item.add(new Label(""));
        list.add(item);



        scroll.add(list);

        panel = new VerticalPanel();
        panel.add(header);
        panel.add(scroll);
        /*
        header.setLeftButtonClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {

            }
        });*/
        //panel.add
        initWidget(panel);
    }
}
