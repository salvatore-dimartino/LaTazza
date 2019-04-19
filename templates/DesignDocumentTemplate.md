# Design Document Template

Authors: Francesco Dibitonto s265421 Federico Silvio Gorrino sXXXXXX Salvatore Di Martino s267553

Date:

Version: 1.0

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

By importing the LaTazza project into Eclipse and inspecting the packages, and by looking at the first lines of code of the .java files as well, we recognized the following structure:

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

We decided to use a 3-Layers Architecture as we have 3 layers: presentation(gui), application logic(functions) and Data(DBMS for getting the reports). <br>
These last two layers (application logic and Data) are both inside the latazza.data package. <br>
The Database stores transactions only and its only purpose is to produce reports. <br>
For the sake of interactivity as well, we decided to use the MVC model too, so our final Architectural pattern choice is MVC + Layers. <br>
Finally, concerning parallelization, concurrency is not needed so 1 thread only is sufficient.


# Class diagram

\<for each package define class diagram with classes defined in the package>

\<mention design patterns used, if any>

We'll use the DataImpl class as a 'facade': it will serve as a single wrapper class and entry point.

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
    +sellCapsules()
    +sellCapsulesToVisitor()
    +rechargeAccount()
    +buyBoxes()
    +getEmployeeReport()
    +getReport()
    +createBeverage()
    +updateBeverage()
    +getBeverageName()
    +getBeverageCapsulesPerBox()
    +getBeverageBoxPrice()
    +getBeveragesId()
    +getBeverages()
    +getBeverageCapsules()
    +createEmployee()
    +updateEmployee()
    +getEmployeeName()
    +getEmployeeSurname()
    +getEmployeeBalance()
    +getEmployeesId()
    +getEmployees()
    +getBalance()
    +reset()
}

class DataImpl {

    +List<Employee>
    +List<Beverege>
    +List<Transaction>
    
    sellCapsules()
    +sellCapsulesToVisitor()
    +rechargeAccount()
    +buyBoxes()
    +getEmployeeReport()
    +getReport(Transaction)
    +createBeverage()
    +updateBeverage() 
    +getBeverageName(String) : String 
    +getBeverageCapsulesPerBox(String) : Integer
    +getBeverageBoxPrice(String) : Integer
    +getBeveragesId(String) : List<String>
    +getBeverages(String) : List<Beverege>
    +getBeverageCapsules(String) : Integer
    +createEmployee() 
    +updateEmployee()
    +getEmployeeName(String) : String
    +getEmployeeSurname(String) : String
    +getEmployeeBalance(String) : Float
    +getEmployeesId(String) : List<String>
    +getEmployees(String) : List<Employee>
    +getBalance(String) : Float
    +reset() 
}

DataImpl --> Datainterface: implements

class PersonalAccount {
    +balance_personal : Float
    +List<Transaction>
}

PersonalAccount "*" --> DataImpl

class LaTazzaAccount {
    +balanceTotal : Float
}

class Employee {
    +name : String
    +surname : String
    +employeeID : Integer
    +getEmployeebyID(String) : Employee
   
}

class Beverage {
    +beverageID : String
    +beverageName : String
    +price : Float
    +quantityPerBox : Integer
    +availableQuantity : Integer
    +getBeneragebyID(String) : Balance
}

class BoxPurchase {
    
    +quantity : Integer
}

class Transaction {
    +date : Date
    +amount : Float


    +getTransactionbyDate(Date) : List<Transaction>
}

DataImpl <-- "*" Employee
DataImpl <-- "*" Beverage
DataImpl o-- LaTazzaAccount

LaTazzaAccount -- "*" BoxPurchase
LaTazzaAccount -- "*" Consumption

Beverage o-- "*" Consumption
Beverage o-- "*" BoxPurchase

Employee o-- PersonalAccount
PersonalAccount -- "*" Transaction

Transaction <|-- Recharge
Transaction <|-- Consumption
Transaction <|-- BoxPurchase

Transaction "*" --> DataImpl

class Recharge {
    +charge(Employee) : void
}
class Consumption {
    +updateQty(Beverage) : void
}


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
    +main(String[])
}

class Buy {
    +main(String[])
}

class EmployeesFrame {
    +main(String[])
}

class Euro {
    +main(String[])
}

class MainSwing {
    +main(String[])
}

class MappedArray {
    +main(String[])
}

class Payment {
    +main(String[])
}

class PrintLogsFrame {
    +main(String[])
}

class Refill {
    +main(String[])
}

class ReportFrame {
    +main(String[])
}


@enduml
```


# Verification traceability matrix


|  | DataImpl | PersonalAccount | LaTazzaAccount| Beverage | BoxPurchase | Transaction | Recharge | Consumption |
| ------------- |:-------------:| -----:| -----:| -----:   | -----:      | -----:      | -----:   | -----:      |
| FR1  | X    |      X          |               |    X     |             |          X  |          |   X         |
| FR2  | X    |                 |               |    X     |             |    X        |          |   X         |  
| FR3  | X    |                 |               |          |             |   X         |      X   |             |   
| FR4  | X    |                 |   X           |   X      |      X      |  X          |          |             |    
| FR5  | X    |          X      |               |          |             |   X         |        X |      X      |   
| FR6  | X    |                 |               |          |             |       X     |    X     |   X         |  
| FR7  | X    |                 |               |    X     |             |             |          |             |  
| FR8  | X    |         X       |               |          |             |             |          |             |  


# Verification sequence diagrams 

Scenario 1

```plantuml
": Class MainSwing" -> ": Class DataImpl": "sellCapsules(employeeId,beverageId,numberOfCapsules,fromAccount)"
": Class DataImpl" -> ": Class Beverage": "getCapsuleType()"
": Class Beverage" --> ": Class DataImpl": "CapsuleType"
": Class DataImpl" -> ": Class Beverage": "updateAmount(numberofCapsules)"
": Class DataImpl" -> ": Class Employee": "getPersonalAccount()"
": Class Employee" --> ": Class DataImpl": "PersonalAccount"
": Class DataImpl" -> ": Class Beverage": "getPrice()"
": Class Beverage" --> ": Class DataImpl": "Price"
": Class DataImpl" -> ": Class PersonalAccount": "updateAmount(Price)"
": Class DataImpl" -> ": Class Transaction": "Transaction(Date,Price)"
```

Scenario 2

```plantuml
": Class MainSwing" -> ": Class DataImpl": "sellCapsules(employeeId,beverageId,numberOfCapsules,fromAccount)"
": Class DataImpl" -> ": Class Beverage": "getCapsuleType()"
": Class Beverage" --> ": Class DataImpl": "CapsuleType"
": Class DataImpl" -> ": Class Beverage": "updateAmount(numberofCapsules)"
": Class DataImpl" -> ": Class Employee": "getPersonalAccount()"
": Class Employee" --> ": Class DataImpl": "PersonalAccount"
": Class DataImpl" -> ": Class Beverage": "getPrice()"
": Class Beverage" --> ": Class DataImpl": "Price"
": Class DataImpl" -> ": Class PersonalAccount": "updateAmount(Price)"
": Class PersonalAccount" -> ": Class NotEnoughBalance": "NotEnoughBalance(Exception)"
```