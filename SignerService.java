package com.paperless.service;

import com.paperless.model.Signature;
import com.paperless.dao.SignatureDAO;

public class SignerService {
    private final SignatureDAO signatureDAO = new SignatureDAO();

    public void signDocument(int documentId, int signerId, String signatureText) {
        Signature s = new Signature(documentId, signerId, signatureText);
        signatureDAO.saveSignature(s);
    }
}
