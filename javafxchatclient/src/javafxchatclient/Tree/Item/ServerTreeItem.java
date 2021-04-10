package javafxchatclient.Tree.Item;

import Interface.client.IChatThreadController;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.text.Text;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.Tree.Item.Interface.IAccept;
import socketconnection.ServerInfo;

public class ServerTreeItem extends TreeItem<Text> implements IAccept {
    private ServerInfo login;
    private Boolean connected;
    private IChatThreadController ichatThreadController;
    private MyTreeCellRoot myTreeCellRoot =null;
    private int pos;
    private ServerTreeItem  serverTreeItem= this;

    public ServerTreeItem(String text ,IChatThreadController ichatThreadController) {
        super(new Text(text));
        super.setExpanded(true);
        connected =false;
        this.ichatThreadController =ichatThreadController;
        super.getChildren().add(new ConnectionTreeItem(ichatThreadController));
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

        reconnect.setOnAction(event -> {
            removeCurrent(current);
            ichatThreadController.end();

        });
        x.getItems().addAll(reconnect,edit,disconnect);
        return x;
    }
    public void removeCurrent(TreeItem current){
        current.getParent().getChildren().remove(current);
    }





}
