package javafxchatclient.thread;

import javafxchatclient.ChatController;

public class SendRunnable implements Runnable{
    private ChatController chatController;
    public SendRunnable(ChatController chatController){
        this.chatController =chatController;
    }

    @Override
    public void run() {

    }
}
