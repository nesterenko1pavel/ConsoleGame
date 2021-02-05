# About the game
After placing a player on the map, it can be moved. Originally, the map is a 7x7 2D array, and area of visibility is 5x5 (so the console displays a 5x5 array at the beginning of the game). 
When the player approaches to the border of the map, the player's field of vision decreases, and when he is trying to cross the border, map expands to 15x15 (n * 2 + 1). 
The odd size of the map was chosen for placing player in the center of the field of vision. 

### How does map extend: 
`A new array with n * 2 + 1 dimensions (n is the size of the map before expansion) is created, and the old array is copied to the center of it. `

## Available commands: 
1.	***exit*** – exit the program
2.	***setXY*** – setting the player on the map in the given coordinates
3.	***setDefaultXY*** – placing the player in the center of the map
4.	***go*** – move the player around the map. After each movement on the map, the player's age increases by 1. Possible directions:
    * top
    * bottom
    * left
    * right
5.	***generateResources*** – randomly generates resources around the player
6.	***stats*** – displays the player's indicators (amount of money, health, etc.)
7.	***addNotes*** – adding an entry to the player's "notebook"
8.	***deleteNote*** – delete notes by number
9.	***checkNotes*** – displays a list of notes

## Objects on the map: 
1. player
2. an object that gives a random amount of money in the range [1;50]. After researching the cell (2), it turns to 0.
3. an object that removes a random amount of health in the range [1;20]. After researching the cell (3), it turns to 0.
4. an object that gives a random amount of mana in the range [1;20]. After researching the cell (4), it turns to 0.
5. NPC with whom interaction is possible: 
    *	There is a 45% chance of encountering a healer, who can exchange 20 mana for 20 health
    *	There is a 45% chance of encountering a magician, who can exchange 20 money for 20 mana
    *	With a 10% chance, you can meet a trader from whom you can buy a superstar for 100 money. If a player tries to buy a superstar but doesn't have enough money, the trader will offer to dance the tango. If the player agrees, the trader will give him a superstar, but the player will be 50 years older. After researching the cell (5), it remains on the map.
6. an object that gives one superstar. After researching the cell (6), it turns to 0.

## Victory/Defeat
`The player wins by reaching 3 Superstars. The player loses when all health is lost or when he becomes 101 years old. `
