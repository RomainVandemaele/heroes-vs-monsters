package bf.java.ex.shop;

import bf.java.ex.mob.Hero;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private ArrayList<Item> items;

    private Hero client;

    public Shop(Hero client) {
        items = new ArrayList<Item>();
        items.add(new HealingItem("Potion",3,5));
        items.add(new HealingItem("Super potion",5,10));
        items.add(new MagicRestoreItem("Ether",5,8));
        this.client = client;
        //items.add(new DamageItem("Shuriken",5,5));
        //items.add(new DamageItem("Gold shuriken",10,10));
    }

    public Item buyItem(int i) {
        return items.get(i).clone();
    }

    public void listItems() {
        for(int i= 0;i<items.size();++i) {
            System.out.printf("%d : %s",i+1,items.get(i));
        }
    }

    public void shopInterface() {

        listItems();
        System.out.printf("You have %d gold\n",client.getGold());
        System.out.println("Choose the item you want or return(0) to you journey?");
        Scanner myScanner = new Scanner(System.in);
        while (!myScanner.hasNext("[0-"+ String.valueOf(items.size()) + "]" )  ) {
            System.out.println("Have another try\n");
            myScanner.next();
        }
        int chosenIndex = myScanner.nextInt();
        if(chosenIndex!=0) {
            if(client.getGold() >= items.get(chosenIndex).getPrice()) {
                System.out.printf("You choose to buy %s.\n",items.get(chosenIndex-1).name);
                Item broughtItem = buyItem(chosenIndex-1);
                client.addItem( broughtItem );
                broughtItem.setReceiver(client);
            }else {
                System.out.println("You don't have enough money. get out.\n");
            }
        }else {
            System.out.println("See you next time.\n");
        }

    }

}
