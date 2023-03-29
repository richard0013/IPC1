
package Personajes;

/**
 *
 * @author user
 */
public class arquero extends Personajes {

    public arquero() {
        this.vuela=false;
        this.vida=150;
        this.dano=100;
        this.movimientoMaximo=3;
        this.dibujo=PURPLE+"A";
        this.precio=200;
        this.nombre = "Arquero";
        this.Ataque=" dispara una flecha a cualquier punto en un rango de tres casillas, en cualquiera de las líneas";
    }
     
}
