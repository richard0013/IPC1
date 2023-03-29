package principal.Juego;
import Jugador.Jugador;
import Tienda.*;
import principal.Casillas.CasillaVacilla;
import principal.common.LectorOpciones;

import java.sql.SQLOutput;

public class Juego {
    private int cantidadTablero=0;
    private CreadorTableros crear = new CreadorTableros();
    private Tablero listaTablero[];
    private Jugador jugador;
    private Jugador boot;
    private Tablero tableroElegido;
    private LimpiraTablero limpia;
    private int tabActual;

    public Juego(Jugador jugador) {
        this.jugador = jugador;
        listaTablero= new Tablero[10];
        this.limpia= new LimpiraTablero();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void subMenuJuego(int contador, Tablero[] table){
        this.listaTablero = table;
        this.cantidadTablero=contador;
        boolean salir=false;
        while(salir==false) {
            System.out.println("\n"
                    + "\n opcion 1 = Nuevo Juego "
                    + "\n opcion 2 = Crear nuevo Tablero"
                    + "\n opcion 3 = Salir"
            );
            int opcion = LectorOpciones.Opcion("Eliga la Opcion que desee");
            switch (opcion) {
                case 1:
                    NuevoJuego();
                    listaTablero[tabActual].setTablero(limpia.limpiarTablero(listaTablero[tabActual].getTablero()));
                    break;
                case 2:
                    crearTablero();
                    break;
                case 3:
                    salir=true;
                    break;
            }
        }
    }
    public void NuevoJuego(){
        boolean eleccion=false;
        escogerPersonajes(1);
        escogerPersonajes(2);
        while (eleccion==false) {
            System.out.println("------------------Elegir Tablero----------------------");
            for (int i = 0; i < cantidadTablero; i++) {
                System.out.println("------------------Opcion " + (i + 1) + " -----------------");
                imprimirTablero(i);
            }
            tabActual=LectorOpciones.Opcion("El Tablero en el que desea Jugar")-1;
            if (tabActual<cantidadTablero){
                eleccion=true;
            }
        }
        tableroElegido=new Tablero(listaTablero[tabActual].getTablero());
        posisionarPrincipales("Primario", 0);
        posisionarPrincipales("Secundario", 1);
        tableroElegido.setTablero(crear.crearEnemigos(2, tableroElegido.getTablero()));
        imprimirTablero();
        turnos();
    }

    public void crearTablero(){

        System.out.println("En esta seccion Podra crear un tablero personalizado ");
        int columnas = LectorOpciones.Opcion("Escoja la cantidad de columnas para el tablero ");
        int filas = LectorOpciones.Opcion("Escoja la cantidad de filas para el tablero ");
        listaTablero[cantidadTablero]= new Tablero(crear.NuevoTablero(columnas,filas));
        imprimirTablero(cantidadTablero);
        cantidadTablero++;
    };

    public int getCantidadTablero() {
        return cantidadTablero;
    }

    public Tablero[] getListaTablero() {
        return listaTablero;
    }
    
    public void imprimirTablero(int posicion){
        listaTablero[posicion].imprimirTablero();
    }

    public void imprimirTablero(){
        tableroElegido.imprimirTablero();
    }
    
    public void Tienda(){
        ObjetosMejoras objetos[]=new ObjetosMejoras[6];
        objetos[0]= new SemillaVida();
        
        for (int i = 0; i < 6; i++) {
            System.out.println(objetos[i].toString());
        }
    }
    public void escogerPersonajes(int num){
        String perso=(num==1) ? "Principal" : "Secundario";
        System.out.println("---------Lista de Personajes------------");
        for (int i = 0; i < jugador.getContadorPersonaje() ; i++) {
            if (jugador.jugables(0)==null){
                System.out.println("Opcion No: "+(i+1)+"  "+jugador.personaje(i).toString());
            }else if(jugador.jugables(0)!=null && !jugador.jugables(0).getNombre().equalsIgnoreCase(jugador.personaje(i).getNombre()))
                System.out.println("Opcion No: "+(i+1)+"  "+jugador.personaje(i).toString());
        }
        int opcion1=LectorOpciones.Opcion("Ingrese la Opcion para el Personaje"+ perso);
        if (num==1){
            jugador.AsignarPeronajes(jugador.personaje(opcion1-1),0);
        }else if(num==2){
            jugador.AsignarPeronajes(jugador.personaje(opcion1-1),1);
        }
    }

    public void posisionarPrincipales(String persona, int pos1){
        boolean valido=true;
        CasillaVacilla[][] casilla = tableroElegido.getTablero();
        int pos= LectorOpciones.casillaPosision( "Elija la casilla en donde empezara el personaje "+jugador.jugables(pos1).getNombre()+" (Ejemplo B2)",
                casilla[0].length,casilla.length);
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[0].length; j++) {
                if (casilla[i][j].getNumeroCasilla()==pos && casilla[i][j].isJugable()==true){
                    casilla[i][j].setPersonaje(jugador.jugables(pos1));
                    casilla[i][j].setOcupado(true);
                    casilla[i][j].modificarDibujoPersonaje();
                    jugador.asignarPosicion(pos1, i, j);
                    valido=true;
                    j=casilla.length;
                    i=casilla[0].length;
                }else{
                    valido=false;
                }
            }
        }
        if (valido==false){
            System.out.println("-----------La Casilla Elegida es Invalida--------------------");
            posisionarPrincipales(persona, pos);
        }
        tableroElegido.setTablero(casilla);
    }

    public void turnos(){
        boolean salir = false;
        int apuntador=0;
        boot= crear.asignarEnemigo(new Jugador(), tableroElegido);
        boot.limpiarInventario();
        CasillaVacilla[][] casilla1= tableroElegido.getTablero();
        Movimientos movi= new Movimientos(casilla1);
        while (!salir){
            boolean terminarTurno=false;
            while(!terminarTurno) {
                System.out.println("Turno Jugador " + jugador.getNombre() + "--------Personaje Actual " + jugador.jugables(apuntador).getNombre());
                System.out.println("Opcion 1: Mover Personaje");
                System.out.println("Opcion 2: Cambiar Personaje");
                System.out.println("Opcion 3: Utilizar Mejoras/Objetos");
                System.out.println("Opcion 4: Salir del Juego");
                int res=LectorOpciones.Opcion("Ingrese la opcion elegida");
                switch (res){
                    case 1:
                        tableroElegido.imprimirTablero();
                        int res1= LectorOpciones.casillaPosision("Elija la casilla a mover al personaje "+jugador.jugables(apuntador).getNombre()+" (Ejemplo B2)",
                                casilla1[0].length,casilla1.length);
                        int[] resp2=movi.comprobarMovimiento(casilla1, res1,jugador.jugables(apuntador));
                        if (resp2[0]==1){
                            tableroElegido.setTablero(limpia.ocuparCasilla(jugador.jugables(apuntador).getPosY(),
                                    jugador.jugables(apuntador).getPosX(),res1,tableroElegido.getTablero(), jugador.jugables(apuntador)));
                            jugador.asignarPosicion(apuntador, resp2[1], resp2[2]);
                        }
                        terminarTurno=true;
                        break;
                    case 2:
                        if (apuntador==0){
                            apuntador=1;
                        }else{
                            apuntador =0;
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("\n\n -----------------------Los Datos se perderan------------------------");
                        jugador.limpiarPrincipales();
                        boot.limpiarInventario();
                        salir=true;
                        terminarTurno=true;
                        break;
                }
            }
            //turno Boot
            turnoBoot();
            tableroElegido.imprimirTablero();
        }
    }

    public void turnoBoot(){
        System.out.println("----------------------Empieza Turno Boot---------------");
        Movimientos movi= new Movimientos(tableroElegido.getTablero());
        boolean terminarTurno=false;
        int conta=0;
        while (!terminarTurno) {
            int moverEnemigo = (int) (Math.random() * boot.getContadorPersonaje());
            if (boot.personaje(moverEnemigo).getNombre().equalsIgnoreCase("Flor Carnivora")) break;
            int verticalHori = (int) (Math.random() * 2);
            int posNega = (int) (Math.random() * 2);
            int canCasi = (int) (Math.random() * 5);
            int posFY = 0;
            int posFX = 0;
            int posMov = 0;
            if (verticalHori == 0) {//mov Vertical
                if (posNega == 0) { // positivo
                    posFY = -canCasi;
                } else {
                    posFY = canCasi;
                }
                posFX = jugador.personaje(moverEnemigo).getPosX();
                posMov = tableroElegido.getCasilla((jugador.personaje(moverEnemigo).getPosY()+posFY), posFX).getNumeroCasilla();
            } else { // mov Horizontal
                if (posNega == 0) { // positivo
                    posFX = -canCasi;
                } else {
                    posFX = canCasi;
                }
                posFY = jugador.personaje(moverEnemigo).getPosY();
                posMov = tableroElegido.getCasilla(posFY, (jugador.personaje(moverEnemigo).getPosX()+posFX)).getNumeroCasilla();
            }
            int[] resp2 = movi.comprobarMovimiento(tableroElegido.getTablero(), posMov, boot.personaje(moverEnemigo));
            if (resp2[0] == 1) {
                tableroElegido.setTablero(limpia.ocuparCasilla(boot.personaje(moverEnemigo).getPosY(),
                        boot.personaje(moverEnemigo).getPosX(), posMov, tableroElegido.getTablero(), boot.personaje(moverEnemigo)));
                boot.asignarPosicionPer(moverEnemigo, resp2[1], resp2[2]);
                terminarTurno=true;
            }
            if (conta>=20) break;
            conta++;
        }
    }
}
