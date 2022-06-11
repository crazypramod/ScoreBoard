ScoreBoard application
=====

About the board
=====
The board supports the following operations:
1. Start a game. When a game starts, it should capture (being initial score 0 – 0):
    a. Home team
    b. Away team
2. Finish game. It will remove a match from the scoreboard.
3. Update score. Receiving the pair score; home team score and away team score
   updates a game score.
4. Get a summary of games by total score. Those games with the same total score will
   be returned ordered by the most recently added to our system.

Getting Started
====
Recommended tools
====

1. IntelliJ IDEA
2. Java JDK 11
3. Apache maven latest version

Build & Tests
====
On a windows machine, 
1. Install latest version of maven and add bin path to Path variable
2. Cmd into source directory ../ScoreBoard and run the following command,

`mvnw clean install`

Start the application
====
On a windows machine, cmd into source directory ../InstApp and run the following command,

`mvnw spring-boot:run`

Application will run by default on port 8060

Todo
====
1. Format result as per expectations 