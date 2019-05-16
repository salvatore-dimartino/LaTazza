# Unit Testing Documentation template

Authors:

Date:

Version:

# Contents

- [Black Box Unit Tests](#black-box-unit-tests)




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
|-------|-------|-------|-------|-------|-------|-------|
| Name does not contain invalid characters | Valid | setName("Caffe") | it.polito.latazza.data.BeverageTest.testSetPrice |
| Name  contain invalid characters | Invalid | setName("Caff3") -> BeverageException() | it.polito.latazza.data.BeverageTest.testSetPrice |

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
|-------|-------|-------|-------|-------|-------|-------|
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
|-------|-------|-------|-------|-------|-------|-------|
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
|-------|-------|-------|-------|-------|-------|-------|
| Namber is positive | Valid | testSetAvailableQuantity(10) | it.polito.latazza.data.BeverageTest.ttestSetQuantityPerBox |
| Namber is negative | Invalid | testSetAvailableQuantity(-10) -> BeverageException() | it.polito.latazza.data.BeverageTest.testSetQuantityPerBox |


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




