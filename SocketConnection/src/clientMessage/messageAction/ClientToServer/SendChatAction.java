package clientMessage.messageAction.ClientToServer;

import Interface.Server.IControllerThread;
import clientMessage.Message;
import clientMessage.MessageData.ClientToServer.MessageSendChat;
import clientMessage.MessageData.ServerToClient.SendBackMessage;
import clientMessage.messageAction.IMessageAction;

public class SendChatAction implements IMessageAction {
    private final IControllerThread controllerThread;
    private final MessageSendChat messageSendChat;
    private final String text;

    public SendChatAction(IControllerThread controllerThread, MessageSendChat messageSendChat, String text) {
        this.controllerThread = controllerThread;
        this.messageSendChat = messageSendChat;
        this.text = text;
    }

    @Override
    public void action() {
        for(IControllerThread x :controllerThread.getServerthread().getControllerthreads()) {
            //TODO

            x.getMessagetosend().addMessage(new SendBackMessage(messageSendChat.getLogin(),text));
        }
    }
}
