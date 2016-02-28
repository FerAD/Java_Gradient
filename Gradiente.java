/*

Karen Stephanie Abarca Garcia A01323627
Fernando Arey Duran A00397411


Programa que hace un gradiente de 800x600 que tiene:
 -en la esquina superior izquierda rojo (FF0000)
 -en la esquina superior derecha negro (000000)
 -en la esquina inferior izquierda magenta (FF00FF)
 -en la esquina inferior derecha verde (00FF00)
*/

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class Gradiente extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        int ancho = getWidth();
        int alto  = getHeight();       


        for (int j = 0;  j < 800 ; j++) { //Ciclo for que recorre el eje de las x

            for ( int i = 0 ; i < 600 ; i++ ) { //Ciclo for que recorre el eje de las y

                /*Para el componente rojo se hace un degradado horizontal 
                  Desde 255 para x = 0 hasta 0 para x = 799
                  Se aplica una regla de 3 para encontrar un valor entre 0 y 255 para cada uno de los 800 px
                */
                int rojo = 255 - (j*255)/799;

                /*En el componente verde se hace un degradado "diagonal" de derecha a izquierda
                  Donde x = 0 tiene un valor de 0 y x = 799 tiene un valor de 255
                  De igual forma y = 0 contiene 0 y y = 599 contiene 255
                  Se hace una regla de 3 para saber el valor que se tomara como base (el mayor en la columna 'j')
                  A ese valor se le aplica otra regla de tres para saber la equivalencia 
                  y a partir de este calcular el degradado "diagonal"
                */
                int verde = i * ( (j * 255) /799 ) / 599;


                /*En el componente azul se hace un degradado "diagonal" de izquierda a derecha
                  Donde x = 0 tiene un valor de 0 y x = 799 tiene un valor de 0
                  De igual forma y = 0 contiene 0 y y = 599 contiene 255
                  Se hace una regla de 3 para saber el valor que se tomara como base (el mayor en la columna 'j')
                  Se resta el resultado al valor 255 para ir en la direccion correcta
                  A ese valor se le aplica otra regla de tres para saber la equivalencia 
                  y a partir de este calcular el degradado "diagonal"
                */
                int azul = i * ( 255 - ( j * 255) / 799 ) / 599;

                //Se crea el color con los tres componentes 
                g.setColor(new Color(rojo, verde, azul));

                //Se dibujan lineas de 1 px de largo (puntos)
                g.drawLine(j,i,j,i);

            }//Fin del for de las y
            
        }//Fin del for de las x

    }//Fin del metodo paintComponent


    public static void main(String args[]){
        Gradiente panel = new Gradiente();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(800, 600);
        application.setVisible(true);
    }
}
