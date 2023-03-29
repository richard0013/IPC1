/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda;

/**
 *
 * @author user
 */
public class ObjetosMejoras {
    protected int precio;
    protected boolean objetos;
    protected String nombre;
    protected String descripcion;
    protected int cantidad;

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isObjetos() {
        return objetos;
    }

    public void setObjetos(boolean objetos) {
        this.objetos = objetos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre + "        precio= " + precio +"\n\t" + descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void AgregarObjeto(){
        this.cantidad++;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad() {
        this.cantidad++;
    }
}
