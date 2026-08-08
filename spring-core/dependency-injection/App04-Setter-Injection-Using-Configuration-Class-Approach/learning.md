# Annotation learning and error came in projects learning

## Annotations use

### @Component
- It use to make user-defined java class as spring bean
- we have to pass bean id as parameter to this annotation i.e `@Component("emp")` otherwise class name will be taken as bean id ( class name first letter is small i.e `Class Employee` -> bean id -> employee.
- it place on the top of class

### @Autowired
- This annotation is used for all basic type dependency injection 
- In this project i place this annotation on setter method , so it become setter injection like this have , constructor, arbitory, filed injections for all these type of injections `@Autowird` is used
- it place on the top , method, field, constructor

### @Configuration
- This annotation is used to configure java class as spring bean come configuration class , where we give inputs and instruction to IOC container
- it place on the top of class

### @ComponentScan
- This annotation is used to provide packages names , thos packages IOC container scan and make those package java classes as spring bean , which are annotated with `@Component` annotation.
- it place on the top of class , basically used with configuration class

### @Bean
- This annotation is place on the top of method in spring bean configuration class and that method return object will become spring bean 
- IOC container will automatically invoked the method and make those methods related object as spring bean
- we have to bean id as parameter to the annotation  , otherwise method name will be taken as bean id

---

## ERROR OBSERVATION

- As use setter injection , and i tried to change the setter method name and i assume that code will thrown exception because i changed the method name , but it work fine because not `@Autowired` performing arbitory method injection 

- In target class all the properties participate in setter injection , and just comment out one of the dependent spring bean in configuration class , when run app i get exception -> *excepting 1 dependent but found none* 


  