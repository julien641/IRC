package javafxchatclient.Tree.Item;

import Interface.client.IChatThreadController;
import com.sun.security.ntlm.Server;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.text.Text;
import javafxchatclient.Processes.ServerConnection;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.Tree.Item.Interface.IAccept;
import socketconnection.Login;

public class ServerTreeItem extends TreeItem<Text> implements IAccept {
    private Login login;
    private Boolean connected;
    private IChatThreadController ichatThreadController;
    private MyTreeCellRoot myTreeCellRoot =null;
    private int pos;
    public ServerTreeItem(String text ,IChatThreadController ichatThreadController) {
        super(new Text(text));
        super.setExpanded(false);

        this.login = login;
        connected =false;
        this.ichatThreadController =ichatThreadController;
    }


    @Override
    public void accept(Visitor visitor, MyTreeCellRoot myTreeCellRoot,Text text) {
        this.myTreeCellRoot = myTreeCellRoot;
        visitor.visit(this,myTreeCellRoot,text);
    }
    public ContextMenu serverTreeContextMenubuilder(){
        ServerTreeItem current =this;
        ContextMenu x = new ContextMenu();
        MenuItem reconnect = new MenuItem("Reconnect");
        MenuItem edit = new MenuItem("Edit");
        MenuItem disconnect = new MenuItem("Disconnect");
        reconnect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               removeCurrent(current);


            }
        });
        x.getItems().addAll(reconnect,edit,disconnect);
        return x;
    }
    public void removeCurrent(TreeItem current){
        current.getParent().getChildren().remove(current);
    }





}
