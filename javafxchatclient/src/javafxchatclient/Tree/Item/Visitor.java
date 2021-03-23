package javafxchatclient.Tree.Item;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.Tree.Item.Interface.IVisit;


public class Visitor implements IVisit {

    @Override
    public void visit(ChannelTreeRoot channelTreeRoot, MyTreeCellRoot myTreeCellRoot, Text item) {


    }

    @Override
    public void visit(ServerTreeItem serverTreeItem, MyTreeCellRoot myTreeCellRoot,Text item) {
        myTreeCellRoot.setText(item.getText());
        myTreeCellRoot.setContextMenu(serverTreeItem.serverTreeContextMenubuilder());
    }

    @Override
    public void visit(ConnectionTreeItem connectionTreeItem, MyTreeCellRoot myTreeCellRoot,Text item) {
        myTreeCellRoot.setText(item.getText());
        myTreeCellRoot.setTextFill(Color.RED);

    }



}
