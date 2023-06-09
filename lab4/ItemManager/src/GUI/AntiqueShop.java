/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Item;
import DTO.Painting;
import DTO.Statue;
import DTO.Vase;
import java.util.Scanner;


/**
 *
 * @author ADMIN
 */
public class AntiqueShop {
    public static void main(String[] args) {
        String[] options = {"Create a Vase","Create a Statue","Create a Painting","Display the Item"};
        Item item = null;
        int choice = 0;
        do{
            choice = Menu.getChoice(options);
            switch(choice){
                case 1:
                    item = new Vase();
                    ((Vase)item).InputVase();
                    break;
                case 2:
                    item = new Statue();
                    ((Statue)item).inputStatue();
                    break;
                case 3:
                    item = new Painting();
                    ((Painting)item).inputPaiting();
                    break;
                case 4:
                    if(item != null){
                        if(item instanceof Vase)
                            ((Vase)item).OutputVase();
                        else if(item instanceof Statue)
                            ((Statue)item).outputStatue();
                        else if(item instanceof Painting)
                            ((Painting)item).outputPaiting();
                    }else{
                        System.out.println("No item created");
                    }
                    break;
                default : 
                    System.out.println("Invalid choice");
            }
        }while(choice != 4);
    }
}
class Menu{
    public static int getChoice(Object[] options){
        for(int i = 0;i < options.length;i++){
            System.out.println((i+1)+"-"+options[i]);
        }
        System.out.println("Choose 1 --> "+options.length+ ": ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
