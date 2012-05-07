/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

/**
 *
 * @author Mao
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author Martin Pakandl
 *
 */
public class ConsoleUI {
	
	
	 public ConsoleUI() {
		
	}

	/** Input reader. */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Reads line of text from the reader.
     * @return line as a string
     */
    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    /**
     * Processes user input.
     * Reads line from console and does the action on a playing field according to input string.
     */
    public void processInput() {
        System.out.print("> ");
        String vstup = readLine();
        try {
        	handleInput(vstup);
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + vstup); 
        }
    }       
    /**
     * Handle input from user.
     * @param input
     * @throws WrongFormatException 
     */
    public void handleInput(String input)throws Exception {
    	
    	String delims = "[ ]";
    	String[] tokens = input.split(delims);
    	
    	
    }
}

