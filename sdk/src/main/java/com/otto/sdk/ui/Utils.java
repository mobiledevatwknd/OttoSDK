package com.otto.sdk.ui;

import com.otto.sdk.R;

import java.util.ArrayList;

public class Utils {
    private Utils(){}

    public static ArrayList<MenuData> getMenu(){
        ArrayList<MenuData> menu = new ArrayList<>();
        menu.add(new MenuData(R.drawable.ic_imkas_phone,"Telepon dan Air"));
        menu.add(new MenuData(R.drawable.ic_imkas_pln,"Listrik"));
        menu.add(new MenuData(R.drawable.ic_imkas_game,"Voucher Game"));
        menu.add(new MenuData(R.drawable.ic_imkas_duit,"Donasi"));
        menu.add(new MenuData(R.drawable.ic_imkas_insurance,"Asuransi"));
        menu.add(new MenuData(R.drawable.ic_imkas_bpjs,"BPJS"));
        menu.add(new MenuData(R.drawable.ic_imkas_multifinance,"Multifinanace"));
        menu.add(new MenuData(R.drawable.ic_gold_bars,"Emas"));

        return menu;
    }
}
