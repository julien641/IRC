package clientMessage.MessageData.ServerToClient;

import Interface.client.IChatThreadController;
import clientMessage.Message;
import clientMessage.MessageData.IClientMessage;
import clientMessage.messageAction.ServerToClient.SendBackMessageAction;
import socketconnection.ServerInfo;

public class SendBackMessage extends Message implements IClientMessage {
    private String payload;

    public SendBackMessage(ServerInfo serverInfo, String payload) {
        super(serverInfo);
        this.payload =payload;
    }

    @Override
    public void setDefaultAction(IChatThreadController client) {
        super.setAction(new SendBackMessageAction(client,this,payload));
    }
}
