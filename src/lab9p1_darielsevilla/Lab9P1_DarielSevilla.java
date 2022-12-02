/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_darielsevilla;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Lab9P1_DarielSevilla {
    static Scanner lea = new Scanner(System.in);
    static SecureRandom random = new SecureRandom();
    static Game game = new Game();
    public static int[][] llenarMatriz(int[][] par1, int[][] par2, ArrayList<String> lista){
       
        for(int i = 0; i < par1.length; i++){
            for(int j = 0; j < par1[0].length; j++){
                if(i == 0 || i == par1.length-1 || j == 0 || j == par1[i].length-1){
                    par1[i][j] = 0;
                } else {
                    par1[i][j] = random.nextInt(2);
                }
            }
        }
        
        for(int i = 0; i < par1.length; i++){
            for(int j = 0; j < par1[0].length; j++){
                if(par1[i][j] == 1){
                    String temp = String.format("%d:%d", j, i);
                    lista.add(temp);
                }
            }
        }
        
        game.setList(lista);
        
        
        return par1;
    }
    
    
    public static int menu(){
        int menu = 0;
        System.out.println("\n--Menu opciones--\n\n");
        System.out.println("1-Juego");
        System.out.println("2-Salida");
        System.out.print("Ingrese opcion:");
        menu = lea.nextInt();
        return menu;
    }
    
    public static void main(String[] args) {
        int menu = 0;
        do{
            menu = menu();
            
            switch(menu){
                case 1:
                    
                    System.out.print("Cuantas rondas desea jugar? :");
                    int rondas = lea.nextInt();
                    
                    //columnas = x, filas = y
                    ArrayList<String> coords = new ArrayList<>();
                    
                    int[][] mat1 = new int[10][10];
                    int[][] newMat = new int[10][10];
                    mat1 = llenarMatriz(mat1, newMat, coords);
                    game.setPrimerMat(mat1);
                    game.setRondas(rondas);
                    System.out.println("Matriz base:");
                    game.print(game.getList());
                    System.out.println("Rondas:");
                    game.juego(game.getRondas());
                    break;
            }
        }while(menu != 2);
    }
    
}
