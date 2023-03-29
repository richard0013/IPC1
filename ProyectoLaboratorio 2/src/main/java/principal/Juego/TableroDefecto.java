/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.Juego;
import principal.Casillas.CasillaAgua;
import principal.Casillas.CasillaArbol;
import principal.Casillas.CasillaLava;
import principal.Casillas.CasillaVacilla;

public class TableroDefecto {
    static int [][] mapaUno = {{0,0,2,0,0,0,0,0},
            {0,1,2,0,0,3,0,0},
            {0,0,2,0,1,0,0,1},
            {0,0,1,0,2,2,2,2},
            {0,0,0,0,0,0,0,0},
            {2,2,2,2,1,0,0,3},
            {0,1,0,0,0,0,1,0},
            {0,0,0,3,0,0,0,0}}; 
    /* 0= Planicie, 1=*/


    public int[][] getTableroDefecto(){
        
        return mapaUno;
    }


}
