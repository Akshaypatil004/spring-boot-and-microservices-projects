# Ambiguity Problem

- Ambiguity problem raises when one target is having more then 1 dependent , IOC container gets confuse which dependent assign
to target


#### exact error message
`org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'ambiguity': Unsatisfied dependency expressed through field 'date': No qualifying bean of type 'java.time.LocalDate' available: expected single matching bean but found 2: date1,date2`