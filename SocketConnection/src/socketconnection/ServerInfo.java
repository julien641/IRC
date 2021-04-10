package socketconnection;

import java.io.Serializable;

public class ServerInfo implements Serializable {
    private String username;
    private String password;
    private int port;
    private String ip;
    private String servername;

    public ServerInfo(String ip,String password, int port) {
        this.password = password;
        this.port = port;
        this.ip = ip;
    }

    public String getPassword() {
        return password;
    }


    public int getPort() {
        return port;
    }


    public String getIp() {
        return ip;
    }


    public String getUsername() {
        return username;
    }


    public String getServername() {
        return servername;
    }

}
