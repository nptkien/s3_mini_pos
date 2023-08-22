package com.semi_pos;

import android.content.Context;

import java.util.List;

public class MyPrinter {

    public void startPrint(Context context, List<String> dataList){
        Printout printout = new Printout(context, dataList);
        printout.run();
    }

}
