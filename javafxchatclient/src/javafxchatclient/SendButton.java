package javafxchatclient;

import javafx.event.Event;
import javafx.event.EventHandler;

public class SendButton implements EventHandler {
    private final ChattabController chattabController;
    public SendButton(ChattabController chattabController){
        this.chattabController =chattabController;
    }
    @Override
    public void handle(Event event) {
        String payload=chattabController.getSendchattextarea().getText();
       // chattabController.

    }
}
