README

I recently solved the Puzzle "Asterix: Total verflixt". (http://www.spielarchiv.de/spiel/a/asterixtotalverflixt/asterixtotalverflixt.htm)
It consists of nine cards each showing on each side the upper or lower half of one of four Figures.
The goal of the puzzle is to put all nine cards in a 3x3 grid so everything fits.
You can see how all cards look like here: http://i70.servimg.com/u/f70/12/90/55/20/mini-v27.jpg

So I solved the puzzle and found a solution - what could a programming project be good for?
First, I program this down to show how to program it down.
Second, I'm curious whether the solution I found is the only one or if it is just one out of many solutions.
Third, I can programm down different strategies to find the solution to find a more efficient one than brute force (which will be the first to start with).
Fourth, if I scan in the cards, I can try to visualize my solution with JavaFX or something.

Outline

The Idea of the brute force solution algorithm is that I start with a deck of all cards and an empty grid and then recursively
- take the next card from the deck
- iterate over all orientations
- put the card into the next free position in the grid
- if no conflicts are in the grid, recurse further
- otherwise, return an empty list. (because on this path no solution can be found.
