/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

/**
 *
 * @author user
 */
public class bruja extends Personajes {

    public bruja() {
        this.vuela=true;
        this.vida=150;
        this.dano=45;
        this.movimientoMaximo=1;
        this.dibujo=RED+"B";
        this.nombre="Bruja";
        this.Ataque="lanza un hechizo en toda una línea, que impacta con el primer personaje o árbol que encuentre";
    }
    
}
