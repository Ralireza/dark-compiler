/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.mrbug.darkcompiler;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ali
 */
public class lows {
    
    public static String[] l1 = {"S","->","while","(","E",")","{","S","}"};
    public static String[] l2 = {"S","->","if","(","E",")","{","S","}"};
    public static String[] l3 = {"S","->","if","(","E",")","{","S","}","else","{","S","}"};
    public static String[] l4 = {"S","->","E",";"};
    public static String[] l5 = {"E","->","E","+","T"};
    public static String[] l6 = {"E","->","T"};
    public static String[] l7 = {"T", "->", "T","*","F"};
    public static String[] l8 = {"T","->","F"};
    public static String[] l9 = {"F","->","(","E",")"};
    public static String[] l10 = {"F","->","id"};
    
    public static Map<String,String> actionGotoTable = new HashMap<>();
    static {
        
        actionGotoTable.put("0WHILE", "s2");
        actionGotoTable.put("0IF", "s16");
//        actionGotoTable.put("0ELSE", "");
        actionGotoTable.put("0id", "s7");
//        actionGotoTable.put("0*", "");
//        actionGotoTable.put("0+", "");
        actionGotoTable.put("0(", "s6");
//        actionGotoTable.put("0)", "");
//        actionGotoTable.put("0{", "");
//        actionGotoTable.put("0}", "");
//        actionGotoTable.put("0;", "");
//        actionGotoTable.put("0$", "");
        actionGotoTable.put("0S", "1");
        actionGotoTable.put("0E", "3");
        actionGotoTable.put("0T", "4");
        actionGotoTable.put("0F", "5");    
    
//        actionGotoTable.put("1WHILE", "");
//        actionGotoTable.put("1IF", "");
//        actionGotoTable.put("1ELSE", "");
//        actionGotoTable.put("1id", "");
//        actionGotoTable.put("1*", "");
//        actionGotoTable.put("1+", "");
//        actionGotoTable.put("1(", "");
//        actionGotoTable.put("1)", "");
//        actionGotoTable.put("1{", "");
//        actionGotoTable.put("1}", "");
//        actionGotoTable.put("1;", "");
        actionGotoTable.put("1$", "acc");
//        actionGotoTable.put("1S", "");
//        actionGotoTable.put("1E", "");
//        actionGotoTable.put("1T", "");
//        actionGotoTable.put("1F", "");
        
//        actionGotoTable.put("2WHILE", "");
//        actionGotoTable.put("2IF", "");
////        actionGotoTable.put("2ELSE", "");
//        actionGotoTable.put("2id", "");
//        actionGotoTable.put("2*", "");
//        actionGotoTable.put("2+", "");
        actionGotoTable.put("2(", "s13");
//        actionGotoTable.put("2)", "");
//        actionGotoTable.put("2{", "");
//        actionGotoTable.put("2}", "");
//        actionGotoTable.put("2;", "");
//        actionGotoTable.put("2$", "");
//        actionGotoTable.put("2S", "");
//        actionGotoTable.put("2E", "");
//        actionGotoTable.put("2T", "");
//        actionGotoTable.put("2F", "");
        
//        actionGotoTable.put("3WHILE", "");
//        actionGotoTable.put("3IF", "");
////        actionGotoTable.put"3ELSE", "");
//        actionGotoTable.put("3id", "");
//        actionGotoTable.put("3*", "");
        actionGotoTable.put("3+", "s10");
//        actionGotoTable.put("3(", "");
//        actionGotoTable.put("3)", "");
//        actionGotoTable.put("3{", "");
//        actionGotoTable.put("3}", "");
        actionGotoTable.put("3;", "s12");
//        actionGotoTable.put("3$", "");
//        actionGotoTable.put("3S", "");
//        actionGotoTable.put("3E", "");
//        actionGotoTable.put("3T", "");
//        actionGotoTable.put("3F", "");
        
//        actionGotoTable.put("4WHILE", "");
//        actionGotoTable.put("4IF", "");
////        actionGotoTable.put("4ELSE", "");
//        actionGotoTable.put("4id", "");
        actionGotoTable.put("4*", "s14");
        actionGotoTable.put("4+", "r6");
//        actionGotoTable.put("4(", "");
        actionGotoTable.put("4)", "r6");
//        actionGotoTable.put("4{", "");
//        actionGotoTable.put("4}", "");
        actionGotoTable.put("4;", "r6");
//        actionGotoTable.put("4$", "");
//        actionGotoTable.put("4S", "");
//        actionGotoTable.put("4E", "");
//        actionGotoTable.put("4T", "");
//        actionGotoTable.put("4F", "");
       
//        actionGotoTable.put("5WHILE", "");
//        actionGotoTable.put("5IF", "");
////        actionGotoTable.put(5"0ELSE", "");
//        actionGotoTable.put("5id", "");
        actionGotoTable.put("5*", "r8");
        actionGotoTable.put("5+", "r8");
//        actionGotoTable.put("5(", "");
        actionGotoTable.put("5)", "r8");
//        actionGotoTable.put("5{", "");
//        actionGotoTable.put("5}", "");
        actionGotoTable.put("5;", "r8");
//        actionGotoTable.put("5$", "");
//        actionGotoTable.put("5S", "");
//        actionGotoTable.put("5E", "");
//        actionGotoTable.put("5T", "");
//        actionGotoTable.put("5F", "");
//        
//        actionGotoTable.put("6WHILE", "");
//        actionGotoTable.put("6IF", "");
////        actionGotoTable.put6"0ELSE", "");
        actionGotoTable.put("6id", "s7");
//        actionGotoTable.put("6*", "");
//        actionGotoTable.put("6+", "");
        actionGotoTable.put("6(", "s6");
//        actionGotoTable.put("6)", "");
//        actionGotoTable.put("6{", "");
//        actionGotoTable.put("6}", "");
//        actionGotoTable.put("6;", "");
//        actionGotoTable.put("6$", "");
//        actionGotoTable.put("6S", "");
        actionGotoTable.put("6E", "8");
        actionGotoTable.put("6T", "4");
        actionGotoTable.put("6F", "5");
//        
//        actionGotoTable.put("7WHILE", "");
//        actionGotoTable.put("7IF", "");
////        actionGotoTable.put7"0ELSE", "");
//        actionGotoTable.put("7id", "");
        actionGotoTable.put("7*", "r10");
        actionGotoTable.put("7+", "r10");
//        actionGotoTable.put("7(", "");
        actionGotoTable.put("7)", "r10");
//        actionGotoTable.put("7{", "");
//        actionGotoTable.put("7}", "");
        actionGotoTable.put("7;", "r10");
//        actionGotoTable.put("7$", "");
//        actionGotoTable.put("7S", "");
//        actionGotoTable.put("7E", "");
//        actionGotoTable.put("7T", "");
//        actionGotoTable.put("7F", "");
//       
//        actionGotoTable.put("8WHILE", "");
//        actionGotoTable.put("8IF", "");
////        actionGotoTable.put8"0ELSE", "");
//        actionGotoTable.put("8id", "");
//        actionGotoTable.put("8*", "");
        actionGotoTable.put("8+", "s10");
//        actionGotoTable.put("8", "");
        actionGotoTable.put("8)", "s9");
//        actionGotoTable.put("8{", "");
//        actionGotoTable.put("8}", "");
//        actionGotoTable.put("8;", "");
//        actionGotoTable.put("8$", "");
//        actionGotoTable.put("8S", "");
//        actionGotoTable.put("8E", "");
//        actionGotoTable.put("8T", "");
//        actionGotoTable.put("8F", "");
//        
//        actionGotoTable.put("9WHILE", "");
//        actionGotoTable.put("9IF", "");
////        actionGotoTable.put("0ELSE", "");
//        actionGotoTable.put("9id", "");
        actionGotoTable.put("9*", "r9");
        actionGotoTable.put("9+", "r9");
//        actionGotoTable.put("9(", "");
        actionGotoTable.put("9)", "r9");
//        actionGotoTable.put("9{", "");
//        actionGotoTable.put("9}", "");
        actionGotoTable.put("9;", "r9");
//        actionGotoTable.put("9$", "");
//        actionGotoTable.put("9S", "");
//        actionGotoTable.put("9E", "");
//        actionGotoTable.put("9T", "");
//        actionGotoTable.put("9F", "");
//       
//        actionGotoTable.put("10WHILE", "");
//        actionGotoTable.put("10IF", "");
////        actionGotoTable.put("0ELSE", "");
        actionGotoTable.put("10id", "s7");
//        actionGotoTable.put("10*", "");
//        actionGotoTable.put("10+", "");
        actionGotoTable.put("10(", "s6");
//        actionGotoTable.put("10)", "");
//        actionGotoTable.put("10{", "");
//        actionGotoTable.put("10}", "");
//        actionGotoTable.put("10;", "");
//        actionGotoTable.put("10$", "");
//        actionGotoTable.put("10S", "");
//        actionGotoTable.put("10E", "");
        actionGotoTable.put("10T", "11");
        actionGotoTable.put("10F", "5");
//        
//        actionGotoTable.put("11WHILE", "");
//        actionGotoTable.put("11IF", "");
////        actionGotoTable.put("0ELSE", "");
//        actionGotoTable.put("11id", "");
        actionGotoTable.put("11*", "s14");
        actionGotoTable.put("11+", "r5");
//        actionGotoTable.put("11(", "");
        actionGotoTable.put("11)", "r5");
//        actionGotoTable.put("11{", "");
//        actionGotoTable.put("11}", "");
        actionGotoTable.put("11;", "r5");
//        actionGotoTable.put("11$", "");
//        actionGotoTable.put("11S", "");
//        actionGotoTable.put("11E", "");
//        actionGotoTable.put("11T", "");
//        actionGotoTable.put("11F", "");
//        
//        actionGotoTable.put("12WHILE", "");
//        actionGotoTable.put("12IF", "");
////        actionGotoTable.put("0ELSE", "");
//        actionGotoTable.put("12id", "");
//        actionGotoTable.put("12*", "");
//        actionGotoTable.put("12+", "");
//        actionGotoTable.put("12(", "");
//        actionGotoTable.put("12)", "");
//        actionGotoTable.put("12{", "");
        actionGotoTable.put("12}", "r4");
        actionGotoTable.put("12;", "r4");
        actionGotoTable.put("12$", "r4");
//        actionGotoTable.put("12S", "");
//        actionGotoTable.put("12E", "");
//        actionGotoTable.put("12T", "");
//        actionGotoTable.put("12F", "");
//        
//        actionGotoTable.put("13WHILE", "");
//        actionGotoTable.put("13IF", "");
////        actionGotoTable.put("ELSE", "");
        actionGotoTable.put("13id", "s7");
//        actionGotoTable.put("13*", "");
//        actionGotoTable.put("13+", "");
        actionGotoTable.put("13(", "s6");
//        actionGotoTable.put("13)", "");
//        actionGotoTable.put("13{", "");
//        actionGotoTable.put("13}", "");
//        actionGotoTable.put("13;", "");
//        actionGotoTable.put("13$", "");
//        actionGotoTable.put("13S", "");
        actionGotoTable.put("13E", "17");
        actionGotoTable.put("13T", "4");
        actionGotoTable.put("13F", "5");
//        
//        actionGotoTable.put("14WHILE", "");
//        actionGotoTable.put("14IF", "");
////        actionGotoTable.put("ELSE", "");
        actionGotoTable.put("14id", "s7");
//        actionGotoTable.put("14*", "");
//        actionGotoTable.put("14+", "");
        actionGotoTable.put("14(", "s6");
//        actionGotoTable.put("14)", "");
//        actionGotoTable.put("14{", "");
//        actionGotoTable.put("14}", "");
//        actionGotoTable.put("14;", "");
//        actionGotoTable.put("14$", "");
//        actionGotoTable.put("14S", "");
//        actionGotoTable.put("14E", "");
//        actionGotoTable.put("14T", "");
        actionGotoTable.put("14F", "15");
//        
//        actionGotoTable.put("15WHILE", "");
//        actionGotoTable.put("15IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("15id", "");
        actionGotoTable.put("15*", "r7");
        actionGotoTable.put("15+", "r7");
//        actionGotoTable.put("15(", "");
        actionGotoTable.put("15)", "r7");
//        actionGotoTable.put("15{", "");
//        actionGotoTable.put("15}", "");
        actionGotoTable.put("15;", "r7");
//        actionGotoTable.put("15$", "");
//        actionGotoTable.put("15S", "");
//        actionGotoTable.put("15E", "");
//        actionGotoTable.put("15T", "");
//        actionGotoTable.put("15F", "");
//        
//        actionGotoTable.put("16WHILE", "");
//        actionGotoTable.put("16IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("16id", "");
//        actionGotoTable.put("16*", "");
//        actionGotoTable.put("16+", "");
        actionGotoTable.put("16(", "s22");
//        actionGotoTable.put("16)", "");
//        actionGotoTable.put("16{", "");
//        actionGotoTable.put("16}", "");
//        actionGotoTable.put("16;", "");
//        actionGotoTable.put("16$", "");
//        actionGotoTable.put("16S", "");
//        actionGotoTable.put("16E", "");
//        actionGotoTable.put("16T", "");
//        actionGotoTable.put("16F", "");
//        
//        actionGotoTable.put("17WHILE", "");
//        actionGotoTable.put("17IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("17id", "");
//        actionGotoTable.put("17*", "");
        actionGotoTable.put("17+", "s10");
//        actionGotoTable.put("17(", "");
        actionGotoTable.put("17)", "s18");
//        actionGotoTable.put("17{", "");
//        actionGotoTable.put("17}", "");
//        actionGotoTable.put("17;", "");
//        actionGotoTable.put("17$", "");
//        actionGotoTable.put("17S", "");
//        actionGotoTable.put("17E", "");
//        actionGotoTable.put("17T", "");
//        actionGotoTable.put("17F", "");
//        
//        actionGotoTable.put("18WHILE", "");
//        actionGotoTable.put("18IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("18id", "");
//        actionGotoTable.put("18*", "");
//        actionGotoTable.put("18+", "");
//        actionGotoTable.put("18(", "");
//        actionGotoTable.put("18)", "");
        actionGotoTable.put("18{", "s19");
//        actionGotoTable.put("18}", "");
//        actionGotoTable.put("18;", "");
//        actionGotoTable.put("18$", "");
//        actionGotoTable.put("18S", "");
//        actionGotoTable.put("18E", "");
//        actionGotoTable.put("18T", "");
//        actionGotoTable.put("18F", "");
//        
        actionGotoTable.put("19WHILE", "s2");
        actionGotoTable.put("19IF", "s16");
////        actionGotoTable.put("ELSE", "");
        actionGotoTable.put("19id", "s7");
//        actionGotoTable.put("19*", "");
//        actionGotoTable.put("19+", "");
        actionGotoTable.put("19(", "s6");
//        actionGotoTable.put("19)", "");
//        actionGotoTable.put("19{", "");
//        actionGotoTable.put("19}", "");
//        actionGotoTable.put("19;", "");
//        actionGotoTable.put("19$", "");
        actionGotoTable.put("19S", "20");
        actionGotoTable.put("19E", "3");
        actionGotoTable.put("19T", "4");
        actionGotoTable.put("19F", "5");
//        
//        actionGotoTable.put("20WHILE", "");
//        actionGotoTable.put("20IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("20id", "");
//        actionGotoTable.put("20*", "");
//        actionGotoTable.put("20+", "");
//        actionGotoTable.put("20(", "");
//        actionGotoTable.put("20)", "");
//        actionGotoTable.put("20{", "");
        actionGotoTable.put("20}", "s21");
//        actionGotoTable.put("20;", "");
//        actionGotoTable.put("20$", "");
//        actionGotoTable.put("20S", "");
//        actionGotoTable.put("20E", "");
//        actionGotoTable.put("20T", "");
//        actionGotoTable.put("20F", "");
//        
//        actionGotoTable.put("21WHILE", "");
//        actionGotoTable.put("21IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("21id", "");
//        actionGotoTable.put("21*", "");
//        actionGotoTable.put("21+", "");
//        actionGotoTable.put("21(", "");
//        actionGotoTable.put("21)", "");
//        actionGotoTable.put("21{", "");
        actionGotoTable.put("21}", "r1");
        actionGotoTable.put("21;", "r1");
        actionGotoTable.put("21$", "r1");
//        actionGotoTable.put("21S", "");
//        actionGotoTable.put("21E", "");
//        actionGotoTable.put("21T", "");
//        actionGotoTable.put("21F", "");
//        
//        actionGotoTable.put("22WHILE", "");
//        actionGotoTable.put("22IF", "");
////        actionGotoTable.put("ELSE", "");
        actionGotoTable.put("22id", "s7");
//        actionGotoTable.put("22*", "");
//        actionGotoTable.put("22+", "");
        actionGotoTable.put("22(", "s6");
//        actionGotoTable.put("22)", "");
//        actionGotoTable.put("22{", "");
//        actionGotoTable.put("22}", "");
//        actionGotoTable.put("22;", "");
//        actionGotoTable.put("22$", "");
//        actionGotoTable.put("22S", "");
        actionGotoTable.put("22E", "23");
        actionGotoTable.put("22T", "4");
        actionGotoTable.put("22F", "5");
//        
//        actionGotoTable.put("23WHILE", "");
//        actionGotoTable.put("23IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("23id", "");
//        actionGotoTable.put("23*", "");
        actionGotoTable.put("23+", "s10");
//        actionGotoTable.put("23(", "");
        actionGotoTable.put("23)", "s24");
//        actionGotoTable.put("23{", "");
//        actionGotoTable.put("23}", "");
//        actionGotoTable.put("23;", "");
//        actionGotoTable.put("23$", "");
//        actionGotoTable.put("23S", "");
//        actionGotoTable.put("23E", "");
//        actionGotoTable.put("23T", "");
//        actionGotoTable.put("23F", "");
//        
//        actionGotoTable.put("24WHILE", "");
//        actionGotoTable.put("24IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("24id", "");
//        actionGotoTable.put("24*", "");
//        actionGotoTable.put("24+", "");
//        actionGotoTable.put("24(", "");
//        actionGotoTable.put("24)", "");
        actionGotoTable.put("24{", "s25");
//        actionGotoTable.put("24}", "");
//        actionGotoTable.put("24;", "");
//        actionGotoTable.put("24$", "");
//        actionGotoTable.put("24S", "");
//        actionGotoTable.put("24E", "");
//        actionGotoTable.put("24T", "");
//        actionGotoTable.put("24F", "");
//        
        actionGotoTable.put("25WHILE", "s2");
        actionGotoTable.put("25IF", "s16");
////        actionGotoTable.put("ELSE", "");
        actionGotoTable.put("25id", "s7");
//        actionGotoTable.put("25*", "");
//        actionGotoTable.put("25+", "");
        actionGotoTable.put("25(", "s6");
//        actionGotoTable.put("25)", "");
//        actionGotoTable.put("25{", "");
//        actionGotoTable.put("25}", "");
//        actionGotoTable.put("25;", "");
//        actionGotoTable.put("25$", "");
        actionGotoTable.put("25S", "26");
        actionGotoTable.put("25E", "3");
        actionGotoTable.put("25T", "4");
        actionGotoTable.put("25F", "5");
//        
//        actionGotoTable.put("26WHILE", "");
//        actionGotoTable.put("26IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("26id", "");
//        actionGotoTable.put("26*", "");
//        actionGotoTable.put("26+", "");
//        actionGotoTable.put("26(", "");
//        actionGotoTable.put("26)", "");
//        actionGotoTable.put("26{", "");
        actionGotoTable.put("26}", "s27");
//        actionGotoTable.put("26;", "");
//        actionGotoTable.put("26$", "");
//        actionGotoTable.put("26S", "");
//        actionGotoTable.put("26E", "");
//        actionGotoTable.put("26T", "");
//        actionGotoTable.put("26F", "");
//        
//        actionGotoTable.put("27WHILE", "");
//        actionGotoTable.put("27IF", "");
        actionGotoTable.put("27ELSE", "s28");
//        actionGotoTable.put("27id", "");
//        actionGotoTable.put("27*", "");
//        actionGotoTable.put("27+", "");
//        actionGotoTable.put("27(", "");
//        actionGotoTable.put("27)", "");
//        actionGotoTable.put("27{", "");
        actionGotoTable.put("27}", "r2");
        actionGotoTable.put("27;", "r2");
        actionGotoTable.put("27$", "r2");
//        actionGotoTable.put("27S", "");
//        actionGotoTable.put("27E", "");
//        actionGotoTable.put("27T", "");
//        actionGotoTable.put("27F", "");
//        
//        actionGotoTable.put("28WHILE", "");
//        actionGotoTable.put("28IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("28id", "");
//        actionGotoTable.put("28*", "");
//        actionGotoTable.put("28+", "");
//        actionGotoTable.put("28(", "");
//        actionGotoTable.put("28)", "");
        actionGotoTable.put("28{", "s29");
//        actionGotoTable.put("28}", "");
//        actionGotoTable.put("28;", "");
//        actionGotoTable.put("28$", "");
//        actionGotoTable.put("28S", "");
//        actionGotoTable.put("28E", "");
//        actionGotoTable.put("28T", "");
//        actionGotoTable.put("28F", "");
//        
        actionGotoTable.put("29WHILE", "s2");
        actionGotoTable.put("29IF", "s16");
////        actionGotoTable.put("ELSE", "");
        actionGotoTable.put("29id", "s7");
//        actionGotoTable.put("29*", "");
//        actionGotoTable.put("29+", "");
        actionGotoTable.put("29(", "s6");
//        actionGotoTable.put("29)", "");
//        actionGotoTable.put("29{", "");
//        actionGotoTable.put("29}", "");
//        actionGotoTable.put("29;", "");
//        actionGotoTable.put("29$", "");
        actionGotoTable.put("29S", "30");
        actionGotoTable.put("29E", "3");
        actionGotoTable.put("29T", "4");
        actionGotoTable.put("29F", "5");
//        
//        actionGotoTable.put("30WHILE", "");
//        actionGotoTable.put("30IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("30id", "");
//        actionGotoTable.put("30*", "");
//        actionGotoTable.put("30+", "");
//        actionGotoTable.put("30(", "");
//        actionGotoTable.put("30)", "");
//        actionGotoTable.put("30{", "");
        actionGotoTable.put("30}", "s31");
//        actionGotoTable.put("30;", "");
//        actionGotoTable.put("30$", "");
//        actionGotoTable.put("30S", "");
//        actionGotoTable.put("30E", "");
//        actionGotoTable.put("30T", "");
//        actionGotoTable.put("30F", "");
//        
//        actionGotoTable.put("31WHILE", "");
//        actionGotoTable.put("31IF", "");
////        actionGotoTable.put("ELSE", "");
//        actionGotoTable.put("31id", "");
//        actionGotoTable.put("31*", "");
//        actionGotoTable.put("31+", "");
//        actionGotoTable.put("31(", "");
//        actionGotoTable.put("31)", "");
//        actionGotoTable.put("31{", "");
        actionGotoTable.put("31}", "r3");
        actionGotoTable.put("31;", "r3");
        actionGotoTable.put("31$", "r3");
//        actionGotoTable.put("31S", "");
//        actionGotoTable.put("31E", "");
//        actionGotoTable.put("31T", "");
//        actionGotoTable.put("31F", "");
//        
    }
}
