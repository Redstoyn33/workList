package me.redstoyn33.worklist;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Date;

public class Preview {
    static public Background selected = new Background(new BackgroundFill(Color.web("#e6e6e6"),CornerRadii.EMPTY, Insets.EMPTY));
    static public Background def = new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY));
    public HBox root;
    public Pane color;
    public Label name;
    public Label info;
    public String text;
    public Color colorV;

    public Preview() {
        WorkListApplication.listofPre.add(this);
        text = "";
        color = new Pane();
        color.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY, Insets.EMPTY)));
        colorV = Color.LIGHTGREEN;
        name = new Label("Новый");
        info = new Label(new Date().toString());
        var anc = new AnchorPane(name, info);
        AnchorPane.setBottomAnchor(info, 0d);
        root = new HBox(color, anc);
        root.setMinWidth(200);
        root.setMinHeight(50);
        color.setMinWidth(10);
        HBox.setHgrow(color, Priority.NEVER);
        HBox.setHgrow(anc, Priority.ALWAYS);
        name.setFont(new Font(24));
        info.setFont(new Font(10));
        root.setOnMouseClicked(mouseEvent -> WorkListApplication.main.open(this));
    }

    public Preview(PreviewData data) {
        WorkListApplication.listofPre.add(this);
        text = data.text;
        color = new Pane();
        color.setBackground(new Background(new BackgroundFill(Color.web(data.color), CornerRadii.EMPTY, Insets.EMPTY)));
        colorV = Color.web(data.color);
        name = new Label(data.name);
        info = new Label(data.info);
        var anc = new AnchorPane(name, info);
        AnchorPane.setBottomAnchor(info, 0d);
        root = new HBox(color, anc);
        root.setMinWidth(200);
        root.setMinHeight(50);
        color.setMinWidth(10);
        HBox.setHgrow(color, Priority.NEVER);
        HBox.setHgrow(anc, Priority.ALWAYS);
        name.setFont(new Font(24));
        info.setFont(new Font(10));
        root.setOnMouseClicked(mouseEvent -> WorkListApplication.main.open(this));
    }
}

