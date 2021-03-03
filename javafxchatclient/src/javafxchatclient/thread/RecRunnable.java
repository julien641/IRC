package javafxchatclient.thread;

import javafxchatclient.ChatController;

public class RecRunnable implements Runnable {
    private ChatController chatController;

    public RecRunnable(ChatController chatController){
        this.chatController =chatController;
    }

    @Override
    public void run() {
        while(chatController){



        }



    }
}
