/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MatthewChang
 */
public class CMusic implements Serializable {
    private static final long serialVersionUID = 3L;
     private String title; //  제목
     private String artist; // 아티스트
     
     public CMusic() {
         title = "";
         artist = "";
     }
     
     public void setMusicInfo(String title, String artist) {
         this.title = title;
         this.artist = artist;
     }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
     
}
