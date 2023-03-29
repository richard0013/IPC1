package principal.Juego;

import Personajes.Personajes;
import principal.Casillas.CasillaVacilla;

public class LimpiraTablero {

    public CasillaVacilla[][] limpiarTablero(CasillaVacilla[][] vacillas){
        for (int i = 0; i < vacillas.length; i++) {
            for (int j = 0; j < vacillas[0].length; j++) {
                if (vacillas[i][j].isJugable()){
                    vacillas[i][j].setOcupado(false);
                    vacillas[i][j].returnOrigin();
                }
            }
        }
        return vacillas;
    }

    public CasillaVacilla limpiarCasilla(CasillaVacilla casillaVacilla){
        if (casillaVacilla.isOcupado()){
            casillaVacilla.setOcupado(false);
            casillaVacilla.returnOrigin();
        }
        return casillaVacilla;
    }

    public CasillaVacilla[][] ocuparCasilla(int posYI, int posXI, int posF, CasillaVacilla[][] casillaVacillas, Personajes personaje){
        int posIni=casillaVacillas[posYI][posXI].getNumeroCasilla();
        for (int i = 0; i < casillaVacillas.length; i++) {
            for (int j = 0; j < casillaVacillas[0].length; j++) {
                if (casillaVacillas[i][j].getNumeroCasilla()==posIni){
                    casillaVacillas[i][j].setOcupado(false);
                    casillaVacillas[i][j].returnOrigin();
                }
                if (casillaVacillas[i][j].getNumeroCasilla()==posF){
                    casillaVacillas[i][j].setOcupado(true);
                    casillaVacillas[i][j].setPersonaje(personaje);
                    casillaVacillas[i][j].modificarDibujoPersonaje();
                }
            }
        }
        return casillaVacillas;
    }
}
