package com.isa.morswiny.model;

import javax.persistence.*;

@Entity
@Table(name="attachment")
public class AttachmentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer attachmentId;
    private String fileName;
    @ManyToOne
    @JoinColumn(name = "event_Id", referencedColumnName = "eventId")
    private EventEntity event;

    public AttachmentEntity(String fileName) {
        this.fileName = fileName;
    }

    public AttachmentEntity() {
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

    public Integer getAttachmentId() {
        return attachmentId;
    }
}
