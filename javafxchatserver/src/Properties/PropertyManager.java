/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;

import com.sun.istack.internal.NotNull;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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
