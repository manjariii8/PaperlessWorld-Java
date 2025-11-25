package com.paperless.model;

public class Document {
    private int id;
    private String filename;
    private int ownerId;
    private String status;

    public Document() {}
    public Document(String filename, int ownerId, String status) {
        this.filename = filename;
        this.ownerId = ownerId;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
