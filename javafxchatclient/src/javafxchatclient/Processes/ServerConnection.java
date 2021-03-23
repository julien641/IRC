package javafxchatclient.Processes;

import Interface.client.IChatThreadController;

public class ServerConnection implements Runnable {

    private IChatThreadController iChatThreadController;
    public ServerConnection(IChatThreadController ichatThreadController) {
        this.iChatThreadController = ichatThreadController;
    }

    @Override
    public void run() {
        iChatThreadController.init();
    }
}
