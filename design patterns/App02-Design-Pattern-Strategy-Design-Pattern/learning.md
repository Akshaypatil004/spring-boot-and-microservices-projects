# Strategy Design Pattern

## Rules/principle of strategy design pattern
- prefer composition(HAS-A relation) over inheritance(IS-A relation)
- always code to interfaces , do not concrete class to achieved loosly coupled interchangable code
- code should be ,open for extenion and close for modification 

---
## Annotation used
### @Lazy(true)
- IOC container will not instanciate the spring bean egarly , IOC container will create spring bean when it used other wise not 

### @Primary , @Qualifier
- used to resolve ambiguity , as there two dependent spring beans(DTDT, BlueDart) for one Target(ICourier type) in target class
- `@Qualifier` specified bean id spring bean will be injected to target spring bean 