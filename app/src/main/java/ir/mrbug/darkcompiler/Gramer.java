package ir.mrbug.darkcompiler;

class Gramer {
    public static String laws =
            "S -> if ( E ) { S } S\n" +
                    "S -> if ( E ) { S } else { S } S\n" +
                    "S -> while ( E ) { S } S\n" +
                    "S -> E ; S | EPSILON \n"+
                    "E -> T D \n" +
                    "D -> + T D | EPSILON \n" +
                    "T -> F G \n" +
                    "G -> * F G | EPSILON \n" +
                    "F -> id \n";
}


/*
*
* E -> E + T |T
* T -> T * F | F
* F -> (E) | id
*
* */