package Interface.Server;


import socketconnection.RC;

public interface IJavafxchatserver {
    RC stopServerThread();
    void startserver(int port);
}
