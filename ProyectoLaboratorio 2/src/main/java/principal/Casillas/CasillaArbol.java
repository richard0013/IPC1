package principal.Casillas;

public class CasillaArbol extends CasillaVacilla{

    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    public CasillaArbol() {
        this.setVida(75);
        this.jugable = false;
    }

    @Override
    public String getDibujo() {
        String dibujo2 =  ANSI_GREEN_BACKGROUND+" "+this.dibujoPersonaje+" "+ANSI_RESET;
        return dibujo2;
    }

    public void ataqueVida(int cantidadAtaque){
        this.setVida(this.getVida()-cantidadAtaque);
    }
}
