package javafxchatclient.Tree.Item;

import Interface.client.IChatThreadController;
import javafx.scene.control.TreeItem;
import javafx.scene.text.Text;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.Tree.Item.Interface.IAccept;

public class ConnectionTreeItem extends TreeItem<Text> implements IAccept {
        private int index =0;
        private final int max =3;
        private String string = "Connecting ....(";
        private String end =")";
        private Text text;
        private IChatThreadController chatThreadController;

    public ConnectionTreeItem( IChatThreadController chatThreadController){
        super(new Text());
        super.setExpanded(false);
        this.chatThreadController =chatThreadController;
    }
    public String newvalue(){
        index++;
        return string +index+end;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void accept(Visitor visitor, MyTreeCellRoot myTreeCellRoot,Text text) {
        visitor.visit(this,myTreeCellRoot,text);
    }
}
