package com.semi_pos;

import android.content.Context;
import android.util.Log;

import java.util.List;
import java.util.logging.Logger;

import wangpos.sdk4.libbasebinder.Printer;

public class Printout extends Thread {

    // obligated printer settings
    private static final int STEP = 100;

    private static final int FONT_SIZE = 28;

    private static Logger logger = Logger.getLogger(Printout.class.getName());

    private Context context;

    private List<String> dataList;

    public Printout(Context context, List dataList) {

        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public void run() {
        Log.d("Andy","Printout is running");
        try {

            Printer mPrinter = new Printer(context);
            int[] status = new int[1];
            mPrinter.setPrintFontType(context, "");
            mPrinter.enableCustomFont(true);
            sleep(10);
            logger.info("Printer status: " + (mPrinter.getPrinterStatus(status)));
            checkStatus(mPrinter.printInit(), "printInit()");
            checkStatus(mPrinter.clearPrintDataCache(), "clearPrintDataCache()");

            // example of method which uses for printout
            for (String printoutData : dataList) {
                checkStatus(mPrinter.printString(printoutData, FONT_SIZE, Printer.Align.LEFT, true, false), "printString()");
//                if (printoutData.getQrCode() != null) {
//                    checkStatus(mPrinter.printQRCode(printoutData.getQrCode(), 120), "printQRCode");
//                }
            }
            checkStatus(mPrinter.printPaper(STEP), "printPaper()");
            mPrinter.printFinish();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    private void checkStatus(int code, String s) throws Exception {

        if (code != 0) {
            throw new Exception("Error in method: " + s + ", error: " + code);
        }
    }
}
