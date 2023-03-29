package principal.Juego;

import Personajes.Personajes;
import principal.Casillas.CasillaVacilla;

public class Movimientos {
    private CasillaVacilla[][] casillaVacillas;
    public Movimientos(CasillaVacilla[][] vacillas) {
        casillaVacillas=vacillas;
    }

    public int [] comprobarMovimiento(CasillaVacilla[][] casillaVacilla, int nuevaPos, Personajes personajes){
        int response[]= new int[3];
        for (int i = 0; i < casillaVacilla.length; i++) {
            for (int j = 0; j < casillaVacilla[0].length; j++) {
                if (nuevaPos==casillaVacilla[i][j].getNumeroCasilla()){
                    response[1]=i;
                    response[2]=j;
                }
            }
        }
        boolean response1= comprobarCantidadMovimiento(personajes.getPosY(), personajes.getPosX(), response[1], response[2],
                            personajes.getMovimientoMaximo(), personajes);
        if (response1==true){
            response1=comprobarObstaculos(personajes.getPosY(), personajes.getPosX(), response[1],response[2],personajes);
        }
        if (response1==true){
            response[0]=1;
        }
        return response;
    }

    public boolean comprobarCantidadMovimiento(int posYI, int posXI, int posYF, int posXF, int maximo, Personajes personaje){
        boolean response=false;
        int vertical = Math.abs(posYI-posYF);
        int horizontal = Math.abs(posXF-posXI);
        int casillas=0;
        if (vertical>0 && horizontal==0){
            casillas= vertical;
        }else if(horizontal>0 && vertical==0){
            casillas= horizontal;
        }else{
            casillas=100;
        }

        if (casillas<=personaje.getMovimientoMaximo()){
            response= true;
        }
        return response;
    }

    public boolean comprobarObstaculos(int posYI, int posXI, int posYF, int posXF, Personajes personaje){
        int vertical = Math.abs(posYI-posYF);
        int horizontal = Math.abs(posXF-posXI);
        int casillas=0;
        int avance=0;

        if (posYF-posYI>0 || posXF-posXI>0){
            avance=1;
        }else{
             avance=-1;
        }
        if (vertical>0 && horizontal==0){
            while((posYF!=posYI ||posYF==posYI) && posYF>=0 && posYF<=casillaVacillas[0].length){
                if (casillaVacillas[posYI][posXI].isJugable()==false){
                    return false;
                }
                if (posYF==posYI)return true;
                posYI+=avance;
            }
        }else if(horizontal>0 && vertical==0){
            while((posXF!=posXI ||posXF==posXI) && posXF>=0 && posXF<=casillaVacillas[0].length){
                if (casillaVacillas[posYI][posXI].isJugable()==false){
                    return false;
                }
                if (posXF==posXI)return true;
                posXI+=avance;
            };
        }

        return true;
    }
}
