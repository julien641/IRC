package Interface.Server;


public interface IJavafxchatserver {

    IServerConfig getServerconfig();

    void setServerconfig(IServerConfig serverconfig);

    void start();

    void startingmessage();

    void commandlineerror(Exception ex);


    int locate(String[] command, String arguments);

    boolean isDebug();

    void setDebug(boolean debug);

    Thread getThread();

    void setThread(Thread thread);

    IServerThread getServer();

    void setServer(IServerThread server);

    boolean isRunning();

    void setRunning(boolean running);
}
