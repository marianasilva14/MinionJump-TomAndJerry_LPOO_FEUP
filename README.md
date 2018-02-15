# LPOO1617_T6G6

# Architecture Design

## Package and class diagram (UML), documenting (describing) each class' responsibility:
![](https://cloud.githubusercontent.com/assets/22835568/25567109/8f3a4c4a-2dde-11e7-8ac0-c9cb16f14368.png)

- #### Minion Jump
Encharge of game logic. This is the main class.
- #### Entity
This class defines all the characteristics common to all entities of the game.
- #### Villain
This class defines the behavior of the villain.
- #### Minion
This class defines the behavior of the minion (character moved by the user).
- #### Platform
This class define platforms where minion walks.
- #### PlatformBehavior
Responsible to behavior of the platform.
- #### NormalPlatform
Class responsible for normals platforms.
- #### SpringPlatform
Class responsible for platforms with springs. This type of platform is where minion achieve more height with help of spring.
- #### SplitPlatform
Class responsible for split platforms. This type of platform breaks down and the minion ends up falling.
- #### RocketPlatform
Class responsible for platforms with rockets. This type of platform is where minion achieve more height than platform with spring, with help of rocket.

## Design of behavioural aspects:
![](https://cloud.githubusercontent.com/assets/22835568/25565858/a254a418-2dc7-11e7-8385-bae2c8e49209.png)
![](https://cloud.githubusercontent.com/assets/22835568/25567332/1359a922-2de3-11e7-8ce6-8d0f210aa065.png)

## Design Patterns:
1. Singleton - for the main game class.
2. Strategy - for the different types of platforms: platform with spring, with rocket or normal and split platform.

# GUI Design
## Listing of the main functionalities:
1. The game will be playable in Single Player.
2. The game keeps scores of single player game runs.
3. The settings of the game will allow for a player to turn off the sound in the game.

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
<p>
Game Over

![](https://cloud.githubusercontent.com/assets/22835568/25565939/d3bf3d5a-2dc8-11e7-9fff-ac54be19d603.png "Game over")

# Test Design
## Listing of the expected final test cases:
1. Test randomness of the platform.
2. Test out-of-bounds behaviour.
3. Test player losing.
4. Test randomness movement of the villain.
5. Test highscore saving.



#### Group members

- Francisca Leão Cerquinho Ribeiro da Fonseca - up201505791
- Mariana Lopes Silva - up201506197
