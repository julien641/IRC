/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author julien
 */
public class PropertyManager {
	
	
	public  Properties PropertyManager(String file) {
		Properties properties=null;
		try (InputStream fileinput = this.getClass().getResourceAsStream(file)) {
			properties = new Properties();
			properties.load(fileinput);
			fileinput.close();
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
			
		return properties;	
	}
	
}
