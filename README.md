This is a tool created to help out SWEN221 students with the Chess assignment.
When I was doing the assignment, I found myself spending hours and hours writing
out chess moves by hand and creating text based boards just to reach the 100 tests
requirement. 
This seemed incredibly unproductive and far more time-consuming than any other part
of the assignment, and so that future students don't have to go through what I went through, 
I've made a tool that can automate the annoying parts of the test creation process.

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
4. Select appropriate format needed- use 'Test Contents' to get a fully generated test.
5. Create a new test shell in you Chess tests file : eg
    @Test public void knightPromotion(){

    }
    and copy paste the contents of the tool's output pane into the test.

TO START THE TOOL:
1. Navigate to where you have downloaded the jar in console
2. Run the command "java -jar --enable-preview ChessNotationConverter.jar"
3. If the tool doesn't launch, make sure you have the latest version of java




@ Tom Baty 2021



