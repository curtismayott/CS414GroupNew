package server.communication;

import server.objects.Topping;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jim on 11/22/2015.
 */
public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner("<TOPPINGHOLDER>\n" +
                "  <toppings>\n" +
                "    <itemid>1</itemid>\n" +
                "    <shortname>A</shortname>\n" +
                "    <fullname>Anchovies</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>2</itemid>\n" +
                "    <shortname>B</shortname>\n" +
                "    <fullname>Beef</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>3</itemid>\n" +
                "    <shortname>C</shortname>\n" +
                "    <fullname>Xtra Cheese</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>4</itemid>\n" +
                "    <shortname>D</shortname>\n" +
                "    <fullname>Banana Peppers</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>5</itemid>\n" +
                "    <shortname>E</shortname>\n" +
                "    <fullname>Green Chilis</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>6</itemid>\n" +
                "    <shortname>F</shortname>\n" +
                "    <fullname>Tomatoes</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>7</itemid>\n" +
                "    <shortname>G</shortname>\n" +
                "    <fullname>Green Pepper</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>8</itemid>\n" +
                "    <shortname>I</shortname>\n" +
                "    <fullname>Artichokes</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>9</itemid>\n" +
                "    <shortname>J</shortname>\n" +
                "    <fullname>Jalapenos</fullname>\n" +
                "  </toppings>\n" +
                "  <toppings>\n" +
                "    <itemid>10</itemid>\n" +
                "    <shortname>K</shortname>\n" +
                "    <fullname>Bacon</fullname>\n" +
                "  </toppings>\n" +
                "</TOPPINGHOLDER>");
        String temp;
        ArrayList<Topping> list = new ArrayList<Topping>();
        while (sc.hasNextLine()) {
            temp = sc.nextLine().trim();
            if (temp.equals("<toppings>")) {
                Topping tempT;
                temp = sc.nextLine().trim();;
                temp = temp.replace("/", "");
                temp = temp.replace("<itemid>", "");
                int id = Integer.parseInt(temp);
                temp = sc.nextLine().trim();;
                temp = temp.replace("/", "");
                temp = temp.replace("<shortname>", "");
                String sh = temp;
                temp = sc.nextLine().trim();;
                temp = temp.replace("/", "");
                temp = temp.replace("<fullname>", "");
                tempT = new Topping(sh, temp);
                tempT.setItemID(id);
                list.add(tempT);
            }
        }
    }
}
