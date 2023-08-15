package com.semi_pos;

public class PrintoutData {

    private String text;

    private String qrCode;

    public PrintoutData(String text, String qrCode) {
        this.text = text;
        this.qrCode = qrCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
