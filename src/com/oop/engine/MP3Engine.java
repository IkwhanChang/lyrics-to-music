/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.engine;

import com.oop.controller.MusicController;
import java.io.File;
import java.io.FileInputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author MatthewChang
 */
// Import the JLayer classes
import javazoom.jl.player.*;

// Import the Java classes
import java.io.*;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaines
 */
public class MP3Engine {

 private Player player;
 private InputStream is;
 MusicController musicController;
 int key;
 String filename;
 /** Creates a new instance of MP3Player */
 public MP3Engine( String filename ,MusicController musicController, int key) 
 {
     this.musicController = musicController;
        filename = filename.replace("#", "sharp");
        this.filename = this.getClass().getResource(filename).toString().substring(5, this.getClass().getResource(filename).toString().length());
 }
 
  public void close() { if (player != null) player.close(); }

    // play the MP3 file to the sound card
    public void play() {
        try {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
            
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try { player.play();}
                catch (Exception e) { System.out.println(e); }
                finally{
                    musicController.play();
                }
            }
        }.start();
    }
}
