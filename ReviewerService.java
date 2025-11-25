package com.paperless.service;

import com.paperless.dao.SignatureDAO;

public class ReviewerService {
    private final SignatureDAO signatureDAO = new SignatureDAO();

    public boolean verifySignature(int signatureId) {
        return signatureDAO.verifySignature(signatureId);
    }
}
