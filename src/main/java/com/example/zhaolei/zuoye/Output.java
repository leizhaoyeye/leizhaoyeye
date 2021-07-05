package com.example.zhaolei.zuoye;

import java.util.Vector;
import java.math.BigInteger;

public class Output {
    Vector endPol;
    String ans;

    Output() {
    };

    Output(Vector pol) {
        this.endPol = pol;
        ans = "";
    }

    void putPol(BigInteger a, BigInteger exp) {
        if (exp.compareTo(new BigInteger("0")) == 0) {
            if (a.compareTo(new BigInteger("0")) == 1)
                ans = ans + "+" + a.toString();
            else
                ans = ans + a.toString();
        } else if (exp.compareTo(new BigInteger("1")) == 0) {
            if (a.compareTo(new BigInteger("1")) == 0)
                ans = ans + "+x";
            else if (a.compareTo(new BigInteger("-1")) == 0)
                ans = ans + "-x";
            else if (a.compareTo(new BigInteger("0")) == 1)
                ans = ans + "+" + a.toString() + "*x";
            else
                ans = ans + a.toString() + "*x";
        } else {
            if (a.compareTo(new BigInteger("1")) == 0)
                ans = ans + "+x^" + exp.toString();
            else if (a.compareTo(new BigInteger("-1")) == 0)
                ans = ans + "-x^" + exp.toString();
            else if (a.compareTo(new BigInteger("0")) == 1)
                ans = ans + "+" + a.toString() + "*x^" + exp.toString();
            else
                ans = ans + a.toString() + "*x^" + exp.toString();
        }
    }

    void putTri(BigInteger tre, String str) {
        if (tre.compareTo(BigInteger.valueOf(0)) == 0) {

        } else if (tre.compareTo(BigInteger.valueOf(1)) == 0) {
            ans = ans + str;
        } else {
            ans = ans + str + "^" + tre.toString();
        }
    }

    void putAll() {
        if (this.endPol.size() == 0) {
            System.out.println("0");
            return;
        }
        for (int i = 0; i < this.endPol.size(); i++) {
            Vector st = (Vector) this.endPol.elementAt(i);
            BigInteger a = new BigInteger(st.elementAt(0).toString());
            BigInteger exp = new BigInteger(st.elementAt(1).toString());
            BigInteger sexp = new BigInteger(st.elementAt(2).toString());
            BigInteger cexp = new BigInteger(st.elementAt(3).toString());
            int yn1 = a.compareTo(BigInteger.valueOf(0));
            int yn2 = exp.compareTo(BigInteger.valueOf(0));
            int yn3 = sexp.compareTo(BigInteger.valueOf(0));
            int yn4 = cexp.compareTo(BigInteger.valueOf(0));

            this.ans = "";
            this.putPol(a, exp);
            if ((yn1 != 0 || yn2 != 0) && (yn3 != 0 || yn4 != 0))
                ans = ans + "*";
            this.putTri(sexp, "sin(x)");
            if (yn3 != 0 && yn4 != 0)
                ans = ans + "*";
            this.putTri(cexp, "cos(x)");
            ans = this.ans.replaceAll("\\+1\\*", "\\+");
            ans = this.ans.replaceAll("\\-1\\*", "\\-");

            System.out.print(this.ans);
        }

        System.out.println("");

    }

}


