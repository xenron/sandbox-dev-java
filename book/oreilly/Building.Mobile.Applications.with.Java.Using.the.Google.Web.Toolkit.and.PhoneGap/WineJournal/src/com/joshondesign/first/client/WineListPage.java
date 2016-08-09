package com.joshondesign.first.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.gwtmobile.ui.client.event.SelectionChangedEvent;
import com.gwtmobile.ui.client.event.SelectionChangedHandler;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.utils.Utils;
import com.gwtmobile.ui.client.widgets.HeaderPanel;
import com.gwtmobile.ui.client.widgets.ListPanel;
import com.gwtmobile.ui.client.widgets.ScrollPanel;

/**
 * Created by IntelliJ IDEA.
 * User: josh
 * Date: 11/15/11
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class WineListPage extends Page {
    private ListPanel wineList;
    private MyFirstApp main;
    private HTMLPanel panel;

    public WineListPage(MyFirstApp mains) {
        this.main = mains;
        wineList = new ListPanel();
        wineList.setShowArrow(true);
        wineList.setSelectable(true);
        wineList.addSelectionChangedHandler(new SelectionChangedHandler() {
            public void onSelectionChanged(SelectionChangedEvent e) {
                Utils.Console("in a selection " + e.getSelection());
                goTo(new ViewWinePage(main.wines.get(e.getSelection())));
            }
        });

        regenerateWineList();




        HeaderPanel header = new HeaderPanel();
        header.setCaption("Your Wines");
        header.setRightButton("Add");
        header.setRightButtonClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                goTo(new AddWinePage(main));
            }
        });

        panel = new HTMLPanel("div","");
        panel.add(header);
        ScrollPanel winescroll = new ScrollPanel();
        winescroll.add(wineList);
        panel.add(winescroll);
        initWidget(panel);
    }


    public void regenerateWineList() {
        wineList.clear();
        for (Wine w : main.wines) {
            wineList.add(new Label(w.variety + ": " + w.name));
        }
    }

}
