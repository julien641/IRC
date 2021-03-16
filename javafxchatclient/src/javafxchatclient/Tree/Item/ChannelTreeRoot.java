package javafxchatclient.Tree.Item;

import javafx.scene.control.TreeItem;
import javafx.scene.text.Text;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.Tree.Item.Interface.IAccept;

public class ChannelTreeRoot<T> extends TreeItem<T> implements IAccept {


    @Override
    public void accept(Visitor visitor, MyTreeCellRoot myTreeCellRoot,Text item) {
        visitor.visit(this,myTreeCellRoot,item);
    }

}
