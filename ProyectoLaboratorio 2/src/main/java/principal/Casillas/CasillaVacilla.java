package principal.Casillas;

import Personajes.Personajes;

public class CasillaVacilla {
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    String dibujo = "   ";
    protected String dibujoPersonaje=" "; 
    protected int numeroCasilla; 
    protected boolean ocupado;
    protected String tipoCasilla= "casillaVacilla";
    protected boolean jugable;
    
//solo las clases hijas pueden acceder o modificar las variable protected
    
    protected int vida;
    protected Personajes personaje;

    public CasillaVacilla() {
        this.jugable=true;
        this.ocupado= false;
    }

    public String getDibujo() {
                String dibujo2 = ANSI_WHITE_BACKGROUND +" "+this.dibujoPersonaje+" "+ANSI_RESET;
        return dibujo2;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setDibujoPersonaje(String dibujoPersonaje) {
        this.ocupado = true;
        this.dibujoPersonaje = dibujoPersonaje;
    }
    
    public void returnOrigin(){
        this.dibujoPersonaje=" ";
        this.ocupado = false;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public void setNumeroCasilla(int numeroCasilla) {
        this.numeroCasilla = numeroCasilla;
    }

    public String getTipoCasilla() {
        return tipoCasilla;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setPersonaje(Personajes personaje) {
        this.personaje = personaje;
    }
    
    public void modificarDibujoPersonaje(){
        this.dibujoPersonaje= personaje.getDibujo();
    }

    public boolean isJugable() {
        return jugable;
    }

    public void setJugable(boolean jugable) {
        this.jugable = jugable;
    }

    public Personajes getPersonaje() {
        return personaje;
    }
    
}
