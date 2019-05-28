# Acceptance Testing Documentation template

Authors: Francesco Dibitonto s265421 Federico Silvio Gorrino s262948 Salvatore Di Martino s267553

Date: 22/05/2019

Version: 1.0

# Contents

- [Scenarios](#scenarios)
- [Coverage of Scenarios](#coverage-of-scenarios)
- [Coverage of non-functional requirements](#coverage-of-non-functional-requirements)



# Scenarios

| Scenario ID: SC1 | Corresponds to UC1                             |
| ---------------- | ---------------------------------------------- |
| Description      | Colleague uses one capsule of type 1           |
| Precondition     | account of C has enough money to buy capsule T |
| Postcondition    | account of C updated, count of T updated       |
| Step#            | Step description                               |
| 1                | Administrator selects capsule type T           |
| 2                | Administrator selects colleague C              |
| 3                | Deduce one for quantity of capsule T           |
| 4                | Deduce price of T from account of C            |

| Scenario ID: SC2 | Corresponds to UC1                                     |
| ---------------- | ------------------------------------------------------ |
| Description      | Colleague uses one capsule of type T, account negative |
| Precondition     | account of C has not enough money to buy capsule T     |
| Postcondition    | account of C updated, count of T updated               |
| Step#            | Step description                                       |
| 1                | Administrator selects capsule type T                   |
| 2                | Administrator selects colleague C                      |
| 3                | Deduce one for quantity of capsule T                   |
| 4                | Deduce price of T from account of C                    |
| 5                | Account of C is negative, issue warning                |

| Scenario ID: SC3 |                                    |
| ---------------- | ---------------------------------------------------- |
| Description      | Colleague uses n capsules of type T                  |
| Precondition     | account of C has enough money to buy n capsules T    |
| Postcondition    | account of C updated, count of T updated             |
| Step#            | Step description                                     |
| 1                | Administrator selects capsule type T                 |
| 2                | Administrator selects colleague C                    |
| 3                | Deduce n for quantity of capsule T                   |
| 4                | Deduce price of n times T from account of C          |

| Scenario ID: SC4 |                                              |
| ---------------- | -------------------------------------------------------------- |
| Description      | Colleague uses n capsules of type T, pays with cash            |
| Precondition     | Colleague has enough cash to pay with                          |
| Postcondition    | Cash account updated, Count of T updated                       |
| Step#            | Step description                                               |
| 1                | Administrator selects capsule type T                           |
| 2                | Administrator selects colleague C                              |
| 3                | Deduce n for quantity of capsule T                             |
| 4                | Increase Cash account balance by the payed amount              |

| Scenario ID: SC5 | Corresponds to UC2                                             |
| ---------------- | -------------------------------------------------------------- |
| Description      | Visitor uses n capsules of type T, pays with cash              |
| Precondition     | Visitor has enough cash to pay with                            |
| Postcondition    | Cash account updated, Count of T updated                       |
| Step#            | Step description                                               |
| 1                | Administrator selects capsule type T                           |
| 2                | Administrator selects the Visitor option                       |
| 3                | Deduce n for quantity of capsule T                             |
| 4                | Increase Cash account balance by the payed amount              |

| Scenario ID: SC6 | Corresponds to UC3                                                 |
| ---------------- | ------------------------------------------------------------------ |
| Description      | Record recharge of account of colleague                            |
| Precondition     | Colleague's account already exists                                 |
| Postcondition    | Cash account updated, account of C updated                         |
| Step#            | Step description                                                   |
| 1                | Administrator selects colleague C                                  |
| 2                | Increase balance of account of C of the recharged amount           |
| 3                | Increase Cash account balance by the recharged amount              |

| Scenario ID: SC7 | Corresponds to UC4                                                                     |
| ---------------- | -------------------------------------------------------------------------------------- |
| Description      | Record purchase of n capsules of type T                                                |   
| Precondition     | Capsule type T exists                                                                  |
| Postcondition    | Cash account updated, count of T updated                                               |
| Step#            | Step description                                                                       |
| 1                | Administrator selects capsule of type T                                                |
| 2                | Administrator selects the minimum amount of boxes to get at least n capsules of type T |
| 3                | Administrator submits the selected informations and proceeds with the order            |
| 4                | Administrator receives the order                                                       |
| 5                | Increase count of T by the number of received capsules                                 |
| 6                | Decrease Cash account balance by the payed amount                                      |

| Scenario ID: SC8 | Corresponds to UC5                                             |
| ---------------- | -------------------------------------------------------------- |
| Description      | Produce report of Colleague C                                  |
| Precondition     | Colleague's account already exists                             |
| Postcondition    | -                                                              |
| Step#            | Step description                                               |
| 1                | Administrator selects Colleague C                              |
| 2                | Administrator selects startdate and enddate                    |
| 3                | Administrator submits the selected informations                |
| 4                | Collect all the transactions of C in the selected time range   |
| 5                | Show C's report                                                |

| Scenario ID: SC9 | Corresponds to UC6                                             |
| ---------------- | -------------------------------------------------------------- |
| Description      | Produce report about consumptions and recharges                |
| Precondition     | -                                                              |
| Postcondition    | -                                                              |
| Step#            | Step description                                               |
| 1                | Administrator selects startdate and enddate                    |
| 2                | Administrator submits the selected time range                  |
| 3                | Collect all the transactions in the selected time range        |
| 4                | Show report about consumptions and recharges                   |


| Scenario ID: SC10 |                                              |
| ----------------- | -------------------------------------------------------------- |
| Description       | Administrator creates a new type of capsule T                  |
| Precondition      | T doesn't exist                                                |
| Postcondition     | T created                                                      |
| Step#             | Step description                                               |
| 1                 | Administrator inserts name, number of capsules and price for T |
| 2                 | Administrator submits the form for T                           |

| Scenario ID: SC11 |                                                 |
| ----------------- | ----------------------------------------------------------------- |
| Description       | Administrator updates data for type of capsule T                  |
| Precondition      | T already exists                                                  |
| Postcondition     | T updated                                                         |
| Step#             | Step description                                                  |
| 1                 | Administrator inserts new name, number of capsules and price for T|
| 2                 | Administrator submits the form for T                              |


| Scenario ID: SC12 |                                         |
| ----------------- | ---------------------------------------------------------- |
| Description       | Administrator creates a new account for a collegue         |
| Precondition      | Colleague's account doesn't exist                          |
| Postcondition     | Colleague's account created                                |
| Step#             | Step description                                           |
| 1                 | Administrator inserts name and surname in the form for C   |
| 2                 | Administrator submits the form for C                       |

| Scenario ID: SC13 |                                              |
| ----------------- | -------------------------------------------------------------- |
| Description       | Administrator updates data for Colleague C                     |
| Precondition      | C already exists                                               |
| Postcondition     | C updated                                                      |
| Step#             | Step description                                               |
| 1                 | Administrator inserts new name and surname in the form for C   |
| 2                 | Administrator submits the form for C                           |



# Coverage of Scenarios

### 

| Scenario ID | Functional Requirements covered | API Test(s) | GUI Test(s) |
| ----------- | ------------------------------- | ----------- | ----------- |
| 1           | FR1                             |it.polito.latazza.APITest.Scenario1|    test1    |
| 2           | FR1                             |it.polito.latazza.APITest.Scenario2|    test2    |
| 3           | FR1                             |it.polito.latazza.APITest.Scenario3|    test3    |
| 4           | FR1                             |it.polito.latazza.APITest.Scenario4|    test4    |
| 5           | FR2                             |it.polito.latazza.APITest.Scenario5|    test5    |
| 6           | FR3                             |it.polito.latazza.APITest.Scenario6|    test6    |
| 7           | FR4                             |it.polito.latazza.APITest.Scenario7|    test7    |
| 8           | FR5                             |it.polito.latazza.APITest.Scenario8|    test8    |
| 9           | FR6                             |it.polito.latazza.APITest.Scenario9|    test9    |
| 10          | FR7                             |it.polito.latazza.APITest.Scenario10|    test10   |
| 11          | FR7                             |it.polito.latazza.APITest.Scenario11|    test11   |
| 12          | FR8                             |it.polito.latazza.APITest.Scenario12|    test12   |
| 13          | FR8                             |it.polito.latazza.APITest.Scenario13|    test13   |



# Coverage of Non Functional Requirements

### 

| Non Functional Requirement | Test name |
| -------------------------- | --------- |
| NFR2 |it.polito.latazza.NFR2.TimeBuyBoxes|
| NFR2 |it.polito.latazza.NFR2.TimeCreateBeverage|
| NFR2 |it.polito.latazza.NFR2.TimeCreateEmployee|
| NFR2 |it.polito.latazza.NFR2.TimeGetBalance|
| NFR2 |it.polito.latazza.NFR2.TimeGetBeverageBoxPrice|
| NFR2 |it.polito.latazza.NFR2.TimeGetBeverageCapsules|
| NFR2 |it.polito.latazza.NFR2.TimeGetBeverageCapsulesPerBox|
| NFR2 |it.polito.latazza.NFR2.TimeGetBeverageName|
| NFR2 |it.polito.latazza.NFR2.TimeGetBeverages|
| NFR2 |it.polito.latazza.NFR2.TimeGetBeveragesId|
| NFR2 |it.polito.latazza.NFR2.TimeGetEmployeeBalance|
| NFR2 |it.polito.latazza.NFR2.TimeGetEmployeeName|
| NFR2 |it.polito.latazza.NFR2.TimeGetEmployeeReport|
| NFR2 |it.polito.latazza.NFR2.TimeGetEmployees|
| NFR2 |it.polito.latazza.NFR2.TimeGetEmployeesId|
| NFR2 |it.polito.latazza.NFR2.TimeGetEmployeeSurname|
| NFR2 |it.polito.latazza.NFR2.TimeGetReport|
| NFR2 |it.polito.latazza.NFR2.TimeLoad|
| NFR2 |it.polito.latazza.NFR2.TimeRechargeAccount|
| NFR2 |it.polito.latazza.NFR2.TimeSellCapsules|
| NFR2 |it.polito.latazza.NFR2.TimeSellCapsulesToVisitor|
| NFR2 |it.polito.latazza.NFR2.TimeUpdateBeverage|
| NFR2 |it.polito.latazza.NFR2.TimeUpdateEmployee|