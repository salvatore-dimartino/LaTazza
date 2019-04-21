# Design Document Template

Authors: Francesco Dibitonto s265421 Federico Silvio Gorrino s262948 Salvatore Di Martino s267553

Date: 23/04/2019

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
    -Employees : Map<Integer,Employee>
    -Beverages : Map<Integer,Beverage>
    -Transactions : Map<Integer,Transaction>
    -account : LaTazzaAccount
    
    +sellCapsules(Integer,Integer,Integer,Boolean) : Integer
    +sellCapsulesToVisitor(Integer,Integer) : void
    +rechargeAccount(Integer,Integer) : Integer
    +buyBoxes(Integer,Integer) : void
    +getEmployeeReport(Integer,Date,Date) : List<String>
    +getReport(Date,Date) : List<String>
    +createBeverage(String,Integer,Integer) : Integer
    +updateBeverage(Integer,String,Integer,Integer) : void 
    +getBeverageName(Integer) : String 
    +getBeverageCapsulesPerBox(Integer) : Integer
    +getBeverageBoxPrice(Integer) : Integer
    +getBeveragesId() : List<Integer>
    +getBeverages() : Map<Integer,String>
    +getBeverageCapsules(Integer) : Integer
    +createEmployee(String,String) : Integer 
    +updateEmployee(Integer,String,String) : void
    +getEmployeeName(Integer) : String
    +getEmployeeSurname(Integer) : String
    +getEmployeeBalance(Integer) : Integer
    +getEmployeesId() : List<Integer>
    +getEmployees() : Map<Integer,String>
    +getBalance() : Integer
    +reset() : void
}

class DataImpl {

    -Employees : Map<Integer,Employee>
    -Beverages : Map<Integer,Beverage>
    -Transactions : Map<Integer,Transaction>
    -account : LaTazzaAccount
    
    +sellCapsules(Integer,Integer,Integer,Boolean) : Integer
    +sellCapsulesToVisitor(Integer,Integer) : void
    +rechargeAccount(Integer,Integer) : Integer
    +buyBoxes(Integer,Integer) : void
    +getEmployeeReport(Integer,Date,Date) : List<String>
    +getReport(Date,Date) : List<String>
    +createBeverage(String,Integer,Integer) : Integer
    +updateBeverage(Integer,String,Integer,Integer) : void 
    +getBeverageName(Integer) : String 
    +getBeverageCapsulesPerBox(Integer) : Integer
    +getBeverageBoxPrice(Integer) : Integer
    +getBeveragesId() : List<Integer>
    +getBeverages() : Map<Integer,String>
    +getBeverageCapsules(Integer) : Integer
    +createEmployee(String,String) : Integer 
    +updateEmployee(Integer,String,String) : void
    +getEmployeeName(Integer) : String
    +getEmployeeSurname(Integer) : String
    +getEmployeeBalance(Integer) : Integer
    +getEmployeesId() : List<Integer>
    +getEmployees() : Map<Integer,String>
    +getBalance() : Integer
    +reset() : void
}

DataImpl --> Datainterface: implements

class PersonalAccount {
    -balance : Integer
    -Transactions : Map<Integer,Transaction>
    
    +getBalance() : Integer
    +setBalance(Integer) : void
    +getTansactions() : Map<Integer,Transaction>
    +addTransaction(Transaction) : void
    +deleteTransaction(Transaction) : void
}

class LaTazzaAccount {
    -total : Integer
    
    +setTotal(Integer) : void
    +getTotal() : Integer
}

class Employee {
    -name : String
    -surname : String
    -ID : Integer
    -account : PersonalAccount
    
    +getName() : String
    +getSurname() : String
    +setName(String) : void
    +setSurname(String) : void
    +getPersonalAccount() : PersonalAccount
    +setPersonalAccount(PersonalAccount) : void
    +getID() : Integer
}

class Beverage {
    -ID : Integer
    -Name : String
    -price : Integer
    -quantityperbox : Integer
    -availablequantity : Integer
    
    +getQuantityperBox() : Integer
    +getAvailableQuantity() : Integer
    +getPrice() : Integer
    +getName() : String
    +setName(String) : void
    +setPrice(Integer) : void
    +setQuantityperBox(Integer) : void
    +setAvailableQuantity(Integer) : void
    +getID() : Integer
}

class BoxPurchase {
    -quantity : Integer
    -beverage : Beverage
    
    +getQuantity() : Integer
    +setQuantity(Integer) : void
    +getBeverage() : Beverage
    +setBeverage(Beverage) : void
    +getString() : String
}

class Transaction {
    -ID : Integer
    -date : Date

    +getDate() : Date
    +setDate(Date) : void
    +getID() : Integer
    +getString() : String
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
    -employee : Employee

    +getAmount() : Integer
    +setAmount(Integer) : void
    +getEmployee() : Beverage
    +setEmployee(Beverage) : void
    +getString() : String
}

class Consumption {
    -quantity : Integer
    -beverage : Beverage
    -employee : Employee
    -type : String
    
    +getQuantity() : Integer
    +setQuantity(Integer) : void
    +getBeverage() : Beverage
    +setBeverage(Beverage) : void
    +getType() : String
    +setType(String) : void
    +getEmployee() : Employee
    +setEmployee(Employee) : void
    +getString() : String
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
": Class DataImpl" -> ": Class Beverage": 1: getAvailableQuantity()
activate ": Class Beverage"
": Class Beverage" --> ": Class DataImpl": 2: Integer
": Class DataImpl" -> ": Class Beverage": 3: setAvailableQuantity(Integer)
": Class DataImpl" -> ": Class Beverage": 4: getPrice()
": Class Beverage" --> ": Class DataImpl": 5: Integer
deactivate ": Class Beverage"
": Class DataImpl" -> ": Class Employee": 6: getPersonalAccount()
activate ": Class Employee"
": Class Employee" --> ": Class DataImpl": 7: PersonalAccount
deactivate ": Class Employee"
": Class DataImpl" -> ": Class PersonalAccount": 8: getBalance()
activate ": Class PersonalAccount"
": Class PersonalAccount" --> ": Class DataImpl": 9: Integer
": Class DataImpl" -> ": Class PersonalAccount": 10: setBalance(Integer)
deactivate ": Class PersonalAccount"
```

Scenario 2

```plantuml
": Class DataImpl" -> ": Class Beverage": 1: getAvailableQuantity()
activate ": Class Beverage"
": Class Beverage" --> ": Class DataImpl": 2: Integer
": Class DataImpl" -> ": Class Beverage": 3: setAvailableQuantity(Integer)
": Class DataImpl" -> ": Class Beverage": 4: getPrice()
": Class Beverage" --> ": Class DataImpl": 5: Integer
deactivate ": Class Beverage"
": Class DataImpl" -> ": Class Employee": 6: getPersonalAccount()
activate ": Class Employee"
": Class Employee" --> ": Class DataImpl": 7: PersonalAccount
deactivate ": Class Employee"
": Class DataImpl" -> ": Class PersonalAccount": 8: getBalance()
activate ": Class PersonalAccount"
": Class PersonalAccount" --> ": Class DataImpl": 9: Integer
deactivate ": Class PersonalAccount"
": Class DataImpl" -> ": Class NotEnoughBalance": 10: NotEnoughBalance(Exception)
activate ": Class NotEnoughBalance"
deactivate ": Class NotEnoughBalance"
```