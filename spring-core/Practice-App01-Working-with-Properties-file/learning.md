## What I learned ?
> Properties file is simple a file like text file , having data in key , value pair, by using properties file we can provide techinal information or detail to application that required , like we can store jdbc connection details in properties, etc .. other 

### Annotations
1. `@PropertySource()`
2. `@Value()`

#### 1. `@PropertySource()`
- This annotation is used to configure properties , so that IOC container could recongnize the properties , and spring bean can use it .
- This annotation can we can place on the top any spring bean class or configuration class, and by configuring we could use properties file data in across multiple spring bean properties 


#### 2. `@Value()`
- This annotation is used to get the values from properties and inject to spring bean properties 
- this is multi purpose annotation 
	1. used to inject simple values to spring bean properties
	2. used to inject properties file values to spring bean properties
	3. used to inject sysyem properties values
	4. used to inject environment values
