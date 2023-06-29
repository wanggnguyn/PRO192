/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

/**
 *
 * @author PC
 */
import java.util.ArrayList;
public class Menu {
    public static int getChoice(ArrayList options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + " - " + options.get(i));
        }

        return Inputter.inputInt("Choose 1.." + options.size() + ": ", 1, options.size());
    }

    public static int getChoice(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " - " + options[i]);
        }

        return Inputter.inputInt("Choose 1.." + options.length + ": ", 1, options.length);
    }
    
}
