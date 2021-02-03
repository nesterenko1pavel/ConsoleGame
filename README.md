# About the game
После установки игрока на карту его можно передвигать. Изначально карта - это двумерный массив 7x7, а область видимости 5x5 (поэтому вначале игры в консоли выводится массив 5x5). 
При приближении к границе карты область видимости игрока уменьшается, и при попытке переступить границу карты, она расширяется до 15x15 (n*2+1). 
Нечетный размер карты выбран с целью размещения игрока в центре области видимости, что нарушается только при приближении к границе. 

### Как происходит расширение карты: 
`Создается новый массив размерности n*2+1 (n - размер карты до расширения), и в центр него копируется старый массив. `

## Доступные игроку команды: 
1.	***exit*** – выход из программы
2.	***setXY*** – установка игрока на поле в заданные координаты
3.	***setDefaultXY*** – установка игрока в центр карты
4.	***go*** – передвижение игрока по карте. После каждого хода по карте возраст игрока увеличивается на 1. Возможные направления: 
    * top
    * bottom
    * left
    * right
5.	***generateResources*** – рандомно генерирует ресурсы вокруг игрока
6.	***stats*** – выводит на экран показатели игрока (количество money, health и т.д.)
7.	***addNotes*** – добавление записи в “блокнот” игрока 
8.	***deleteNote*** – удаление записи по номеру
9.	***checkNotes*** – выводит на экран список заметок

## Объекты, которые есть на карте: 
1. игрок
2. объект, который дает случайное количество money в диапазоне [1;50]. После изучения клетки (2) она превращается в 0.
3. объект, который снимает случайное количество health в диапазоне [1;20]. После изучения клетки (3) она превращается в 0.
4. объект, который дает случайное количество mana в диапазоне [1;20]. После изучения клетки (4) она превращается в 0.
5. NPC, с которым возможно взаимодействие: 
    *	С шансом 45% попадется healer, который обменяем 20 mana на 20 health
    *	С шансом 45% попадется magician, который обменяет 20 money на 20 mana
    *	С шансом 10%, попадется trader, у которого можно будет купить superstar за 100 money. Если игрок попытается купить superstar, но окажется, что у него недостаточно money, торговец предложит станцевать танго. Если игрок согласиться, торговец даст ему superstar, но игрок постареет на 50 лет. После изучения клетки (5) она остается на карте.
6. объект, который дает одну суперзвезду. После изучения клетки (6) она превращается в 0.

## Victory/Defeat
`Игрок выигрывает при достижении 3 суперзвезд. Игрок проигрывает при потере всего здоровья либо при достижении возраста 101 год. `