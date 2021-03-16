package javafxchatclient.Tree.Item.Interface;

import javafx.scene.text.Text;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.Tree.Item.ChannelTreeRoot;
import javafxchatclient.Tree.Item.ConnectionTreeItem;
import javafxchatclient.Tree.Item.ServerTreeItem;

public interface IVisit {
    void visit(ChannelTreeRoot channelTreeRoot, MyTreeCellRoot myTreeCellRoot, Text item);
    void visit(ServerTreeItem serverTreeItem, MyTreeCellRoot myTreeCellRoot, Text item);
    void visit(ConnectionTreeItem connectionTreeItem, MyTreeCellRoot myTreeCellRoot,Text item);
}
