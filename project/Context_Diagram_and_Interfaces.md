# Context Diagram and interfaces

## Context Diagram

```plantuml
@startuml

left to right direction

skinparam packageStyle rectangle

actor Manager as m
actor Employee as e
actor SystemAdmin as sa
actor Visitor as v
actor PaymentSystem as ps

rectangle system {
	(LaTazza) as l
}

m -- l
e -- l
l -- sa
l -- v 

note "Manager is also an employee, but It can be considered as a lone actor because\nhe interacts differently with the system with respect to the employees" as n

@enduml
```

## Interfaces
| Actor | Logical Interface | Physical Interface  |
| ------------- |:-------------:| -----:|
|   Employee    | LaTazza application GUI | They ask to the manager for ordering capsules |
|   Manager    | LaTazza application GUI | Electronical device like personal computer |
|   Visitor    | X | They ask to the manager to get capsules and pay |
|   SystemAdmin    | GUI of the OS used to manage and handle the system | Electronical device like personal computer |
|   PaymentSystem    | Web service and APIs | Internet Connection |