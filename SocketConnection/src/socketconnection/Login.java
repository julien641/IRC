package socketconnection;

import java.io.Serializable;

public class Login implements Serializable {
    private String username;
    private String password;
    private int port;
    private String ip;
    private String servername;

    public Login(String username, String password, int port, String ip,String servername) {
        this.username = username;
        this.password = password;
        this.port = port;
        this.ip = ip;
        this.servername =servername.isEmpty() ? ip :servername;
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
