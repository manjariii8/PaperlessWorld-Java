#Paperless World - Java JDBC Project

Project Overview:
-----------------
Paperless World is a Java-based e-signature platform designed to securely and efficiently sign digital documents electronically. 
It uses Core Java, JDBC, and MySQL to manage users, documents, and signatures. The platform reduces the need for physical signatures 
and ensures document security and traceability.

Key Features:
-------------
1. User Management:
   - Roles: Admin, Signer, Reviewer
   - Admin can add users, assign roles, and manage access

2. Document Management:
   - Upload documents
   - Sign documents electronically
   - Verify signatures
   - List uploaded documents

3. OOP & Core Java Concepts:
   - Classes for Users, Documents, and Signatures
   - DAO classes handle database operations
   - Exception handling for invalid inputs and database errors
   - Collections & Generics for storing objects
   - Basic multithreading demonstrated in document uploader thread

4. Database Integration:
   - Uses MySQL with JDBC for database connectivity
   - `DBConnection.java` handles database connection
   - `database.sql` included to create required tables

5. Minimal GUI:
   - `LoginGUI.java` for login interface (optional enhancement)
   

Setup Instructions:
-------------------
1. Prerequisites:
   - Java JDK 17 or higher
   - MySQL Server
   - MySQL Connector JAR (`mysql-connector-j-9.5.0.jar`) included in lib/

2. Database Setup:
   - Create a database named `paperless_world`
   - Run `database.sql` to create tables
   - Update MySQL username/password in `DBConnection.java`:
     ```
     private static final String USER = "root";
     private static final String PASSWORD = "your_mysql_password";
     ```

3. Compile and Run:
   - Option 1: Using command line
     ```
     cd src
     javac com/paperless/model/*.java com/paperless/dao/*.java com/paperless/service/*.java Main.java
     java -cp ".;../lib/mysql-connector-j-9.5.0.jar" Main
     ```
   - Option 2: Using `run.bat` (Windows)
     - Double-click `run.bat` inside the `src` folder



Usage Instructions:

1. Start the application
2. Menu Options:
   1. Add User (Admin/Signer/Reviewer)
   2. Upload Document
   3. Sign Document
   4. Verify Signature
   5. List Documents
   6. Exit

3. Follow prompts to perform each operation



Sample Console Output:
Paperless World - Core Java JDBC (Menu)

1. Add user (admin/signer/reviewer)
2. Upload document
3. Sign document
4. Verify signature
5. List documents
6. Exit
Choose option: 1
Username: Charley
Password: 0090
Role: SIGNER
User added successfully!

Documents uploaded and signed successfully.


Repository Link:
----------------
https://github.com/manjariii8/PaperlessWorld-Java



Author:
-------
Manjari


