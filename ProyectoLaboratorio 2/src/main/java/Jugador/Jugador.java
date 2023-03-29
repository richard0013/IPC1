/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugador;

import Personajes.Personajes;
import Tienda.*;

import java.util.Arrays;

/**
 *
 * @author user
 */
public class Jugador {
    private String nombre;
    private int oro;
    private Personajes inventario[];
    public static final String GREEN = "\u001B[42m";
    public static final String RESET = "\u001B[0m";
    private boolean inicio;
    private int contadorPersonaje;
    private int contadorObjetos;
    private ObjetosMejoras [] objetos;
    private Personajes principales[];

    public Jugador() {
        this.oro=500;
        inventario= new Personajes[5];
        objetos = new ObjetosMejoras[6];
        this.contadorObjetos=0;
        this.contadorPersonaje=0;
        this.inicio=false;
        objetos[0]= new SemillaVida();
        objetos[1]=new Elixir();
        objetos[2]= new CapaMovimiento();
        objetos[3]= new vida();
        objetos[4]= new daño();
        objetos[5]= new movilidad();
        this.principales= new Personajes[2];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public Personajes[] getInventario() {
        return inventario;
    }

    public void setInventario(Personajes[] inventario) {
        this.inventario = inventario;
    }

    public int getContadorPersonaje() {
        return contadorPersonaje;
    }

    public int getContadorObjetos() {
        return contadorObjetos;
    }
    
    public void agregarPersonaje(Personajes personaje){
        inventario[contadorPersonaje]=personaje;
        contadorPersonaje++;
    }
    
    public void agregarObjetos(String nombre){
        for (int i = 0; i < 6; i++) {
            if (objetos[i].getNombre().equalsIgnoreCase(nombre)){
                objetos[i].AgregarObjeto();
            }
        }
        contadorObjetos++;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    @Override
    public String toString() {
        return "-------------------Jugador----------------------\n" +
                "------------------" + nombre + "---------------\n" +
                "------------------- oro=" + oro +"--------------------------\n";
    }
    public Personajes personaje(int pos){
        return inventario[pos];
    }

    public void AsignarPeronajes(Personajes personaje, int pos){
        principales[pos]= personaje;

    }

    public Personajes jugables(int pos){
        return principales[pos];
    }

    public String ObjetoToString(int pos){
        String response=objetos[pos].toString()+"\t\t"+GREEN+"Cantidad "+objetos[pos].getCantidad()+RESET;
        return response;
    }

    public void asignarPosicion(int pos, int posY, int posX){
        principales[pos].setPosY(posY);
        principales[pos].setPosX(posX);
    }
    public void asignarPosicionPer(int pos, int posY, int posX){
        inventario[pos].setPosY(posY);
        inventario[pos].setPosX(posX);
    }
    public  void limpiarPrincipales(){
        principales[0]=null;
        principales[1]=null;
    }
    public void limpiarInventario(){
        contadorPersonaje=0;
    }
}
