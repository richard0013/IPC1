package Tienda;

import Jugador.Jugador;
import Personajes.*;
import principal.common.LectorOpciones;

public class Tienda {

    public Jugador Compra(Jugador jugador){
        boolean salir=false;
        while (salir==false && jugador.getOro()>0 ) {
            System.out.println(jugador.toString());
            int opcion=LectorOpciones.Opcion("Opcion 1 Comprar Personajes \nOpcion 2: Comprar Objetos/Mejoras\nOpcion 3: Salir");
            switch (opcion){
                case 1: jugador= CompraPersonajes(jugador);
                    break;
                case 2: jugador= CompraObjetos(jugador);
                        break;
                case 3:
                    salir=true;
                    break;
            }


        }
        return jugador;
    }

    public Jugador CompraPersonajes(Jugador jugador){
        Personajes[] personajes= new Personajes[5];
        personajes[0]= new caballero();
        personajes[1]= new arquero();
        personajes[2]= new mago();
        personajes[3]= new gigante();
        personajes[4]= new dragon();
        System.out.println(jugador.toString());
        if (jugador.getContadorPersonaje()<5){
            for (int i = 0; i < 5; i++) {
                boolean imprimir=true;
                for (int j = 0; j < jugador.getContadorPersonaje(); j++) {
                    if (personajes[i]== null || jugador.personaje(j).getNombre().equalsIgnoreCase(personajes[i].getNombre())){
                        imprimir=false;
                        personajes[i]=null;
                    }
                }
                if (imprimir==true) {
                    System.out.print("Opcion "+(i+1)+" ");
                    System.out.println(personajes[i].toString());
                }
            }
        }
        int opcion = LectorOpciones.Opcion("Opcion 6: Salir\n\nIngrese Opcion de Personaje a Comprar");
        if (opcion<6 ){
            if (personajes[opcion-1]!=null && jugador.getOro()>= personajes[opcion-1].getPrecio() ){
                jugador.agregarPersonaje(personajes[opcion-1]);
                jugador.setOro(jugador.getOro()-personajes[opcion-1].getPrecio());
                System.out.println("---------Compra Realizada con Exito-------------");
            }else{
                System.out.println("---------No cuenta con Suficiente Oro para realizar la compra o la compra no se puede realizar-------");
            }
        }
        return jugador;
    }

    public Jugador CompraObjetos(Jugador jugador){
        ObjetosMejoras objetosMejoras[] = new ObjetosMejoras[6];
        objetosMejoras[0]= new SemillaVida();
        objetosMejoras[1]=new Elixir();
        objetosMejoras[2]= new CapaMovimiento();
        objetosMejoras[3]= new vida();
        objetosMejoras[4]= new daño();
        objetosMejoras[5]= new movilidad();
        System.out.println(jugador.toString());
        System.out.println("Objetos a Comprar");
        for (int i = 0; i < 3; i++) {
            System.out.print("Opcion No "+(i+1)+"----");
            System.out.println(objetosMejoras[i].toString());
        }
        System.out.println(" Mejoras a Comprar");
        for (int i = 3; i < 6; i++) {
            System.out.print("Opcion No "+(i+1)+"----");
            System.out.println(objetosMejoras[i].toString());
        }
        int opcion = LectorOpciones.Opcion("Opcion 7: Salir\n\nIngrese la opcion que desea comprar");
        if (opcion<7){
            if (jugador.getOro()>=objetosMejoras[opcion-1].getPrecio()){
                jugador.setOro(jugador.getOro()-objetosMejoras[opcion-1].getPrecio());
                jugador.agregarObjetos(objetosMejoras[opcion-1].getNombre());
                System.out.println("---------Compra Realizada con Exito-------------");
            }else{
                System.out.println("---------No cuenta con Suficiente Oro para realizar la compra-------");
            }
        }

        return  jugador;
    }
}
