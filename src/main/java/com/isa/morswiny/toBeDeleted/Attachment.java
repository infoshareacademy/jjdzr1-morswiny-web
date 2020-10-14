package com.isa.morswiny.toBeDeleted;

import javax.persistence.*;

//@Entity
//@Table(name="attachment")
public class Attachment {
    public Integer getAttachmentId() {
        return attachmentId;
    }
    private Integer attachmentId;
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
