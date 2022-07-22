package com.otto.sdk.ui;

public class MenuData {
    int icon;
    String label;

    MenuData(int icon, String label){
        this.icon=icon;
        this.label=label;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
