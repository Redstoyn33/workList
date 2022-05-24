package me.redstoyn33.worklist;

import java.io.Serializable;
import java.util.ArrayList;

public class PreviewData implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 1234234124213433L;

    public String name;
    public String info;
    public String text;
    public String color;
    private PreviewData(){}
    public PreviewData(Preview pre){
        name = pre.name.getText();
        info = pre.info.getText();
        text = pre.text;
        color = pre.colorV.toString();
    }

    static public ArrayList<PreviewData> toData(ArrayList<Preview> pre){
        ArrayList<PreviewData> data = new ArrayList<>(pre.size());
        pre.forEach(preview -> data.add(new PreviewData(preview)));
        return data;
    }
    static public ArrayList<Preview> toPre(ArrayList<PreviewData> data){
        ArrayList<Preview> pre = new ArrayList<>(data.size());
        data.forEach(previewData -> pre.add(new Preview(previewData)));
        return pre;
    }
}