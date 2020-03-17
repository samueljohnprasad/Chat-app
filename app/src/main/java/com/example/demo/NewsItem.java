package com.example.demo;

public class NewsItem {


    String Title ,Content,Data;
    int userPhoto;


    public NewsItem(){

    }

    public NewsItem(String title, String content, String data, int userPhoto) {
        Title = title;
        Content = content;
        Data = data;
        this.userPhoto = userPhoto;
    }



    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }
}
