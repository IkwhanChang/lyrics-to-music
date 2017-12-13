/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.model;

import java.io.Serializable;

/**
 *
 * @author MatthewChang
 */
public class CLyrics implements Serializable {
    private static final long serialVersionUID = 2L;
    private int num;
    private String lyrics;
    private CCode code;
    
    public CLyrics() {
        
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public CLyrics(int num, String lyrics, CCode code){
        this.lyrics = lyrics;
        this.code = code;
        this.num = num;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public CCode getCode() {
        return code;
    }

    public void setCode(CCode code) {
        this.code = code;
    }
}
