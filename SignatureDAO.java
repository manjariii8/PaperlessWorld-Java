package com.paperless.dao;

import com.paperless.model.Signature;
import com.paperless.util.DBConnection;
import java.sql.*;

public class SignatureDAO {
    public void saveSignature(Signature s) {
        String sql = "INSERT INTO signatures (document_id, signer_id, signature_text) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, s.getDocumentId());
            ps.setInt(2, s.getSignerId());
            ps.setString(3, s.getSignatureText());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) s.setId(rs.getInt(1));
            }
            System.out.println("Signature saved with id=" + s.getId());
        } catch (Exception e) {
            System.out.println("Error saving signature: " + e.getMessage());
        }
    }

    public boolean verifySignature(int signatureId) {
        String sql = "SELECT id, document_id, signer_id, signature_text FROM signatures WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, signatureId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Found signature: id=" + rs.getInt("id")
                            + ", doc=" + rs.getInt("document_id")
                            + ", signer=" + rs.getInt("signer_id")
                            + ", text='" + rs.getString("signature_text") + "'");
                    return true;
                } else {
                    System.out.println("Signature id not found");
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Error verifying signature: " + e.getMessage());
            return false;
        }
    }
}
