package com.example.zhaolei.zuoye;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;

public class StrCut {
    String polStr;
    Vector polFull;
    Vector ratFull;

    BigInteger aX;
    BigInteger xExp;
    BigInteger sExp;
    BigInteger cExp;
    String part[] = new String[1000];
    int len;

    final String ADDORDE = "[-+]?";
    // final String INTX = "[-+]?[0-9]+";
    final String POLINT = "([0-9]*)?\\*?";
    final String POLEXP = "(x(\\^[+-]?[0-9]+)?)?";
    final String POLPART = ADDORDE + POLINT + POLEXP;
    // final String EMPTY = "\\s*";
    // final String POLFULL = "^("+ADDORDE + EMPTY + POLINT + EMPTY + POLEXP +
    // ")+$";
    final String POLPARTA = "[-+]?" + "([0-9]*)?\\s*\\*?\\s*" + "(x\\s*(\\^\\s*[+-]?[0-9]+)?)?";
    final String POLPARTB = "([0-9]*)?\\s*\\*?\\s*" + "(x\\s*(\\^\\s*[+-]?[0-9]+)?)?";
    final String OPER1 = "(\\+\\+)|(\\-\\-)";
    final String OPER2 = "(\\+\\-)|(\\-\\+)";

    final String SIN = "sin\\(x\\)(\\^[+-]?[0-9]+)?";
    final String COS = "cos\\(x\\)(\\^[+-]?[0-9]+)?";
    final String POL = "x(\\^[+-]?[0-9]+)?";
    final String EXP = "[+-]?[0-9]+";
    final String NUM = "[0-9]+";
    // final String

    final String TRIA = "((sin)|(cos))\\s*\\(x\\)(\\s*\\^\\s*[+-]?[0-9]+)?";
    final String TRIB = "[+-]?((sin)|(cos))\\s*\\(x\\)(\\s*\\^\\s*[+-]?[0-9]+)?";
    final String CONX = "x\\s*(\\^\\s*[+-]?[0-9]+)?";
    final String CON = "[+-]?(" + TRIA + "|" + CONX + "|" + NUM + ")(\\*\\s*(" + TRIA + "|" + CONX + "|" + NUM + "))+";

    final String ERRORA = "[0-9]+\\s+[0-9]+";
    final String ERRORB = "([+-][+-]\\s*[+-]\\s+[0-9]+)" + "|" + "([+-]\\s*[+-]\\s*[+-]x)";
    final String ERRORC = "[0-9]+[a-z]";
    final String ERRORD = "[^xsincos\\(\\)\\d\\s\\^\\*+-]";
    final String ERRORE = "(\\*\\s*[+-])|(\\^[+-]+\\s+[0-9]+)";
    final String ERRORF = "(\\+oo)|([+-][+-][+-][+-]+)";

    final String ERLEF1 = "[sincos\\(\\)]";
    final String ERLEF2 = "\\s";
    final String ERLEF = ERLEF1 + "|" + ERLEF2;

    StrCut() {
    }

    StrCut(String str1) {
        this.polStr = str1;
        len = 0;

        this.sExp = BigInteger.valueOf(0);
        this.cExp = BigInteger.valueOf(0);
        this.aX = BigInteger.valueOf(1);
        this.xExp = BigInteger.valueOf(0);
        this.polFull = new Vector();
        this.ratFull = new Vector();
    }

    boolean check() {
        boolean ynTrue = false;
        String str = this.polStr;

        boolean yn1 = false, yn2 = false;
        if (str.equals("")) {
            yn1 = true;
        }
        if (this.standard(str).equals("")) {
            yn2 = true;
        }

        // -------------------------------------------------
        String er[] = { ERRORA, ERRORB, ERRORC, ERRORD, ERRORE, ERRORF };
        boolean yn[] = new boolean[er.length];
        for (int i = 0; i < er.length; i++) {
            yn[i] = false;
            Pattern p = Pattern.compile(er[i]);
            Matcher m = p.matcher(polStr);
            yn[i] = m.find();
            /*
             * if(yn[i]) System.out.println("str---> "+m.group());
             * System.out.println((i+1)+"->"+yn[i]);
             */
        }

        // -------------------------------------------------
        str = str.replaceAll(CON, "");
        str = str.replaceAll(TRIB, "");
        str = this.standard(str);
        // -------------------------------------------------
        boolean yn3 = false;
        Pattern p1 = Pattern.compile(ERLEF);
        Matcher m1 = p1.matcher(str);
        yn3 = m1.find();

        // -------------------------------------------------
        boolean qw = false;
        for (int i = 0; i < yn.length; i++) {
            if (yn[i]) {
                qw = true;
            }
        }
        if (!yn1 && !yn2 && !yn3 && !qw)
            ynTrue = true;

        return ynTrue;
    }

    String standard(String str) {
        String be = new String();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) != '\t')
                be += str.charAt(i);
        }
        be = be.replaceAll(OPER1, "+");
        be = be.replaceAll(OPER2, "-");
        return be;
    }

    void strCut() {
        // 1.CON 2.TRIB 3.POLPARTA
        String aStr = this.standard(this.polStr);
        // System.out.println("standard--> "+ aStr);
        String patt[] = { CON, TRIB, POLPARTA };
        for (int i = 0; i < patt.length; i++) {
            Pattern p = Pattern.compile(patt[i]);
            Matcher m = p.matcher(aStr);
            while (m.find()) {
                this.part[this.len] = m.group();
                this.len++;
            }
            aStr = aStr.replaceAll(patt[i], "");
        }
        this.len--;
        for (int i = 0; i < this.len; i++) {
            // System.out.println(i+1+" ---> "+this.part[i]);
            this.ratFull.add(this.union(this.part[i]));
            // System.out.println(this.ratFull);
        }
    }

    Vector union(String str) {
        this.sExp = BigInteger.valueOf(0);
        this.cExp = BigInteger.valueOf(0);
        this.aX = BigInteger.valueOf(1);
        this.xExp = BigInteger.valueOf(0);
        Vector sec = new Vector();
        BigInteger op = new BigInteger("1");
        if (str.charAt(0) == '-')
            op = new BigInteger("-1");
        BigInteger b = new BigInteger("0");
        // sin|cos^e x^e num

        String mat[] = { SIN, COS, POL, EXP, NUM };
        Pattern p1 = Pattern.compile(SIN);
        Pattern p2 = Pattern.compile(COS);
        Pattern p3 = Pattern.compile(POL);
        Pattern p4 = Pattern.compile(EXP);
        Pattern p5 = Pattern.compile(NUM);
        // ---------------------------------------------------sin(x)^a
        Matcher m1 = p1.matcher(str);
        while (m1.find()) {
            String sinStr = m1.group();
            // System.out.println("=======> "+sinStr);
            if (sinStr.length() == 6) {
                b = new BigInteger("1");
            } else {
                Matcher e1 = p4.matcher(sinStr);
                if (e1.find()) {
                    String s = e1.group();
                    b = new BigInteger(s);
                }
            }
            this.sExp = this.sExp.add(b);
        }
        str = str.replaceAll(SIN, "");
        // ----------------------------------------------------cos(x)^a
        Matcher m2 = p2.matcher(str);
        while (m2.find()) {
            String cosStr = m2.group();
            // System.out.println("=======> "+cosStr);
            if (cosStr.length() == 6) {
                b = new BigInteger("1");
            } else {
                Matcher e2 = p4.matcher(cosStr);
                if (e2.find()) {
                    String s = e2.group();
                    b = new BigInteger(s);
                }
            }
            this.cExp = this.cExp.add(b);
        }
        str = str.replaceAll(COS, "");
        // ------------------------------------------------------x^a
        Matcher m3 = p3.matcher(str);
        while (m3.find()) {
            String pStr = m3.group();
            // System.out.println("=======> "+pStr);
            if (pStr.length() == 1) {
                b = new BigInteger("1");
            } else {
                Matcher e3 = p4.matcher(pStr);
                if (e3.find()) {
                    String s = e3.group();
                    b = new BigInteger(s);
                }
            }
            this.xExp = this.xExp.add(b);
        }
        str = str.replaceAll(POL, "");
        // ---------------------------------------------------[0-9]
        Matcher m4 = p5.matcher(str);
        while (m4.find()) {
            String nStr = m4.group();
            // System.out.println("=======> "+nStr);
            Matcher e4 = p4.matcher(nStr);
            if (e4.find()) {
                String s = e4.group();
                b = new BigInteger(s);
                this.aX = this.aX.multiply(b);
            }
        }
        this.aX = this.aX.multiply(op);
        sec.add(this.aX);
        sec.add(this.xExp);
        sec.add(this.sExp);
        sec.add(this.cExp);
        //System.out.println(sec);
        return sec;
    }

}


