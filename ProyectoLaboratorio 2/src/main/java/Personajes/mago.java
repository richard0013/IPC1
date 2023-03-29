/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

/**
 *
 * @author user
 */
public class mago extends Personajes {

    public mago() {
        this.vuela=true;
        this.vida=100;
        this.dano=60;
        this.movimientoMaximo=1;
        this.dibujo=PURPLE+"M";
        this.precio=200;
        this.nombre="Mago";
        this.Ataque="dispara un hechizo hacía el final de una línea que impacta en el primer enemigo/obstáculo que se encuentre";
    }
    
}
