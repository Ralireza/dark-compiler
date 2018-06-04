/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.mrbug.darkcompiler;

/**
 *
 * @author ali
 */
public class scanner {
    
    private String code ;
    private int forward = 0;
    private char c ;
    public token nexttoken(){
        c = nextchar();
        while(isws())
            c=nextchar();
        if (c==0)
            return null;
        if (c=='$')
            return new token("$", 0);
        else if(isop())
            return getop();
        else if (isleter())
            return getleter();
        else if (isdigit())
            return getdigit();
        else if (isac())
            return getac();
        return new token("eror", -1);
    }

    public scanner(String code) {
        this.code=code+" $";
    }

    private char nextchar(){
        forward++;
        if(forward<=code.length())
            return code.charAt(forward-1);
        return 0;
    }
    private void backtrack(){forward--;}
    private boolean isws(){
        return (c==' ' || c=='\t' || c=='\n');
    }
    private boolean isop(){
        switch(c){
            case ';':
            case '+':
            case '-':
            case '*':
            case '/':
            case '<':
            case '>':
            case '=':
            case '!':
                return true;
        }
        return false;
    }
    private boolean isdigit(){
        return (c<57 && c>47);
    }
    private boolean isleter(){
        return (c>64 && c<91) || (c<123 && c>96);
    }
    
    private token getdigit(){
        int t=c-48;
        c=nextchar();
        while (!isws()){
            if (isdigit()){
                t=t*10+c-48;
                c=nextchar();
            }
            else
                return new token("eror", -1);
        }
        return new token("number", t);
    }   
    private token getleter(){
        String ltr=""+c;
        c=nextchar();
        
        while(!isws()){
            if  (isleter() || isdigit()){
                ltr+=c;
                c= nextchar();
            }
            else if(isop() || isac()){
                backtrack();
                break;
            }
            else
                return new token("eror", -1);
        }
        switch(ltr){
            case "if":
                return new token("IF", 0);
            case "else":
                return new token("ELSE", 0);
            case "while":
                return new token("WHILE", 0);
            case "do":
                return new token("DO", 0);
        }

        return new token("id",addORsearch(ltr));
    }
    private token getop(){
        char t = c;
        c = nextchar();
        int state=0;
        while (true){
            switch(state){
            case 0 :
                switch(t){
                    case ';':
                        backtrack();
                        return new token(";", 0);
                    case '+':
                        backtrack();
                        return new token("+", 0);
                    case '-':
                        backtrack();
                        return new token("-", 0);
                    case '*':
                        backtrack();
                        return new token("*", 0);
                    case '/':
                        backtrack();
                        return new token("/", 0);
                    case '<':
                        if(isop()){
                            state=1;
                            break;
                        }
                        else
                            return new token("REOP", 12);
                    case '>':
                        if(isop()){
                            state=2;
                            break;
                        }
                        else
                            return new token("REOP", 21);
                    case '=':
                        if(isop()){
                            state=3;
                            break;
                        }
                        else
                            return new token("assign", 0);
                    case '!':
                        if(isop()){
                            state=4;
                            break;
                        }
                        else
                            return new token("NOt", 0);
                        
                    default:
                        return new token("eror", -1);
                }
            case 1:
                if (c=='=')
                    return new token("REOP", 112);
            case 2:
                if (c=='=')
                    return new token("REOP", 211);
            case 3:
                if (c=='=')
                    return new token("REOP", 11);
            case 4:
                if (c=='=')
                    return new token("REOP", 10);
            }
        }
    }
    
    private int addORsearch(String ltr) {
        return 123456;
    }

    private boolean isac() {
        return c=='(' || c==')' || c=='{' || c=='}';
    }

    private token getac() {
        if (c=='(')
            return new token("(", 0);
        if(c==')')
            return new token(")", 0);
        if (c=='{')
            return new token("{", 0);
        return new token("}", 0);
    }
}
