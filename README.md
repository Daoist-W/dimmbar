# Project Dimmbar
> Java application that works with a MySQL Database to provide Stock management for our fictional Bar, Dimmbar

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
> The client requires a backend to be produced using Java where they can do the following:
>
> - Add beers / foods / drinks to the database MySQL
> - Retrieve all items from a table from MySQL
> - Retrieve item by id / name
> - Update items
> - Delete items
>
> At minimum 1 table, the stretch goal would be multiple tables NO NEED TO MAKE THEM RELATIONAL
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

This project started out as a group exercise to allow us to exercise our understanding of JDBC, design patterns, and solid principles. The initial design was a proof of concept 
that gave the team a clearer development direction and met the base goals mentioned above.

![alt text](https://github.com/Daoist-W/dimmbar/blob/main/documents/images/0001.jpg "Initial UML For project")
> Click on Image for better resolution


Once we had reached our initial goal, I wanted to see how much further I could take this simple application. 

The initial design cycle saw me take this to the point where it was scaled up to handle a larger number of table entities, and with a simple terminal-based UI (click here for the link to commit with terminal-based native application).

![alt text](https://github.com/Daoist-W/dimmbar/blob/main/documents/images/0002.jpg "Updated UML For project")
> Click on Image for better resolution

![alt text](https://github.com/Daoist-W/dimmbar/blob/main/documents/images/Login-screenshot.PNG "screen grab of application terminal based ui")
> Click on Image for better resolution

The current design cycle will see me refactor the application into a Spring Boot application, it is far easier to start fresh and reference the old code base than to try and mix the two, so I've taken the approach of starting from a blank Spring Boot template. This design iteration will also feature a Redux/React front end that sends RESTful requests to the web server linked to the backend source code



---

## Getting Started

### Things to note
This app is still in the process of development, so there are some elements that have not been completely implemented yet, and the testing was limited to unit testing at
the time of development. Moving forward there will be much better documentation, testing, and functionality; look forward to the next main branch issue ;)!

To set up the database functionality, please refer to the SQL scripts stored in the following location
-  [https://github.com/Daoist-W/dimmbar/blob/main/documents/user%20setup.sql](https://github.com/Daoist-W/dimmbar/blob/main/documents/user%20setup.sql)
-  [https://github.com/Daoist-W/dimmbar/blob/main/documents/dimmbar.sql](https://github.com/Daoist-W/dimmbar/blob/main/documents/dimmbar.sql)

Assuming you have JDK 8/9/11 and the corresponding JRE, the jar file located on the link below can be run by typing the following commands in your terminal

`cd /path/to/project/root/directory`

and then

`java -jar /path/to/jarfile.jar`

this should execute the jar file and allow you to run the application from your terminal

Alternatively, if you have windows you can simply download the dimmbar.exe file and execute it.

Files:
-  [...](...)
-  [...](...)




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

**Developer:** Don Isiko - isikodon@googlemail.com

Repository Link: [https://github.com/Daoist-W/dimmbar](https://github.com/Daoist-W/dimmbar)