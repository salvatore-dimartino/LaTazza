# Unit Testing Documentation template

Authors:

Date:

Version:

# Contents

- [Black Box Unit Tests](#black-box-unit-tests)
    - [Class Beverage](#class-beverage)
        - [Consutructor Beverage()](#class-beverage---constructor-beverage())
        - [Class Beverage Method setName()](#class-beverage---method-setname())
        - [Method setPrice()](#class-beverage---method-setprice())
        - [Method setQuantityPerBox()](#class-beverage---method-setquantityperbox())
        - [Method setAvailableQuantity()](#class-beverage---method-setavailablequantity())
    - [Class Employee](#class-employee)
        - [Consutructor Employee()](#class-employee---constructor-employee())
        - [Method setName()](#class-employee---method-setname())
        - [Method setSurame()](#class-employee---method-setsurname())
    - [Class PersonalAccount](#class-personalaccount)
        - [Consutructor PersonalAccount()](#class-personalaccount---constructor-personalaccount())
        - [Method setBalance()](#class-personalaccount---method-setbalance())
    - [Class LaTazzaAccount](#class-latazzaaccount)
        - [Consutructor LaTazzaAccount()](#class-latazzaaccount---constructor-latazzaaccount())
        - [Method setTotal()](#class-latazzaaccount---method-settotal())
    - [Class Consumption](#class-consumption)
        - [Consutructor Consumption()](#class-consumption---constructor-consumption())
        - [Method setQuantity()](#class-consumption---method-setquantity())
    - [Class Recharge](#class-recharge)
        - [Consutructor Recharge()](#class-recharge---constructor-recharge())
        - [Method setAmount()](#class-recharge---method-setamount())
    - [Class BoxPurchase](#class-boxpurchase)
        - [Consutructor BoxPurchase()](#class-boxpurchase---constructor-boxpurchase())
        - [Method setQuantity()](#class-boxpurchase---method-setquantity())
    - [Class DataImpl](#class-dataimpl)
        - [Method sellCapsules()](#class-dataimpl---method-sellcapsules())
        - [Method sellCapsulesToVisitor()](#class-boxpurchase---method-sellCapsulestovisitor())
        - [Method rechargeAccount()](#class-boxpurchase---method-rechargeaccounty())
        - [Method buyBoxes()](#class-dataimpl---method-buyboxes())
        - [Method setQuantity()](#class-dataimpl---method-setquantity())
        - [Method getEmployeeReport(()](#class-dataimpl---method-getemployeereport())
        - [Method getReport()](#class-dataimpl---method-getreport())
        - [Method createBeverage()](#class-dataimpl---method-createbeveraget())
        - [Method updateBeverage()](#class-dataimpl---method-updatebeverage())
        - [Method createEmployee()](#class-dataimpl---method-createemployee())
        - [Method updateEmployee()](#class-dataimpl---method-updateemployee())

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

### **Class *Beverage* - method *setQuantityPerBox()***

**Criteria for  method *setQuantityPerBox()*:**
	
 - SignOfQuantityPerBox (on input)

**Predicates for method *setQuantityPerBox()*:**

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

### **Class *Beverage* - method *setAvailableQuantity()***

**Criteria for  method *setAvailableQuantity()*:**
	
 - SignOfAvailableQuantity (on input)

**Predicates for method *setAvailableQuantity()*:**

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

### **Class *Employee* - method *setName()***

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
 - ExistanceOfEmployee (on imput)
 - ExistanceOfBeverage (on imput)
 - NumberOfCapsules (on input)

**Predicates for method *sellCapsules*:**

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

### **Class *DataImpl* - method *sellCapsulesToVisitor()***

**Criteria for method *sellCapsulesToVisitor()*:**

 - ExistanceOfBeverage (on imput)
 - NumberOfCapsules (on input)

**Predicates for method *sellCapsulesToVisitor*:**

| Criteria | Predicate |
| ------------- | --------- |
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

| ExistanceOfBeverage | Number Of Capsules |  Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|---------|
| The beverage is cointained in the Map | 0 to NumberOfAvailableCapsules |  Valid   | sellCapsulesToVisitor() -> account.balance | it.polito.latazza.DataImplTest.testSellCapsules |
| The beverage is cointained in the Map | more than NumberOfAvailabaleCapsules  |  Invalid  | sellCapsulesToVisitor() -> NotEnoughCapsules() | it.polito.latazza.DataImplTest.testSellCapsules |
| The beverage is not cointained in the Map or null | 0 to NumberOfAvailablecapsules | Invalid | sellCapsulesToVisitor() -> BeverageException() | it.polito.latazza.DataImplTest.testSellCapsules |
| The beverage is not cointained in the Map or null | more than NumberOfAvailableCapsules |  Invalid | sellCapsulesToVisitor() -> BeverageException() | it.polito.latazza.DataImplTest.testSellCapsules |


**Criteria for method *sellCapsulesToVisitor()*:**

 - ExistanceOfBeverage (on imput)
 - NumberOfCapsules (on input)

**Predicates for method *sellCapsulesToVisitor*:**

| Criteria | Predicate |
| ------------- | --------- |
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

| ExistanceOfBeverage | Number Of Capsules |  Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|---------|---------|
| The beverage is cointained in the Map | 0 to NumberOfAvailableCapsules |  Valid   | sellCapsulesToVisitor() | it.polito.latazza.DataImplTest.testSellCapsulesToVisitor |
| The beverage is cointained in the Map | more than NumberOfAvailabaleCapsules  |  Invalid  | sellCapsulesToVisitor() -> NotEnoughCapsules() | it.polito.latazza.DataImplTest.testSellCapsulesToVisitor |
| The beverage is not cointained in the Map or null | 0 to NumberOfAvailablecapsules | Invalid | sellCapsulesToVisitor() -> BeverageException() | it.polito.latazza.DataImplTest.testSellCapsulesToVisitor |
| The beverage is not cointained in the Map or null | more than NumberOfAvailableCapsules |  Invalid | sellCapsulesToVisitor() -> BeverageException() | it.polito.latazza.DataImplTest.testSellCapsulesToVisitor |

### **Class *DataImpl* - method *rechargeAccount()***


**Criteria for method *rechargeAccount()*:**

 - ExistanceOfBeverage (on imput)
 - NumberOfCapsules (on input)

**Predicates for method *rechargeAccount*:**

| Criteria | Predicate |
| ------------- | --------- |
| ExistanceOfEmployee | The employee is cointained in the Map |
|                     | The employee is not contained in the Map or null |
| Amount              |  <= 0 |
|                     | 0 to 2,147,483,647 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Amount   |           0          |
|                    |   <  2,147,483,647   |
|                    |   > -2,147,483,647   |

**Combination of predicates**:

| ExistanceOfEmployee | Amount |  Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|---------|
| The employee is cointained in the Map | <= 0 |  Invalid   | rechargeAccount() -> account.balance | it.polito.latazza.DataImplTest.testRechargeAccount |
| The employee is cointained in the Map | 0 to 2,147,483,647  |  Valid  | rechargeAccount() -> account.balance | it.polito.latazza.DataImplTest.testRechargeAccount |
| The employee is not cointained in the Map or null | <= 0 | Invalid | rechargeAccount() -> EmployeeException() | it.polito.latazza.DataImplTest.testRechargeAccount |
| The beverage is not cointained in the Map or null | 0 to 2,147,483,647 |  Invalid | rechargeAccount() -> EmployeeException() | it.polito.latazza.DataImplTest.testRechargeAccount |

### **Class *DataImpl* - method *buyBoxes()***


**Criteria for method *buyBoxes()*:**

 - ExistanceOfBeverage (on imput)
 - NumberOfCapsules (on input)

**Predicates for method *buyBoxes*:**

| Criteria | Predicate |
| ------------- | --------- |
| ExistanceOfBeverage | The beverage is cointained in the Map |
|                     | The beverage is not contained in the Map or null |
| Amount              |  <= 0 |
|                     | 0 to 2,147,483,647 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Amount   |           0          |
|                    |   <  2,147,483,647   |
|                    |   > -2,147,483,647   |

**Combination of predicates**:

| ExistanceOfBeverage | Amount |  Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|---------|
| The beverage is cointained in the Map | <= 0 |  Invalid   | buyBoxes() -> account.balance | it.polito.latazza.DataImplTest.testBuyBoxes |
| The beverage is cointained in the Map | 0 to 2,147,483,647  |  Valid  | buyBoxes() -> account.balance | it.polito.latazza.DataImplTest.testBuyBoxes |
| The beverage is not cointained in the Map or null | <= 0 | Invalid | buyBoxes() -> BeverageException() | it.polito.latazza.DataImplTest.testBuyBoxes |
| The beverage is not cointained in the Map or null | 0 to 2,147,483,647 |  Invalid | buyBoxes() -> BeverageException() | it.polito.latazza.DataImplTest.testBuyBoxes |

### **Class *DataImpl* - method *getEmployeeReport()***


**Criteria for method *getEmployeeReport()*:**

 - ExistanceOfBeverage (on imput)
 - DateConsistency (on input)

**Predicates for method *getEmployeeReport*:**

| Criteria | Predicate |
| ------------------- | --------------------------------- |
| ExistanceOfEmployee | The employee is cointained in the Map |
|                     | The employee is not contained in the Map or null |
| DateConsistency        | Start date is before end date |
|                        | Start date is after end date  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Amount   |           0          |
|          |   <  2,147,483,647   |
|          |   > -2,147,483,647   |

**Combination of predicates**:

| ExistanceOfEmployee | DateCoerency |  Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|---------|
| The employee is cointained in the Map | Start date is before end date |  Valid   | getEmployeeReport() -> List<*String*> | it.polito.latazza.DataImplTest.testGetEmployeeReport |
| The employee is cointained in the Map | Start date is after end date   |  Invalid  | getEmployeeReport() -> DateException() | it.polito.latazza.DataImplTest.testGetEmployeeReport |
| The employee is not cointained in the Map or null | Start date is before end date | Invalid | getEmployeeReport() -> EmployeeException() | it.polito.latazza.DataImplTest.testGetEmployeeReport |
| The employee is not cointained in the Map or null | Start date is after end date |  Invalid | getEmployeeReport() -> EmployeeException() | it.polito.latazza.DataImplTest.testGetEmployeeReport |

### **Class *DataImpl* - method *getReport()***


**Criteria for method *getReport()*:**

 - ExistanceOfBeverage (on imput)
 - DateConsistency (on input)

**Predicates for method *getReport*:**

| Criteria | Predicate |
| ------------------- | --------------------------------- |
| DateConsistency        | Start date is before end date |
|                        | Start date is after end date  |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Amount   |           0          |
|          |   <  2,147,483,647   |
|          |   > -2,147,483,647   |

**Combination of predicates**:

| DateCoerency |  Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|---------|---------|
| Start date is before end date |  Valid   | getReport() | it.polito.latazza.DataImplTest.testGetReport |
| Start date is after end date   |  Invalid  | getReport() -> DateException() | it.polito.latazza.DataImplTest.testGetReport |

### **Class *DataImpl* - method *createBeverage()***

**Criteria for method *createBeverage()*:**

 - NameCorrectness (on input)
 - CapsulesPerBox (on input)
 - Price  (on input)


**Predicates for method *createBeverage*:**

| Criteria | Predicate |
| -------------------- | --------------------------------- |
|  NameCorrectness       | Name cointains invalid symbols |
|                        | Name does not cointain invalid symbols |
|  CapsulePerBox         | Less equal than 0 |
|                        | More than 0 |
|  PriceOfBox            | Less equal than 0 |
|                        | More than 0 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Amount   |           0          |
|          |   <  2,147,483,647   |
|          |   > -2,147,483,647   |

**Combination of predicates**:

| NameCorrectness | CapsulesPerBox | PriceOfBox | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|---------|---------|------------|---------|
| Name cointains invalid symbols | Less equal than 0 | Less equal than 0 |  Invalid   | createBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testCreateBeverage |
| Name cointains invalid symbols | Less equal than 0 | More than 0 |  Invalid  | createBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testCreateBeverage |
| Name cointains invalid symbols | More than 0  | Less equal than 0 |  Invalid  | createBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testCreateBeverage |
| Name cointains invalid symbols | More than 0 | More than 0 |  Invalid  | createBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testCreateBeverage |
| Name does not cointain invalid symbols | Less equal than 0 | Less equal than 0 |  Invalid   | createBeverage() -> BeverageException()| it.polito.latazza.DataImplTest.testCreateBeverage |
| Name does not cointain invalid symbols | Less equal than 0 | More than 0 |  Invalid  | createBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testCreateBeverage |
| Name does not cointain invalid symbols | More than 0  | Less equal than 0 |  Invalid  | createBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testCreateBeverage |
| Name does not cointain invalid symbols | More than 0 | More than 0 |  Valid  | createBeverage() -> 1 | it.polito.latazza.DataImplTest.testCreateBeverage |


### **Class *DataImpl* - method *updateBeverage()***


**Criteria for method *updateBeverage()*:**

 - NameCorrectness (on input)
 - CapsulesPerBox (on input)
 - Price  (on input)

**Predicates for method *updateBeverage*:**

| Criteria | Predicate |
| -------------------- | --------------------------------- |
| ExistanceOfBeverage  | The beverage is cointained in the Map |
|                      | The beverage is not contained in the Map or null |
|  NameCorrectness     | Name cointains invalid symbols |
|                      | Name does not cointain invalid symbols |
|  CapsulePerBox       | Less equal than 0 |
|                      | More than 0 |
|  PriceOfBox          | Less equal than 0 |
|                      | More than 0 |

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Amount   |           0          |
|          |   <  2,147,483,647   |
|          |   > -2,147,483,647   |

**Combination of predicates**:

| ExistanceOfBeverage | NameCorrectness | CapsulesPerBox | PriceOfBox | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|---------|---------|------------|---------|-----------------|
| The beverage is cointained in the Map| Name cointains invalid symbols | Less equal than 0 | Less equal than 0 |  Invalid   | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is cointained in the Map| Name cointains invalid symbols | Less equal than 0 | More than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is cointained in the Map| Name cointains invalid symbols | More than 0  | Less equal than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is cointained in the Map| Name cointains invalid symbols | More than 0 | More than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is cointained in the Map| Name does not cointain invalid symbols | Less equal than 0 | Less equal than 0 |  Invalid   | updateBeverage() -> BeverageException()| it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is cointained in the Map| Name does not cointain invalid symbols | Less equal than 0 | More than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is cointained in the Map| Name does not cointain invalid symbols | More than 0  | Less equal than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is cointained in the Map| Name does not cointain invalid symbols | More than 0 | More than 0 |  Valid  | updateBeverage() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is not contained in the Map or null | Name cointains invalid symbols | Less equal than 0 | Less equal than 0 |  Invalid   | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is not contained in the Map or null | Name cointains invalid symbols | Less equal than 0 | More than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is not contained in the Map or null | Name cointains invalid symbols | More than 0  | Less equal than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is not contained in the Map or null | Name cointains invalid symbols | More than 0 | More than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is not contained in the Map or null | Name does not cointain invalid symbols | Less equal than 0 | Less equal than 0 |  Invalid   | updateBeverage() -> BeverageException()| it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is not contained in the Map or null | Name does not cointain invalid symbols | Less equal than 0 | More than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is not contained in the Map or null | Name does not cointain invalid symbols | More than 0  | Less equal than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |
| The beverage is not contained in the Map or null | Name does not cointain invalid symbols | More than 0 | More than 0 |  Invalid  | updateBeverage() -> BeverageException() | it.polito.latazza.DataImplTest.testUpdateBeverage |

### **Class *DataImpl* - method *createEmployee()***

**Criteria for method *createEmployee()*:**

 - NameCorrectness (on input)
 - SurnameCorrectness (on input)

**Predicates for method *createEmployee*:**

| Criteria | Predicate |
| -------------------- | --------------------------------- |
|  NameCorrectness       | Name cointains invalid symbols |
|                        | Name does not cointain invalid symbols |
|  SurameCorrectness     | Surname cointains invalid symbols |
|                        | Surname does not cointain invalid symbols |


**Combination of predicates**:

| NameCorrectness | SurenameCorrectness | Valid / Invalid | Description of the test case | JUnit test case |
|-----------------|----------|---------|---------|---------|
| Name cointains invalid symbols  | Surname cointains invalid symbols |  Invalid   | createEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testCreateEmployee |
| Name cointains invalid symbols | Surname does not cointain invalid symbols |  Invalid  | createEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testCreateEmployee |
| Name does not cointain invalid symbols |  Surname cointains invalid symbols |  Invalid  | createEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testCreateEmployee |
| Name does not cointain invalid symbols |  Surname does not cointain invalid symbols |  Valid  | createEmployee() | it.polito.latazza.DataImplTest.testCreateEmployee |

### **Class *DataImpl* - method *updateEmployee()***

**Criteria for method *updateEmployee()*:**

 - NameCorrectness (on input)
 - SurnameCorrectness (on input)

**Predicates for method *updateEmployee*:**

| Criteria | Predicate |
| -------------------- | --------------------------------- |
| ExistanceOfEmployee  | The employee is cointained in the Map |
|                      | The employee is not contained in the Map or null |
|  NameCorrectness       | Name cointains invalid symbols |
|                        | Name does not cointain invalid symbols |
|  SurameCorrectness     | Surname cointains invalid symbols |
|                        | Surname does not cointain invalid symbols |

**Combination of predicates**:

| ExistanceOfEmployee | NameCorrectness | SurenameCorrectness | Valid / Invalid | Description of the test case | JUnit test case |
|-------------|-----------------|----------|---------|---------|---------|
| The employee is cointained in the Map | Name cointains invalid symbols  | Surname cointains invalid symbols |  Invalid   | updateEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testUpdateeEmployee |
| The employee is cointained in the Map | Name cointains invalid symbols | Surname does not cointain invalid symbols |  Invalid  | updateEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testUpdateEmployee |
| The employee is cointained in the Map | Name does not cointain invalid symbols |  Surname cointains invalid symbols |  Invalid  | updateEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testUpdateEmployee |
| The employee is cointained in the Map | Name does not cointain invalid symbols |  Surname does not cointain invalid symbols |  Valid  | updateEmployee() | it.polito.latazza.DataImplTest.testUpdateEmployee |
| The employee is not contained in the Map or null  | Name cointains invalid symbols  | Surname cointains invalid symbols |  Invalid   | updateEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testUpdateeEmployee |
| The employee is not contained in the Map or null  | Name cointains invalid symbols | Surname does not cointain invalid symbols |  Invalid  | updateEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testUpdateEmployee |
| The employee is not contained in the Map or null  | Name does not cointain invalid symbols |  Surname cointains invalid symbols |  Invalid  | updateEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testUpdateEmployee |
| The employee is not contained in the Map or null  | Name does not cointain invalid symbols |  Surname does not cointain invalid symbols |  Invalid  | updateEmployee() -> EmployeeException() | it.polito.latazza.DataImplTest.testUpdateEmployee |
# White Box Unit Tests

### Test cases definition

| Unit name | JUnit test case |
|--|--|
|it.polito.latazza.DataImpl.sellCapsules|it.polito.latazza.DataImplWhite.testSellCapsules|
|it.polito.latazza.DataImpl.sellCapsulesToVisitor|it.polito.latazza.DataImplWhite.testSellCapsulesToVisitor|
|it.polito.latazza.DataImpl.rechargeAccount|it.polito.latazza.DataImplWhite.testRechargeAccount|
|it.polito.latazza.DataImpl.buyBoxes|it.polito.latazza.DataImplWhite.testBuyBoxes|
|it.polito.latazza.DataImpl.getEmployeeReport|it.polito.latazza.DataImplWhite.testGetEmployeeReport|
|it.polito.latazza.DataImpl.getReport|it.polito.latazza.DataImplWhite.testGetReport|
|it.polito.latazza.DataImpl.createBeverage|it.polito.latazza.DataImplWhite.testCreateBeverage|
|it.polito.latazza.DataImpl.updateBeverage|it.polito.latazza.DataImplWhite.testUpdateBeverage|
|it.polito.latazza.DataImpl.getBeverageName|it.polito.latazza.DataImplWhite.testGetBeverageName|
|it.polito.latazza.DataImpl.getBeverageCapsulesPerBox|it.polito.latazza.DataImplWhite.testGetBeverageCapsulesPerBox|
|it.polito.latazza.DataImpl.getBeverageBoxPrice|it.polito.latazza.DataImplWhite.testGetBeverageBoxPrice|
|it.polito.latazza.DataImpl.getBeveragesId|it.polito.latazza.DataImplWhite.testGetBeveragesId|
|it.polito.latazza.DataImpl.getBeverages|it.polito.latazza.DataImplWhite.testGetBeverages|
|it.polito.latazza.DataImpl.getBeverageCapsules|it.polito.latazza.DataImplWhite.testGetBeverageCapsules|
|it.polito.latazza.DataImpl.createEmployee|it.polito.latazza.DataImplWhite.testCreateEmployee|
|it.polito.latazza.DataImpl.updateEmployee|it.polito.latazza.DataImplWhite.testUpdateEmployee|
|it.polito.latazza.DataImpl.getEmployeeName|it.polito.latazza.DataImplWhite.testGetEmployeeName|
|it.polito.latazza.DataImpl.getEmployeeSurname|it.polito.latazza.DataImplWhite.testGetEmployeeSurname|
|it.polito.latazza.DataImpl.getEmployeeBalance|it.polito.latazza.DataImplWhite.testGetEmployeeBalance|
|it.polito.latazza.DataImpl.getEmployeesId|it.polito.latazza.DataImplWhite.testGetEmployeesId|
|it.polito.latazza.DataImpl.getEmployees|it.polito.latazza.DataImplWhite.testGetEmployees|
|it.polito.latazza.DataImpl.getBalance|it.polito.latazza.DataImplWhite.testGetBalance|

### Code coverage report

    <Add here the screenshot report of the code and branch coverage obtained using
    the Jacoco tool. >


### Loop coverage analysis

|Unit name | Loop rows | Number of iterations | JUnit test case |
|---|---|---|---|
|it.polito.latazza.DataImpl.getEmployeeReport|Transactions.forEach((k, v) -> {if(v.getDate().after(startDate) && v.getDate().before(endDate)) l.add(v.getString());});|0|it.polito.latazza.DataImplWhite.testGetEmployeeReport|
|it.polito.latazza.DataImpl.getEmployeeReport|Transactions.forEach((k, v) -> {if(v.getDate().after(startDate) && v.getDate().before(endDate)) l.add(v.getString());});|1|it.polito.latazza.DataImplWhite.testGetEmployeeReport|
|it.polito.latazza.DataImpl.getEmployeeReport|Transactions.forEach((k, v) -> {if(v.getDate().after(startDate) && v.getDate().before(endDate)) l.add(v.getString());});|2|it.polito.latazza.DataImplWhite.testGetEmployeeReport|
|it.polito.latazza.DataImpl.getReport|Transactions.forEach((k, v) -> {if(v.getDate().after(startDate) && v.getDate().before(endDate)) l.add(v.getString());});|0|it.polito.latazza.DataImplWhite.testGetReport|
|it.polito.latazza.DataImpl.getReport|Transactions.forEach((k, v) -> {if(v.getDate().after(startDate) && v.getDate().before(endDate)) l.add(v.getString());});|1|it.polito.latazza.DataImplWhite.testGetReport|
|it.polito.latazza.DataImpl.getReport|Transactions.forEach((k, v) -> {if(v.getDate().after(startDate) && v.getDate().before(endDate)) l.add(v.getString());});|2|it.polito.latazza.DataImplWhite.testGetReport|
|it.polito.latazza.DataImpl.getBeveragesId|Beverages.forEach((k, v) -> {id.add(k);});|0|it.polito.latazza.DataImplWhite.testGetBeveragesId|
|it.polito.latazza.DataImpl.getBeveragesId|Beverages.forEach((k, v) -> {id.add(k);});|1|it.polito.latazza.DataImplWhite.testGetBeveragesId|
|it.polito.latazza.DataImpl.getBeveragesId|Beverages.forEach((k, v) -> {id.add(k);});|2|it.polito.latazza.DataImplWhite.testGetBeveragesId|
|it.polito.latazza.DataImpl.getBeverages|Beverages.forEach((k, v) -> {b.put(k, v.getName());});|0|it.polito.latazza.DataImplWhite.testGetBeverages|
|it.polito.latazza.DataImpl.getBeverages|Beverages.forEach((k, v) -> {b.put(k, v.getName());});|1|it.polito.latazza.DataImplWhite.testGetBeverages|
|it.polito.latazza.DataImpl.getBeverages|Beverages.forEach((k, v) -> {b.put(k, v.getName());});|2|it.polito.latazza.DataImplWhite.testGetBeverages|
|it.polito.latazza.DataImpl.getEmployeesId|Employees.forEach((k,v)->{Emp.add(k);});|0|it.polito.latazza.DataImplWhite.testGetEmployeesId|
|it.polito.latazza.DataImpl.getEmployeesId|Employees.forEach((k,v)->{Emp.add(k);});|1|it.polito.latazza.DataImplWhite.testGetEmployeesId|
|it.polito.latazza.DataImpl.getEmployeesId|Employees.forEach((k,v)->{Emp.add(k);});|2|it.polito.latazza.DataImplWhite.testGetEmployeesId|
|it.polito.latazza.DataImpl.getEmployees|Employees.forEach((k,v)->{Emp.put(k,v.getName()+" "+v.getSurname());});|0|it.polito.latazza.DataImplWhite.testGetEmployees|
|it.polito.latazza.DataImpl.getEmployees|Employees.forEach((k,v)->{Emp.put(k,v.getName()+" "+v.getSurname());});|1|it.polito.latazza.DataImplWhite.testGetEmployees|
|it.polito.latazza.DataImpl.getEmployees|Employees.forEach((k,v)->{Emp.put(k,v.getName()+" "+v.getSurname());});|2|it.polito.latazza.DataImplWhite.testGetEmployees|
