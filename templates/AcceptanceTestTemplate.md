# Acceptance Testing Documentation template

Authors:

Date:

Version:

# Contents

- [Scenarios](#scenarios)

- [Coverage of scenarios](#scenario-coverage)
- [Coverage of non-functional requirements](#nfr-coverage)



# Scenarios

```
<Define here additional scenarios for the application. The two original scenarios in the Requirements Document are reported here.>
```

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

| Scenario ID: SC2 | Corresponds to UC2                                     |
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

| Scenario ID: SC3 | Corresponds to UC3                                   |
| ---------------- | ---------------------------------------------------- |
| Description      | Colleague uses n capsules of type T                  |
| Precondition     | account of C has enough money to buy n capsules T    |
| Postcondition    | account of C updated, count of T updated             |
| Step#            | Step description                                     |
| 1                | Administrator selects capsule type T                 |
| 2                | Administrator selects colleague C                    |
| 3                | Deduce n for quantity of capsule T                   |
| 4                | Deduce price of n times T from account of C          |

| Scenario ID: SC4 | Corresponds to UC4                                             |
| ---------------- | -------------------------------------------------------------- |
| Description      | Colleague uses n capsules of type T, pays with cash            |
| Precondition     | Colleague has enough cash to pay with                          |
| Postcondition    | Cash account updated, Count of T updated                       |
| Step#            | Step description                                               |
| 1                | Administrator selects capsule type T                           |
| 2                | Administrator selects colleague C                              |
| 3                | Deduce n for quantity of capsule T                             |
| 4                | Increase Cash account balance by the payed amount              |

| Scenario ID: SC5 | Corresponds to UC5                                             |
| ---------------- | -------------------------------------------------------------- |
| Description      | Visitor uses n capsules of type T, pays with cash              |
| Precondition     | Visitor has enough cash to pay with                            |
| Postcondition    | Cash account updated, Count of T updated                       |
| Step#            | Step description                                               |
| 1                | Administrator selects capsule type T                           |
| 2                | Administrator selects the Visitor option                       |
| 3                | Deduce n for quantity of capsule T                             |
| 4                | Increase Cash account balance by the payed amount              |

| Scenario ID: SC6 | Corresponds to UC6                                                 |
| ---------------- | ------------------------------------------------------------------ |
| Description      | Colleague recharges his account                                    |
| Precondition     | Colleague's account already exists                                 |
| Postcondition    | Cash account updated, account of C updated                         |
| Step#            | Step description                                                   |
| 1                | Administrator selects colleague C                                  |
| 2                | Increase balance of account of C of the recharged amount           |
| 3                | Increase Cash account balance by the recharged amount              |

| Scenario ID: SC7 | Corresponds to UC7                                                                     |
| ---------------- | -------------------------------------------------------------------------------------- |
| Description      | Buy n capsules of type C                                                               |
| Precondition     | Capsule type T exists                                                                  |
| Postcondition    | Cash account updated, count of T updated                                               |
| Step#            | Step description                                                                       |
| 1                | Administrator selects capsule of type T                                                |
| 2                | Administrator selects the minimum amount of boxes to get at least n capsules of type T |
| 3                | Administrator submits the selected informations and proceeds with the order            |
| 4                | Administrator receives the order                                                       |
| 5                | Increase count of T by the number of received capsules                                 |
| 6                | Increase Cash account balance by the payed amount                                      |

| Scenario ID: SC8 | Corresponds to UC8                                             |
| ---------------- | -------------------------------------------------------------- |
| Description      | Produce report of Colleague C                                  |
| Precondition     | Colleague's account already exists                             |
| Postcondition    | C's report is shown                                            |
| Step#            | Step description                                               |
| 1                | Administrator selects Colleague C                              |
| 2                | Administrator selects startdate and enddate                    |
| 3                | Administrator submits the selected informations                |
| 4                | Collect all the transactions of C in the selected time range   |
| 5                | Show C's report                                                |

| Scenario ID: SC9 | Corresponds to UC9                                             |
| ---------------- | -------------------------------------------------------------- |
| Description      | Produce consumption report                                     |
| Precondition     | -                                                              |
| Postcondition    | Consumption report is shown                                    |
| Step#            | Step description                                               |
| 1                | Administrator selects startdate and enddate                    |
| 2                | Administrator submits the selected time range                  |
| 3                | Collect all the transactions in the selected time range        |
| 4                | Show consumption report                                        |





| Scenario ID: SCX | Corresponds to UCX                                             |
| ---------------- | -------------------------------------------------------------- |
| Description      | Administrator creates a new type of capsule T and price        |
| Precondition     | T doesn't exist                                                |
| Postcondition    | T created                                                      |
| Step#            | Step description                                               |
| 1                | Administrator inserts name, number of capsules and price for T |
| 2                | Administrator submits the form for T                           |


| Scenario ID: SCX | Corresponds to UCX                                         |
| ---------------- | ---------------------------------------------------------- |
| Description      | Administrator creates a new account for a collegue         |
| Precondition     | Colleague's account doesn't exist                          |
| Postcondition    | Colleague's account created                                |
| Step#            | Step description                                           |
| 1                | Administrator inserts name and surname in the form for C   |
| 2                | Administrator submits the form for C                       |



# Coverage of Scenarios

```
<Report in the following table the coverage of the scenarios listed above. Report at least an API test (defined on the functions of DataImpl only) and a GUI test (created with EyeAutomate) for each of the scenarios. For each scenario, report the functional requirements it covers.
In the API Tests column, report the name of the method of the API Test JUnit class you created. In the GUI Test column, report the name of the .txt file with the test case you created.>
```

### 

| Scenario ID | Functional Requirements covered | API Test(s) | GUI Test(s) |
| ----------- | ------------------------------- | ----------- | ----------- |
| 1           | FR1                             |             |             |
| 2           | FR1                             |             |             |
| 3           | FR1                             |             |             |
| 4           | FR1                             |             |             |
| 5           | FR2                             |             |             |
| 6           | FR3                             |             |             |
| 7           | FR4                             |             |             |
| 8           | FR5                             |             |             |
| X           | FR7                             |             |             |
| X           | FR8                             |             |             |



# Coverage of Non Functional Requirements

```
<Report in the following table the coverage of the Non Functional Requirements of the application - only those that can be tested with automated testing frameworks.>
```

### 

| Non Functional Requirement | Test name |
| -------------------------- | --------- |
|                            |           |

