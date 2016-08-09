package com.joshondesign.first.client;

//standard GWT stuff

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.storage.client.Storage;
import com.googlecode.gwtphonegap.client.*;
import com.gwtmobile.ui.client.page.Page;
import com.gwtmobile.ui.client.utils.Utils;

import java.util.ArrayList;

//standard java stuff
//gwt mobile stuff


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyFirstApp implements EntryPoint {

    ArrayList<Wine> wines = new ArrayList<Wine>();
    PhoneGap phoneGap;
    WineListPage wineListPage;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        phoneGap = GWT.create(PhoneGap.class);
        phoneGap.addHandler(new PhoneGapTimeoutHandler() {
            public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
                Utils.Console("phonegap failed to initialize");
            }
        });
        phoneGap.addHandler(new PhoneGapAvailableHandler() {
            public void onPhoneGapAvailable(PhoneGapAvailableEvent phoneGapAvailableEvent) {
                Utils.Console("loading main screen");
                initWines();
                wineListPage = new WineListPage(MyFirstApp.this);
                Page.load(wineListPage);
            }
        });
        phoneGap.initializePhoneGap();

    }

    private void initWines() {
        Utils.Console("storage supported = " + Storage.isSupported());
        if(Storage.isSupported()) {
            Storage storage = Storage.getLocalStorageIfSupported();
            Utils.Console("storage = " + storage);
            Utils.Console("len = " + storage.getLength());


            String winekeys = storage.getItem("winekeys");
            if(winekeys == null) return;
            String[] keys = winekeys.split(",");
            for(String key : keys) {
                Wine wine = new Wine();
                wine.id = key;
                wine.name = storage.getItem(key+"/name");
                wine.variety = storage.getItem(key+"/variety");
                wine.vineyard = storage.getItem(key+"/vineyard");
                wine.photoURL = storage.getItem(key+"/photoURL");
                if(storage.getItem(key+"/rating") != null) {
                    wine.rating = Integer.parseInt(storage.getItem(key+"/rating"));
                }
                if(storage.getItem(key+"/geolat") != null) {
                    wine.geoLat = Double.parseDouble(storage.getItem(key+"/geolat"));
                }
                if(storage.getItem(key+"/geolon") != null) {
                    wine.geoLon = Double.parseDouble(storage.getItem(key+"/geolon"));
                }
                wines.add(wine);
            }
        } else {
            Wine w1 = new Wine();
            w1.name = "foo wine";
            w1.variety = "resling";
            w1.rating = 3;
            w1.vineyard = "foo yard";
            wines.add(w1);

            w1 = new Wine();
            w1.name = "bar wine";
            w1.variety = "malbec";
            w1.rating = 2;
            w1.vineyard = "foo yard";
            wines.add(w1);
        }
    }

    public void saveWines() {
        if(Storage.isSupported()) {
            Storage storage = Storage.getLocalStorageIfSupported();
            String ids = null;
            for(Wine wine : wines) {
                if(wine.id == null) {
                    wine.id = "wine_"+Math.random();
                }
                storage.setItem(wine.id+"/name",wine.name);
                storage.setItem(wine.id+"/variety",wine.variety);
                storage.setItem(wine.id+"/vineyard",wine.vineyard);
                storage.setItem(wine.id+"/rating",""+wine.rating);
                storage.setItem(wine.id+"/geolat",""+wine.geoLat);
                storage.setItem(wine.id+"/geolon",""+wine.geoLon);
                storage.setItem(wine.id+"/photoURL",""+wine.photoURL);
                if(ids == null) {
                    ids = wine.id;
                } else {
                    ids += ("," + wine.id);
                }
            }
            storage.setItem("winekeys",ids);
        }
    }
}
