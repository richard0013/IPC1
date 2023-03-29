/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import Jugador.Jugador;
import Tienda.Tienda;
import principal.Juego.CreadorTableros;
import principal.Juego.Juego;
import principal.Juego.Tablero;
import principal.common.LectorOpciones;

/**
 *
 * @author user
 */
public class LanzadorJuego {
    private int cantidadTablero=0;
    private CreadorTableros crear = new CreadorTableros();
    private Tablero listaTablero[] = new Tablero[10];
    public Jugador jugador;

    public LanzadorJuego() {
        jugador = new Jugador();
        jugador.setNombre(LectorOpciones.ImprimirTextos("Ingrese su nombre para iniciar el Juego"));
        menu();
    }
    
    
    
    public void menu(){
        boolean salir = false;
        listaTablero[0]= new Tablero(crear.Defecto());
        cantidadTablero++;
        while(!salir){
        System.out.println(""
                + "\n\n\n"
                + ":::::::::  ::::::::::: :::::::::: ::::    ::: :::     ::: :::::::::: ::::    ::: ::::::::::: :::::::::   ::::::::  \n" +
":+:    :+:     :+:     :+:        :+:+:   :+: :+:     :+: :+:        :+:+:   :+:     :+:     :+:    :+: :+:    :+: \n" +
"+:+    +:+     +:+     +:+        :+:+:+  +:+ +:+     +:+ +:+        :+:+:+  +:+     +:+     +:+    +:+ +:+    +:+ \n" +
"+#++:++#+      +#+     +#++:++#   +#+ +:+ +#+ +#+     +:+ +#++:++#   +#+ +:+ +#+     +#+     +#+    +:+ +#+    +:+ \n" +
"+#+    +#+     +#+     +#+        +#+  +#+#+#  +#+   +#+  +#+        +#+  +#+#+#     +#+     +#+    +#+ +#+    +#+ \n" +
"#+#    #+#     #+#     #+#        #+#   #+#+#   #+#+#+#   #+#        #+#   #+#+#     #+#     #+#    #+# #+#    #+# \n" +
"#########  ########### ########## ###    ####     ###     ########## ###    #### ########### #########   ########  "
                + "\n\n\n\n\n"
                + "ESTE ES UN JUEGO DE ESTRATEGIA EN EL QUE LUCHARA CONTRA BRUJAS, GARGOLAS, CANCERBEROS Y OTRAS CRIATURAS,"
                +"\n\n");
        
        
        System.out.println("Opcion 1 Iniciar Partida");
        System.out.println("Opcion 2 Tienda");
        System.out.println("Opcion 3 Generacion de tablero");
        System.out.println("Opcion 4 Inventario");
        System.out.println("Opcion 10 Salir");
        int opcion =LectorOpciones.Opcion("PORFAVOR SELECCIONE EL NUMERO DE OPCION QUE DESEA EJECUTAR Y DESPUES PRESIONE LA TECLA ENTER/RETURN.");
        switch (opcion) {
            case 1:
                while (jugador.isInicio()==false && jugador.getContadorPersonaje()<2){
                    System.out.println(LectorOpciones.getAnsiRedBackground()+"Antes de Iniciar es Necesario tener como minimo 2 Personajes en el Inventario"+LectorOpciones.getAnsiReset());
                    tienda();
                }
                Juego nuevoJuego= new Juego(jugador);
                nuevoJuego.subMenuJuego( cantidadTablero, listaTablero);
                listaTablero= nuevoJuego.getListaTablero();
                cantidadTablero=nuevoJuego.getCantidadTablero();
                jugador= nuevoJuego.getJugador();
                break;
            case 2:
                tienda();
                break;
            case 3:
                crearTablero();
                break;
            case 4:
                ImprimirInventario();
                break;

            case 10:
                salir=true;
        }
        }
    }

    public void crearTablero(){

        System.out.println("En esta seccion Podra crear un tablero personalizado, ingresando primero el numero de columnas y despues el numero de filas. \n\n");
        int columnas = LectorOpciones.Opcion("Escoja la cantidad de columnas para el tablero");
        int filas = LectorOpciones.Opcion("Escoja la cantidad de filas para el tablero");
        listaTablero[cantidadTablero]= new Tablero(crear.NuevoTablero(columnas,filas));
        listaTablero[cantidadTablero].imprimirTablero();
        cantidadTablero++;
    };

    public void tienda(){
        Tienda tienda= new Tienda();
        tienda.Compra(jugador);
    }

    public void ImprimirInventario(){
        System.out.println("\n-------------Inventario de Personajes-------------");
        for (int i = 0; i < jugador.getContadorPersonaje(); i++) {
            System.out.println(jugador.personaje(i));
        }
        System.out.println("\n-------------Inventario de Objetos---------");
        for (int i = 0; i < 3; i++) {
            System.out.println(jugador.ObjetoToString(i));
        }
        System.out.println("\n-------------Inventario de Mejoras---------");
        for (int i = 3; i < 6; i++) {
            System.out.println(jugador.ObjetoToString(i));
        }
        LectorOpciones.ImprimirTextos("\n\nPresione Enter para continuar");
    }

    
}
