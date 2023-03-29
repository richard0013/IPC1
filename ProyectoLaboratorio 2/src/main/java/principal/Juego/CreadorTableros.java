package principal.Juego;
import Jugador.Jugador;
import principal.Casillas.*;
import principal.common.LectorOpciones;
import Personajes.*;
        
public class CreadorTableros {

    public CasillaVacilla [][] NuevoTablero(int columnas, int filas){
        CasillaVacilla [][] tablero = new CasillaVacilla[columnas][filas];
        int contadorCasillas=0;
        int probabilidades[] = porcentajesProbabilidad();
      
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {

                int opcion =(int) (Math.random()*100)+1;

                if (opcion>0 && opcion<=probabilidades[0]){
                    tablero[i][j]= new CasillaVacilla();
                }  else if  (opcion>=probabilidades[0] && opcion<probabilidades[1] ){
                    tablero[i][j]= new CasillaArbol();
                } else if (opcion>=probabilidades[1] && opcion<probabilidades[2]){
                    tablero[i][j]= new CasillaAgua();
                } else {
                    tablero[i][j]= new CasillaLava();
                }
                tablero[i][j].setNumeroCasilla(contadorCasillas);
                contadorCasillas++;
            }
        }

        return tablero;
    }

    public int[] porcentajesProbabilidad(){
        String tipos []= {"Planicie", "Agua", "Arbol", "Lava"};
        int control=100;
        int acumulado=0;
        int porcentajes[]= new int[4];
        for (int i = 0; i < 4; i++) {
            int porcentaje= LectorOpciones.Opcion("ingrese Porcentaje de probabilidad para casillas tipo " + tipos[i]
                    + "/n porcentaje restante "+ control);
            if (porcentaje<control && i>0){
                porcentajes[i]=porcentaje+porcentajes[i-1];
                control-=porcentaje;
            }else{
                porcentajes[i]=porcentaje;
                control-=porcentaje;
            }
            if (i==2){
                porcentajes[i+1]=100;
                i++;
            }
        }
        return porcentajes;
    }
    
   
    public CasillaVacilla[][] Defecto(){
        TableroDefecto mapa = new TableroDefecto();
        int [][] defecto=mapa.getTableroDefecto();
        int contadorCasillas=0;
        CasillaVacilla [][] tableroDefecto = new CasillaVacilla[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(defecto[i][j]==0){
                    tableroDefecto[i][j]=new CasillaVacilla();
                } else if(defecto[i][j]==1){
                    tableroDefecto[i][j]= new CasillaArbol();
                } else if(defecto [i][j]==2){
                    tableroDefecto[i][j]= new CasillaAgua();
                } else if(defecto[i][j]== 3){
                    tableroDefecto[i][j]= new CasillaLava();
                }
                tableroDefecto[i][j].setNumeroCasilla(contadorCasillas);
                contadorCasillas++;
            }
        }
        return tableroDefecto;
    }
    
    public CasillaVacilla[][] crearEnemigos(int cantidadEnemigos, CasillaVacilla[][] tablero){
        int total= tablero.length*tablero[0].length;
        for (int i = 0; i < cantidadEnemigos; i++) {
            int posicion= (int)(Math.random()*total)+1;
            
            for (int j = 0; j < tablero.length; j++) {
                for (int k = 0; k < tablero[0].length; k++){
                    if(tablero[j][k].getNumeroCasilla()==posicion){
                        if(tablero[j][k].getTipoCasilla().equalsIgnoreCase("CasillaVacilla")&&tablero[j][k].isOcupado()==false && tablero[j][k].isJugable()== true){
                            int Enemigo=(int)(Math.random()*5)+1;
                            if(Enemigo==1){
                                tablero[j][k].setPersonaje(new ogro());
                            } else if(Enemigo==2){
                                tablero[j][k].setPersonaje(new bruja());
                            } else if(Enemigo==3){
                                tablero[j][k].setPersonaje(new cancerbero());
                            } else if(Enemigo==4){
                                tablero[j][k].setPersonaje(new gargola());
                            } else if(Enemigo==5){
                                tablero[j][k].setPersonaje(new florCarnivora());
                            }
                            tablero[j][k].setOcupado(true);
                            tablero[j][k].setDibujoPersonaje(tablero[j][k].getPersonaje().getDibujo());
                        }else{
                            i--;
                        }
                    }
                    
                }
            }
        }
        return tablero;
    }

    public Jugador asignarEnemigo(Jugador jugador, Tablero tablero){
        CasillaVacilla[][] vacilla = tablero.getTablero();
        for (int i = 0; i < vacilla.length; i++) {
            for (int j = 0; j < vacilla[0].length; j++) {
                if (vacilla[i][j].getPersonaje()!=null) {
                    if (vacilla[i][j].getPersonaje().getNombre().equalsIgnoreCase("Flor Carnivora") ||
                            vacilla[i][j].getPersonaje().getNombre().equalsIgnoreCase("Cancerbero") ||
                            vacilla[i][j].getPersonaje().getNombre().equalsIgnoreCase("Ogro") ||
                            vacilla[i][j].getPersonaje().getNombre().equalsIgnoreCase("Gargola") ||
                            vacilla[i][j].getPersonaje().getNombre().equalsIgnoreCase("Bruja")) {
                        jugador.agregarPersonaje(vacilla[i][j].getPersonaje());
                        jugador.asignarPosicionPer((jugador.getContadorPersonaje() - 1), i, j);
                    }
                }
            }
        }
        return jugador;
    }
   
}
