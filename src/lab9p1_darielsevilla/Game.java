/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_darielsevilla;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Game {
    public int[][] primeraMat = new int[10][10];
    public int[][] segundaMat = new int[10][10];
    public ArrayList<String> list;
    public int rondas;
    
    public Game(){
        
    }
    //getters y setters
    public int[][] getPrimerMat(){
        return primeraMat;
    }
    
    public int[][] getSegundaMat(){
        return segundaMat;
    }
    
    public ArrayList<String> getList(){
        return list;
    }
    
    public int getRondas(){
        return rondas;
    }
    
    public void setPrimerMat(int[][] par){
        primeraMat = par;
    }
    
    public void setSegundaMat(int[][] par){
        segundaMat = par;
    }
    
    public void setList(ArrayList<String> par){
        list = par;
    }
    
    public void setRondas(int par){
        rondas = par;
    }
    
    //metodos adicionales
    public void juego(int x){
        for(int i = 0; i < x; i++){
            nextGen();
            print(list);
        }
    }
    
    public void nextGen(){
        //remover elementos de lista
        
        list = new ArrayList<String>();
        
        
        for(int i = 1; i < primeraMat.length-2; i++){
            for(int j = 1; j < primeraMat[0].length-2; j++){
                //chequear los alrededores
                int cont = 0;
                for(int x = -1; x < 2; x++){
                    for(int y = -1; y < 2; y++){
                       if(x != 0 || y != 0){
                           if(primeraMat[i + x][j + y] == 1){
                               cont++;
                           }
                       }
                    }
                }
                
                //convertir en cero y uno;
                if ((cont < 2 && primeraMat[i][j] == 1) || (cont >= 3 && primeraMat[i][j] == 1)){
                    segundaMat[i][j] = 0;
                }else if((primeraMat[i][j] == 0 && cont == 3) || (primeraMat[i][j] == 1 && cont == 2)){
                    segundaMat[i][j] = 1;
                    String temp = String.format("%d:%d", j,i);
                    list.add(temp);
                }
                        
                
                
                
                
            }
        }
        
        //swap arrays
        setPrimerMat(segundaMat);
        setSegundaMat(new int[10][10]);
                
    }
    
    public void print(ArrayList<String> x){
        System.out.println("\n");
        
        int[][] temp = new int[10][10];
        for(int i = 0; i < x.size(); i++){
            System.out.printf("[%s]", x.get(i));
            String[] tempo = x.get(i).split(":");
            temp[Integer.parseInt(tempo[1])][Integer.parseInt(tempo[0])] = 1;
        }
        System.out.println("\n");
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length;j++){
                String temporal = String.format("[%d]", temp[i][j]);
                System.out.print(temporal);
            }
            System.out.println("\n");
        }
        
        
    }
    
}
