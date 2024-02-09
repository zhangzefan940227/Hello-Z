package com.main.app.menu.model;

public class MenuModel {

    private String title;
    private Class<?> jumpToWhere;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getJumpToWhere() {
        return jumpToWhere;
    }

    public void setJumpToWhere(Class<?> jumpToWhere) {
        this.jumpToWhere = jumpToWhere;
    }

}
