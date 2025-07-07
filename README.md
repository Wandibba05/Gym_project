# GYM Management System

## Database Setup

1. Install MySQL Server if not already installed
2. Run the database schema script:
   ```bash
   mysql -u root -p < Backend/src/com/gymnation/database/schema.sql
   ```

## Configuration

1. Update database connection properties in `Backend/src/main/resources/database.properties`:
   ```properties
   db.url=jdbc:mysql://localhost:3306/gym_db?useSSL=false&serverTimezone=UTC
   db.username=your_username
   db.password=your_password
   ```

## Dependencies

- MySQL Connector/J 9.3.0
- HikariCP (Connection Pooling)

Add the following to your project's build path:
```xml
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.1</version>
</dependency>
```

## API Documentation

### User Registration
```java
UserRegistrationResult result = DatabaseConnection.registerUser(name, email, password);
if (result.success) {
    String userId = result.userId;
    String message = result.message;
}
```

### User Login
```java
LoginResult result = DatabaseConnection.validateUser(userId, password);
if (result.success) {
    String name = result.name;
    String message = result.message;
}
```

### Get User Profile
```java
UserProfile profile = DatabaseConnection.getUserProfile(userId);
if (profile != null) {
    String name = profile.name;
    String email = profile.email;
    String membershipType = profile.membershipType;
    String membershipStatus = profile.membershipStatus;
}
```

## Security Notes

1. Password Hashing: Currently using placeholder implementation. Replace with BCrypt or similar in production.
2. Connection Pool: Configured with safe defaults, adjust based on load.
3. Session Management: Implement proper session tokens and expiration.

## Future Improvements

1. Implement password hashing with BCrypt
2. Add email verification
3. Implement proper session management
4. Add logging framework
5. Add unit tests
6. Implement backup strategy


   
