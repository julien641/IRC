package javafxchatclient.Tree.Cell;

import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import javafxchatclient.Tree.Item.Interface.IAccept;
import javafxchatclient.Tree.Item.Visitor;

public class MyTreeCellRoot extends TreeCell<Text> {
    private TreeView param;
    public MyTreeCellRoot(TreeView param){
        this.param =param;

    }

    public TreeView getParam() {
        return param;
    }

    @Override
    public void updateItem(Text item, boolean empty){
        super.updateItem(item,empty);
        if(getTreeItem() ==null||empty){
            setText(null);
            setGraphic(null);
        }else{
             //Visitor pattern see Visitor class for logic
              Visitor visitor = new Visitor();
            ((IAccept)getTreeItem()).accept(visitor,this,item);

        }
    }

    }

