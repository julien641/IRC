package clientMessage.MessageData.ClientToServer;

import Interface.Server.IControllerThread;
import clientMessage.Message;
import clientMessage.MessageData.IServerMessage;
import clientMessage.MessageData.IMessageAction;
import socketconnection.ServerInfo;


/**
 * extends abstract class Message and implements IServerMessage
 *
 * The purpose of this class is to send chat messages to other clients.
 *
 * This object comes from the client and goes to the server
 */
public class MessageSendChat extends Message implements IServerMessage {

    /**
     * text variable is the message sent
     */
    private String text;
    public MessageSendChat(ServerInfo serverInfo, String text) {
        super(serverInfo);
        this.text = text;
    }

    @Override
    public void setDefaultAction(IControllerThread controllerthread) {
        super.setAction(new SendChatAction(controllerthread,this,text));
    }
    /**
     * Action that is used when sending
     *
     *
     *
     */
   private class SendChatAction implements IMessageAction {
        private final IControllerThread controllerThread;
        private final MessageSendChat messageSendChat;
        private final String text;

        public SendChatAction(IControllerThread controllerThread, MessageSendChat messageSendChat, String text) {
            this.controllerThread = controllerThread;
            this.messageSendChat = messageSendChat;
            this.text = text;
        }

        @Override
        public void action() {
        }
    }


}
