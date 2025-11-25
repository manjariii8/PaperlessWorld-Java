package com.paperless.model;

public class Signature {
    private int id;
    private int documentId;
    private int signerId;
    private String signatureText;

    public Signature() {}
    public Signature(int documentId, int signerId, String signatureText) {
        this.documentId = documentId;
        this.signerId = signerId;
        this.signatureText = signatureText;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDocumentId() { return documentId; }
    public void setDocumentId(int documentId) { this.documentId = documentId; }
    public int getSignerId() { return signerId; }
    public void setSignerId(int signerId) { this.signerId = signerId; }
    public String getSignatureText() { return signatureText; }
    public void setSignatureText(String signatureText) { this.signatureText = signatureText; }
}
