# Requirements Document Template

Authors:

* Gianni Cito
* Dario Ciaudano
* Gianpiero Carrieri
* Daniele Leto

Date: 09/04/2019

Version: 3.1

# Contents

- [Stakeholders](#stakeholders)
- [Context Diagram and interfaces](#context-diagram-and-interfaces)
	+ [Context Diagram](#context-diagram)
	+ [Interfaces](#interfaces) 
	
- [Requirements Document Template](#requirements-document-template)
- [Contents](#contents)
- [Stakeholders](#stakeholders)
- [Context Diagram and interfaces](#context-diagram-and-interfaces)
  - [Context Diagram](#context-diagram)
  - [Interfaces](#interfaces)
- [Stories and personas](#stories-and-personas)
  - [Persona One](#persona-one)
    - [Role: ***Manager***](#role-manager)
    - [Name: ***Alberto Verdi***](#name-alberto-verdi)
    - [Personal Data](#personal-data)
    - [Biography](#biography)
    - [Distinctive Features](#distinctive-features)
    - [Goals](#goals)
    - [Quote](#quote)
    - [Personality](#personality)
    - [Motivations](#motivations)
  - [Persona Two](#persona-two)
    - [Role: ***Employee***](#role-employee)
    - [Name: ***Giorgio Rossi***](#name-giorgio-rossi)
    - [Personal Data](#personal-data-1)
    - [Biography](#biography-1)
    - [Distinctive Features](#distinctive-features-1)
    - [Goals](#goals-1)
    - [Quote](#quote-1)
    - [Personality](#personality-1)
    - [Motivations](#motivations-1)
  - [Persona Three](#persona-three)
    - [Role: ***Visitor***](#role-visitor)
    - [Name: ***Bruno Bianchi***](#name-bruno-bianchi)
    - [Personal Data](#personal-data-2)
    - [Biography](#biography-2)
    - [Distinctive Features](#distinctive-features-2)
    - [Goals](#goals-2)
    - [Quote](#quote-2)
    - [Personality](#personality-2)
    - [Motivations](#motivations-2)
- [Functional and non functional requirements](#functional-and-non-functional-requirements)
  - [Functional Requirements](#functional-requirements)
  - [Non Functional Requirements](#non-functional-requirements)
- [Use case diagram and use cases](#use-case-diagram-and-use-cases)
  - [Use case diagram](#use-case-diagram)
  - [Use Cases](#use-cases)
    - [Use case 1, UC1](#use-case-1-uc1)
    - [Use case 2, UC2](#use-case-2-uc2)
- [Relevant scenarios](#relevant-scenarios)
  - [Scenario 1](#scenario-1)
  - [Scenario 2](#scenario-2)
- [Glossary](#glossary)
- [System Design](#system-design)

# Stakeholders

| Stakeholder name  | Description | 
|:-----------------:|:-----------:|
| Manager | Sell capsules, buy boxes of capsules, manages money, track inventory status, check cash account| 
| System admin | Manages the server infrastructure and web system |
| Retailer | Provide boxes of capsule on orders |
| Employee | Buy capsules by using cash or personal account money |
| Visitor | Buy capsules by using cash |

# Context Diagram and interfaces

## Context Diagram
```plantuml

left to right direction
skinparam packageStyle rectangle
actor Manager as m
actor "System Admin" as sa
actor Visitor as v
actor Employee as e
actor "Payment Systems" as ps

rectangle System {
   (Capsule Management System) as cms
   m -- cms
   sa -- cms
   cms -- e
   cms -- v
   cms -- ps
}

note "The Retailer is not represented in the system because he sells \ncapsule's boxes directly to the Manager, this means that \nhe doesn't interact directly with the Capsule Management System." as n

```

## Interfaces
| Actor | Logical Interface | Physical Interface |
|:-----:|:-----------------:|:------------------:|
| Visitor | GUI (display the type of Capsules and relative buttons) | Screen, buttons, money |
| Employee | GUI (display the type or Capsules and relative buttons), payment services | Screen, buttons, money |
| Manager | GUI (display the type or Capsules and relative buttons, check inventory and cash account), payment services | Screen, buttons, money |

# Stories and personas

## Persona One

### Role: ***Manager***

### Name: ***Alberto Verdi***

---

### Personal Data

**Birth's Location:** Rivoli (TO)<br>
**Birth's Date:** 6 March 1958<br>
**Work Location:** Torino<br>
**Marital Status:** Married<br>
**Kids:** 4 (Alessia, Giulia, Andrea, Marco)<br>
**Occupation:** Manager<br>
**Education:** Master Degree in Economics and Management<br>
**Hobbies:** ski, tennis, read lots of book, spend time with his kids<br>

---

### Biography

Alberto was born in Rivoli in 1958. He grew in a wealthy family as an only child. For this reason all the family attention was for him, and he was a bit vitiated child.<br>
At 9 he starts playing tennis and he never stops to play. Today sports are an important piece of his person.<br>
He was a really good student and able to accomplish every task assigned. After the excellent performances at high school he decided to go to the University of Munich to study Economics and Management. Four months before the deegre he was already intern in a big German finance society. At the age of 32 years he came back in Italy and he realized one of his dreams and he founded its own society.
After the expansions of his company he hires Carla, a new employee that one year later became his wife. Today is an happy manager and an example for his kids and employees.

---

### Distinctive Features

* Active
* Calm
* Generous
* Hard Worker
* Coffee Lover

### Goals

* Be kind with other work colleagues.
* See all the kids with a degree and fulfilled.
* Try the adrenaline of a parachute fly.

---

### Quote

> When we train the people who work with us we are building solid foundations.<br>
> Otherwise we would build only on the sand.

---

### Personality

Unfriendly&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/65)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Friendly<br><br>
Lazy&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/100)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hard-Working<br><br>
Dishonest &nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/75)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Honest <br><br>
Rude&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/90)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Respectful<br><br>
Unsure&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/90)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Determined<br>

### Motivations

Incentive&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/20)<br><br>
Fear&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/40)<br><br>
Growth&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/100)<br><br>
Power&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/70)<br><br>
Social&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/65)<br>

## Persona Two

### Role: ***Employee***

### Name: ***Giorgio Rossi***

---

### Personal Data

**Birth's Location:** Castellammare di Stabia (NA)<br>
**Birth's Date:** 27 February 1989<br>
**Work Location:** Torino<br>
**Marital Status:** Single<br>
**Kids:** 0<br>
**Occupation:** Employee<br>
**Education:** Degree in Economics and Management<br>
**Hobbies:** going out with friends, football, tv series, cinema<br>

---

### Biography

Giorgio was born in Castellammare in 1989. He grew in a big family, in fact, he was the second of four children. For this reason he loves to be surrounded by so many people.<br>
At the age of 14 his father took him to see his first Naples game and since then he became a great fan. Today he never misses a game of his favorite team.<br>
He was a good student, but a little unruly. After the study at high school he decided to go to the University of Naples to study Economics and Management. His first job was in Rome, with an accountant. After two years he decided to move to Turin after an indispensable job offer.<br>
He had many girlfriends, but he never found true love. Today is looking for a girl and successes at work.

---

### Distinctive Features

* Playful
* Irascible
* Generous
* Laggard
* Coffee Lover

### Goals

* Make friends with all his work colleagues.
* Find the girl of his dreams.
* Receive a promotion.

---

### Quote

> Life is not the party we hoped for, but as long as we are here we dance.<br>
> Naples is not a city, it is a world.

---

### Personality

Unfriendly&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/90)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Friendly<br><br>
Lazy&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/65)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hard-Working<br><br>
Dishonest &nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/45)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Honest <br><br>
Rude&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/25)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Respectful<br><br>
Unsure&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/100)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Determined<br>

### Motivations

Incentive&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/80)<br><br>
Fear&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/60)<br><br>
Growth&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/70)<br><br>
Power&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/90)<br><br>
Social&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/100)<br>

## Persona Three

### Role: ***Visitor***

### Name: ***Bruno Bianchi***

---

### Personal Data

**Birth's Location:** Milano (MI)<br>
**Birth's Date:** 5 August 1967<br>
**Work Location:** Milano<br>
**Marital Status:** Married<br>
**Kids:** 1 (Luca)<br>
**Occupation:** Architect<br>
**Education:** Degree in Architecture<br>
**Hobbies:** Travel around the world, tasting wines, go to the pool, watch documentaries<br>

---

### Biography

Bruno was born in Milano in 1967. He grew in a simple family and was the youngest of the three children.<br>
He always practiced swimming, as a boy he had thought about a career as an agonist, but then he preferred his studies; however swimming has remained a constant companion in his life.<br>
He was a very good student, polite and diligent. After the study at high school he he enrolled at the Milan Polytechnic to study Architecture. after an apprenticeship, he opened his studio and conducted it with dedication for years.<br>
He met his wife as a young man and they have been married for twenty years, he also has a 15-year-old teenage son he cares about.

---

### Distinctive Features

* Smiling
* Vigorous
* Precise
* Shy
* Tea Lover

### Goals

* Draw a skyscraper.
* Become a grandfather.
* Always make his family happy.

---

### Quote

> True individual freedom cannot exist without economic security and independence.
People who are hungry and without work are the pasta that dictatorships are made of.<br>
> It is a good idea to always start from the bottom, except when learning to swim.

---

### Personality

Unfriendly&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/60)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Friendly<br><br>
Lazy&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/85)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hard-Working<br><br>
Dishonest &nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/70)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Honest <br><br>
Rude&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/90)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Respectful<br><br>
Unsure&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/75)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Determined<br>

### Motivations

Incentive&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/80)<br><br>
Fear&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/70)<br><br>
Growth&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/80)<br><br>
Power&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/100)<br><br>
Social&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Progress](http://progressed.io/bar/30)<br>

# Functional and non functional requirements

## Functional Requirements
| ID        | Description  |
| ------------- |:-------------:| 
|  FR1     | Acquire the capsules |  
|  FR2     | Store the boxes of capsules |
|  FR3     | Take a capsule from the manager |
|  FR4     | Show the different capsule's quality |
|  FR5     | Check the order and pay the bill |
|  FR6     | Take the cash as payment method |
|  FR7     | Reduce the credit account on the cashless system |
|  FR8     | Lack of a specific caplsule's quality |
|  FR9     | Refill the inventory |
|  FR10    | Fix the software faults |
|  FR11    | Clear the inventory from empty boxes |
|  FR12    | Consumption of electric energy |

## Non Functional Requirements
| ID        | Type (efficiency, reliability, ..)           | Description  | Refers to |
| --------- |:--------------------------------------------:| :-----------:| ---------:|
|  NFR1     | Reliability | Buy from a retailer | FR1 |
|  NFR2     | Reliability | Avoid damaging the goods during the storage phase | FR2 |
|  NFR3     | Reliability | Performed by manager | FR5 |
|  NFR4     | Reliability | Avoid lack of data in the virtual account | FR7 |
|  NFR5     | Reliability | Periodic checks | FR11 |
|  NFR6     | Efficency | Less than fifteen minutes | FR2 |
|  NFR7     | Efficency | Set up a check before a capsule type run out | FR8 |
|  NFR8    | Efficency | Set a stand by mode to reduce the consumption of energy during the unused times | FR12 |
|  NFR9    | Maintainability | Place on the inventory in an orderly and categorized manner | FR2 |
|  NFR10    | Maintainability | Perform an order for the specific lack | FR8 |
|  NFR11    | Maintainability | A specialized techinician is required | FR10 |
|  NFR12    | Functionality | The list is shown on the app | FR4 |
|  NFR13    | Functionality | Place the inventory in a central room | FR3 |
|  NFR14    | Functionality | The manager takes the collection by hand | FR6 |
|  NFR15    | Functionality | Put the trash can on the left side near the door | FR11 |
|  NFR16    | Usability | The one and two cents coin isn't accepted | FR6 |


# Use case diagram and use cases

## Use case diagram
```plantuml
left to right direction

actor Manager as m
actor Visitor as v
actor Employee as e
actor Retailer as r

(Manage employee credit/debit) as mecd
(Buy boxes of capsules) as bbc
(Check inventory) as ci
(Sell boxes of capsules) as sbc

v -- bbc
bbc -- e
m -- mecd
m -- ci
ci .> bbc : <<include>>
m -- sbc
r -- sbc
```

## Use Cases  

### Use case 1, UC1
- Buy capsules: An employee or a visitor decide to buy some capsules. They will choose what type and how many capsules buy. In case an employee want to buy some capsules, this one can provide his employee ID in order to exploit his company credit.

| Actors Involved        | Visitor, Employee |
| ------------- |:-------------:| 
|  Precondition     | Inventory is not empty |  
|  Post condition     | Actor can take the product |
|  Nominal Scenario     | SC1 |
|  Variants     | Abort executions cause: chosen product is wrong; customer has no money; selected product is out of stock |

### Use case 2, UC2
- Check inventory: Once the manager check the inventory and see that some type of capsules are going to run out, supply a request to the Retailer to buy a certain amount of boxes, containing 10 capsules per box.

| Actors Involved        | Manager |
| ------------- |:-------------:| 
|  Precondition     | Inventory is empty |  
|  Post condition     | Inventory is not empty |
|  Nominal Scenario     | SC2 |
|  Variants     | Abort executions cause: manager has forgotten his credentials; manager did not receive new boxes of capsule from retailer |


# Relevant scenarios

## Scenario 1

| Scenario ID: SC1        | Corresponds to UC1: Buy boxes of capsules |
| ------------- |:-------------:| 
| Step#        | Description  |
|  1     | Start iteration |  
|  2     | Choose type of product |
|  3     | Choose number of capsules (choice from those available in the inventory) |
|  4     | Confirm product |
|  5     | Manage payment |
|  6     | Take the product |
|  7     | Inventory is decreased |
|  8     | Close iteration |

## Scenario 2
| Scenario ID: SC2        | Corresponds to UC2: Check inventory |
| ------------- |:-------------:| 
| Step#        | Description  |
|  1     | Start iteration |  
|  2     | Insert manager's credentials |
|  3     | Add new boxes of capsule |
|  4     | Update the inventory |
|  5     | Close iteration |

# Glossary
```plantuml

class "Capsule Management System" {

}

class Employee {
    +ID
    +name
    +surname
}

class "System Admin" {
    
}

class Manager {

}

class Retailer {
    +society name
    +IBAN
}

class Visitor {
    +ID
}

class "Payment System" {
    +method
    +date
}

class Contract {
    +ID
    +start date
    +expire date *
    +capsules amount
    +total cost
}

class Bill {
    +ID
    +date
    +products amount
    +total cost
}

"Payment System" "1..*" --  Visitor : is paid via cash
"Payment System" "1..*" -- Employee : is paid

Bill -right- "Payment System" : has

"Capsule Management System"  -- "1..*" Retailer : contacts
Employee <|-- Manager
Employee <|-- "System Admin"

class Visitor
note left: Name and surname \naren't necessary \nto preserve \nvisitor's privacy.

"Capsule Management System"  -- "1..*" Bill : produce

Retailer  -- "0..*" Contract : signs
Contract "0..*" --  Manager : is offered

```

# System Design

``` plantuml

Class “Capsule Management System” {
}

Class “Desktop Application” {
   +sellCapsules()
   +buyCapsules()
   +seeInventoryStatus()
}

Class Server {
   +sendData()
   +updateData()
   +computePrice()
   +processPayment()
}

Class “Capsule Inventory” {
   +availablePerType()
}

Class “Employee Database” {
   +getName()
   +getPaymentOptions()
   +getID()
}

Class “Payment System” {
   +getPaymentMenthod()
   +checkoutAmount()
   +getPaymentStatus()
}

“Capsule Management System” -- “Desktop Application” : has
“Desktop Application” -- Server : query 
Server o-- “Employee Database” : has
Server o-- “Capsule Inventory”: has
Server o-- “Payment System” : use

```