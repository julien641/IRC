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

        synchronized(chatThreadController.getMts().getMessagetosend()) {
            while (chatThreadController.getRunning().get()) {
                while (!chatThreadController.getMts().hasremaining()) {
                    try {
                            chatThreadController.getMts().getMessagetosend().wait();
                    } catch (InterruptedException ignored) {}
                }
                System.out.println("sending message");
                chatThreadController.getSw().sendMessage((Message) chatThreadController.getMts().getRemMessage());
                System.out.println("sent message");
            }
        }



    }
}
