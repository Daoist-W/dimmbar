# Project Dimmbar
> Native exe Java application that works with a MySQL Database to provide Stock management for our fictional Bar, Dimmbar

- [About](#about)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [Licence](#Licence)
- [Contact](#contact)

---

## About

### The Challenge

![Java](https://img.shields.io/badge/-java-blue)
![mysql](https://img.shields.io/badge/-sql-yellow)
![bash](https://img.shields.io/badge/-bash-black)
![GitHub issues](https://img.shields.io/github/issues/Daoist-W/dimmbar)
![GitHub repo size](https://img.shields.io/github/repo-size/Daoist-W/dimmbar)
![GitHub last commit](https://img.shields.io/github/last-commit/Daoist-W/dimmbar)

This application is a solution to a challenge project set by QA Academy Software Development course

The brief is as follows

> Project for 21/01/22
>
> You have been put in charge of running the database software for a trendy bar
>
> The client requires a backend to be produced using Java where they are able to do the following:
>
> - Add beers / foods / drinks to the database MySQL
> - Retrieve all items from a table from MySQL
> - Retrieve item by id / name
> - Update items
> - Delete items
>
> At minimum 1 table, stretch goal would be multiple tables NO NEED TO MAKE THEM RELATIONAL
>
> Your project should make use of the following:
> - SOLID Principles (as best as you can)
> - Generics
> - Optionals
> - Streams (returning data)
> - Exceptions (As well as creating some custom exceptions)
> - Attempt to use some of the design patterns, or make note of what design patterns you could use
>
> You should be able to access the methods using a runner
>
> Stretch goal - Use input scanners to allow the user to specify what they want to do
>
> MAKE A GITHUB REPO AND USE FBM:
> Main -> Dev -> Feature1


### The Approach

This scope that this application has been taken to is well beyond the scope of the original challenge, but I feel that this is the nature of iterative design.

This started out as a group exercise to allow us to exercise our undertsanding of JDBC, design patterns and solid principles. The initial design was a proof of concept 
that gave the team a clearer development direction and met the base goals mentioned above.

![alt text](https://github.com/Daoist-W/dimmbar/blob/main/documents/images/0001.jpg "Initial UML For project")
> Click on Image for better resolution


Once we had reached our initial goal, I wanted to see how much further I could take this simple application, couuld I apply stronger design principles? could I add
functionality in a way that's meaningful? How about deployment? How far can I take what was once a simple terminal application run on the terminal inside an IDE?

The initial area I looked at was the UML diagram, as this is usually my starting point for more complex projects, and after considering the SOLLID principles and design
patterns, I opted for strategy patterns where I had abstract classes or interfaces being extended/implemented by multiple child classes, as well as pushing for segregation
of responsibilty as far as was reasonable for maintainability. The facade pattern was used as a consequence of SOLID, and I also ensured that there were no wasted inherited methods.

![alt text](https://github.com/Daoist-W/dimmbar/blob/main/documents/images/0002.jpg "Updated UML For project")
> Click on Image for better resolution

The result of this was added features such as RBAC, enforced by MYSQL root admin, that restricted what different levels of users could do with the data stored
as well as a more easily extendable code base that mimicks the 3 layer set up often seen in springboot applications.

Further to this, the application has now been packaged and converted to native exe format so it can be executed on any windows OS with the appropriate JRE (associated 
versions for Java 8/9)

moving forward, the aims are to refactor this application into a springboot application, and create a web application front end written in REDUX/REACT to improve upon 
the current terminal based UI.

![alt text](https://github.com/Daoist-W/dimmbar/blob/main/documents/images/Login-screenshot.PNG "screen grab of application terminal based ui")
> Click on Image for better resolution

---

## Getting Started

### Things to note
This app is still in the process of development, so there are some elements that have not been completely implemented yet, and the testing was limited to unit testing at
the time of development. Moveing forward there will be much better documentation, testing and functionality, look forward to the next main branch issue ;)!

To set up the database functionality, please refer to the SQL scripts stored in the following location
-  [https://github.com/Daoist-W/dimmbar/blob/main/documents/user%20setup.sql](https://github.com/Daoist-W/dimmbar/blob/main/documents/user%20setup.sql)
-  [https://github.com/Daoist-W/dimmbar/blob/main/documents/dimmbar.sql](https://github.com/Daoist-W/dimmbar/blob/main/documents/dimmbar.sql)

Assuming you have JDK 8/9/11 and the corresponding JRE, the jar file located on the link below can be run by typing the following commands in your terminal

`cd /path/to/project/root/directory`

and then

`java -jar /path/to/jarfile.jar`

this should execute the jar file and allow you to run the application from your terminal

Alternatively, if you have windows you can simply download the dimmbar.exe file and excute it.

Files:
-  [https://github.com/Daoist-W/dimmbar/blob/main/target/dimmbar.exe](https://github.com/Daoist-W/dimmbar/blob/main/target/dimmbar.exe)
-  [https://github.com/Daoist-W/dimmbar/blob/main/target/dimmbar-1.0-DFESW7-jar-with-dependencies.jar](https://github.com/Daoist-W/dimmbar/blob/main/target/dimmbar-1.0-DFESW7-jar-with-dependencies.jar)




---

## Usage




---

## Contributing

1. Fork the project
2. Create a feature branch: `git checkout -b feature-branch`
3. Commit your changes: `git commit -am 'Added new features'`
4. Push your changes: `git push origin feature-branch`
5. Create a pull request

---

## Licence

Distributed under the MIT Licence.

---

## Contact

**Developer:** Don Isiko - don.k.isiko@gmail.com

Repository Link: [https://github.com/Daoist-W/dimmbar](https://github.com/Daoist-W/dimmbar)
