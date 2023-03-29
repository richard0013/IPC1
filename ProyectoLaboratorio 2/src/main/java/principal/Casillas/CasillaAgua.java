/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.Casillas;

/**
 *
 * @author user
 */
public class CasillaAgua extends CasillaVacilla{

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RESET = "\u001B[0m";

    public CasillaAgua() {
       this.jugable=false;
    }

    @Override
    public String getDibujo() {
        String dibujo2 =  ANSI_BLUE_BACKGROUND+" "+this.dibujoPersonaje+" "+ANSI_RESET;
        return dibujo2;
    }

 }