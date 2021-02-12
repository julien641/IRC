/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

/**
 *
 * @author julien
 */
public class connectionInfo {
    private String username;
    private String password;
    private String hostName;
    private int port;
    
    
    public connectionInfo(){
        
    }
    public connectionInfo(String username,String password,String hostName,int port){
        this.username=username;
        this.password=password;
        this.hostName=hostName;
        this.port=port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
    
    
}
