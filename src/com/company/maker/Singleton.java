package com.company.maker;

import java.io.FileWriter;
import java.io.IOException;

public class Singleton {
    private static Singleton firstInstance =null;

    private Singleton(){}
    public  static Singleton getInstance(){
        if(firstInstance==null){
            firstInstance =new Singleton();
        }

    return firstInstance;


    }

    public static final int MAX_USES = 5;
    private float sugarAmount;
    private float waterAmount;
    private float beansAmount;
    private int useCount;





    public Singleton(float water, float sugar, float beans) {
        waterAmount = water;
        sugarAmount = sugar;
        beansAmount = beans;
    }


    public void fillProducts(Float[] papildymas) {
        waterAmount += papildymas[0];
        sugarAmount += papildymas[1];
        beansAmount += papildymas[2];
    }


    public void makeCoffe(String coffeType) {
        if (!isReady()) return;

        switch (coffeType.toLowerCase()) {
            case "black":
                sugarAmount -= 10;
                beansAmount -= 20;
                waterAmount -= 0.25f;
                System.out.println("                        (\n" +
                        "                          )     (\n" +
                        "                   ___...(-------)-....___\n" +
                        "               .-\"\"       )    (          \"\"-.\n" +
                        "         .-'``'|-._             )         _.-|\n" +
                        "        /  .--.|   `\"\"---...........---\"\"`   |\n" +
                        "       /  /    |                             |\n" +
                        "       |  |    |                             |\n" +
                        "        \\  \\   |                             |\n" +
                        "         `\\ `\\ |                             |\n" +
                        "           `\\ `|                             |\n" +
                        "           _/ /\\                             /\n" +
                        "          (__/  \\                           /\n" +
                        "       _..---\"\"` \\                         /`\"\"---.._\n" +
                        "    .-'           \\                       /          '-.\n" +
                        "   :               `-.__             __.-'              :\n" +
                        "   :                  ) \"\"---...---\"\" (                 :\n" +
                        "    '._               `\"--...___...--\"`              _.'\n" +
                        "  jgs \\\"\"--..__                              __..--\"\"/\n" +
                        "       '._     \"\"\"----.....______.....----\"\"\"     _.'\n" +
                        "          `\"\"--..,,_____            _____,,..--\"\"`\n" +
                        "                        `\"\"\"----\"\"\"`");
                break;
            case "latte":
                sugarAmount -= 20;
                beansAmount -= 40;
                waterAmount -= 0.33f;
                System.out.println("     {\n" +
                        "      {   }\n" +
                        "       }_{ __{\n" +
                        "    .-{   }   }-.\n" +
                        "   (   }     {   )\n" +
                        "   |`-.._____..-'|\n" +
                        "   |             ;--.\n" +
                        "   |            (__  \\\n" +
                        "   |             | )  )\n" +
                        "   |             |/  /\n" +
                        "   |             /  / \n" +
                        "   |            (  /\n" +
                        "   \\             y'\n" +
                        "    `-.._____..-'");
                break;
            case "esspresso":
                sugarAmount -= 10;
                beansAmount -= 40;
                waterAmount -= 0.1f;
                System.out.println("  .-~~-.\n" +
                        ",|`-__-'|\n" +
                        "||      |\n" +
                        "`|      |\n" +
                        "  `-__-'\n");
                break;
        }
        useCount++;
        sugarAmount = Math.max(sugarAmount, 0);
        waterAmount = Math.max(waterAmount, 0);
        beansAmount = Math.max(beansAmount, 0);

    }


    public void washMaker() {
        this.useCount = 0;
    }


    public boolean isReady() {

        boolean ready = true;

        if (useCount >= MAX_USES) System.out.println("Reikia isplauti aparata");
        ;
        if (waterAmount <= 0.1) {
            System.out.println("Truksta vandens");
            ready = false;
        }
        if (sugarAmount <= 10) {
            System.out.println("Truksta cukraus");
            ready = false;
        }
        if (beansAmount <= 20) {
            System.out.println("Truksta pupeliu");
            ready = false;
        }

        return ready;
    }

    public boolean isReadystatus() {

        boolean ready = true;

        if (useCount >= MAX_USES) ready = false;

        if (waterAmount <= 0.1) {

            ready = false;
        }
        if (sugarAmount <= 10) {

            ready = false;
        }
        if (beansAmount <= 20) {

            ready = false;
        }

        return ready;
    }


    public void showProducts() {
        System.out.println("=========Product status=========");
        System.out.println("Sugar amount left:" + sugarAmount);
        System.out.println("Water amount left:" + waterAmount);
        System.out.println("Beans amount left:" + beansAmount);

    }


    public void showStatus() {
        System.out.println("=========Maker status============");
        System.out.println("Usages left:" + (MAX_USES - this.useCount));
        System.out.println("is machine ready:" + isReady());
        this.showProducts();
    }

    public void issaugok() {
        StringBuilder builder = new StringBuilder("");

        builder.append("=========Maker status============\n");
        builder.append("Usages left:");
        builder.append(MAX_USES);
        builder.append(this.useCount + "\n");
        builder.append("is machine ready:");
        builder.append(isReadystatus() + "\n");
        builder.append("=========Product status=========\n");
        builder.append("Sugar amount left:\n");
        builder.append(sugarAmount + "\n");
        builder.append("Water amount left:\n");
        builder.append(waterAmount + "\n");
        builder.append("Beans amount left:\n");
        builder.append(beansAmount + "\n");

        FileWriter veiksmai = null;

        try {
            veiksmai = new FileWriter("duomenys.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            veiksmai.write(String.valueOf(builder));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            veiksmai.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public float getWater() {
        return this.waterAmount;
    }


    public void setWater(float value) {
        this.waterAmount = value;
    }


    public float getBeans() {
        return this.beansAmount;
    }


    public void setBeans(float value) {
        this.beansAmount = value;
    }


    public float getSugar() {
        return this.sugarAmount;
    }


    public void setSugar(float value) {
        this.sugarAmount = value;
    }


}
