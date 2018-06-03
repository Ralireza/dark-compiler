package ir.mrbug.darkcompiler;

class Gramer {
    public static String laws =
            "S -> if ( E ) { S } X \n" +
                    "X -> else { S } S | S\n" +
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
            "S -> while ( E ) { S } S\n" +
                    "S -> MATCHED | UNMATCHED \n" +
                    "UNMATCHED -> if ( E ) { S } S\n" +
                    "UNMATCHED -> if ( E ) { MATCHED } else { UNMATCHED } S\n" +
                    "MATCHED -> if ( E ) { MATCHED } else { MATCHED } S\n" +
                    "MATCHED -> E ; S | EPSILON \n"+
                    "UNMATCHED -> E ; S | EPSILON \n"+
                    "S -> E ; S | EPSILON \n"+*/
/*
* our grammar is :
*
* S -> if (E) {S} S
* S -> if (E) {S} else {S} S
* S -> while (E) {S} S
* S -> E ; S
* S -> ϵ
* E -> E + T |T
* T -> T * F | F
* F -> (E) | id
*
* */