# Design Document Template

Authors:

Date:

Version:

# Contents

- [Package diagram](#package-diagram)
- [Class diagram](#class-diagram)
- [Verification traceability matrix](#verification-traceability-matrix)
- [Verification sequence diagrams](#verification-sequence-diagrams)

# Instructions

The design document has to comply with:
1. [Official Requirement Document](../Official\ Requirements\ Document.md)
2. [DataInterface.java](../src/main/java/it/polito/latazza/data/DataInterface.java)

UML diagrams **MUST** be written using plantuml notation.

# Package diagram

\<define UML package diagram >

\<explain rationales for choices> 

\<mention architectural patterns used, if any>

From the first line of code of the .java files, it is easy to recognise the structure of the UML Diagram.

```plantuml
@startuml

package latazza.gui
package latazza.data
package latazza.exception
package latazza

latazza --> latazza.gui: import
latazza --> latazza.data: import
latazza.data --> latazza.exception: import

@enduml
```


# Class diagram

\<for each package define class diagram with classes defined in the package>

\<mention design patterns used, if any>

## latazza Class diagram

```plantuml
@startuml
allowmixing

class LaTazza {
    +main();
}

@enduml
```

## latazza.data Class diagram

```plantuml
@startuml
allowmixing

interface Datainterface {
    +sellCapsules();
    +sellCapsulesToVisitor();
    +rechargeAccount();
    +buyBoxes();
    +getEmployeeReport();
    +getReport();
    +createBeverage();
    +updateBeverage();
    +getBeverageName();
    +getBeverageCapsulesPerBox();
    +getBeverageBoxPrice();
    +getBeveragesId();
    +getBeverages();
    +getBeverageCapsules();
    +createEmployee();
    +updateEmployee();
    +getEmployeeName();
    +getEmployeeSurname();
    +getEmployeeBalance();
    +getEmployeesId();
    +getEmployees();
    +getBalance();
    +reset();
}

class DataImpl {
    +sellCapsules();
    +sellCapsulesToVisitor();
    +rechargeAccount();
    +buyBoxes();
    +getEmployeeReport();
    +getReport();
    +createBeverage();
    +updateBeverage();
    +getBeverageName();
    +getBeverageCapsulesPerBox();
    +getBeverageBoxPrice();
    +getBeveragesId();
    +getBeverages();
    +getBeverageCapsules();
    +createEmployee();
    +updateEmployee();
    +getEmployeeName();
    +getEmployeeSurname();
    +getEmployeeBalance();
    +getEmployeesId();
    +getEmployees();
    +getBalance();
    +reset();
}

DataImpl --> Datainterface: implements

class PersonalAccount {
+ balance_personal
}

PersonalAccount "*" --> DataImpl

class LaTazzaAccount {
+ balance_total
}

class Beverage {
+ name
+ price
+ description
}

CapsuleType -- Beverage

class CapsuleType {
+ name
+ price
+ quantity
}

class BoxPurchase {
+ quantity
}

class Transaction {
+ date
+ amount
}

DataImpl <-- "*" Employee
DataImpl <-- "*" CapsuleType
DataImpl <-- "*" Beverage
DataImpl <-- LaTazzaAccount

LaTazzaAccount -- "*" BoxPurchase
LaTazzaAccount -- "*" Consumption

CapsuleType -- "*" Consumption
CapsuleType -- "*" BoxPurchase

Employee -- PersonalAccount
PersonalAccount -- "*" Transaction

Transaction <|-- Recharge
Transaction <|-- Consumption
Transaction <|-- BoxPurchase

Transaction "*" --> DataImpl

class Recharge
class Consumption


@enduml
```

## latazza.exception Class diagram

```plantuml
@startuml
allowmixing
class BeverageExceptrion {
}

class DataExceptrion {
}

class EmployeeExceptrion {
}

class NotEnoughBalance {
}

class NotEnoughCapsules {
}

@enduml
```


## latazza.gui Class diagram

```plantuml
@startuml
allowmixing

class BeveragesFrame {

}

class Buy {

}

class EmployeesFrame {

}

class Euro {

}

class MainSwing {

}

class MappedArray {

}

class Payment {

}

class PrintLogsFrame {

}

class Refill {

}

class ReportFrame {

}


@enduml
```

# Verification traceability matrix


|  | DataImpl | BeverageException | DateException | EmployeeException | NotEnoughBalance | NotEnoughCapsules |
| ------------- |:-------------:| -----:| -----:| -----:| -----:| -----:|
| Functional requirement 1  | X | X | X | X | X | X | 
| Functional requirement 2  | X | X | X |   |   | X | 
| Functional requirement 3  | X |   | X | X |   |   |   
| Functional requirement 4  | X | X |   |   | X |   |   
| Functional requirement 5  | X |   | X | X |   |   |   
| Functional requirement 6  | X |   | X |   |   |   |   
| Functional requirement 7  | X |   |   |   |   |   |   
| Functional requirement 8  | X |   | X |   |   |   |   


# Verification sequence diagrams 

Scenario 1

```plantuml
": Class MainSwing" -> ": Class DataImpl": "sellCapsules()"
": Class DataImpl" -> ": Class Employee": "getEmployee(employeeId)"
": Class Employee" --> ": Class DataImpl": "Employee"
": Class DataImpl" -> ": Class Beverage": "getBeverage(beverageId)"
": Class Beverage" --> ": Class DataImpl": "Beverage"
": Class DataImpl" -> ": Class CapsuleType": "updateAmount(Beverage,Amount)"
": Class DataImpl" -> ": Class PersonalAccount": "updateAmount(EmployeeAmount)"
": Class DataImpl" -> ": Class Transaction": "Transaction(Date,Amount)"
": Class DataImpl" --> ": Class MainSwing": "Response"
```

Scenario 2

```plantuml
": Class MainSwing" -> ": Class DataImpl": "sellCapsules()"
": Class DataImpl" -> ": Class Employee": "getEmployee(employeeId)"
": Class Employee" --> ": Class DataImpl": "Employee"
": Class DataImpl" -> ": Class Beverage": "getBeverage(beverageId)"
": Class Beverage" --> ": Class DataImpl": "Beverage"
": Class DataImpl" -> ": Class CapsuleType": "updateAmount(Beverage,Amount)"
": Class DataImpl" -> ": Class PersonalAccount": "updateAmount(EmployeeAmount)"
": Class PersonalAccount" -> ": Class NotEnoughBalance": "NotEnoughBalance(Exception)"
": Class DataImpl" --> ": Class MainSwing": "Response"
```