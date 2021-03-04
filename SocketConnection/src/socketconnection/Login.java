package socketconnection;

public class Login {
    private String username;
    private String password;
    private int port;
    private String ip;

    public Login(String username, String password, int port, String ip) {
        this.username = username;
        this.password = password;
        this.port = port;
        this.ip = ip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
