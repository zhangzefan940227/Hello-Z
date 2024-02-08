package com.main.app.model;

public class MenuModel {

    private int position;
    private String title;
    private Class<?> jumpToWhere;

    public String getTitle() {
        return title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
