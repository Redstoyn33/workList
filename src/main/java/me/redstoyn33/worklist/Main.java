package me.redstoyn33.worklist;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Main {
    public VBox list;
    public Pane color;
    public VBox panel;
    public ColorPicker colorP;
    public Preview opened;
    public TextField name;
    public TextField info;
    public TextArea text;

    public Main(){
        WorkListApplication.main = this;
    }

    public void add(ActionEvent actionEvent) {
        var newPre = new Preview();
        list.getChildren().add(newPre.root);
    }

    public void open(Preview pre){
        if (panel.isDisable()) panel.setDisable(false);
        else opened.root.setBackground(Preview.def);
        opened = pre;
        color.setBackground(pre.color.getBackground());
        name.setText(pre.name.getText());
        info.setText(pre.info.getText());
        text.setText(pre.text);
        colorP.setValue(pre.colorV);
        pre.root.setBackground(Preview.selected);
    }

    public void setColor(ActionEvent actionEvent) {
        color.setBackground(new Background(new BackgroundFill(colorP.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
        opened.color.setBackground(new Background(new BackgroundFill(colorP.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
        opened.colorV = colorP.getValue();
    }

    public void textEdit(KeyEvent keyEvent) {
        opened.text = text.getText();
    }

    public void infoEdit(KeyEvent keyEvent) {
        opened.info.setText(info.getText());
        if (opened.info.getWidth()>180d) {
            info.deletePreviousChar();
        }
        opened.info.setText(info.getText());
    }

    public void nameEdit(KeyEvent keyEvent) {
        if (opened.name.getWidth()>170d) {
            name.deletePreviousChar();
        }
        opened.name.setText(name.getText());
    }

    public void delete(ActionEvent actionEvent) {
        WorkListApplication.listofPre.remove(opened);
        list.getChildren().remove(opened.root);
        panel.setDisable(true);
        opened = null;
        color.setBackground(Preview.def);
        name.clear();
        info.clear();
        text.clear();
        colorP.setValue(Color.WHITE);
    }
}
