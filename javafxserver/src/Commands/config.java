/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import javafxchatserver.Javafxchatserver;
import socketconnection.RC;

/**
 *
 * @author julien
 */
public class config extends Commands{

	public config(Javafxchatserver cli, String commands) {
		super(cli, commands);
	}

	@Override
	public RC run() {
		System.out.println(super.getCli().getServerconfig().toString());

		
		return null;
	}
	
}
