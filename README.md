# Chess-Battle
A fun chess-like board game that utilizes major Object-Oriented Programming concepts.

## About the Game:
There are 2 teams: Team Blu and Team Red.    
Each Team starts off with 6 pieces (one of each of these):
* Buzz (B)
* Minion (M)
* EvilMinion (E)
* BlueHen (H)
* PowerPuff (P)
* SpanishBuzz (S)

<img src="https://static.wikia.nocookie.net/mugen/images/5/56/Buzz_Lightyear_TS4.png/revision/latest?cb=20210702233122" width="65"/>    <img src="https://www.nicepng.com/png/full/918-9180199_minions-png.png" width="55"/>    <img src="https://i.pinimg.com/originals/db/6d/46/db6d464fcee21800440b5c90ea0fc446.png" width="120"/>     <img src="https://bluehens.com/images/logos/site/site.png" width="90"/>    <img src="https://www.pngall.com/wp-content/uploads/12/Powerpuff-Girls-No-Background.png" width="125"/>     <img src="https://static1.personality-database.com/profile_images/8e50c25b61fb45f4a4d0f99159e468a8.png" width="110"/>

### There are 5 possible actions/moves that a player can do:
* **Move (M)** - move the piece on the FROM-square to another (empty) spot (the TO-square) on the board
* **Attack (A)** - attack the piece on the TO-square with the piece on the FROM-square (can only attack pieces on other team) (removes the attacked piece from the board)
* **Recruit (R)** - recruit the piece on the TO-square with the piece on the FROM-square (makes the TO-square piece become part of the FROM-square piece’s team)
* **Spawn (S)** - create and add a new piece of the same type as the FROM-square piece to the board and place it on the TO-square (the new piece will be part of the FROM square piece’s team)
* **Moonwalk (W)** - move the piece on the FROM-square backwards three spaces to the TO-square and “push” any pieces (doesn’t matter what team they’re on) on those spaces to new random locations on the board (only SpanishBuzz can do this action!) 

**Objective of the Game:** Attack the other team's pieces 15 times first

## How to Play:
* When the player starts the game, the board will appear/print with all the game pieces in random positions on the board
  * Each team’s pieces will be listed below the board
  * It will say which team’s turn it is (always starts with Team Blu)
* When prompted, the player will enter the action/move they would like to do
  * The player will enter the coordinates of the position of the piece they would like to do the action with (should be a piece from their team), and then the coordinates of the position of the piece (or the coordinates of the space on the board) they would like to do the action to
* The board will print again with any appropriate changes made to the pieces on the board and the lists of the pieces in each team
* The next team will go and repeat the above

### Special Functionalities:
* There is a **hidden board square/space** in every game
  * Its location on the board is chosen at random each game
  * Any piece that lands on this square gets taken off the board / disappears
* If any piece can reach **5 number of attacks** in a game, that piece’s team gets another turn

## Valid Action Paths:
|                       | Move                                                                                          | Attack                                                               | Recruit                                                           | Spawn                                                             | *Notes*                                                                                                                                                                                                                                                                                      |
|-----------------------|-----------------------------------------------------------------------------------------------|----------------------------------------------------------------------|-------------------------------------------------------------------|-------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|    **Piece Buzz (B)**        | Anywhere                                                                                      | Left and right  OR two spaces up or down                             | N/A                                                               | N/A                                                               | N/A                                                                                                                                                                                                                                                                                        |
|    **Piece Minion (M)**      | Up or down OR Two spaces left or right                                                        | N/A                                                                  | Up or down OR Two spaces left or right                            | Nearest empty corner                                              | Can only spawn up to 3 pieces                                                                                                                                                                                                                                                              |
|    **Piece EvilMinion (E)**  | Up or down OR Two spaces left or right                                                        | Up or down OR Two spaces left or right                               | Up or down OR Two spaces left or right                            | Up or down OR Two spaces left or right                            | Can only attack up to 4 pieces; Can only spawn up to 3 pieces                                                                                                                                                                                                                              |
|    **Piece BlueHen (H)**     | If can fly: anywhere on board  If can’t fly: one space in any direction, including diagonally | If can fly: anywhere on board  If can’t fly: one space left or right | If can fly: anywhere on board  If can’t fly: one space up or down | If can fly: anywhere on board  If can’t fly: one space diagonally | Can’t fly after 3 attacks                                                                                                                                                                                                                                                                  |
|    **Piece Powerpuff (P)**   | One space forward or backward                                                                 | Two squares forward and one to the left or right                     | One space left or right                                           | One space diagonally                                              | Can only spawn up to 3 pieces; Can’t attack if piece on left or right is also a Powerpuff                                                                                                                                                                                                  |
|    **Piece SpanishBuzz (S)** | Three spaces diagonally                                                                       | Three spaces forward                                                 | N/A                                                               | N/A                                                               | Can do an additional move called  Moonwalk: moves backwards three spaces and “pushes” any pieces on those spaces to new random locations on the board (can only do this once in a game and only if the piece isn't three spaces to the edge of the board (so it doesn’t go out of bounds)) |
