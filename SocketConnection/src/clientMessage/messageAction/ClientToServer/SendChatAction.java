package clientMessage.messageAction.ClientToServer;

import Interface.Server.IControllerThread;
import clientMessage.MessageData.ServerToClient.SendBackMessage;
import clientMessage.messageAction.IMessageAction;

public class SendChatAction implements IMessageAction {
    private final IControllerThread controllerThread;
    private final String from;
    private final String text;

    public SendChatAction(IControllerThread controllerThread, String from, String text) {
        this.controllerThread = controllerThread;
        this.from = from;
        this.text = text;
    }

    @Override
    public void action() {
        for(IControllerThread x :controllerThread.getServerthread().getControllerthreads()) {
            //TODO

            x.getMessagetosend().addMessage(new SendBackMessage(from,text));
        }
    }
}
