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
                            switch(action.charAt(2)){
                                case '0':
                                    currentState = 10;
                                    stack.push("10");
                                    break;
                                case '1':
                                    currentState = 11;
                                    stack.push("11");
                                    break;
                                case '2':
                                    currentState = 12;
                                    stack.push("12");
                                    break;
                                case '3':
                                    currentState = 13;
                                    stack.push("13");
                                    break;
                                case '4':
                                    currentState = 14;
                                    stack.push("14");
                                    break;
                                case '5':
                                    currentState = 15;
                                    stack.push("15");
                                    break;
                                case '6':
                                    currentState = 16;
                                    stack.push("16");
                                    break;
                                case '7':
                                    currentState = 17;
                                    stack.push("17");
                                    break;
                                case '8':
                                    currentState = 18;
                                    stack.push("18");
                                    break;
                                case '9':
                                    currentState = 19;
                                    stack.push("19");
                                    break;
                            }
                            
                        }break;
                    case '2':
                        if (action.length() == 2) {
                            currentState = 2;
                            stack.push("2");
                            break;
                        } else {
                            switch(action.charAt(2)){
                                case '0':
                                    currentState = 20;
                                    stack.push("20");
                                    break;
                                case '1':
                                    currentState = 21;
                                    stack.push("21");
                                    break;
                                case '2':
                                    currentState = 22;
                                    stack.push("22");
                                    break;
                                case '3':
                                    currentState = 23;
                                    stack.push("23");
                                    break;
                                case '4':
                                    currentState = 24;
                                    stack.push("24");
                                    break;
                                case '5':
                                    currentState = 25;
                                    stack.push("25");
                                    break;
                                case '6':
                                    currentState = 26;
                                    stack.push("26");
                                    break;
                                case '7':
                                    currentState = 27;
                                    stack.push("27");
                                    break;
                                case '8':
                                    currentState = 28;
                                    stack.push("28");
                                    break;
                                case '9':
                                    currentState = 29;
                                    stack.push("29");
                                    break;
                            }break;
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
