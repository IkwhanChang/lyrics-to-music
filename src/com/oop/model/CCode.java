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
public class CCode  implements Serializable{
    private static final long serialVersionUID = 1L;
    private String codeName;    // 코드 이름
    private String fileName;    // mp3  파일 이름
    private int codeType;       //   minor  여부. 1 : 일반 2 : 메이저 3 : 마이너
    
    public CCode() {
        codeName = "";
        fileName = "";
        codeType = -1;
    }
    
    public CCode(String codeName, String fileName){
        this.codeName = codeName;
        this.fileName = fileName;
    }
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }
    
    
}
