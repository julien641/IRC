package clientMessage.MessageData.ClientToServer;

import Interface.Server.IControllerThread;
import clientMessage.Message;
import clientMessage.MessageData.IServerMessage;
import clientMessage.messageAction.ClientToServer.SendChatAction;
import socketconnection.Login;

public class MessageSendChat extends Message implements IServerMessage {
private String text;
    public MessageSendChat(Login login, String text) {
        super(login);
        this.text = text;
    }

    @Override
    public void setDefaultAction(IControllerThread controllerthread) {
        super.setAction(new SendChatAction(controllerthread,this,text));
    }
}
