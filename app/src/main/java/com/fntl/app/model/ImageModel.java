package com.fntl.app.model;

public class ImageModel {
    private final long id;
    private final String title;
    private final String fileId;
    private final String mimeType;

    public ImageModel(long id, String title, String fileId, String mimeType) {
        this.id = id;
        this.title = title;
        this.fileId = fileId;
        this.mimeType = mimeType;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFileId() {
        return fileId;
    }

    public String getMimeType() {
        return mimeType;
    }
}
