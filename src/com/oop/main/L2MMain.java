/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.main;

import com.oop.controller.MusicController;
import com.oop.view.AddBitWindow;
import com.oop.view.AddCodeWindow;
import com.oop.view.AddLyricsWindow;
import com.oop.view.AddMusicWindow;
import com.oop.view.HelpWindow;
import com.oop.view.L2MWindow;

/**
 *
 * @author MatthewChang
 */
public class L2MMain {
    
    /**
     * @param args the command line arguments
     */
    
    static MusicController musicController = new MusicController();
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(L2MMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(L2MMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(L2MMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(L2MMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                musicController.getL2mWindow().setVisible(true);
            }
        });
    }
}
