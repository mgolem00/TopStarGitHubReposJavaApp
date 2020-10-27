package com.example.topstargithubrepos_javaapp;

public class Items {

    private String imgURL;
    private String repoName;
    private String repoOwner;
    private int numOfStars;

    public Items (String r_imgURL, String r_repoName, String r_repoOwner, int r_numOfStars) {
        this.imgURL = r_imgURL;
        this.repoName = r_repoName;
        this.repoOwner = r_repoOwner;
        this.numOfStars = r_numOfStars;
    }

    public String getImgURL(){
        return imgURL;
    }

    public String getRepoName(){
        return repoName;
    }

    public String getRepoOwner(){
        return repoOwner;
    }

    public int getNumOfStars(){
        return numOfStars;
    }
}
