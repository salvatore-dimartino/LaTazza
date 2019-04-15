# General instructions for the design

The design of your software project will have to include the packages of the template project provided. You must also consider the classes you added for the Package and Class diagram.

For the design assignment follow the guidelines in the Design Template markdown file provided in the template folder of the repository.

# General instructions for development

To work on the project, you will have to follow these steps:

1. Clone the project in a local folder of your pc;
2. From Eclipse IDE, import a Maven project (File -> Import -> Maven -> Existing Maven Projects);
3. Update the project (right click on the project name in the left part of the IDE, then click Maven -> Update Project; enable the checkbox *Force Update of Snapshot/Releases*, then click on *OK*).

At this point you can work on the class `DataImpl.java`. You will find the methods' documentation in the interface `DataInterface.java`. Do not modify the interface `DataInterface.java` or the methods' signatures.

You can create whatever class or package you identify as necessary for the implementation of the requirements of the project.

## Database implementation

The final project must implement data persistency. To do so, a database may be needed. If choose to use a database, to make the project portable, you will have to use an embedded database, that is a database that stores the data in local files. [H2](https://www.h2database.com/html/main.html), [DerbyDB](https://db.apache.org/derby/) and [SQLite](https://www.sqlite.org/index.html) are the suggested alternatives for this purpose.

You can also create JSON, XML, or CSV files of your own to store the data of the application, or properly serialize/deserialize Java objects into local files.

## Use of remote libraries

You can use external libraries, that must be declared in the pom.xml to be imported with Maven.

To do so, add a dependency tag in the end of the pom.xml file. The format of the dependency tag is as follows:

```
<dependency>
    <groupId>it.polito.latazza</groupId>
    <artifactId>latazza-gui</artifactId>
    <version>1.0.0</version>
</dependency>
```

You will find the proper tag in the documentation of the library you want to import, or on https://mvnrepository.com/.

After you modify the pom.xml file, you have to perform again a Maven Update of the project (see point 2 for details).

## What to upload on the GitLab project

* Implementation of the template project.

## What to NOT upload on the GitLab project

* Binaries;
* IDE configuration files (e.g., `.project`, `.classpath`). Make sure to include them in the `.gitignore` file before committing;
* Database files. 

# Scheenshots

![](figures/initial.png)
![](figures/add_beverage.png)
![](figures/add_employee.png)
![](figures/recharge_employee.png)
![](figures/recharge_employee_conf.png)
![](figures/supply_box.png)
![](figures/supply_conf.png)
![](figures/sale_employee.png)
![](figures/sale_visitor.png)
![](figures/log_menu.png)
![](figures/log_all.png)
![](figures/log_employee.png)
