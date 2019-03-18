# Requirements Document Template

Authors:

Date:

Version:

# Contents
- [Stakeholders](#stan)
- [Context Diagram and interfaces](#cds)
	+ [Context Diagram](#cd)
	+ [Interfaces](#itf) 
- [Stories and personas] (#st)
- [Functional and non functional requirements](#reqs)
	+ [Functional Requirement] (#fr)
	+ [Non functional requirements](#nf)
- [Use case diagram and use cases](#ucs)
	+ [Use case diagram](#ucd)
	+ [Use cases](#uc)
	+ [Relevant scenarios](#sc)
- [Glossary](#gl)
- [System design](#sd)

<div id="stan"></div>

# Stakeholders

\<Define>

| Actor | Logical Interface | 
| ------------- |:-------------:|
|       |  | 

<div id="cds"></div>

# Context Diagram and interfaces

<div id="cd"></div>

## Context Diagram
\<Define here Context diagram using UML use case diagram>

\<actors are a subset of stakeholders>

<div id="itf"></div>

## Interfaces
| Actor | Logical Interface | Physical Interface  |
| ------------- |:-------------:| -----:|
|       |  |  |

<div id="st"></div>

# Stories and personas
\<A Persona is a realistic impersonation of an actor. Define here a few personas and describe in plain text how a persona interacts with the system>

\<Persona is-an-instance-of actor>  \<stories will be formalized later as use cases>


<div id="reqs"></div>

# Functional and non functional requirements

<div id="fr"></div>

## Functional Requirements

\<In the form DO SOMETHING, or VERB NOUN, describe high level capabilities of the system> <will match to high level use cases>

| ID        | Description  |
| ------------- |:-------------:| 
|  FR1     |  |  
|  FR2     |  |
|  ...     |  |

<div id="nf"></div>

## Non Dunctional Requirements

\<Describe constraints on functional requirements>

| ID        | Type (efficiency, reliability, ..)           | Description  | Refers to |
| ------------- |:-------------:| :-----:| -----:|
|  NFR1     |  |  | FR\<x>|
|  NFR2     |  |  | FR\<y>|
|  ...     |  |  | FR\<x>|


<div id="ucs"></div>

# Use case diagram and use cases


<div id="ucd"></div>

## Use case diagram
\<define here UML Use case diagram UCD summarizing all use cases, and their relationships>

<div id="uc"></div>

## Use Cases
\<describe here each use case in the UCD>

### Use case 1, UC1
| Actors Involved        |  |
| ------------- |:-------------:| 
|  Precondition     | \<Boolean expression, must evaluate to true before the UC can start> |  
|  Post condition     | \<Boolean expression, must evaluate to true after UC is finished> |
|  Nominal Scenario     | \<Textual description of actions executed by the UC> |
|  Variants     | \<other executions, ex in case of errors> |

### Use case 2, UC2

### Use case \<n>


<div id="sc"></div>

# Relevant scenarios
State at which UC the scenario refers to
\<a scenario is a sequence of steps that corresponds to a particular execution of one use case>
\<a scenario is more formal description of a story>
\<only relevant scenarios should be described>

##Scenario 1

| Scenario ID: SC1        | Corresponds to UC:  |
| ------------- |:-------------:| 
| Step#        | Description  |
|  1     |  |  
|  2     |  |
|  ...     |  |

##Scenario 2

...

<div id="gl"></div>

# Glossary

\<use UML class diagram to define important concepts in the domain of the system, and their relationships>  <concepts are used consistently all over the document, ex in use cases, requirements etc>

<div id="sd"></div>

# System Design
\<describe here system design> <must be consistent with Context diagram>
