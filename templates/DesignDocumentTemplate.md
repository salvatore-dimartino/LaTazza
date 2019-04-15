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

```plantuml
@startuml

package latazza.gui
package java.util
package latazza.data
package latazza.exception
package latazza
package exceptions

latazza --> latazza.gui: import
latazza --> latazza.data: import
latazza.data --> latazza.exception: import
latazza.exception --> exceptions: import
latazza.data --> java.util: import

@enduml
```


# Class diagram

\<for each package define class diagram with classes defined in the package>

\<mention design patterns used, if any>

## latazza Class diagram

```plantuml
@startuml
allowmixing

package latazza.data
package latazza.gui

class LaTazza {
    +main();
}

LaTazza --> latazza.data: import
LaTazza --> latazza.gui: import

@enduml
```
## latazza.exception Class diagram

```plantuml
@startuml
allowmixing
class BeverageExceptrion {
    +serialVersionUID;
}

class DataExceptrion {
    +serialVersionUID;
}

class EmployeeExceptrion {
    +serialVersionUID;
}

class NotEnoughBalance {
    +serialVersionUID;
}

class NotEnoughCapsules {
    +serialVersionUID;
}

package exceptions

BeverageExceptrion --> exceptions: import
DataExceptrion --> exceptions: import
EmployeeExceptrion  --> exceptions: import
NotEnoughBalance --> exceptions: import
NotEnoughCapsules --> exceptions: import

@enduml
```

## latazza.data Class diagram

```plantuml
@startuml
allowmixing
package latazza.exception

interface Datainterface {
    +sellCapsules();
    +sellCapsulesToVisitor();
    +rechargeAccount();
    +buyBoxes();
    +getEmployeeReport();
    +getReport();
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

DataImpl --> Datainterface: inplements
DataImpl --> latazza.exception: import
Datainterface --> latazza.exception


@enduml
```


## latazza.gui Class diagram

```plantuml
@startuml
allowmixing

class MainSwing {

}


@enduml
```


# Verification traceability matrix

\<for each functional requirement from the requirement document, list which classes concur to implement it>


|  | Class x | Class y  | .. |
| ------------- |:-------------:| -----:| -----:|
| Functional requirement x  |  |  | |
| Functional requirement y  |  |  | |
| .. |  |  | |

# Verification sequence diagrams 
\<select key scenarios from the requirement document. For each of them define a sequence diagram showing that the scenario can be implemented by the classes and methods in the design>

```plantuml
": Class X" -> ": Class Y": "1: message1()"
": Class X" -> ": Class Y": "2: message2()"
```