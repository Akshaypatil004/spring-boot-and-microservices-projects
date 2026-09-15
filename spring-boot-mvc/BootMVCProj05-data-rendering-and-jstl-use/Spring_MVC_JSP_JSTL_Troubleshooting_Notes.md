# Spring MVC + JSP + JSTL --- Troubleshooting Notes

> **Project:** `BootMVCProj05-data-rendering-and-jstl-use`\
> **Stack:** Spring Boot 4.1.1 + Spring MVC + JSP + JSTL + Tomcat 11 +
> Java 17

------------------------------------------------------------------------

## 1. What went wrong?

Two related problems occurred while rendering `display.jsp`.

### Error 1 --- Response already committed

``` text
Cannot forward to error page for request [/wish-message]
as the response has already been committed
```

This was **not the root cause**.

The JSP started rendering, then failed while processing a JSTL tag. At
that point the HTTP response had already started, so Spring/Tomcat could
not forward to its error page.

### Actual root cause

``` text
java.lang.ClassNotFoundException:
jakarta.servlet.jsp.jstl.core.ConditionalTagSupport
```

and:

``` text
java.lang.NoClassDefFoundError:
jakarta/servlet/jsp/jstl/core/ConditionalTagSupport
```

### Lesson

When you see:

``` text
response has already been committed
```

**look earlier in the stack trace for the first real exception.**

------------------------------------------------------------------------

# 2. Why did JSTL fail initially?

The project was using the Jakarta stack:

-   Spring Boot 4.x
-   Spring Framework 7.x
-   Tomcat 11
-   Jakarta Servlet

Therefore JSTL must also use the **Jakarta JSTL 3.x** setup.

The old dependency was:

``` xml
org.eclipse.jetty:apache-jstl
```

That was inappropriate for this Tomcat/Jakarta setup.

The first attempted fix added only the JSTL API:

``` xml
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
</dependency>
```

Then only the implementation was used.

### Correct setup

Use **both API + implementation**:

``` xml
<!-- JSTL API -->
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>3.0.0</version>
</dependency>

<!-- JSTL Implementation -->
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>3.0.1</version>
</dependency>
```

### Remember

``` text
JSTL API
   +
JSTL Implementation
   ↓
JSTL can execute
```

------------------------------------------------------------------------

# 3. Correct JSTL taglib URI

For Jakarta JSTL 3.x:

``` jsp
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
```

Do **not** use the old Java EE URI:

``` jsp
http://java.sun.com/jsp/jstl/core
```

### Quick rule

  Stack              JSTL URI
  ------------------ -------------------------------------
  Old Java EE        `http://java.sun.com/jsp/jstl/core`
  Jakarta JSTL 3.x   `jakarta.tags.core`

------------------------------------------------------------------------

# 4. Second problem --- JSTL `test` syntax

After JSTL itself was fixed, the page rendered but all conditional
content was missing.

The JSP contained:

``` jsp
<c:if test="!empty msg">
```

This is wrong because `test` must receive an **EL expression**.

### Correct

``` jsp
<c:if test="${not empty msg}">
```

The same rule applies to:

``` jsp
<c:when test="${not empty listOfPerson}">
```

### Remember

JSTL condition:

``` jsp
test="${expression}"
```

Examples:

``` jsp
<c:if test="${not empty msg}">
<c:if test="${budget > 0}">
<c:if test="${person != null}">
<c:when test="${not empty listOfPerson}">
```

------------------------------------------------------------------------

# 5. Variable-name mismatch

Controller:

``` java
map.put("nickname", "parthiban");
```

JSP must use:

``` jsp
${nickname}
```

Not:

``` jsp
${nickName}
```

### Lesson

EL variable names must match the attribute name.

``` text
nickname ≠ nickName
```

Always compare:

``` text
Controller map.put("KEY", value)
                    ↓
JSP ${KEY}
```

------------------------------------------------------------------------

# 6. Final working flow

The complete data-rendering flow is:

``` text
Controller
   ↓
map.put("msg", ...)
map.put("person", ...)
map.put("listOfPerson", ...)
   ↓
Model attributes
   ↓
JSP
   ↓
EL: ${msg}
   ↓
JSTL: <c:if>, <c:forEach>, <c:choose>
   ↓
HTML response
```

------------------------------------------------------------------------

# 7. Debugging checklist for future JSP + JSTL projects

Before debugging application logic, check these in order:

### 1. Check the FIRST real exception

Do not assume:

``` text
response already committed
```

is the root cause.

------------------------------------------------------------------------

### 2. Check JSTL dependencies

For Spring Boot 4 / Tomcat 11:

``` text
JSTL API + JSTL Implementation
```

------------------------------------------------------------------------

### 3. Check taglib URI

``` jsp
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
```

------------------------------------------------------------------------

### 4. Check EL syntax

Correct:

``` jsp
${not empty msg}
```

Incorrect:

``` jsp
!empty msg
```

------------------------------------------------------------------------

### 5. Check controller → JSP names

Controller:

``` java
map.put("heroName", "Thalapathy Vijay");
```

JSP:

``` jsp
${heroName}
```

------------------------------------------------------------------------

### 6. Check JSP syntax / HTML structure

Look for:

-   mismatched tags
-   incorrect JSP expressions
-   malformed HTML
-   incorrect table structure

------------------------------------------------------------------------

### 7. After dependency changes

In Eclipse:

``` text
Maven → Update Project
        ↓
Force Update
        ↓
Project → Clean
        ↓
Restart application
```

------------------------------------------------------------------------

# 8. Mistakes to remember

``` text
❌ Old Jetty JSTL dependency
❌ JSTL API without implementation
❌ JSTL implementation without required API
❌ Old java.sun.com JSTL URI
❌ test="!empty msg"
❌ ${nickName} when controller has "nickname"
❌ Debugging "response already committed" before finding the earlier exception
```

### Correct pattern

``` text
Spring Boot 4
     ↓
Tomcat 11 / Jakarta
     ↓
JSTL 3.x
     ↓
API + Implementation
     ↓
jakarta.tags.core
     ↓
EL expressions: ${...}
     ↓
JSTL conditions/loops
```

------------------------------------------------------------------------

## ⭐ One-minute revision

**JSTL not working?**

``` text
1. Read FIRST exception
2. Check API + implementation
3. Check jakarta.tags.core
4. Check ${...} in test
5. Check controller/JSP variable names
6. Maven Update + Clean + Restart
```

**Most important lesson:**\
\> The last error in a Spring/Tomcat stack trace is often a consequence.
Find the **earliest meaningful exception** to identify the real problem.
