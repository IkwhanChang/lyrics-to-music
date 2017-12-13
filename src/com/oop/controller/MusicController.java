/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.controller;

import com.oop.engine.MP3Engine;
import com.oop.manager.LyricsManager;
import com.oop.manager.MusicManager;
import com.oop.model.CCode;
import com.oop.model.CLyrics;
import com.oop.model.CMusic;
import com.oop.view.AddBitWindow;
import com.oop.view.AddCodeWindow;
import com.oop.view.AddLyricsWindow;
import com.oop.view.AddMusicWindow;
import com.oop.view.HelpWindow;
import com.oop.view.L2MWindow;
import com.oop.view.LyricsPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author MatthewChang
 */
public class MusicController {
    
    // View
    private HelpWindow helpWindow = new HelpWindow(this);
    private AddBitWindow addBitWindow = new AddBitWindow(this);
    private AddLyricsWindow addLyricsWindow = new AddLyricsWindow(this);
    private AddCodeWindow addCodeWindow = new AddCodeWindow(this);
    private AddMusicWindow addMusicWindow = new AddMusicWindow(this);
    private L2MWindow l2mWindow = new L2MWindow(this);
    
    // Manager
    private MusicManager musicManager = new MusicManager();
    private ArrayList<LyricsPanel> arrLyricsPane = new ArrayList<LyricsPanel>(); // 가사정보 패널
    
    //
    int cIndex = -1;
    int nowKey = 0;
    boolean isPlay = false;
    
    // Engines
    private ArrayList<MP3Engine> arrMp3 = new ArrayList<MP3Engine>(); // MP3

    public HelpWindow getHelpWindow() {
        return helpWindow;
    }

    public void setHelpWindow(HelpWindow helpWindow) {
        this.helpWindow = helpWindow;
    }

    public AddBitWindow getAddBitWindow() {
        return addBitWindow;
    }

    public void setAddBitWindow(AddBitWindow addBitWindow) {
        this.addBitWindow = addBitWindow;
    }

    public AddLyricsWindow getAddLyricsWindow() {
        return addLyricsWindow;
    }

    public void setAddLyricsWindow(AddLyricsWindow addLyricsWindow) {
        this.addLyricsWindow = addLyricsWindow;
    }

    public AddCodeWindow getAddCodeWindow() {
        return addCodeWindow;
    }

    public void setAddCodeWindow(AddCodeWindow addCodeWindow) {
        this.addCodeWindow = addCodeWindow;
    }

    public AddMusicWindow getAddMusicWindow() {
        return addMusicWindow;
    }

    public void setAddMusicWindow(AddMusicWindow addMusicWindow) {
        this.addMusicWindow = addMusicWindow;
    }

    public MusicManager getMusicManager() {
        return musicManager;
    }

    public void setMusicManager(MusicManager musicManager) {
        this.musicManager = musicManager;
    }

    public L2MWindow getL2mWindow() {
        return l2mWindow;
    }

    public void setL2mWindow(L2MWindow l2mWindow) {
        this.l2mWindow = l2mWindow;
    }
    
    
    
    //  새 음악 만들기
     public void addNewMusic(String title, String artist) {
         CMusic tMusic = new CMusic();
         tMusic.setMusicInfo(title, artist);
         this.musicManager.setMusicInfo(tMusic);
         this.l2mWindow.updateMusicInfo();
         this.addMusicWindow.setVisible(false);
     }
     
     // 가사 추가 windows open
     public void addLyricsWindow() {
         if(this.musicManager.getMusicInfo().getTitle().equals("")){ //  제목이 없으면 아직 곡이 생성 안된겅미
             JOptionPane.showMessageDialog(null, "먼저 L2M 곡을 생성해 주세요.");
             return;
         }
         this.addLyricsWindow.getjTextField3().requestFocus();
         this.addLyricsWindow.setVisible(true);
     }
     
     //  가사  추가  Logic
     public void addLyricsPanel(LyricsPanel lyricsPanel, String lyrics) {
         // 레이어 패널 추가
         this.arrLyricsPane.add(lyricsPanel);
         
         // 데이터 추가
         int myNum = this.musicManager.getLyricsManager().getArrLyrics().size()+1;
         CLyrics tLyrics = new CLyrics(myNum,lyrics,new CCode());
         
         this.musicManager.getLyricsManager().getArrLyrics().add(tLyrics);
         
         
         // 
         
         lyricsPanel.getjTextField9().setText(""+myNum);
         lyricsPanel.getjTextField10().setText(lyrics);
         
         this.l2mWindow.getjPanel2().add(lyricsPanel);
         this.l2mWindow.getjPanel2().setVisible(false);
         this.l2mWindow.getjPanel2().setVisible(true);
         
         //this.l2mWindow.pack();
     }
     
     //  가사  추가  Logic
     public void addLyricsPanel(LyricsPanel lyricsPanel,CLyrics lyrics) {
         // 레이어 패널 추가
         this.arrLyricsPane.add(lyricsPanel);
         
         // 데이터 추가
         
         lyricsPanel.getjTextField9().setText(""+lyrics.getNum());
         lyricsPanel.getjTextField10().setText(lyrics.getLyrics());
         lyricsPanel.getjTextField12().setText(lyrics.getCode().getCodeName());
         
         this.l2mWindow.getjPanel2().add(lyricsPanel);
         this.l2mWindow.getjPanel2().setVisible(false);
         this.l2mWindow.getjPanel2().setVisible(true);
         
         //this.l2mWindow.pack();
     }
     
     public void setCode1(int index){
         this.cIndex = index;
         this.addCodeWindow.setVisible(true);
     }
     public void setCode2(String codeName) {
         //this.tLyricsPanel.getjTextField12().setText(codeName);
         arrLyricsPane.get(cIndex).getjTextField12().setText(codeName);
         this.musicManager.getLyricsManager().getArrLyrics().get(cIndex).setCode(new CCode(codeName,""));
     }

    public ArrayList<LyricsPanel> getArrLyricsPane() {
        return arrLyricsPane;
    }

    public void setArrLyricsPane(ArrayList<LyricsPanel> arrLyricsPane) {
        this.arrLyricsPane = arrLyricsPane;
    }
     public void play() {
         if(nowKey < musicManager.getLyricsManager().getArrLyrics().size() && isPlay){
            CCode code = musicManager.getLyricsManager().getArrLyrics().get(nowKey).getCode();
            MP3Engine tEngine = new MP3Engine(code.getCodeName()+".mp3",this,nowKey);
            changeNowLyrics(nowKey);
            tEngine.play();
            nowKey++; 
         }
     }

    public boolean isIsPlay() {
        return isPlay;
    }

    public void setIsPlay(boolean isPlay) {
        this.isPlay = isPlay;
    }
     

    public int getcIndex() {
        return cIndex;
    }

    public void setcIndex(int cIndex) {
        this.cIndex = cIndex;
    }

    public ArrayList<MP3Engine> getArrMp3() {
        return arrMp3;
    }

    public void setArrMp3(ArrayList<MP3Engine> arrMp3) {
        this.arrMp3 = arrMp3;
    }
     public void stop() {
         this.nowKey = 0;
         this.isPlay = false;
         
         for(LyricsPanel tlp : arrLyricsPane){
            tlp.getjTextField10().setForeground(new Color(0,0,0));
        }
         this.l2mWindow.getjScrollPane1().getVerticalScrollBar().setValue(0);
         this.l2mWindow.getjProgressBar1().setValue(0);
         this.l2mWindow.getjPanel2().setVisible(false);
         this.l2mWindow.getjPanel2().setVisible(true);
         
         this.l2mWindow.getjTextField4().setText("가사창");
         
     }
     public void Save(){
         // 1. OptionData -> file
         File fileName;
         JFileChooser chooser = new JFileChooser();
         chooser.setFileFilter
    (new javax.swing.filechooser.FileNameExtensionFilter("L2M", "l2m"));
         int yn =  chooser.showSaveDialog(this.l2mWindow);
         if(yn != JFileChooser.APPROVE_OPTION){
             fileName = null;
             return;
         }else{
             fileName = new File(chooser.getSelectedFile().getPath()+".l2m");
         }
        try {
                ObjectOutputStream os = new ObjectOutputStream(
                                new FileOutputStream(fileName));
                os.writeObject(this.musicManager);
                os.flush();
                os.close(); // 주의하세요.!!

                System.out.println("success file write!! write optionData");
        } catch (IOException ioe) {
                ioe.printStackTrace();

                System.out.println("temp file make.[" + fileName.getPath() + "]");
        }
     }
     public void Load(){
         File fileName;
         JFileChooser chooser = new JFileChooser();
         chooser.setFileFilter
    (new javax.swing.filechooser.FileNameExtensionFilter("L2M", "l2m"));
         int yn =  chooser.showOpenDialog(this.l2mWindow);
         if(yn != JFileChooser.APPROVE_OPTION){
             fileName = null;
             return;
         }else{
             fileName = chooser.getSelectedFile();
         }
         
         // 1.file -> OptionData
        
        try {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                                fileName));
                this.musicManager = (MusicManager) is.readObject();
                loadMusic();
                is.close();
        } catch (Exception ex) {
                ex.printStackTrace();

        }
     }
     
     public void deleteLyrics(LyricsPanel tlyricsPanel){
         int idx = -1;
         this.l2mWindow.getjPanel2().remove(tlyricsPanel);
         
         
         for(LyricsPanel tlp : arrLyricsPane){
             if(tlp.equals(tlyricsPanel)){
                 idx = tlp.getIndex();
                 arrLyricsPane.remove(tlyricsPanel);
                 break;
             }
         }
         
         updateLyricsNum();
         this.l2mWindow.getjPanel2().setVisible(false);
         this.l2mWindow.getjPanel2().setVisible(true);
         
         this.musicManager.getLyricsManager().getArrLyrics().remove(idx);
     }
     
     public void updateLyricsNum(){
         int i = 0;
         for(LyricsPanel tlp : arrLyricsPane){
             tlp.getjTextField9().setText(""+(i+1));
             tlp.setIndex(i);
             i++;
             tlp.setVisible(false);
             tlp.setVisible(true);
         }
     }
     
     public void changeLyrics(LyricsPanel tlyricsPanel){
         int idx = -1;
         
         for(LyricsPanel tlp : arrLyricsPane){
             if(tlp.equals(tlyricsPanel)){
                 idx = tlp.getIndex();
                 break;
             }
         }
         
         this.musicManager.getLyricsManager().getArrLyrics().get(idx).setLyrics(tlyricsPanel.getjTextField10().getText());
         System.out.println("changed");
         
     }
     
     public void clearAll() {
         int response = JOptionPane.showConfirmDialog(
                     null,
                    "모든 가사와 작업한 내용이 초기화됩니다.\n사용자는 확실합니까?",
                    "경고",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
         System.out.println(response);
         if(response == 0){
            int k = arrLyricsPane.size();
            for(int i = 0 ; i < k ; i++){
                this.l2mWindow.getjPanel2().remove(arrLyricsPane.get(i));
            }
           musicManager = new MusicManager();
           arrLyricsPane = new ArrayList<LyricsPanel>(); // 가사정보 패널

           cIndex = -1;

           arrMp3 = new ArrayList<MP3Engine>(); // MP3

           this.l2mWindow.getjTextField2().setText("먼저 곡을 생성해 주세요.");
           this.l2mWindow.getjTextField3().setText("먼저 곡을 생성해 주세요.");
           
           this.l2mWindow.getjPanel2().setVisible(false);
         this.l2mWindow.getjPanel2().setVisible(true);
         }
     }
     
     public void loadMusic(){
         this.l2mWindow.updateMusicInfo();
         for(int i = 0 ; i < this.musicManager.getLyricsManager().getArrLyrics().size() ; i++){
             addLyricsPanel(new LyricsPanel(this),musicManager.getLyricsManager().getArrLyrics().get(i));
         }
     }


    public void changeNowLyrics(int key){
        for(LyricsPanel tlp : arrLyricsPane){
            tlp.getjTextField10().setForeground(new Color(0,0,0));
        }
        arrLyricsPane.get(key).getjTextField10().setForeground(new Color(255,0,0));
        //arrLyricsPane.get(key).getjTextField10().setVisible(false);
        //arrLyricsPane.get(key).setVisible(true);
        this.l2mWindow.getjTextField4().setText(this.musicManager.getLyricsManager().getArrLyrics().get(key).getLyrics());
        
        System.out.println(""+(((double)(key+1) / arrLyricsPane.size())*100));
        int process = (int)((((double)(key+1) / arrLyricsPane.size())*100));
        //int process2 = (int)((((double)(key) / arrLyricsPane.size())*100));
        this.l2mWindow.getjProgressBar1().setValue(process);
        
       
        this.l2mWindow.getjScrollPane1().setAutoscrolls(true);
        //this.l2mWindow.getjScrollPane1().getVerticalScrollBar().setValue(process2);
        
        
        
        this.l2mWindow.getjPanel2().setVisible(false);
        this.l2mWindow.getjPanel2().setVisible(true);
        
        
    }
    
}
