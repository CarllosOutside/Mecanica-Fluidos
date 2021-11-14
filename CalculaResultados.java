/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fenomenotransporte;

import static java.lang.Math.sqrt;

/**
 *
 * @author peterpc
 */
public class CalculaResultados {
    public double gamma_concreto = 25; //em kN/m^3
    //Calcula ponto de aplicação da força hidrostática, com origem no solo, em metros
    public double PontoDeAplicacao(double h, double L){
        double y_cp = (double) ((h/2)+ ((L*Math.pow(h, 3))/12)/((h/2)*L*h));
        return (h-y_cp);
    }
    
        //Calcula largura da base da parede, em metros
    public double LarguraBase(double gamma_fluido, double h){
        double b = (h/3) * sqrt((3*gamma_fluido)/gamma_concreto);
        return b;                                                                               //retorna uma base mínima que permite gerar momento o suficiente para evitar que a barragem caia
    }
    
       //Calcula a intensidade da força hisdrostatica exercida na parede, em kN
    public double IntensidadeForca(double gamma_fluido, double h, double L){
        double i = gamma_fluido*L*Math.pow(h, 2)/2;
        return i; 
    }
    
    //retorna o peso da parede em kN
     public double PesoParede(double b, double h, double L){
        double p = gamma_concreto*L*b*h;
        return p; 
    }
}
