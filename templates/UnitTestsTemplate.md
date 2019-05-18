# Unit Testing Documentation template

Authors:

Date:

Version:

# Contents

- [Black Box Unit Tests](#black-box-unit-tests)
    - [Class Beverage](#class-beverage)
    - [Class Employee](#class-employee)
    - [Class PersonalAccount](#class-personalaccount)
    - [Class LaTazzaAccount](#class-latazzaaccount)
    - [Class Consumption](#class-consumption)
    - [Class Recharge](#class-recharge)
    - [Class BoxPurchase](#class-boxpurchase)
    - [Class DataImpl](#class-dataimpl)

- [White Box Unit Tests](#white-box-unit-tests)


# Black Box Unit Tests

    <Define here criteria, predicates and the combination of predicates for each function of each class.
    Define test cases to cover all equivalence classes and boundary conditions.
    In the table, report the description of the black box test case and the correspondence with the JUnit black box test case name/number>

## **Class *Beverage***

### **Class *Beverage* - constructor *Beverage()***


**Criteria for constructor *Beverage()*:**
	
 - ValidityOfName (on input)
 - SignOfPrice (on input)
 - SignOfAvaibleQuantity (on input)
 - SignOfQuantityPerBox (on input)

**Predicates for constructor *Beverage*:**

| Criteria | Predicate |
| ------------- | --------- |
| ValidityOfName            | Name does not contain invalid characters |
|                           | Name contains invalid characters |
| SignOfPrice               | Sign of number is positive |
|                           | Sign of number is negative |
| SignOfAvailableQuantity   | Sign of number is positive |
|                           | Sign of number is negative |
| SignOfQuantityPerBox      | Sign of number is positive |
|                           | Sign of number is negative |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfPrice              |         >= 0         |
|                          |   <  2,147,483,647   |
| SignOfAvailableQuantity  |         >= 0         |
|                          |   <  2,147,483,647   |
| SignOfQuantityPerBox     |         >= 0         |
|                          |   <  2,147,483,647   |



**Combination of predicates**:

| ValidityOfName | SignOfPrice | SignOfAvailableQuantity | SignOfQuantityPerBox | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|-------|-------|-------|
| Name does not contain invalid characters | Sign of number is positive | Sign of number is positive | Sign of number is positive | Valid | Beverage("Caffe",,,) | it.polito.latazza.data.BeverageTest.testBeverage |
| Name  contain invalid characters | Sign of number is positive | Sign of number is positive | Sign of number is positive | Invalid | Beverage("Caff3",,,) -> BeverageException() | it.polito.latazza.data.BeverageTest.testBeverage |
| Name does not contain invalid characters | Sign of number is negative | Sign of number is positive | Sign of number is positive | Invalid | Beverage(,-5000,,) -> BeverageException() | it.polito.latazza.data.BeverageTest.testBeverage |
| Name does not contain invalid characters | Sign of number is positive | Sign of number is negative | Sign of number is positive | Invalid | Beverage(,,-10,) -> BeverageException() | it.polito.latazza.data.BeverageTest.testBeverage |
| Name does not contain invalid characters | Sign of number is positive | Sign of number is positive | Sign of number is negative | Invalid | Beverage(,,,-10) -> BeverageException() | it.polito.latazza.data.BeverageTest.testBeverage |


### **Class *Beverage* - method *setName()***

**Criteria for  *setName()*:**
	
 - ValidityOfName (on input)

**Predicates for method *setName()*:**

| Criteria | Predicate |
| ------------- | --------- |
| ValidityOfName            | Name does not contain invalid characters |
|                           | Name contains invalid characters |

**Combination of predicates**:

| ValidityOfName | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Name does not contain invalid characters | Valid | setName("Caffe") | it.polito.latazza.data.BeverageTest.testSetName |
| Name  contain invalid characters | Invalid | setName("Caff3") -> BeverageException() | it.polito.latazza.data.BeverageTest.testSetName |


### **Class *Beverage* - method *setName()***

**Criteria for method *setName()*:**
	
 - ValidityOfName (on input)

**Predicates for method *setName()*:**

| Criteria | Predicate |
| ------------- | --------- |
| ValidityOfName            | Name does not contain invalid characters |
|                           | Name contains invalid characters |

**Combination of predicates**:

| ValidityOfName | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Name does not contain invalid characters | Valid | setName("Caffe") | it.polito.latazza.data.BeverageTest.testSetName |
| Name  contain invalid characters | Invalid | setName("Caff3") -> BeverageException() | it.polito.latazza.data.BeverageTest.testSetName |

### **Class *Beverage* - method *setPrice()***

**Criteria for method *setPrice()*:**
	
 - SignOfPrice (on input)

**Predicates for method *setPrice()*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfPrice | Namber is positive |
|             | Namber is negative |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfPrice              |         >= 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfPrice | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Number is positive | Valid | setPrice(3000) | it.polito.latazza.data.BeverageTest.testSetPrice |
| Number is negative | Invalid | setPrice(-3000) -> BeverageException() | it.polito.latazza.data.BeverageTest.testSetPrice |

### **Class *Beverage* - method *testSetQuantityPerBox()***

**Criteria for  method *testSetQuantityPerBox()*:**
	
 - SignOfQuantityPerBox (on input)

**Predicates for method *testSetQuantityPerBox()*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfQuantityPerBox | Number is positive |
|             | Number is negative |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfPrice              |         >= 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfQuantityPerBox | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Number is positive | Valid | testSetQuantityPerBox(10) | it.polito.latazza.data.BeverageTest.ttestSetQuantityPerBox |
| Number is negative | Invalid | testSetQuantityPerBox(-10) -> BeverageException() | it.polito.latazza.data.BeverageTest.testSetQuantityPerBox |

### **Class *Beverage* - method *testSetAvailableQuantity()***

**Criteria for  method *testSetAvailableQuantity()*:**
	
 - SignOfAvailableQuantity (on input)

**Predicates for method *testSetAvailableQuantity()*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfAvailableQuantity | Number is positive |
|             | Number is negative |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfAvailableQuantity              |         >= 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfPrice | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Number is positive | Valid | testSetAvailableQuantity(10) | it.polito.latazza.data.BeverageTest.ttestSetQuantityPerBox |
| Number is negative | Invalid | testSetAvailableQuantity(-10) -> BeverageException() | it.polito.latazza.data.BeverageTest.testSetQuantityPerBox |

## **Class *Employee***

### **Class *Employee* - constructor *Employee()***

**Criteria for constructor *Employee()*:**
	
 - ValidityOfName (on input)
 - ValidityOfSurname (on input)

**Predicates for constructor *Employee*:**

| Criteria | Predicate |
| ------------- | --------- |
| ValidityOfName            | Name does not contain invalid characters |
|                           | Name contains invalid characters |
| ValidityOfSurname            | Surname does not contain invalid characters |
|                           | Surname contains invalid characters |

**Combination of predicates**:

| ValidityOfName | ValidityOfSurname | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|-------|
| Name does not contain invalid characters | Surname does not contain invalid character | Valid | Employee("Paolo","Vinovi",) | it.polito.latazza.data.EmployeeTest.testEmployee |
| Name does not contain invalid characters | Surname does contain invalid character | Invalid | Employee("Nicola", "Molin329o",) | it.polito.latazza.data.EmployeeTest.testEmployee |
| Name does contain invalid characters | Surname does not contain invalid character | Invalid | Employee("Nico3277la", "Molino",) | it.polito.latazza.data.EmployeeTest.testEmployee |

### **Class *Employee* - method *setSurname()***

**Criteria for  *setSurname()*:**
	
 - ValidityOfSurname (on input)

**Predicates for method *setSurname()*:**

| Criteria | Predicate |
| ------------- | --------- |
| ValidityOfSurname            | Surname does not contain invalid characters |
|                           | Surname contains invalid characters |

**Combination of predicates**:

| ValidityOfSurname | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Surname does not contain invalid characters | Valid | setSurname("Valencia") | it.polito.latazza.data.EmployeeTest.testSetSurname |
| Surname  contain invalid characters | Invalid | setSurname("Val219ncia") -> EmployeeException() | it.polito.latazza.data.EmployeeTest.testSetSurname |

**Criteria for  *setName()*:**
	
 - ValidityOfName (on input)

**Predicates for method *setName()*:**

| Criteria | Predicate |
| ------------- | --------- |
| ValidityOfName            | Name does not contain invalid characters |
|                           | Name contains invalid characters |

**Combination of predicates**:

| ValidityOfName | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Name does not contain invalid characters | Valid | setName("Vincenzo") | it.polito.latazza.data.EmployeeTest.testSetName |
| Name  contain invalid characters | Invalid | setName("Vinc879nzo") -> EmployeeException() | it.polito.latazza.data.EmployeeTest.testSetName |

## **Class *PersonalAccount***

### **Class *PersonalAccount* - constructor *PersonalAccount()***


**Criteria for constructor *PersonalAccount()*:**
	
 - SignOfBalance (on input)

**Predicates for constructor *PersonalAccount*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfBalance               | Sign of number is positive |
|                           | Sign of number is negative |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfBalance              |         >= 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfBalance | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Sign of number is positive | Valid | PersonalAccount(1) | it.polito.latazza.data.PersonalAccountTest.testPersonalAccount |
| Sign of number is negative | Invalid | PersonalAccount(-1) | it.polito.latazza.data.PersonalAccountTest.testPersonalAccount |

### **Class *PersonalAccount* - method *setBalance()***

**Criteria for method *setBalance()*:**
	
 - SignOfBalance (on input)

**Predicates for method *setBalance()*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfBalance | Namber is positive |
|             | Namber is negative |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfBalance              |         >= 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfPrice | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Number is positive | Valid | setBalance(2500) | it.polito.latazza.data.PersonalAccountTest.testSetBalance |
| Number is negative | Invalid | setBalance(-1000) -> NotEnoughBalance() | it.polito.latazza.data.PersonalAccountTest.testSetBalance |

## **Class *LaTazzaAccount***

### **Class *LaTazzaAccount* - constructor *LaTazzaAccount()***

**Criteria for constructor *LaTazzaAccount()*:**
	
 - SignOfTotal (on input)

**Predicates for constructor *LaTazzaAccount*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfTotal               | Sign of number is positive |
|                           | Sign of number is negative |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfTotal              |         >= 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfBalance | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Sign of number is positive | Valid | LaTazzaAccount(1) | it.polito.latazza.data.LaTazzaAccountTest.testLaTazzaAccount |
| Sign of number is negative | Invalid | LaTazzaAccount(-1) | it.polito.latazza.data.LaTazzaAccountTest.testLaTazzaAccount |

### **Class *LaTazzaAccount* - method *setTotal()***

**Criteria for method *setTotal()*:**
	
 - SignOfTotal (on input)

**Predicates for method *setBalance()*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfTotal | Namber is positive |
|             | Namber is negative |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfTotal              |         >= 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfPrice | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Number is positive | Valid | setTotal(2500) | it.polito.latazza.data.LaTazzaAccountTest.testSetTotal |
| Number is negative | Invalid | setTotal(-1000) -> NotEnoughBalance() | it.polito.latazza.data.LaTazzaAccountTest.testSetTotal |

## **Class *Consumption***

### **Class *Consumption* - constructor *Consumption()***

**Criteria for constructor *Consumption()*:**
	
 - SignOfQuantity (on input)

**Predicates for constructor *Consumption*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfQuantity            | > 0 |
|                           | <= 0 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfQuantity              |         > 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfQuantity | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| > 0 | Valid | Consumption(10,,,) | it.polito.latazza.data.ConsumptionTest.testConsumption |
| <= 0 | Invalid | Consumption(-10,,,) -> Exception() | it.polito.latazza.data.ConsumptionTest.testConsumption |

### **Class *Consumption* - method *setQuantity()***

**Criteria for method *setQuantity()*:**
	
 - SignOfQuantity (on input)

**Predicates for method *setQuantity()*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfQuantity | > 0 |
|                | <= 0 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfQuantity             |         > 0         |
|                            |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfQuantity | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| > 0 | Valid | setQuantity(10) | it.polito.latazza.data.ConsumptionTest.testSetQuantity |
| <= 0 | Invalid | setQuantity(-10) -> Exception() | it.polito.latazza.data.ConsumptionTest.testSetQuantity |


## **Class *Recharge***

### **Class *Recharge* - constructor *Recharge()***

**Criteria for constructor *Recharge()*:**
	
 - SignOfAmount (on input)

**Predicates for constructor *Recharge*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfAmount              | > 0|
|                           | <= 0 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfAmount             |         > 0         |
|                            |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfAmount | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| > 0| Valid | Recharge(,,100,) | it.polito.latazza.data.RechargeTest.testRecharge |
| <= 0 | Invalid | Recharge(,,-100,) -> Exception() | it.polito.latazza.data.RechargeTest.testRecharge |

### **Class *Recharge* - method *setAmount()***

**Criteria for method *setAmount()*:**
	
 - SignOfAmount (on input)

**Predicates for method *setAmount()*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfAmount | > 0 |
|             | <= 0 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfAmount               |         > 0         |
|                            |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfAmount | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| > 0 | Valid | setAmount(10) | it.polito.latazza.data.RechargeTest.testSetAmount |
| <= 0 | Invalid | setAmount(-10) -> Exception() | it.polito.latazza.data.RechargeTest.testSetAmount |


## **Class *BoxPurchase***

### **Class *BoxPurchase* - constructor *BoxPurchase()***

**Criteria for constructor *BoxPurchase()*:**
	
 - SignOfQuantity (on input)

**Predicates for constructor *BoxPurchase*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfQuantity            | > 0 |
|                           | <= 0 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfQuantity              |         > 0         |
|                          |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfQuantity | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| > 0 | Valid | BoxPurchase(,,10,) | it.polito.latazza.data.BoxPurchaseTest.testBoxPurchase |
| <= 0 | Invalid | BoxPurchase(,,-10,) -> Exception() | it.polito.latazza.data.BoxPurchaseTest.testBoxPurchase |

### **Class *BoxPurchase* - method *setQuantity()***

**Criteria for method *setQuantity()*:**
	
 - SignOfQuantity (on input)

**Predicates for method *setQuantity()*:**

| Criteria | Predicate |
| ------------- | --------- |
| SignOfQuantity | > 0 |
|                | <= 0 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| SignOfQuantity             |         > 0         |
|                            |   <  2,147,483,647   |

**Combination of predicates**:

| SignOfQuantity | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| > 0 | Valid | setQuantity(10) | it.polito.latazza.data.BoxPurchaseTest.testSetQuantity |
| <= 0 | Invalid | setQuantity(-10) -> Exception() | it.polito.latazza.data.BoxPurchaseTest.testSetQuantity |

## **Class *DataImpl***

### **Class *DataImpl* - method *sellCapsules()***


**Criteria for method *sellCapsules()*:**
	
 - NumberOfCapsules (on input)

**Predicates for constructor *DataImpl*:**

| Criteria | Predicate |
| ------------- | --------- |
| ExistanceOfEmployee | The employee is cointained in the Map |
|                     | The employee is not contained in the Map or null |
| ExistanceOfBeverage | The beverage is cointained in the Map |
|                     | The beverage is not contained in the Map or null |
|  NumberOfCapsules   |  0 to NumberOfAvailableCapsules |
|                     | more than NumberOfAvailableCapsules |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| NumberOfCapsules   |           0          |
|                    |   <  2,147,483,647   |
|                    |   > -2,147,483,647   |

**Combination of predicates**:

| ExistanceOfEmployee | ExistanceOfBeverage | Number Of Capsules |  Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|---------|---------|
| The employee is cointained in the Map | The beverage is cointained in the Map | 0 to NumberOfAvailableCapsules |  Valid   | sellCapsules() -> account.balance | it.polito.latazza.DataImplTest.testSellCapsules |
| The employee is cointained in the Map | The beverage is cointained in the Map | more than NumberOfAvailabaleCapsules  |  Invalid   | sellCapsules() -> NotEnoughCapsules() | it.polito.latazza.DataImplTest.testSellCapsules |
| The employee is not cointained in the Map or null | The beverage is cointained in the Map | 0 to NumberOfAvailableCapsules |  Invalid | sellCapsules() -> EmployeeException() | it.polito.latazza.DataImplTest.testSellCapsules |
| The employee is not cointained in the Map or null | The beverage is cointained in the Map | more than NumberOfAvailableCapsules |  Invalid | sellCapsules() -> EmployeeException() | it.polito.latazza.DataImplTest.testSellCapsules |
| The employee is cointained in the Map | The beverage is not cointained in the Map or null | 0 to NumberOfAvailablecapsules | Invalid | sellCapsules() -> BeverageException() | it.polito.latazza.DataImplTest.testSellCapsules |
| The employee is cointained in the Map | The beverage is not cointained in the Map or null | more than NumberOfAvailableCapsules |  Invalid | sellCapsules() -> BeverageException() | it.polito.latazza.DataImplTest.testSellCapsules |
| The employee is not cointained in the Map or null | The beverage is not cointained in the Map or null | 0 to NumberOfAvailableCapsules |  Invalid | sellCapsules() -> EmployeeException() | it.polito.latazza.DataImplTest.testSellCapsules |
| The employee is not cointained in the Map or null | The beverage is not cointained in the Map or null| more than NumberOfAvailableCapsules |  Invalid | sellCapsules() -> EmployeeException() | it.polito.latazza.DataImplTest.testSellCapsules |

# White Box Unit Tests

### Test cases definition

    <Report here all the created JUnit test cases, and the units/classes they test >


| Unit name | JUnit test case |
|--|--|
|||
|||
||||

### Code coverage report

    <Add here the screenshot report of the code and branch coverage obtained using
    the Jacoco tool. >


### Loop coverage analysis

    <Identify significant loops in the units and reports the test cases
    developed to cover zero, one or multiple iterations >

|Unit name | Loop rows | Number of iterations | JUnit test case |
|---|---|---|---|
|||||
|||||
||||||




