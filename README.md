Tool made for more efficiently creating tests for the swen221 chess assignment. In my opinion, you won't learn anything from spending
hours hand editing chess notation that you wouldn't learn from making one, so why not make the 100 tests requirement a little easier.

NOTE:
Wrote most of this code in second year, so there may be bugs. I've tested fairly thoroughly and haven't found any, but keep it in mind.

HOW TO USE:

1. Get PGN notation for a game: these can be easily sourced from any web-based chess site as it is the
standard notation for chess games. I would suggest sites like:
    - https://theweekinchess.com/a-year-of-pgn-game-files for full professional games. These can be useful if you think 
      your code is up to scratch and want to test in-depth games that are likely to have every chess rule utilized.
    - https://lichess.org/analysis is a very useful tool for creating your own games, simply make the moves you want to test
      and copy the PGN from the field below the board. 
2. GOOD NOTATION: 1. e4 e5 2. Nf3 Nc5
   BAD NOTATION : 1.e4 e5 2.Nf3 Nc5
   The tool runs on a token-based scanner that must have seperated turn counts and moves. It will not be able to parse moves
   if they are not clearly distinct from turn counts.
   Also, some games may have a header ([Event "Aimchess US Rapid Prelim"]...), or comments inside the game. Do not include these, only moves.
3. Copy PGN into left-hand input box in the program.
4. Create a new test shell in you Chess tests file : eg
    @Test public void knightPromotion(){

    }
    and copy paste the contents of the tool's output pane into the test.

TO START THE TOOL:
1. Run the jar file. Might need latest java.

- Tom



