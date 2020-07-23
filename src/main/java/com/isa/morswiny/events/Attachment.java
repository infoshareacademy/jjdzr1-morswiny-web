package com.isa.morswiny.events;

public class Attachment {
    private String fileName;

    public Attachment(String fileName) {
        this.fileName = fileName;
    }

    public Attachment() {
    }

    @Override
    public String toString() {
        return "Attachment " +
                "file Name = " + fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
