## code learning

### Annotation used
#### @Scope("scopename") 
- This annotation can be place on the top of class , and method 
- This is annotation used to is defined scope of the spring bean, and use along with `@Component , @Bean`  annotation 

#### singleton scope
- ex - `@Scope("singleton")` - make IOC container to create single object for the spring bean and kept reference in internal cache for reusability of spring bean across application.
- we can bring the effect of singleton using **singleton** , it container level restriction ,container will create only one object for the spring bean , but not make it as singleton java class/spring bean , can create multiple objects 
