package principal.Juego;

import principal.Casillas.CasillaVacilla;
import principal.common.LectorOpciones;


public class Tablero {
    CasillaVacilla[][] tablero;

    public Tablero(CasillaVacilla[][] tablero2) {
        this.tablero = tablero2;
    }

    public CasillaVacilla[][] getTablero() {
        return tablero;
    }

    public void imprimirTablero(){
        Character cha[] = LectorOpciones.getAbcedario();
        System.out.print("  ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(" "+cha[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(""+(i+1)+" ");
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(this.tablero[i][j].getDibujo());
            }
            System.out.println();
        }
    }

    public void setTablero(CasillaVacilla[][] tablero) {
        this.tablero = tablero;
    }

    public void setCasilla(int posY, int posX, CasillaVacilla vacilla){
        tablero[posY][posX]=vacilla;
    }

    public CasillaVacilla getCasilla(int posY, int posX){
        if (posY>=tablero.length) posY= (tablero.length-1);
        if (posY<0)posY=0;
        if (posX>=tablero[0].length)posX=(tablero[0].length-1);
        if (posX<0)posX=0;

        return tablero[posY][posX];
    }
}
