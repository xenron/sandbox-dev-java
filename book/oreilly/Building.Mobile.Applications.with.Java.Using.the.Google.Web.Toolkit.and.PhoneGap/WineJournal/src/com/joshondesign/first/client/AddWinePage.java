package com.joshondesign.first.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gwtphonegap.client.camera.PictureCallback;
import com.googlecode.gwtphonegap.client.camera.PictureOptions;
import com.googlecode.gwtphonegap.client.geolocation.Geolocation;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback;
import com.googlecode.gwtphonegap.client.geolocation.Position;
import com.googlecode.gwtphonegap.client.geolocation.PositionError;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.utils.Utils;
import com.gwtmobile.ui.client.widgets.Button;
import com.gwtmobile.ui.client.widgets.DropDownItem;
import com.gwtmobile.ui.client.widgets.DropDownList;
import com.gwtmobile.ui.client.widgets.HeaderPanel;
import com.gwtmobile.ui.client.widgets.ListItem;
import com.gwtmobile.ui.client.widgets.ListPanel;
import com.gwtmobile.ui.client.widgets.RadioButton;
import com.gwtmobile.ui.client.widgets.RadioButtonGroup;
import com.gwtmobile.ui.client.widgets.ScrollPanel;
import com.gwtmobile.ui.client.widgets.TextBox;
import com.gwtmobile.ui.client.widgets.VerticalPanel;

/**
 * Created by IntelliJ IDEA.
 * User: josh
 * Date: 11/15/11
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddWinePage extends Page {
    private DropDownList variety;
    private RadioButtonGroup ratings;
    private TextBox nameBox;
    private TextBox vineyardBox;
    private Position selectedPosition;
    private MyFirstApp main;
    private String photoURL;

    public AddWinePage(MyFirstApp mains) {
        this.main = mains;


        //add wine panel
        ListPanel addPanel = new ListPanel();

        ListItem nameRow = new ListItem();
        nameRow.add(new Label("Wine name:"));
        nameBox = new TextBox();
        nameRow.add(nameBox);
        addPanel.add(nameRow);

        ListItem vineyardRow = new ListItem();
        vineyardRow.add(new Label("Vineyard:"));
        vineyardBox = new TextBox();
        vineyardRow.add(vineyardBox);
        addPanel.add(vineyardRow);


        variety = new DropDownList();
        DropDownItem it1 = new DropDownItem();
        it1.setText("Riesling");
        it1.setValue("Riesling");
        variety.add(it1);
        it1 = new DropDownItem();
        it1.setText("Merlot");
        it1.setValue("Merlot");
        variety.add(it1);

        ListItem varietalRow = new ListItem();
        varietalRow.add(new Label("Varietal"));
        varietalRow.add(variety);
        addPanel.add(varietalRow);



        ratings = new RadioButtonGroup();
        ratings.setVertical(false);
        ratings.setName("foo");
        for (int i = 0; i < 5; i++) {
            RadioButton bt = new RadioButton();
            bt.setText("" + (i+1));
            ratings.add(bt);
        }

        //TODO: what is this for?
        addPanel.setSecondaryStyle("modify");
        addPanel.setSelectable(false);



        ListItem ratingRow = new ListItem();
        ratingRow.add(new Label("Rating"));
        ratingRow.add(ratings);
        addPanel.add(ratingRow);



        ListItem photoRow = new ListItem();
        photoRow.add(new Label("Photo"));
        Button photoButton = new Button();
        photoButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                Utils.Console("clicked");
                PictureOptions options = new PictureOptions(25);
                options.setDestinationType(PictureOptions.DESTINATION_TYPE_DATA_URL);
                options.setSourceType(PictureOptions.PICTURE_SOURCE_TYPE_CAMERA);
                main.phoneGap.getCamera().getPicture(options, new PictureCallback() {
                    public void onSuccess(String s) {
                        Utils.Console("succeeded: " + s);
                        photoURL = s;
                    }
                    public void onFailure() {
                        Utils.Console("failed");
                    }
                });
            }
        });
        photoButton.setText("Choose");
        photoRow.add(photoButton);
        addPanel.add(photoRow);




        ListItem locationRow = new ListItem();
        final Label locationLabel = new Label("Location");
        locationRow.add(locationLabel);
        Button locationButton = new Button();
        locationButton.setText("Find");
        locationButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                Utils.Console("other clicked");
                Geolocation geo = main.phoneGap.getGeolocation();
                geo.getCurrentPosition(new GeolocationCallback() {
                    public void onSuccess(Position position) {
                        selectedPosition = position;
                        locationLabel.setText("Location: " +
                                position.getCoordinates().getLatitude() +
                                ", " + position.getCoordinates().getLongitude());
                    }

                    public void onFailure(PositionError positionError) {
                        Utils.Console("failure");
                    }
                });
            }
        });
        locationRow.add(locationButton);
        addPanel.add(locationRow);



        //panel = new TabPanel();

        ListItem addRow = new ListItem();
        Button addButton = new Button();
        addButton.setText("Add");
        addButton.addClickHandler(new AddWineHandler());
        addRow.add(addButton);
        addPanel.add(addRow);

        HeaderPanel header = new HeaderPanel();
        header.setLeftButton("Back");
        header.setCaption("Add New Wine");

        VerticalPanel panel = new VerticalPanel();
        panel.add(header);
        ScrollPanel scroll = new ScrollPanel();
        scroll.add(addPanel);
        panel.add(scroll);
        initWidget(panel);
    }


    private class AddWineHandler implements ClickHandler {
        public void onClick(ClickEvent clickEvent) {
            Wine wine = new Wine();

            wine.name = nameBox.getText();
            nameBox.setText("");

            wine.variety =  variety.getSelectedValue();
            //variety.clear();

            wine.vineyard = vineyardBox.getText();
            vineyardBox.setText("");

            wine.rating = ratings.getCheckedIndex();
            //ratings.clear();

            //photo
            wine.photoURL = photoURL;

            // geo position
            if(selectedPosition != null) {
                wine.geoLat = selectedPosition.getCoordinates().getLatitude();
                wine.geoLon = selectedPosition.getCoordinates().getLongitude();
            }
            selectedPosition = null;


            main.wines.add(wine);
            main.saveWines();
            main.wineListPage.regenerateWineList();

            goTo(main.wineListPage);
        }
    }
}
