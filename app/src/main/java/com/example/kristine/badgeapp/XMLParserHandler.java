package com.example.kristine.badgeapp;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangf_000 on 12/17/2014.       //Stephany Added
 */

public class XMLParserHandler {

List<Badge> badges;
    private com.example.kristine.badgeapp.Badge Badge;
    private String text;

    public XMLParserHandler(){
        badges = new ArrayList<Badge>();
    }

    public List<Badge> getBadges(){
        return badges;
    }

    public List<Badge> parse (InputStream is){
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;

        try{
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();

            parser.setInput(is,null);

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagname = parser.getName();

                switch (eventType)
                {
                    case XmlPullParser.START_TAG:
                        if(tagname.equalsIgnoreCase("badge")) {
                            Badge = new Badge();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(tagname.equalsIgnoreCase("badge")) {
                            badges.add(Badge);
                        }
                        else if(tagname.equalsIgnoreCase("id")){
                            Badge.setID(text);
                        }
                        else if(tagname.equalsIgnoreCase("item1")){
                            Badge.setItem1(text);
                        }
                        else if(tagname.equalsIgnoreCase("item2")){
                            Badge.setItem2(text);
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return badges;
    }
}
