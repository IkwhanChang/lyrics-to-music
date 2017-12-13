/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.manager;

import com.oop.model.CCode;

/**
 * 
 * @author Comet
 */
public class CodeManager {
	CCode code = new CCode();

	// private String code; //코드

	// add, modify, del

	//액션 취했을 때 액션의 이름 가져오기
	public void addCode(){
//<<<<<<< .mine
	String add_code = null;
//=======
		//String add_code = null;
//>>>>>>> .r10
    	CCode addCode = new CCode();
    	addCode.setCodeName(add_code);
    }
	
	
	public void modifyCode(String mod_code) {
		code.setCodeName(mod_code);
	}

	

}
