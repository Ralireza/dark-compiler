/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.mrbug.darkcompiler;
import java.util.Stack;


/**
 *
 * @author ali
 */
public class parser {

    private String result = "";
    private Stack<String> symbols = new Stack<>();
    private Stack<String> stack = new Stack<>();
    private scanner codescanner;
    private token currentToken;
    private String input, action, symbol;
    private int currentState = 0;



    public parser(String code) {
        codescanner = new scanner(code);
        currentToken = codescanner.nexttoken();
    }

    public String parsCode() {
        stack.push("0");

        while (currentToken != null) {
            symbol = currentToken.name;
            input = "" + currentState + currentToken.name;
            action = lows.actionGotoTable.get(input);
//            System.out.println(symbol);
//            System.out.println(action);

            if (symbol.equals("eror")) {
                result +=" \tlexeme error !!! ";
                break;
            }

            else if (action == null) {
                result +=" \tsyntax error !!! ";
                break;
            }

            else if (action.equals("acc")) {
                result +="\nend";
                System.out.println("end");
                break;
            }

            else if (action.charAt(0) == 'r') {
                switch (action.charAt(1)) {
                    case '1':
                        if(action.length()==3){
                            printreduce(lows.l10);
                            pushreduce(10);
                            break;
                        }
                        else{
                            printreduce(lows.l1);
                            pushreduce(1);
                            break;
                        }
                    case '2':
                        printreduce(lows.l2);
                        pushreduce(2);
                        break;
                    case '3':
                        printreduce(lows.l3);
                        pushreduce(3);
                        break;
                    case '4':
                        printreduce(lows.l4);
                        pushreduce(4);
                        break;
                    case '5':
                        printreduce(lows.l5);
                        pushreduce(5);
                        break;
                    case '6':
                        printreduce(lows.l6);
                        pushreduce(6);
                        break;
                    case '7':
                        printreduce(lows.l7);
                        pushreduce(7);
                        break;
                    case '8':
                        printreduce(lows.l8);
                        pushreduce(8);
                        break;
                    case '9':
                        printreduce(lows.l9);
                        pushreduce(9);
                        break;
                }
            }
            else if (action.charAt(0) == 's') {
                symbols.push(symbol);
                switch (action.charAt(1)) {
                    case '1':
                        if (action.length() == 2) {
                            currentState = 1;
                            stack.push("1");
                            break;
                        } else {
                            currentState = (action.charAt(1)-'0')*10+action.charAt(2)-'0';
                            stack.push(""+action.charAt(1)+action.charAt(2));
                            break;
                        }
                    case '2':
                        if (action.length() == 2) {
                            currentState = 2;
                            stack.push("2");
                            break;
                        } else {
                            currentState = (action.charAt(1)-'0')*10+action.charAt(2)-'0';
                            stack.push(""+action.charAt(1)+action.charAt(2));
                            break;
                        }
                    case '3':
                        if (action.length() == 2) {
                            currentState = 3;
                            stack.push("3");
                            break;
                        } else if(action.charAt(2)=='0'){
                            currentState = 30;
                            stack.push("30");
                            break;
                        }else{
                            currentState = 31;
                            stack.push("31");
                            break;
                        }
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        currentState = action.charAt(1)-'0';
                        stack.push(""+action.charAt(1));
                        break;//TODO for all shifts this adea
                }
                
                currentToken = codescanner.nexttoken();
            }
//            System.out.println(stack);
//            System.out.println(symbols);
        }


        return result;
    }

    private boolean pushreduce(int i) {
        
        int count = 0;
        String[] low ={};
        String t;
        switch(i){
            case 1:
                low = lows.l1;
                break;
            case 2:
                low = lows.l2;
                break;
            case 3:
                low = lows.l3;
                break;
            case 4:
                low = lows.l4;
                break;
            case 5:
                low = lows.l5;
                break;
            case 6:
                low = lows.l6;
                break;
            case 7:
                low = lows.l7;
                break;
            case 8:
                low = lows.l8;
                break;
            case 9:
                low = lows.l9;
                break;
            case 10:
                low = lows.l10;
                break;
        }
        count = low.length-2;
        for (int j = 0; j < count; j++){
            stack.pop();
            symbols.pop();
        }
        t = stack.pop();
        stack.push(t);
        symbols.push(low[0]);
        input =t+low[0];
        String GOTO = lows.actionGotoTable.get(input);
        if(GOTO==null)
            return false;
        else 
            stack.push(GOTO);
        currentState = Integer.parseInt(GOTO);
        return true;
    }

    private void printreduce(String[] l1) {
        for (String l11 : l1) {
            result+=l11;
        }
        result+="\n";
    }

}
