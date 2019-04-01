# Functional and non functional requirements

## Functional Requirements

| ID        | Description  |
| ------------- |:-------------:| 
|FR1|The Employee shall be able to order the boxes of capsules from the Coffee Manager|  
|FR2|The Visitor shall be able to order the boxes of capsules from the Coffee Manager|
|FR3|The Coffee Manager shall be able to buy the boxes of capsules on the LaTazza web application|
|FR4|When an order comes the LaTazza system should be able to comunicate to the Warehouse worker that he has to put the boxes of capsules on the transport vehicle|
|FR5|When the LaTazza driver has the boxes of capsules he shall be able to transport it to the Coffee Manager's company|
|FR6|When the web application has a fault the System Admin shall be able to repair it|
|FR7|The system should be able to handle correctly the registation requests of the customers and store theirs profiles into its costumer profiles database|
|FR8|The system should be able to handle correctly the payment procedure with the payment system, storing each transaction into the transactions database|
|FR9|The Coffee Manager shall be able to sell the capsules to clients|
|FR10|The Coffee Manager shall be able to manage credit and debt of the employees|
|FR11|The Coffee Manager shall be able to check the number of capsules per type in the inventory|
|FR12|The Coffee Manager shall be able to check the total checkout on his own cash account|

## Non Functional Requirements

| ID        | Type (efficiency, reliability, ..)           | Description  | Refers to |
| ------------- |:-------------:| :-----:| -----:|
|NFR1|Reliability|The web application must have at most one fault per year|FR6|
|NFR2|Usability|The system shall be easy to use|FR1 FR3 FR7 FR8 FR9 FR10 FR11 FR12|
|NFR3|Performance|The payment and registration procedure should last at most 30 seconds|FR1 FR8|
|NFR4|Availability|Each different drink product can be unavailable at most for a week|FR3 FR4 FR5|
|NFR5|Capacity|The system should be able to save 4Tb of Data|FR7 FR8|
|NFR6|Security|The transaction and the data of all actors should be encrypted|FR1 FR7 FR8|
|NFR7|Interoperability|The system should be run on smartphone and pc|FR1 FR3 FR7 FR8 FR9 FR10 FR11 FR12|
|NFR8|Data integrity|The system adopts a two phase locking mechanism to guarantee coherence and consistance of data|FR7 FR8|
|NFR9|Recoverability|The system transaction steps are written on a safety log, in away in case of fault the transaction can be restore successfully|FR7 FR8|
|NFR10|Recoverability|The system transactions and the customer accounts are also stored on 3 different backup servers|FR7 FR8|
|NFR11|Domain|The currency is dollars|FR1 FR2 FR3 FR8
|NFR12|Capacity|The minimum number of capsules per type in the Werehouse is 20|FR4|