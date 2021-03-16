package javafxchatclient.Tree.Item.Interface;

import javafx.scene.text.Text;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.Tree.Item.Visitor;

public interface IAccept {
     void accept(Visitor visitor, MyTreeCellRoot myTreeCellRoot, Text item);


}
