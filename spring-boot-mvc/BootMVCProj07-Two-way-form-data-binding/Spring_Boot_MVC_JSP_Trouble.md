# Spring Boot MVC + JSP Troubleshooting Guide

> **Purpose:** Quick reference for fixing JSP/JSTL/Spring Form Tag
> problems in future Spring Boot MVC projects.

------------------------------------------------------------------------

## 1. First identify the View Technology

If your controller returns:

``` java
return "home";
```

and the actual view is:

``` text
/WEB-INF/pages/home.jsp
```

then the application is using **JSP**.

For JSP, the runtime must have JSP processing support.

### Embedded Tomcat

If running as a Spring Boot application with embedded Tomcat, add:

``` xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

Then:

``` text
Maven → Update Project
Project → Clean
Restart application
```

------------------------------------------------------------------------

## 2. JSP, JSTL and Spring Form Tags are Different

Do not mix these three concepts.

  What I use in JSP                                What it needs
  ------------------------------------------------ ---------------------------
  Normal JSP (`.jsp`)                              JSP-capable runtime
  JSTL (`<c:if>`, `<c:forEach>`)                   JSTL API + implementation
  Spring form tags (`<frm:form>`, `<frm:input>`)   `spring-webmvc`

### Spring MVC form taglib

``` jsp
<%@ taglib prefix="frm"
    uri="http://www.springframework.org/tags/form" %>
```

Examples:

``` jsp
<frm:form>
<frm:input>
<frm:select>
<frm:checkbox>
<frm:errors>
```

The Spring form tag library is supplied by Spring MVC (`spring-webmvc`).

### JSTL

If using:

``` jsp
<c:if>
<c:forEach>
<c:choose>
```

then JSTL dependencies are required.

For Spring Boot 4 / Jakarta-based projects, use the Jakarta JSTL
dependencies, not old `javax.servlet:jstl` dependencies.

------------------------------------------------------------------------

## 3. Most Common Problem: JSP Does Not Render

### Typical symptoms

You may see errors such as:

``` text
JasperException
ServletException
JspException
Cannot find the tag library descriptor
ClassNotFoundException
Cannot forward to error page...
response has already been committed
```

### Important

Do **not** assume:

``` text
response has already been committed
```

is the root cause.

Look **above it** in the console for:

``` text
Caused by:
JasperException
ClassNotFoundException
JspException
```

The first/root exception is usually more useful.

------------------------------------------------------------------------

# 4. Troubleshooting Steps

## Step 1 --- Confirm JSP location

For Spring MVC JSP, keep views under:

``` text
src/main/webapp/
    WEB-INF/
        pages/
            home.jsp
            student_register.jsp
```

Do not accidentally put JSP files in:

``` text
src/main/resources/templates/
```

if you are configuring the application for JSP views.

------------------------------------------------------------------------

## Step 2 --- Check ViewResolver configuration

Typical configuration:

``` properties
spring.mvc.view.prefix=/WEB-INF/pages/
spring.mvc.view.suffix=.jsp
```

Then:

``` java
return "home";
```

resolves to:

``` text
/WEB-INF/pages/home.jsp
```

Remember:

``` text
return "home";
        ↓
prefix + view name + suffix
        ↓
/WEB-INF/pages/home.jsp
```

------------------------------------------------------------------------

## Step 3 --- Check JSP engine

For embedded Tomcat:

``` xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

If adding this fixes the problem, the issue was JSP processing support
in the embedded runtime.

------------------------------------------------------------------------

## Step 4 --- If using JSTL, check JSTL dependencies

If JSP contains:

``` jsp
<c:forEach>
<c:if>
<c:choose>
```

check that Jakarta JSTL API + implementation are present.

Do not use old:

``` xml
javax.servlet:jstl
```

in a Spring Boot 4 / Jakarta project.

------------------------------------------------------------------------

## Step 5 --- If using Spring Form Tags, check the taglib

Use:

``` jsp
<%@ taglib prefix="frm"
    uri="http://www.springframework.org/tags/form" %>
```

For example:

``` jsp
<frm:form modelAttribute="stud">
    <frm:input path="sname"/>
</frm:form>
```

If Eclipse says it cannot find the tag library:

1.  Check `spring-boot-starter-webmvc`.
2.  Check Maven Dependencies.
3.  Make sure Spring MVC is actually on the classpath.
4.  Maven → Update Project.
5.  Clean and restart Eclipse/server.

**Do not search Maven Repository for the URI itself.**

Search for the actual library/dependency instead.

------------------------------------------------------------------------

# 5. Taglib Dependency Quick Reference

### Spring form tags

Search:

``` text
Spring Framework JSP form tag library
```

URI:

``` text
http://www.springframework.org/tags/form
```

Library:

``` text
spring-webmvc
```

------------------------------------------------------------------------

### JSTL

Search:

``` text
Jakarta JSTL
```

For Boot 4, look for:

``` text
jakarta.servlet.jsp.jstl-api
```

and the compatible JSTL implementation.

When checking Maven Repository, always verify:

``` text
Group ID
Artifact ID
Version
Jakarta vs javax
Spring Boot / Java compatibility
```

Do not blindly copy dependencies from old tutorials.

------------------------------------------------------------------------

# 6. Check URL/Form Paths

Avoid unnecessary relative paths such as:

``` jsp
<form action="register">
```

Prefer:

``` jsp
<form action="${pageContext.request.contextPath}/register">
```

or with Spring form tags:

``` jsp
<frm:form
    action="${pageContext.request.contextPath}/register"
    method="POST"
    modelAttribute="stud">
```

For links:

``` jsp
<a href="${pageContext.request.contextPath}/register">
```

This avoids problems when the application has a context path.

------------------------------------------------------------------------

# 7. Check Controller ↔ JSP Names

If controller has:

``` java
return "student_register";
```

the file should be:

``` text
student_register.jsp
```

Watch for spelling mistakes such as:

``` text
student_resgiter.jsp   ❌
student_register.jsp   ✅
```

Also check:

``` java
@ModelAttribute("stud")
```

matches:

``` jsp
modelAttribute="stud"
```

and:

``` java
@ModelAttribute("stud") Student st
```

matches the form's model attribute.

------------------------------------------------------------------------

# 8. Embedded vs External Tomcat

### Embedded

``` text
Spring Boot
    ↓
Embedded Tomcat
    ↓
JSP
```

JSP support must be available to the embedded runtime.

### External Tomcat

``` text
WAR
 ↓
External Tomcat
 ↓
JSP
```

The external container provides the servlet/JSP runtime.

**Important:** Spring Boot 4.x uses the Jakarta/Servlet 6.1 generation.
Make sure the external Tomcat version is compatible with your Spring
Boot version.

Do not mix old Tomcat/Java EE/JSTL configurations from older tutorials
with Boot 4.

------------------------------------------------------------------------

# 9. Eclipse WTP / External Server Problems

If the console seems to mention the wrong project, for example:

``` text
BootMVCProj05...
```

while you are running:

``` text
BootMVCProj07...
```

check:

``` text
Servers
 → Tomcat
 → Modules
```

Make sure the correct project is deployed.

If necessary:

``` text
Stop Tomcat
↓
Remove project from server
↓
Clean server
↓
Project → Clean
↓
Maven → Update Project
↓
Add project again
↓
Start Tomcat
```

This can remove stale Eclipse WTP deployment artifacts.

------------------------------------------------------------------------

# 10. Fast Diagnosis Checklist

When JSP suddenly stops working, check in this order:

``` text
1. Is the View actually JSP?
        ↓
2. Is JSP in src/main/webapp/WEB-INF/...?
        ↓
3. Is ViewResolver prefix/suffix correct?
        ↓
4. Is JSP engine/Jasper available?
        ↓
5. Am I using JSTL?
        ↓
   Yes → Check Jakarta JSTL API + implementation
        ↓
6. Am I using Spring form tags?
        ↓
   Yes → Check spring-webmvc + taglib URI
        ↓
7. Check JSP filename spelling
        ↓
8. Check controller return value
        ↓
9. Check form/link URL and context path
        ↓
10. Read the FIRST exception / "Caused by:"
        ↓
11. Clean + Maven Update + redeploy
```

------------------------------------------------------------------------

# 11. Key Lessons From This Project

### Mistake

I used JSP as the View but did not provide JSP processing support for
the embedded runtime.

### Symptom

Application started, but JSP processing failed and the console
eventually showed:

``` text
Cannot forward to error page...
response has already been committed
```

### Solution

Added:

``` xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

Then cleaned/updated the Maven project and ran again.

### Lesson

> **JSP is a view technology. The server/runtime must have JSP
> processing support to execute `.jsp` files.**

------------------------------------------------------------------------

# 12. The Mental Model to Remember

``` text
Spring Boot MVC
      │
      ├── Controller
      │
      ├── Model
      │
      └── View
            │
            └── JSP
                 │
                 ├── JSP engine/support
                 │
                 ├── JSTL (ONLY if JSTL is used)
                 │
                 └── Spring Form Tags
                         │
                         └── spring-webmvc
```

### One-line rule

> **JSP → JSP support. JSTL → JSTL dependencies. Spring form tags →
> Spring MVC.**

This is the main rule to carry into the next Spring MVC JSP project.
