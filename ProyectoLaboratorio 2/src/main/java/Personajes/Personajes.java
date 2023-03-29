
package Personajes;


public class Personajes {
    protected int vida;
    protected int dano;
    protected int movimientoMaximo;
    protected int precio;
    protected String dibujo;
    protected String nombre;
    protected boolean vuela;
    protected int posY;
    protected int posX;
    protected String RED= "\u001B[41m";
    protected String PURPLE= "\u001B[45m";

    protected String Ataque;

    public Personajes() {

    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getMovimientoMaximo() {
        return movimientoMaximo;
    }

    public void setMovimientoMaximo(int movimientoMaximo) {
        this.movimientoMaximo = movimientoMaximo;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDibujo() {
        return dibujo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + "--------------" +
                "precio=" + precio + "--------------\n"+

                "\t Ataque:" + Ataque +"\n";
    }

    public boolean isVuela() {
        return vuela;
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}
