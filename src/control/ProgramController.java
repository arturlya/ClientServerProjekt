package control;

import control.framework.UIController;
import model.Field;
import model.TicTacToeClient;
import model.TicTacToeServer;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    // Attribute

    // Referenzen
    private UIController uiController;  // diese Referenz soll auf ein Objekt der Klasse uiController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse UIController. Diese wird als Parameter übergeben.
     * @param uiController das UIController-Objekt des Programms
     */
    public ProgramController(UIController uiController){
        this.uiController = uiController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     */
    public void startProgram(){
        TicTacToeServer server = new TicTacToeServer(2796);
        Field[] map = new Field[9];
        for(int i=0;i<map.length;i++){
            map[i]= new Field();
            map[i].setX(i/3);
            map[i].setY(i%3);
            uiController.drawObject(map[i]);
        }
        if(server.isOpen()) {

            TicTacToeClient client = new TicTacToeClient("localhost", 2796, map);
            TicTacToeClient client2 = new TicTacToeClient("localhost",2796, map);
            uiController.drawObject(client);
            uiController.drawObject(client2);

          //  TicTacToeClient client3 = new TicTacToeClient("localhost",2796);
        }


    }

    /**
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){

    }


}
