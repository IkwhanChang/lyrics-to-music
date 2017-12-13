/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.manager;

import com.oop.controller.MusicController;
import com.oop.engine.MP3Engine;
import com.oop.model.CCode;
import com.oop.model.CLyrics;
import com.oop.view.LyricsPanel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MatthewChang
 */
public class LyricsManager implements Serializable {
    private ArrayList<CLyrics> arrLyrics; //  가사정보들

    public ArrayList<CLyrics> getArrLyrics() {
        return arrLyrics;
    }

    public void setArrLyrics(ArrayList<CLyrics> arrLyrics) {
        this.arrLyrics = arrLyrics;
    }

    
    public LyricsManager() {
        arrLyrics = new ArrayList<CLyrics>();
        
    }
    
    public void addLyrics(String lyrics, CCode code) {
        CLyrics tLyrics = new CLyrics(arrLyrics.size()+1,lyrics, code);
        arrLyrics.add(tLyrics);
    }
}
