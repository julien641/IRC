package javafxchatclient.Processes;

import Interface.client.IChatThreadController;
import Interface.client.INewChattabController;
import clientMessage.MessageData.ClientToServer.MessageLogin;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import javafxchatclient.NewChattabController;
import javafxchatclient.Tree.Item.ConnectionTreeItem;
import javafxchatclient.Tree.Item.ServerTreeItem;
import socketconnection.RC;

public class ServerConnection implements Runnable {

    private INewChattabController newChattabController;
    private IChatThreadController iChatThreadController;
    private ServerTreeItem serverTreeItem;
    public ServerConnection(INewChattabController newChattabController, IChatThreadController ichatThreadController) {
        this.newChattabController = newChattabController;
        this.iChatThreadController = ichatThreadController;
    }

    @Override
    public void run() {
        RC rc = RC.failed;
        ServerTreeItem serverTreeItem = new ServerTreeItem(iChatThreadController.getLogin().getServername(), iChatThreadController);
        iChatThreadController.setServer(serverTreeItem);
        serverTreeItem.setExpanded(true);
        ConnectionTreeItem connecting = new ConnectionTreeItem(iChatThreadController);
        serverTreeItem.getChildren().add(connecting);
        TreeView view = iChatThreadController.getChatclientController().getTreechannelview();

        view.getRoot().getChildren().add(serverTreeItem);
        for (int i = 0; i < connecting.getMax(); i++) {
            connecting.setValue(new Text("Connecting ....(" + i + ")"));
            rc = iChatThreadController.getSw().connect(iChatThreadController.getLogin().getIp(), iChatThreadController.getLogin().getPort());
            if (rc == RC.success) {
                iChatThreadController.start();
                MessageLogin messageLogin = new MessageLogin(iChatThreadController.getLogin());
                iChatThreadController.getMts().addMessage(messageLogin);
                connecting.setValue(new Text("Waiting for the server"));
                break;
            }
            try {
                connecting.setValue(new Text("Sleeping for 10 seconds"));
                Thread.currentThread().sleep(10000);

            } catch (InterruptedException ignored) {
            }

        }
        if (rc != RC.success) {
            connecting.setValue(new Text("Failed to connect"));
            //  "Failed to connect");
        }
    }
}
