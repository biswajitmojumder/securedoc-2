# Secure Document Management System

## Introduction
The Secure Document Management System is a robust and user-friendly application designed to securely store, update, upload, and delete documents. This application addresses the need for a centralized and secure repository for sensitive information, offering a seamless and efficient solution for document management. The Secure Document Management System offers a comprehensive solution for organizations to securely store, manage, and collaborate on documents. With robust security measures and a user-friendly interface, it addresses the needs of businesses requiring a reliable and secure document management platform.

## Key Features
### User Authentication and Authorization
- **User Authentication**: Ensures secure access through user login.
- **Multi-Factor Authentication (MFA)**: Provides an additional layer of security during login.
- **Access Control**: Role-based access control to define user privileges based on roles and permissions, maintaining data integrity.

### Document Management
- **Document Upload**: User-friendly interface to upload documents in formats like DOC, DOCX, XLS, PDFs, etc.
- **Document Search**: Powerful search feature based on document metadata (name, file extension), with advanced filtering options.

### Audit Trail
- **Detailed Logs**: Logs all user activities to provide a comprehensive audit trail for security and compliance purposes.

## Functional Requirements
### User Account
#### New Account
- Users can create a new account using basic information, email (unique), and password.
- All new accounts are disabled until verified via an email confirmation link.
- Only verified users can log into the application.

#### Log In
- Users can log in using email and password.
- If MFA is set up, users must enter a QR code after entering the correct email and password.
- After 6 failed login attempts, the user account is locked for 15 minutes.
- Passwords expire every 90 days, requiring users to update them.

#### Reset Password
- Users can reset their passwords via an email link.
- The link is invalid after being clicked once.
- Users can reset their password as many times as needed.

### Multi-Factor Authentication (MFA)
- Users can set up MFA using a QR code and an authenticator app on their mobile phone.

### Profile Management
- Users can update their basic information, password, account settings, and profile picture while logged in.

### Document Management
#### Document List
- Displays all uploaded documents on the homepage with details like name, size, owner, type, etc.
- Allows users to upload new documents.
- Features pagination and document search by name.

#### Document Details
- Shows details of a document when clicked.
- Allows updating the name and description, downloading, and deleting the document.

### Access Control
#### User Role
- Assigns roles to users with specific permissions.
- Different roles grant different access levels.
- Only users with proper roles can perform certain actions like updating account settings and roles, and deleting documents.

### Audit Trail
- Tracks who created and updated entities (user, document, etc.) and when.

## Technology Stack
- **Backend**: Spring Boot and Spring Security
- **Frontend**: React and Bootstrap

## Usage
  1. Register a new account.
  2. Verify your account via the email link.
  3. Log in with your credentials.
  4. Set up MFA if required.
  5. Upload, search, manage, and collaborate on documents securely.

# License
This project is licensed under the MIT License - see the LICENSE file for details.

