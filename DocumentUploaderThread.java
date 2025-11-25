package com.paperless.util;

import com.paperless.model.Document;

public class DocumentUploaderThread extends Thread {
    private Document doc;

    public DocumentUploaderThread(Document doc) {
        this.doc = doc;
    }

    @Override
    public void run() {
        try {
            System.out.println("Uploading document: " + doc.getFilename() + " by Thread: " + Thread.currentThread().getName());
            Thread.sleep(2000); // simulate upload delay
            System.out.println("Document uploaded: " + doc.getFilename());
        } catch (InterruptedException e) {
            System.out.println("Upload interrupted for document: " + doc.getFilename());
        }
    }
}
