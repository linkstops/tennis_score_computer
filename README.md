# tennis_score_computer
This Kata goal is to implement a simple tennis score computer.

The scoring system consist in one game, divided by points :
Each player starts a game with 0 point.
If the player wins the 1st ball, he will have 15 points. 2nd balls won : 30 points. 3rd ball won : 40points.
If a player have 40 points and wins the ball, he wins the game, however there are special rules.
If both players have 40 points the players are “deuce”.
If the game is in deuce, the winner of the ball will have advantage
If the player with advantage wins the ball he wins the game
If the player without advantage wins the ball they are back at “deuce”.

You can found more details about the rules here : ( http://en.wikipedia.org/wiki/Tennis#Scoring )

Here we want you to develop a java method that will take a String as input containing the character ‘A’ or ‘B’. The character ‘A’ corresponding to “player A won the ball”, and ‘B’ corresponding to “player B won the ball”. The java method should print the score after each won ball (for example : “Player A : 15 / Player B : 30”) and print the winner of the game.

For example the following input “ABABAA” should print :
“Player A : 15 -- Player B : 0”
“Player A : 15 -- Player B : 15”
“Player A : 30 -- Player B : 15”
“Player A : 30 -- Player B : 30”
“Player A : 40 -- Player B : 30”
“Player A wins the game


## Comment exécuter le projet

1. Assurez-vous d'avoir installé JDK 22 ou une version ultérieure.
2. Clonez le dépôt ou téléchargez les fichiers sources.
3. Naviguez vers le répertoire du projet.
4. Utilisez Maven pour compiler et exécuter l'application :

mvn clean install
mvn exec:java -Dexec.mainClass="tennis.TennisApplication.java"
