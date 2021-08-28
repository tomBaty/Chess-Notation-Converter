import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.*;

public class Tests {
    /**
     * Tests for the conversion tool
     * These tests will not work for the assignment! Input is in PGN notation, not long notation.
     * Convert your notation with the tool and create your own tests.
     * 
     *      @input String of PGN notation moves in token form
     *      @board text representation of game's final board
     */
    @Test
    void capablanca1(){
        String input = "1. e4 e5 2. Nf3 Nc6 3. Bc4 Bc5 4. b4 Bxb4 " +
        "5. c3 Ba5 6. d4 exd4 7. O-O d6 8. Qb3 Qe7 9. e5 dxe5 " +
        "10. Ba3 Qf6 11. Nbd2 Bb6 12. Rae1 Nge7 13. Ne4 Qg6 14. Bxe7 Kxe7 " +
        "15. Neg5 f6 16. Qa3+ Nb4 17. Qxb4+ c5 18. Qb3 h6 19. Nf7 Bh3 "+
        "20. g3 Bxf1 21. Nxh8 Rxh8 22. Bxf1 Qf7 23. Nxe5 fxe5 24. Rxe5+ Kf8 "+
        "25. Bc4 Qc7 26. cxd4 cxd4 27. Qf3+";
        String board =  "|_|_|_|_|_|k|_|r|\n"+
                        "|p|p|q|_|_|_|p|_|\n"+
                        "|_|b|_|p|_|_|_|p|\n"+
                        "|_|_|_|_|R|_|_|_|\n"+
                        "|_|_|B|p|_|_|_|_|\n"+
                        "|_|_|_|_|_|Q|P|_|\n"+
                        "|P|_|_|_|_|P|_|P|\n"+
                        "|_|_|_|_|_|_|K|_|\n";
        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void capablanca2(){
        String input = "1. d4 f5 2. e3 Nf6 3. Nf3 e6 4. Bd3 b6 5. b3 Bb7 6. Nbd2 Bb4 "+
        "7. Bb2 Ne4 8. Bxe4 fxe4 9. Ne5 O-O 10. c3 Be7 11. Qg4 Rf5 12. f3 exf3 13. gxf3 Bh4+ "+
        "14. Ke2 Qf6 15. Qh3 d6 16. Ng4 Qe7 17. Rhg1 Kh8 18. d5 e5 19. Nh6 Rh5 20. Nf5 Bc8 "+
        "21. Qxh4 Qxh4 22. Nxh4 Rxh4 23. Rg2 Bh3 24. Rf2 Nd7 25. c4 a5 26. Ne4 h6 27. Nc3 Nc5 "+
        "28. Nb5 Rc8 29. Ba3 e4 30. Bxc5 exf3+ 31. Rxf3 Bg4 32. Kf2 Bxf3 33. Kxf3 bxc5 34. Kg3 Re4 "+
        "35. Re1 Re7 36. e4 Rf8 37. Na7 g5 38. Nc6 Ree8 39. e5 dxe5 40. Rxe5 Rxe5 41. Nxe5 Re8 "+
        "42. Nd7 Re7 43. a4 Re3+ 44. Kg4 Rxb3 45. Kf5 Rb4 46. Ne5 Rxa4 47. Ke6 Rb4 48. Kd7 Rb7 "+
        "49. Nd3 a4 50. Kc8 Rb1 51. Kxc7 Rd1 52. Nxc5 a3 53. d6 a2 54. Nb3 g4 55. d7 h5 56. d8=Q+ Rxd8 "+
        "57. Kxd8 h4 58. c5 g3 59. hxg3 hxg3 60. c6 g2 61. c7";
        String board =  "|_|_|_|K|_|_|_|k|\n"+
                        "|_|_|P|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|N|_|_|_|_|_|_|\n"+
                        "|p|_|_|_|_|_|p|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n";
        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void capablanca3(){
        String input = "1. e4 e5 2. Nf3 Nc6 3. Nc3 Nf6 4. Bb5 Bb4 5. O-O O-O 6. d3 d6 7. Bg5 Ne7 "+
        "8. Ne2 Ng6 9. c3 Ba5 10. Ng3 h6 11. Bxf6 Qxf6 12. Nh5 Qe7 13. h3 c6 14. Bc4 Be6 15. Nd2 Qg5 "+
        "16. Bxe6 fxe6 17. Qg4 Qxg4 18. hxg4 Bc7 19. Nf3 Rae8 20. g5 hxg5 21. Nxg5 Nf4 22. Nxf4 exf4 "+
        "23. f3 e5 24. Rad1 c5 25. Kf2 Bd8 26. Nh3 b5 27. Ke2 Bb6 28. Rh1 Rf6 29. Rh2 Rh6 30. Rdh1 Ree6 "+
        "31. Nf2 Rxh2 32. Rxh2 Rh6 33. Rxh6 gxh6 34. Nh3 Kg7 35. c4 bxc4 36. dxc4 Kg6 37. Kf2 Ba5 38. Ke2 Kh5 "+
        "39. Nf2 Kg5 40. a3 h5 41. Nd3 Kh4 42. b4 Bb6 43. Nb2 Kg3 44. Kf1 h4 45. Na4 cxb4 46. axb4 h3 "+
        "47. gxh3 Kxf3 48. c5 dxc5 49. Nxc5 Kg3 50. Nd3 Bd4 51. b5 Kxh3 52. Ke2 Kg3 53. Ne1 Kg4 54. Nf3 Bc3 "+
        "55. Kf2 Bd4+ 56. Ke2 Kg3 57. Ne1 Ba1 58. Nf3 Bc3 59. Ng5 f3+ 60. Nxf3 Kf4 61. Kf2 Kxe4 62. Ng5+ Kd3 "+
        "63. Kf3 Kc4 64. Ne4 Bd4 65. Nd6+ Kc5 66. Nc8 Kxb5 67. Ke4 a5 68. Nd6+ Kb4";
        String board =  "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|N|_|_|_|_|\n"+
                        "|p|_|_|_|p|_|_|_|\n"+
                        "|_|k|_|b|K|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n";

        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void giri1(){
        String input = "1. e4 c5 2. Nf3 Nc6 3. Bb5 g6 4. O-O Bg7 5. c3 e5 6. Re1 Nge7 7. Na3 O-O "+
        "8. Nc2 d6 9. d3 h6 10. Bc4 Kh7 11. h4 f5 12. g3 f4 13. d4 cxd4 14. cxd4 fxg3 15. fxg3 Qd7 "+
        "16. Kf2 Qh3 17. Bf1 Qh2+ 18. Bg2 Bg4 19. Re3 exd4 20. Rd3 Be5 21. Bf4 Bxf4 22. Nxh2 Bxd1 "+
        "23. Raxd1 Be3+ 24. Ke1 Rf2 25. Rxe3 dxe3 26. Nxe3 Rxb2 27. Rxd6 Rf8 28. Nhg4 Kg7 29. Rd7 Rd8 "+
        "30. Rxd8 Nxd8 31. e5 Rxa2 32. Be4 Nec6 33. Bxc6 Nxc6 34. Nc4 b5 35. Nd6 b4 36. e6 b3 37. Nc4 b2 "+
        "38. Nd2 Ra1+ 39. Ke2 b1=Q 40. Nxb1 Rxb1 41. Kd2 Rg1 42. Ne3 Rxg3 43. h5 Rxe3 44. Kxe3 gxh5 "+
        "45. Ke4 Kf6 46. Kd5 Nd8 47. Kd6 Nxe6";
        String board =  "|_|_|_|_|_|_|_|_|\n"+
                        "|p|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|K|n|k|_|p|\n"+
                        "|_|_|_|_|_|_|_|p|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n";
        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void giri2(){
        String input = "1. f4 Nf6 2. b3 e6 3. Bb2 b6 4. Nf3 Bb7 5. e3 Be7 6. Be2 O-O 7. O-O c5 "+
        "8. c4 Nc6 9. Nc3 d5 10. cxd5 exd5 11. d4 Ng4 12. Qd2 Nxe3 13. Qxe3 cxd4 14. Nxd4 Nxd4 "+
        "15. Bd3 Bc5 16. Qh3 Qh4 17. Qxh4 Nf3+ 18. Kh1 Nxh4 19. f5 Bd4 20. Rf4 Bxc3 21. Bxc3 Nxg2 "+
        "22. Rd4 Nh4 23. Rf1 Rfe8 24. Bd2 Re4 25. Bxe4 dxe4 26. Be3 Re8 27. Rd7 Bc8 28. Rxa7 Nxf5 "+
        "29. Bxb6 e3 30. Kg2 g5 31. Kf3 Nh4+ 32. Kg3 f5 33. h3 f4+ 34. Rxf4 gxf4+ 35. Kxh4 e2 "+
        "36. Bf2 e1=Q 37. Bxe1 Rxe1 38. Ra8 Rc1 39. b4 Rc3 40. b5 Kg7 41. Kg5 f3 42. Ra7+ Kg8 43. Ra4 Rc5+ 44. Kh6 f2 45. Rf4 Rf5";
        String board =  "|_|_|b|_|_|_|k|_|\n"+
                        "|_|_|_|_|_|_|_|p|\n"+
                        "|_|_|_|_|_|_|_|K|\n"+
                        "|_|P|_|_|_|r|_|_|\n"+
                        "|_|_|_|_|_|R|_|_|\n"+
                        "|_|_|_|_|_|_|_|P|\n"+
                        "|P|_|_|_|_|p|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n";
        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void giri3(){
        String input = "1. e4 c6 2. d4 d5 3. Nc3 dxe4 4. Nxe4 Nf6 5. Nxf6+ exf6 6. Nf3 Bd6 7. Bd3 O-O "+
        "8. O-O Bg4 9. Re1 Nd7 10. c3 Qc7 11. h3 Bh5 12. Qc2 Bg6 13. Nh4 c5 14. Nxg6 hxg6 15. Qb3 Rfd8 "+
        "16. Be3 f5 17. Bg5 Nf6 18. Re2 Rac8 19. Bxf6 gxf6 20. Qc4 Kg7 21. b3 cxd4 22. Qxc7 Rxc7 23. cxd4 Bf8 "+
        "24. Bc4 Rxd4 25. a4 f4 26. Ree1 Bc5 27. Rad1 Rcd7 28. Rxd4 Rxd4 29. Kf1 f5 30. Re2 g5 31. Re5 b6 "+
        "32. Rxf5 Rd2 33. Ke1 Rb2 34. Rxg5+ Kf6 35. Rd5 Bxf2+ 36. Kf1 Be3 37. h4 a6 38. h5 Kg7 39. Rf5 f6 "+
        "40. Rd5 Kh6 41. Be2 Rxb3 42. Bxa6 Rb1+ 43. Ke2 Rb2+ 44. Kf3 Rf2+ 45. Ke4 Rxg2 46. Rf5 Kg7 47. Bb5 Rh2 "+
        "48. Kf3 Rh3+ 49. Ke4 Bc1 50. Kd4 Bb2+ 51. Kd5 Bc1 52. Kd4 Kf7 53. Bc4+ Ke7 54. Rd5 Bb2+ 55. Ke4 Be5 "+
        "56. a5 bxa5 57. Rxa5 Rxh5 58. Be2 Rh1 59. Ra6 Rb1 60. Ra7+ Kd6 61. Ra6+ Kc5 62. Ra5+ Kb6 63. Ra6+ Kb7 "+
        "64. Ra3 Rb2 65. Bc4 Kc6 66. Rb3 Rc2 67. Bd3 Rc1 68. Be2 Re1 69. Kf3 Kd5 70. Rd3+";
        String board =  "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|_|_|_|_|p|_|_|\n"+
                        "|_|_|_|k|b|_|_|_|\n"+
                        "|_|_|_|_|_|p|_|_|\n"+
                        "|_|_|_|R|_|K|_|_|\n"+
                        "|_|_|_|_|B|_|_|_|\n"+
                        "|_|_|_|_|r|_|_|_|\n";
        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void levenfish1(){
        String input = "1. e4 e5 2. Nf3 Nc6 3. Bb5 a6 4. Ba4 Nf6 5. O-O Nxe4 6. d4 b5 7. Bb3 d5 8. dxe5 Be6 "+
        "9. c3 Be7 10. Nbd2 Bg4 11. Qe1 Nc5 12. Bc2 Qd7 13. Nd4 Nxd4 14. cxd4 Ne6 15. Nb3 c5 16. f4 c4 17. f5 cxb3 "+
        "18. fxe6 fxe6 19. axb3 Qc6 20. Bd3 g6 21. Qg3 Bf5 22. Bxf5 exf5 23. Bh6 g5 24. Bg7 Rg8 25. Bf6 Bxf6 "+
        "26. Rac1 Qb6 27. exf6 Qxd4+ 28. Kh1 Qxf6 29. Rc7 Rg7 30. Rxg7 Qxg7";
        String board =  "|r|_|_|_|k|_|_|_|\n"+
                        "|_|_|_|_|_|_|q|p|\n"+
                        "|p|_|_|_|_|_|_|_|\n"+
                        "|_|p|_|p|_|p|p|_|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|_|P|_|_|_|_|Q|_|\n"+
                        "|_|P|_|_|_|_|P|P|\n"+
                        "|_|_|_|_|_|R|_|K|\n";

        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void levenfish2(){
        String input = "1. e4 c5 2. Nf3 e6 3. Nc3 Nc6 4. d4 cxd4 5. Nxd4 Nf6 6. Be2 Bb4 7. Bf3 d5 8. exd5 Nxd5 "+
        "9. O-O O-O 10. Ne4 Ne5 11. Be2 Ng6 12. f4 Ndxf4 13. Rxf4 e5 14. c3 Ba5 15. Rf1 exd4 16. cxd4 Bb6 17. Nc5 Qe7 "+
        "18. Qc2 Bd7 19. Bf3 Bb5 20. Rd1 Rad8 21. Nxb7 Rxd4 22. Kh1 Nh4 23. Bd5 Rxd5";
        String board =  "|_|_|_|_|_|r|k|_|\n"+
                        "|p|N|_|_|q|p|p|p|\n"+
                        "|_|b|_|_|_|_|_|_|\n"+
                        "|_|b|_|r|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|n|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|P|P|Q|_|_|_|P|P|\n"+
                        "|R|_|B|R|_|_|_|K|\n";

        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void levenfish3(){
        String input = "1. d4 d5 2. Nf3 Nf6 3. c4 c6 4. e3 e6 5. Nc3 Nbd7 6. Bd3 Bd6 7. O-O O-O 8. e4 dxc4 9. Bxc4 e5 "+
        "10. Bg5 Qa5 11. d5 cxd5 12. Nxd5 Nxe4 13. b4 Bxb4 14. Qb1 Nd2 15. Bxd2 Bxd2 16. Rd1 Bh6 17. Qe4 Nc5 18. Qxe5 Bg4 "+
        "19. Ne7+ Kh8 20. Rd5 b6 21. Nh4 Rae8 22. Re1 Be6 23. Nef5 f6 24. Qe2 Bf7 25. Ne7 Bxd5 26. Neg6+ hxg6 27. Qxe8 Rxe8 "+
        "28. Rxe8+ Kh7 29. Bxd5 Ne6";
        String board =  "|_|_|_|_|R|_|_|_|\n"+
                        "|p|_|_|_|_|_|p|k|\n"+
                        "|_|p|_|_|n|p|p|b|\n"+
                        "|q|_|_|B|_|_|_|_|\n"+
                        "|_|_|_|_|_|_|_|N|\n"+
                        "|_|_|_|_|_|_|_|_|\n"+
                        "|P|_|_|_|_|P|P|P|\n"+
                        "|_|_|_|_|_|_|K|_|\n";

        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }
    @Test
    void enpassantMate(){
        String input = "1. e4 e6 2. d4 d5 3. e5 c5 4. c3 cxd4 5. cxd4 Bb4+ 6. Nc3 Nc6 7. Nf3 Nge7 8. Bd3 O-O "+
        "9. Bxh7+ Kxh7 10. Ng5+ Kg6 11. h4 Nxd4 12. Qg4 f5 13. h5+ Kh6 14. Nxe6+ g5 15. hxg6# 1-0";
        String board =  "|r|_|b|q|_|r|_|_|\n"+
                        "|p|p|_|_|n|_|_|_|\n"+
                        "|_|_|_|_|N|_|P|k|\n"+
                        "|_|_|_|p|P|p|_|_|\n"+
                        "|_|b|_|n|_|_|Q|_|\n"+
                        "|_|_|N|_|_|_|_|_|\n"+
                        "|P|P|_|_|_|P|P|_|\n"+
                        "|R|_|B|_|K|_|_|R|\n";

        Chess.convert(input);
        assertEquals(board,Chess.board.toString());
    }

}
