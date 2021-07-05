package com.example.zhaolei.zuoye;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Mian {
    static String polStr;

    Mian() {
        this.polStr = "";
    }

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            polStr = sc.nextLine();
            StrCut sts = new StrCut(polStr);
            boolean jk = sts.check();
            if (jk) {
                sts.strCut();
                DerMerge dm = new DerMerge(sts.ratFull);
                dm.dervation();
                dm.merge();
                Output op = new Output(dm.derV);
                op.putAll();
            } else {
                System.out.println("WRONG FORMAT!");
            }
        }
    }

}


