/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.manager;

import com.oop.controller.MusicController;
import com.oop.model.CCode;
import com.oop.model.CLyrics;
import com.oop.model.CMusic;
import com.oop.view.LyricsPanel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MatthewChang
 */
public class MusicManager implements Serializable {
    LyricsManager lyricsManager;
    
    CMusic musicInfo;
    
    
    public MusicManager() {
        this.lyricsManager = new LyricsManager();
        musicInfo = new CMusic();
    }
   
    public LyricsManager getLyricsManager() {
        return lyricsManager;
    }

    public void setLyricsManager(LyricsManager lyricsManager) {
        this.lyricsManager = lyricsManager;
    }

    public CMusic getMusicInfo() {
        return musicInfo;
    }

    public void setMusicInfo(CMusic musicInfo) {
        this.musicInfo = musicInfo;
    }

    
    
}
