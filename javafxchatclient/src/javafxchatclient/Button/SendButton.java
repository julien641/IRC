package javafxchatclient.Button;

import Interface.client.IChatTabController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafxchatclient.ChattabController;
import clientMessage.MessageData.ClientToServer.MessageSendChat;
public class SendButton implements EventHandler {
    private final IChatTabController chattabController;
    public SendButton(ChattabController chattabController){
        this.chattabController =chattabController;
    }
    @Override
    public void handle(Event event) {
        String payload=chattabController.getSendchattextarea().getText();
        chattabController.getSendchattextarea().setText("");
        //TODO MAke message TO SEND TO THE SERVER
        chattabController.getIChatThreadController().getMts().addMessage(new MessageSendChat(chattabController.getIChatThreadController().getLogin().getUsername(),payload));

    }
}
