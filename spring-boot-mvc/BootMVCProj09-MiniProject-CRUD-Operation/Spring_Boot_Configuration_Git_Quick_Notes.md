# Spring Boot Configuration & Git — Quick Notes

## Project

`BootMVCProj09-MiniProject-CRUD-Operation`

---

## What I Learned

### 1. `application.properties`

Used for common, non-sensitive application configuration.

Example:

```properties
server.port=4041
spring.datasource.url=jdbc:mysql:///sbms
spring.jpa.hibernate.ddl-auto=update
```

### 2. Profile-specific properties

Naming convention:

```text
application-{profile}.properties
```

Examples:

```text
application-local.properties
application-dev.properties
application-test.properties
application-prod.properties
```

The profile must be active.

```properties
spring.profiles.active=local
```

Then Spring Boot loads:

```text
application.properties
        +
application-local.properties
```

### 3. Local credentials

For this project:

```text
application-local.properties
```

contains:

```properties
spring.datasource.username=...
spring.datasource.password=...
```

This file is **NOT committed to Git**.

### 4. `.gitignore`

Use:

```gitignore
src/main/resources/application-local.properties
```

`.gitignore` is a **Git mechanism**, not a Spring Boot mechanism.

It prevents Git from tracking the local credentials file.

### 5. `@PropertySource`

For this situation, **do not use**:

```java
@PropertySource("classpath:application-local.properties")
```

Spring Boot's profile mechanism is the appropriate approach.

### 6. Important distinction

```text
Spring Profile
    ↓
Controls which configuration Spring Boot loads

.gitignore
    ↓
Controls what Git tracks
```

They solve completely different problems.

---

# Future Project Muscle Memory

Before committing:

```text
1. Check application*.properties
2. Remove passwords / API keys / secrets
3. Put local secrets in ignored configuration
4. Check Git Staging
5. Make sure secrets are NOT staged
6. Commit
```

Remember:

> **Commit configuration; never commit secrets.**

And:

> **Production-ready does NOT mean maximum complexity.**

Practice production **principles**, not unnecessary production complexity.

For larger/real production applications, secrets are commonly supplied through environment variables, CI/CD secrets, or secret-management systems.

---

# Current Project — Conclusion

```text
BootMVCProj09-MiniProject-CRUD-Operation

✓ Spring Boot configuration separated
✓ Database credentials externalized locally
✓ application-local.properties ignored by Git
✓ local profile activated
✓ Hibernate successfully receives database credentials
✓ Application runs successfully
✓ Git/production configuration fundamentals completed
```

## Quick Rule to Remember

> `application.properties` = common/safe configuration

> `application-{profile}.properties` = profile-specific configuration

> `spring.profiles.active=local` = activate the `local` profile

> `.gitignore` = keep local secrets out of Git

> `@PropertySource` = not needed for this setup
