# LPOO1617_T6G6

#### Group members

- Francisca Leão Cerquinho Ribeiro da Fonseca - up201505791
- Mariana Lopes Silva - up201506197

# Architecture Design

## Package and class diagram (UML), documenting (describing) each class' responsibility:
![](https://cloud.githubusercontent.com/assets/22835568/25563546/e6f2741a-2d95-11e7-8320-9f0709b40330.png)

- ### Minion Jump
Encharge of game logic. This is the main class.
- ### Entity
This class defines all the characteristics common to all entities of the game.
- ### Villain
This class defines the behavior of the villain.
- ### Minion
This class defines the behavior of the minion (character moved by the user).
- ### Platform
This class define platforms where minion walks.


## Design of behavioural aspects:
![](https://cloud.githubusercontent.com/assets/22794956/25520108/933c2752-2bf2-11e7-969d-e11f7be1f61e.png)
![](https://cloud.githubusercontent.com/assets/22835568/25563546/e6f2741a-2d95-11e7-8320-9f0709b40330.png)
## Design Patterns:
1. Singleton - for the main game class (provisory).

# GUI Design
## Listing of the main functionalities:
1. The game will be playable in Single Player.
2. The game keeps scores of single player game runs.
3. The settings of the game will allow for a player to turn off the sound in the game.
4. The game will be able to share a post on Facebook upon player's request.
## GUI mock-ups:
<p>
Main Menu

![](https://cloud.githubusercontent.com/assets/22835568/25562908/32a8b318-2d89-11e7-90cc-62002322f5d7.png "Main Menu")
<p>
Score Menu

![](https://cloud.githubusercontent.com/assets/22835568/25562909/32af0f56-2d89-11e7-90b6-2fe3d179046d.png "Score Menu")
<p>
Settings Menu

![](https://cloud.githubusercontent.com/assets/22835568/25562910/32afa9de-2d89-11e7-8436-5dccf40c2be5.png "Settings Menu")
<p>
Game Mode

![](https://cloud.githubusercontent.com/assets/22835568/25562911/32b5f5dc-2d89-11e7-8443-aa50e5ef65b3.png "Game Mode")

# Test Design
## Listing of the expected final test cases:
1. Test randomness of the platform.
2. Test out-of-bounds behaviour.
3. Test player losing.
4. Test randomness movement of the villain.
5. Test highscore saving.
