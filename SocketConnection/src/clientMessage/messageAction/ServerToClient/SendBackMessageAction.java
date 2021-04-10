package clientMessage.messageAction.ServerToClient;

import Interface.client.IChatThreadController;
import clientMessage.Message;
import clientMessage.messageAction.IMessageAction;
import javafx.application.Platform;
import javafx.scene.text.Text;

public class SendBackMessageAction implements IMessageAction {
    private Message message;
    private IChatThreadController client;
    private String payload;

    public SendBackMessageAction(IChatThreadController client,Message message,String payload)
    {
        this.message =message;
        this.client =client;
        this.payload =payload;
    }
    @Override
    public void action() {
      //  Platform.runLater(() ->  client.getChattabController().getChatbox().getChildren().add(new Text(message.getServerInfo().getUsername()+":"+payload+"\n")));

    }
}
