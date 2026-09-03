# Ambiguity Problem

- Ambiguity problem raises when one target is having more then 1 dependent , IOC container gets confuse which dependent assign
to target


#### exact error message
`org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'ambiguity': Unsatisfied dependency expressed through field 'date': No qualifying bean of type 'java.time.LocalDate' available: expected single matching bean but found 2: date1,date2`

## Solutiong for ambiguity problem 

### 1. using @Primary annotation
- place `@Primary` annotation on the top of one of the multiple dependent spring bean , so that IOC container will be priority 
to that dependent , for dependency injection. If` @Primary` place on multiple dependent of same type the ambiguity problem continue

### 2. using @Qualifier("beanid") annotation
- using `@Qualifier(-)` annotation - we pass one of the dependent spring bean id to this annotation along with `@Autowird` and that
dependent will be injected to target , we can pass bean id to this annotation through properties file , xml withouting touching
the source code, and it has highest preference if all solutions applied to resolve ambiguity problem that why is best to 
resolve ambiguity problem

### 3. by matching HAS-A with one of the dependent spring bean 

---
- If we apply all 3 solutions to resolve ambiguity problem then the `@Qualifier` annotation will be taken as final dependent to target