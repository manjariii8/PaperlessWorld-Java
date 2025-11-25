import java.util.Scanner;
import com.paperless.model.*;
import com.paperless.dao.*;
import com.paperless.service.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserDAO userDAO = new UserDAO();
    private static final DocumentDAO documentDAO = new DocumentDAO();
    private static final SignatureDAO signatureDAO = new SignatureDAO();
    private static final SignerService signerService = new SignerService();
    private static final ReviewerService reviewerService = new ReviewerService();

    public static void main(String[] args) {
        System.out.println("Paperless World - Core Java JDBC (Menu)");
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add user (admin/signer/reviewer)");
            System.out.println("2. Upload document");
            System.out.println("3. Sign document");
            System.out.println("4. Verify signature");
            System.out.println("5. List documents");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addUser();
                    case "2" -> uploadDocument();
                    case "3" -> signDocument();
                    case "4" -> verifySignature();
                    case "5" -> listDocuments();
                    case "6" -> { System.out.println("Goodbye"); System.exit(0); }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void addUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();
        System.out.print("Role (ADMIN/SIGNER/REVIEWER): ");
        String role = scanner.nextLine().trim().toUpperCase();
        User u = new User(username, password, role);
        userDAO.addUser(u);
    }

    private static void uploadDocument() {
        System.out.print("Filename (example.pdf): ");
        String filename = scanner.nextLine().trim();
        System.out.print("Owner user id: ");
        int ownerId = Integer.parseInt(scanner.nextLine().trim());
        Document d = new Document(filename, ownerId, "UPLOADED");
        documentDAO.saveDocument(d);
    }

    private static void signDocument() {
        System.out.print("Document id to sign: ");
        int docId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Signer user id: ");
        int signerId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Signature text (type your name): ");
        String sigText = scanner.nextLine().trim();
        signerService.signDocument(docId, signerId, sigText);
    }

    private static void verifySignature() {
        System.out.print("Signature id to verify: ");
        int sigId = Integer.parseInt(scanner.nextLine().trim());
        boolean ok = reviewerService.verifySignature(sigId);
        System.out.println("Verification: " + (ok ? "VALID" : "INVALID/NOT FOUND"));
    }

    private static void listDocuments() {
        documentDAO.listDocuments();
    }
}
