/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topology;

import storage.configuration.ComponentConfigurator;

/** 
 *
 * @author Mao
 */
public class Warehouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ComponentConfigurator c = new ComponentConfigurator("C:/Documents and Settings/Mao/My Documents/NetBeansProjects/WSE/src/storage/configuration/load.txt");
        c.configure(null);
        
    }
}
