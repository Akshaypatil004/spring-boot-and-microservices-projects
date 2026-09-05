## What happens if we configure the real singleton java class as the prototype scope spring bean?

> Ans1) if IOC container is creating singleton Java class obj by accessing private constructor then the
prototype scope will be continued i.e the IOC container creates the multiple objs for multiple
ctx.getBean(-,-) method calls (Singleton Java class will be broken)

---

> Ans2) if we enable static factory based instantiation for the prototype
scope spring bean who class is singleton java class, then the singleton
behavior will be continued.

---

### What I learned ?
> on every `getBean()` method call on container object to get the real singleton java class object ref, container creates seperate object for every call although class is singleton , because container creating object by accesing the private constructor of class using reflection API , and not by static factory method instansition based , that why singleton bahaviour is broken.

** *if we configure static factory method based object creation then singleton behaviour will be continued* **

#### Sample output 1

When container creating object by accesing private constructor on real singleton java class having prototype scope

```
Printer.Printer() :: private constructor
Printer.Printer() :: private constructor
Printer.Printer() :: private constructor
p1.hashcode() :: 1791045777
p2.hashcode() :: 511717113
p3.hashcode() :: 728739494
-------------------------------------
p1 == p2 :: false
p1 == p3 :: false
p2 == p3 :: false
```

> To get this out uncomment out the `@Component(), @Scope()` Annotation on top of Printer spring bean and comment out AppConfig `@Bean(), @Scope` annotation and code , you will get the above output as reverse of this get the below output 

#### Sample output 2

When container creating object by static factory method on real singleton java class having prototype scope

```
Printer.Printer() :: private constructor
AppConfig.getPrinter()
AppConfig.getPrinter()
p1.hashcode() :: 484589713
p2.hashcode() :: 484589713
p3.hashcode() :: 484589713
-------------------------------------
p1 == p2 :: true
p1 == p3 :: true
p2 == p3 :: true
```

 
