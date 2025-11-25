package com.paperless.dao;

import com.paperless.model.Document;
import com.paperless.util.DBConnection;
import java.sql.*;

public class DocumentDAO {
    public void saveDocument(Document doc) {
        String sql = "INSERT INTO documents (filename, owner_id, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, doc.getFilename());
            ps.setInt(2, doc.getOwnerId());
            ps.setString(3, doc.getStatus());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) doc.setId(rs.getInt(1));
            }
            System.out.println("Document saved with id=" + doc.getId());
        } catch (Exception e) {
            System.out.println("Error saving document: " + e.getMessage());
        }
    }

    public void listDocuments() {
        String sql = "SELECT d.id, d.filename, d.owner_id, d.status, u.username FROM documents d LEFT JOIN users u ON d.owner_id = u.id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\nID | Filename | OwnerId | OwnerName | Status");
            while (rs.next()) {
                System.out.printf("%d | %s | %d | %s | %s\n",
                        rs.getInt("id"),
                        rs.getString("filename"),
                        rs.getInt("owner_id"),
                        rs.getString("username"),
                        rs.getString("status"));
            }
        } catch (Exception e) {
            System.out.println("Error listing documents: " + e.getMessage());
        }
    }
}
