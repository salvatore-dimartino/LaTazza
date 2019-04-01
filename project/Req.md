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


## Non Functional Requirements

| ID        | Type (efficiency, reliability, ..)           | Description  | Refers to |
| ------------- |:-------------:| :-----:| -----:|
|NFR1|Security|The web application must have at most one fault per year| FR\<x>|
|NFR2|Serviceability|It should be easy to add a new product in the shopping cart of the web application| FR\<y>|
|NFR3|Performance|The reorder process can last at most a week| FR\<x>|
|NFR4|Availability|Each different drink product can be unavailable at most for 2 weeks|FR\<y>|