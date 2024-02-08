package com.main.app.utils;

import android.util.Xml;

import com.main.app.model.MenuModel;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlPullParserUtils {
    private static final String TAG = "XmlPullParserUtils";

    public static List<MenuModel> getMenuList(InputStream xml) throws IOException, XmlPullParserException {

        List<MenuModel> menuList = new ArrayList<>();
        MenuModel mainMenu = null;
        XmlPullParser pullParser = Xml.newPullParser();
        try {

            //为PULL解析器设置要解析的XML数据
            pullParser.setInput(xml, "UTF-8");
            int event = pullParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if ("activity".equals(pullParser.getName())) {
                            mainMenu = new MenuModel();
                        }
                        if ("title".equals(pullParser.getName())) {
                            String title = pullParser.nextText();
                            mainMenu.setTitle(title);
                        }
                        if ("jump".equals(pullParser.getName())) {
                            Class<?> jumpToWhere = Class.forName(pullParser.nextText());
                            mainMenu.setJumpToWhere(jumpToWhere);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("activity".equals(pullParser.getName()) && mainMenu != null) {
                            menuList.add(mainMenu);
                            mainMenu = null;
                        }
                        break;
                }
                event = pullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        LogUtils.i(TAG, menuList.toString());
        return menuList;
    }
}
