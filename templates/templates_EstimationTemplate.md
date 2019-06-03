# Project Estimation  template

Authors: Francesco Dibitonto s265421 Federico Silvio Gorrino s262948 Salvatore Di Martino s267553

Date: 5/30/2019

Version: 1.1

# Contents

- [Data from your LaTazza project](#data-from-your-latazza-project)
- [Estimate by product decomposition](#estimate-by-product-decomposition)
- [Estimate by activity decomposition ](#estimate-by-activity-decomposition)



# Data from your LaTazza project

###
|||
| ----------- | ------------------------------- | 
|         Total person hours  worked by your  team, considering period March 5 to May 26, considering ALL activities (req, des, code, test,..)    | 225  |             
|Total Java LoC delivered on May 26 (only code, without Exceptions, no Junit code) | 869 |
| Total number of Java classes delivered on May 26 (only code, no Junit code, no Exception classes)| 9 |
| Productivity P =| 869/28 person days(225 hours) =  31 |
|Average size of Java class A = | 96.5 LOC |

# Estimate by product decomposition



### 

|             | Estimate                        |             
| ----------- | ------------------------------- |  
| Estimated n classes NC (no Exception classes)  |          10                   |             
| Estimated LOC per class  (Here use Average A computed above )      |   110                         | 
| Estimated LOC (= NC * A) | 1100 |
| Estimated effort  (person days) (Here use productivity P)  |    1100/31=35.5                                  |      
| Estimated calendar time (calendar weeks) (Assume team of 4 people, 8 hours per day, 5 days per week ) |        5 march - 11 march (one week)             |               


# Estimate by activity decomposition



### 

|         Activity name    | Estimated effort    |             
| ----------- | ------------------------------- | 
| Requirements | 5 person days |
| Design | 4 person days |
| Coding | 12 person days |
| Testing | 10 person days |
| System Testing | 4 person days |
| Project management | 4 person days |


###
Insert here Gantt chart with above activities

```plantuml
@startgantt
project starts the 2019/03/5
sunday are closed
saturday are closed
[Requirements] lasts 2 days and is colored in Lavender/LightBlue
[Design] lasts 1 days and starts 1 days after [Requirements]'s end and is colored in Lavender/LightBlue
[Coding] lasts 3 days and starts 1 days after [Design]'s end and is colored in Lavender/LightBlue
[Testing] lasts 3 days and starts 1 days after [Coding]'s end and is colored in Lavender/LightBlue
[System Testing] lasts 1 days and starts 1 days after [Testing]'s end and is colored in Lavender/LightBlue
[Project Management] lasts 1 days and starts 1 days after [System Testing]'s end and is colored in Lavender/LightBlue
@endgantt
```

