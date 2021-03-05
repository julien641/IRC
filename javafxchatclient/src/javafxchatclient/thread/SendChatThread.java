package javafxchatclient.thread;

import clientMessage.Message;

public class SendChatThread implements Runnable{
    private ChatThreadController chatThreadController;

    public SendChatThread(ChatThreadController chatThreadController) {
        this.chatThreadController = chatThreadController;
    }

    public ChatThreadController getChatThreadController() {
        return chatThreadController;
    }

    public void setChatThreadController(ChatThreadController chatThreadController) {
        this.chatThreadController = chatThreadController;
    }

    @Override
    public void run() {
        while(chatThreadController.getRunning().get()){
            while(!chatThreadController.getMts().hasremaining()){
                try {
                    synchronized(chatThreadController.getTsend()) {
                        chatThreadController.getTsend().wait();
                    }
                } catch (InterruptedException e) {
                }
            }
            chatThreadController.getSw().sendMessage((Message) chatThreadController.getMts().getRemMessage());

        }




    }
}
