/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.Casillas;

/**
 *
 * @author user
 */
public class CasillaLava extends CasillaVacilla{

    public static final String ANSI_YELLOW_BACKGROUND = "\033[43m";
    public static final String ANSI_RESET = "\u001B[0m";

    public CasillaLava() {
        this.jugable=false;
    }

    
    @Override
    public String getDibujo() {
        String dibujo2 =  ANSI_YELLOW_BACKGROUND+" "+this.dibujoPersonaje+" "+ANSI_RESET;
        return dibujo2;
    }

 }