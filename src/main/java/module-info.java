module me.redstoyn33.worklist {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.redstoyn33.worklist to javafx.fxml;
    exports me.redstoyn33.worklist;
}