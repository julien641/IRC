package javafxchatclient.Tree.Item;

import Interface.client.IChatThreadController;
import javafx.scene.control.TreeItem;
import javafx.scene.text.Text;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.Tree.Item.Interface.IAccept;

public class ConnectionTreeItem extends TreeItem<Text> implements IAccept {
        private IChatThreadController chatThreadController;
        private final int max =4;
    public ConnectionTreeItem( IChatThreadController chatThreadController){
        super();
        this.chatThreadController =chatThreadController;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void accept(Visitor visitor, MyTreeCellRoot myTreeCellRoot,Text text) {
        visitor.visit(this,myTreeCellRoot,text);
    }
}
