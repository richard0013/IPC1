
package Personajes;

/**
 *
 * @author user
 */
public class florCarnivora extends Personajes {

    public florCarnivora() {
        this.vuela=false;
        this.vida=250;
        this.dano=30;
        this.movimientoMaximo=0;
        this.dibujo=RED+"F";
        this.nombre= "Flor Carnivora";
        this.Ataque ="golpea con sus raíces a todos los personajes que estén en una línea en un rango de tres casillas";
    }
}
