package clientMessage.MessageData.ClientToServer;

import Interface.Server.IControllerThread;
import clientMessage.Message;
import clientMessage.MessageData.IServerMessage;
import clientMessage.messageAction.ClientToServer.SendChatAction;

public class MessageSendChat extends Message implements IServerMessage {
private String text;
    public MessageSendChat(String from,String text) {
        super(from);
        this.text = text;
    }

    @Override
    public void setDefaultAction(IControllerThread controllerthread) {
        super.setAction(new SendChatAction(controllerthread,super.getFrom(),text));
    }
}
