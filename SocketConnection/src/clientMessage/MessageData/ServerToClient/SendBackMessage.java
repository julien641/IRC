package clientMessage.MessageData.ServerToClient;

import Interface.client.IChatThreadController;
import clientMessage.Message;
import clientMessage.MessageData.IClientMessage;
import clientMessage.messageAction.ServerToClient.SendBackMessageAction;
import socketconnection.Login;

public class SendBackMessage extends Message implements IClientMessage {
    private String payload;

    public SendBackMessage(Login login,String payload) {
        super(login);
        this.payload =payload;
    }

    @Override
    public void setDefaultAction(IChatThreadController client) {
        super.setAction(new SendBackMessageAction(client,this,payload));
    }
}
