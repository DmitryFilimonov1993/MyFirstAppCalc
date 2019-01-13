package com.example.complexnumcalc;

import java.math.BigDecimal;

public class Complex {


    private double re, im;

    public Complex(double re, double im){

        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    private String sign(){

        if (im > 0) return  " + ";
        else return  " - ";
    }

    public String toString(){

        Double ScaleRe, ScaleIm;

        ScaleRe = new BigDecimal(re).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
        ScaleIm = new BigDecimal(im).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();

        String string;
        if (im == 1 || im == -1) {
            if (re == 0) {
                string = sign() + "i";
            } else {
                string = Double.toString(ScaleRe) + sign() + " i ";
            }
        } else {
            string = Double.toString(ScaleRe) + sign() + Double.toString(Math.abs(ScaleIm)) + " i ";
        }
        return string;
            }

    public static Complex sum(Complex z1, Complex z2){

        return new Complex(z1.getRe() + z2.getRe(), z1.getIm() + z2.getIm());

    }

    public static Complex minus(Complex z1, Complex z2){

        return new Complex(z1.getRe() - z2.getRe(), z1.getIm() - z2.getIm());

    }

    public static Complex multiplication(Complex z1, Complex z2){

        return new Complex(z1.getRe() * z2.getRe() - z1.getIm() * z2.getIm(),
                z1.getRe() * z2.getIm() + z2.getRe() * z1.getIm());

    }

    public static Complex div(Complex z1, Complex z2){

        double divider;
        divider = Math.pow(z2.getRe(), 2) + Math.pow(z2.getIm(), 2);

        return new Complex((z1.getRe() * z2.getRe() + z1.getIm() * z2.getIm())/divider,
                (z1.getIm() * z2.getRe() - z1.getRe() * z2.getIm())/divider);

    }

}
