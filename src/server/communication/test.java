package server.communication;

import java.io.IOException;

/**
 * Created by Jim on 11/20/2015.
 */
public class test {

    public static void main(String[] args) throws IOException {
        String st = "<toppingList><topping><id>1</id><short>A</short><full>Anchovies</full></topping><topping><id>2</id><short>B</short><full>Beef</full></topping><topping><id>3</id><short>C</short><full>Xtra Cheese</full></topping><topping><id>4</id><short>D</short><full>Banana Peppers</full></topping><topping><id>5</id><short>E</short><full>Green Chilis</full></topping><topping><id>6</id><short>F</short><full>Tomatoes</full></topping><topping><id>7</id><short>G</short><full>Green Pepper</full></topping><topping><id>8</id><short>I</short><full>Artichokes</full></topping><topping><id>9</id><short>J</short><full>Jalapenos</full></topping><topping><id>10</id><short>K</short><full>Bacon</full></topping><topping><id>11</id><short>L</short><full>Green Olives</full></topping><topping><id>12</id><short>M</short><full>Mushrooms</full></topping><topping><id>13</id><short>N</short><full>Chicken</full></topping><topping><id>14</id><short>O</short><full>Onion</full></topping><topping><id>15</id><short>P</short><full>Pepperoni</full></topping><topping><id>16</id><short>R</short><full>Black Olive</full></topping><topping><id>17</id><short>S</short><full>Sausage</full></topping><topping><id>18</id><short>U</short><full>Sundried Tomatoes</full></topping><topping><id>19</id><short>V</short><full>Feta</full></topping><topping><id>20</id><short>W</short><full>Garlic</full></topping></toppingList>";
        String[] split = st.split("</topping>");
        System.out.println(split[0]);
        if (split[0].contains("<toppingList>")) {
            System.out.println(split[0] + '\t' + split[1]);
            for (int i = 0; i < split.length; i++) {
                if (i == 0) {
                    split[0] = split[0].replaceAll("<toppinglist>", "");
                }
                createToppingFromXML(split[i]);
            }
        }
    }


    private static void createToppingFromXML(String s) {
        String[] temp = s.split("/");
        temp[0] = temp[0].replaceAll("topping><id>", "");
        temp[0] = temp[0].substring(0, temp[0].length() - 1);
        temp[1] = temp[1].replaceAll("id><short>", "");
        temp[1] = temp[1].substring(0, temp[1].length() - 1);
        temp[2] = temp[2].replaceAll("short><full>", "");
        temp[2] = temp[2].substring(0, temp[2].length() - 1);
        System.out.println("SHORT:  " + temp[1] + "    FULL: " + temp[2]);
    }
}

