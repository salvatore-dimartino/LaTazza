# Functional and non functional requirements

## Functional Requirements

| ID        | Description  |
| ------------- |:-------------:| 
|FR1|The Employee shall be able to order from the drinks from the Cofee Manager|  
|FR2| The Visitor shall be able to order from the drinks from the Cofee Manager|
|FR3|The Cofee Manager shall be able to contact the LaTazza driver and the Warehouse worker when no longer has stocks|
|FR4|When the Coffe Manager orders the Warehouse worker shall be able to charge the drinks on the van|
|FR5|When the LaTazza driver has the drinks he shall be able to transport it to the Coffee Manager|
|FR6|When the application has a fault the System Admin shall be able to repair it|

## Non Functional Requirements

| ID        | Type (efficiency, reliability, ..)           | Description  | Refers to |
| ------------- |:-------------:| :-----:| -----:|
|NFR1|Security|The application has at most one fault per year| FR\<x>|
|NFR2|Serviceability|Should be easy to add a new product in the application| FR\<y>|
|NFR3|Performance|The reorder process can last a week| FR\<x>|
|NFR4|Availability|Every drinks costs at most 5 dollars|FR\<y>|