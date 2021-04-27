package clientMessage.MessageData.ServerToClient;

import Interface.client.IChatThreadController;
import clientMessage.Message;
import clientMessage.MessageData.IClientMessage;
import clientMessage.MessageData.IMessageAction;
import socketconnection.ServerInfo;

public class SendBackMessage extends Message implements IClientMessage {
    private String payload;

    public SendBackMessage(ServerInfo serverInfo, String payload) {
        super(serverInfo);
        this.payload = payload;
    }

    @Override
    public void setDefaultAction(IChatThreadController client) {
        super.setAction(new SendBackMessageAction(client, this, payload));
    }

   private class SendBackMessageAction implements IMessageAction {
        private Message message;
        private IChatThreadController client;
        private String payload;

        public SendBackMessageAction(IChatThreadController client, Message message, String payload) {
            this.message = message;
            this.client = client;
            this.payload = payload;
        }

        @Override
        public void action() {
            //  Platform.runLater(() ->  client.getChattabController().getChatbox().getChildren().add(new Text(message.getServerInfo().getUsername()+":"+payload+"\n")));

        }

    }
}
