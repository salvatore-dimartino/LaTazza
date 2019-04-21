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
latazza.gui --> latazza.data: import

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

    +EmployeeMap : HashMap<String,Employee>
    +BeverageMap : HashMap<String,Beverage>
    +TransactionMap : HashMap<String,Transaction>
    
    +sellCapsules()
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
    +reset() : void
}

DataImpl --> Datainterface: implements

class PersonalAccount {
    -balance : Integer
    -TransactionMap : HashMap<String,Transaction>
    
    +getBalance() : Integer
    +setBalance(Integer) : void
    +getTansactions() : List<Transaction>
    +getMapTansactions() : HashMap<String,Transaction>
    +addTransaction(Transaction) : void
    +deleteTransaction(Transaction) : void
}

class LaTazzaAccount {
    -Total : Integer
    
    +setTotal(Integer) : void
    +getTotal() : Integer
}

class Employee {
    -name : String
    -surname : String
    -ID : String
    -account : PersonalAccount
    
    +getName() : String
    +getSurname() : String
    +setName(String) : void
    +setSurname(String) : void
    +getPersonalAccount() : PersonalAccount
    +setPersonalAccount(PersonalAccount) : void
}

class Beverage {
    -ID : String
    -Name : String
    -price : Integer
    -quantityPerBox : Integer
    -availableQuantity : Integer
    
    +getQuantityperBox() : Integer
    +getAvailableQuantity() : Integer
    +getPrice() : Integer
    +getName() : String
    +setName(String) : void
    +setPrice(Integer) : void
    +setQuantityperBox(Integer) : void
    +setAvailableQuantity(Integer) : void
}

class BoxPurchase {
    -quantity : Integer
    -beverage : Beverage
    
    +getQuantity() : Integer
    +setQuantity(Integer) : void
    +getBeverage() : Beverage
    +setQuantity(Beverage) : void
}

class Transaction {
    -ID : String
    -date : Date

    +getDate() : Date
    +setDate(Date) : void
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
    -amount : Integer

    +charge(Employee,Integer) : void
}

class Consumption {
    -quantity : Integer
    -beverage : Beverage
    
    +getQuantity() : Integer
    +setQuantity(Integer) : void
    +getBeverage() : Beverage
    +setQuantity(Beverage) : void
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

class MainSwing {
    +main(String[])
    +getPaymantFrame()
    +getSupplyOfCapsulesFrame()
    +getSellCapsulesFrame()
    +getSummaryFrame()
}

class PaymentFrame {
    +JLabel Employee
    +JLabel Balance
    +JButton Pay
    +getMainSwing()
}

class CommandMenuBar {
    +getMainSwing()
}

class SummaryFrame {
    +JLabel Cash_Account
    +getMainSwing()
}

class MenuMenu {
    +getCommandMenuBar()
    +showConsuptionReport()
}

class EditMenu {
    +getCommandMenuBar()
    +showManageEmployees()
    +showManageBeverages()
}

class SupplyOfCapsulesFrame {
    +JLabel Number_of_Boxes
    +JLabel Beverage
    +JButton Buy
    +getMainSwing()
}

class SellCapsulesFrame {
    +JLabel Buy_credits
    +JLabel Employee
    +JLabel Beverage
    +JLabel Number_of_Capsules
    +JButton Sell
    +getMainSwing()
}

class EditEmployees {
    +Jlabel Id
    +Jlabel Name
    +Jlabel Surname
    +Jlabel Balance
    +JButton Insert
    +JButton Update
    +getEditMenu()
}

class EditBeverages {
    +Jlabel Id
    +Jlabel Name
    +Jlabel Capsules
    +Jlabel Price
    +JButton Insert
    +JButton Update
    +getEditMenu()
}

class LaTazzaReportFrame {
    +getMenuMenu()
}

class ConsuptionReportFrame {
    +JLabel Start_Date
    +JLabel End_Date
    +JButton Generate_consuption_report
    +getLaTazzaReportFrame()
}

class EmployeeReportFrame {
    +JLabel Employee
    +JLabel Start_Date
    +JLabel End_Date
    +JButton employee_report
    +getLaTazzaReportFrame()
}

class ConsuptionReport {
    -textArea
}
class EmployeeReport {
    -textArea
}

class Message {

}

MainSwing o-- CommandMenuBar
MainSwing o-- PaymentFrame
MainSwing o-- SupplyOfCapsulesFrame
MainSwing o-- SellCapsulesFrame
MainSwing o-- SummaryFrame
EditMenu o-- EditEmployees
EditMenu o-- EditBeverages
CommandMenuBar  o-- MenuMenu
CommandMenuBar  o-- EditMenu
MenuMenu o-- LaTazzaReportFrame
LaTazzaReportFrame o-- ConsuptionReportFrame
LaTazzaReportFrame o-- EmployeeReportFrame
ConsuptionReportFrame o-- ConsuptionReport
EmployeeReportFrame o-- EmployeeReport

PaymentFrame o-- Message
SupplyOfCapsulesFrame o-- Message
SellCapsulesFrame o-- Message
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
": Class MainSwing" -> ": Class DataImpl": 1: sellCapsules(employeeId,beverageId,numberOfCapsules,fromAccount)
": Class DataImpl" -> ": Class Beverage": 2: getCapsuleType()
": Class Beverage" -> ": Class DataImpl": 3: CapsuleType
": Class DataImpl" -> ": Class Beverage": 4: updateAmount(numberofCapsules)
": Class DataImpl" -> ": Class Employee": 5: getPersonalAccount()
": Class Employee" -> ": Class DataImpl": 6: PersonalAccount
": Class DataImpl" -> ": Class Beverage": 7: getPrice()
": Class Beverage" -> ": Class DataImpl": 8: Price
": Class DataImpl" -> ": Class PersonalAccount": 9: updateAmount(Price)
": Class DataImpl" -> ": Class Transaction": 10: Transaction(Date,Price)
```

Scenario 2

```plantuml
": Class MainSwing" -> ": Class DataImpl": 1: sellCapsules(employeeId,beverageId,numberOfCapsules,fromAccount)
": Class DataImpl" -> ": Class Beverage": 2: getCapsuleType()
": Class Beverage" -> ": Class DataImpl": 3: CapsuleType
": Class DataImpl" -> ": Class Beverage": 4: updateAmount(numberofCapsules)
": Class DataImpl" -> ": Class Employee": 5: getPersonalAccount()
": Class Employee" -> ": Class DataImpl": 6: PersonalAccount
": Class DataImpl" -> ": Class Beverage": 7: getPrice()
": Class Beverage" -> ": Class DataImpl": 8: Price
": Class DataImpl" -> ": Class PersonalAccount": 9: updateAmount(Price)
": Class PersonalAccount" -> ": Class NotEnoughBalance": 10: NotEnoughBalance(Exception)
```