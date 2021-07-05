package com.example.zhaolei.zuoye;

import java.util.Vector;
import java.math.BigInteger;

public class DerMerge {
    Vector ratV;
    Vector derV;
    BigInteger nA, xE, sE, cE;

    DerMerge() {
    }

    DerMerge(Vector st) {
        ratV = st;
        derV = new Vector();
        this.nA = BigInteger.valueOf(1);
        this.xE = BigInteger.valueOf(0);
        this.sE = BigInteger.valueOf(0);
        this.cE = BigInteger.valueOf(0);
    }

    void merge() {
        Vector ve = new Vector();
        ve.add(derV.elementAt(0));
        for (int i = 1; i < derV.size(); i++) {
            Vector at = (Vector) derV.elementAt(i);
            int j = 0;
            boolean as = false;
            for (j = 0; j < ve.size(); j++) {
                Vector temp = (Vector) ve.elementAt(j);
                BigInteger t1 = new BigInteger(temp.elementAt(1).toString());
                BigInteger t2 = new BigInteger(at.elementAt(1).toString());
                int by = t1.compareTo(t2);
                if (by == 1) {
                    ve.add(j, at);
                    as = true;
                    break;
                }
                if (by == 0) {
                    BigInteger s1 = new BigInteger(temp.elementAt(2).toString());
                    BigInteger s2 = new BigInteger(at.elementAt(2).toString());
                    BigInteger c1 = new BigInteger(temp.elementAt(3).toString());
                    BigInteger c2 = new BigInteger(at.elementAt(3).toString());
                    int sy = s1.compareTo(s2);
                    int cy = c1.compareTo(c2);
                    if (sy == 0 && cy == 0) {
                        BigInteger a1 = new BigInteger(temp.elementAt(0).toString());
                        BigInteger a2 = new BigInteger(at.elementAt(0).toString());
                        a1 = a1.add(a2);
                        BigInteger e1 = new BigInteger(temp.elementAt(1).toString());
                        if (a1.compareTo(new BigInteger("0")) == 0) {
                            ve.remove(j);
                        } else {
                            Vector a = new Vector();
                            a.add(a1);
                            a.add(e1);
                            a.add(s1);
                            a.add(c1);
                            ve.setElementAt(a, j);
                        }
                        as = true;
                        break;
                    }
                }
            }
            if (!as) {
                ve.add(at);
            }
        }
        this.derV = ve;
        /*
         * System.out.println("after merge:"); for(int i=0;i<this.derV.size();i++) {
         * System.out.println(derV.elementAt(i)); }
         */
    }

    void dervation() {
        BigInteger a, b, c, d;
        for (int i = 0; i < this.ratV.size(); i++) {
            Vector temp = (Vector) this.ratV.elementAt(i);
            this.nA = (BigInteger) temp.elementAt(0);
            this.xE = (BigInteger) temp.elementAt(1);
            this.sE = (BigInteger) temp.elementAt(2);
            this.cE = (BigInteger) temp.elementAt(3);

            // ----------------------------------1
            Vector ve1 = new Vector();
            a = this.nA.multiply(this.xE);
            if (a.compareTo(new BigInteger("0")) != 0) {
                b = this.xE.subtract(new BigInteger("1"));
                c = this.sE;
                d = this.cE;
                ve1.add(a);
                ve1.add(b);
                ve1.add(c);
                ve1.add(d);
                this.derV.add(ve1);
            }

            // ----------------------------------2
            Vector ve2 = new Vector();
            a = this.nA.multiply(this.sE);
            if (a.compareTo(new BigInteger("0")) != 0) {
                b = this.xE;
                c = this.sE.subtract(new BigInteger("1"));
                d = this.cE.add(new BigInteger("1"));
                ve2.add(a);
                ve2.add(b);
                ve2.add(c);
                ve2.add(d);
                this.derV.add(ve2);
            }

            // ----------------------------------3
            Vector ve3 = new Vector();
            a = this.nA.multiply(this.cE);
            a = a.negate();
            if (a.compareTo(new BigInteger("0")) != 0) {
                b = this.xE;
                c = this.sE.add(new BigInteger("1"));
                d = this.cE.subtract(new BigInteger("1"));
                ve3.add(a);
                ve3.add(b);
                ve3.add(c);
                ve3.add(d);
                this.derV.add(ve3);
            }
        }
        // if derV is empty
        if (this.derV.isEmpty()) {
            Vector v = new Vector();
            for (int i = 0; i <= 4; i++) {
                v.add(BigInteger.valueOf(0));
            }
            this.derV.add(v);
        }

        /*
         * System.out.println("after dervation:"); for(int i=0;i<this.derV.size();i++) {
         * System.out.println(derV.elementAt(i)); }
         */
    }

}


