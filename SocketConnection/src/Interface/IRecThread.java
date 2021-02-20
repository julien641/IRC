/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author julien
 */
public interface IRecThread extends Runnable{
public IControllerThread getController();
public void setController(IControllerThread controller);
	
	
}
