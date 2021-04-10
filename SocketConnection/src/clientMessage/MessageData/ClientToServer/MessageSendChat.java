package clientMessage.MessageData.ClientToServer;

import Interface.Server.IControllerThread;
import clientMessage.Message;
import clientMessage.MessageData.IServerMessage;
import clientMessage.messageAction.ClientToServer.SendChatAction;
import socketconnection.ServerInfo;

public class MessageSendChat extends Message implements IServerMessage {
private String text;
    public MessageSendChat(ServerInfo serverInfo, String text) {
        super(serverInfo);
        this.text = text;
    }

    @Override
    public void setDefaultAction(IControllerThread controllerthread) {
        super.setAction(new SendChatAction(controllerthread,this,text));
    }
}
