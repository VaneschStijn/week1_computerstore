package be.pxl.computerstore.hardware;

import java.util.Random;

public class ComputerComponent {
    private final String vendor;
    private String name;
    private double price;
    private String articleNumber;
    private static int counter = 0;

    public ComputerComponent(String vendor, String name, double price){
        this.vendor = vendor;
        this.name = name;
        this.price = price;
        this.createArticleNumber();
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        ComputerComponent.counter = counter;
    }

    public void createArticleNumber(){
        String temporary;

        //3 letters uppercase from vendor
        if(vendor.length() > 2){
            temporary = vendor.substring(0,3).toUpperCase();
        }else{
            counter = 3 - vendor.length();
            temporary = vendor.toUpperCase();
            for (int i = 0; i < counter; i++){
                temporary = temporary + "X";
            }
        }

        temporary = temporary + "-";

        //Unique number
        Random rand = new Random();
        String  number = (rand.nextInt(99999) + 1) + "";
        if(number.length() < 5){
            counter = 5 - number.length();

            for (int i = 0; i < counter; i++){
                temporary = temporary + 0;
            }

            temporary = temporary + number;
        }else{
            temporary = temporary + number;
        }
    }

    @Override
    public String toString() {
        return name + '(' + articleNumber + ')';
    }

    public String getFullDescription() {
        return  "ArticleNumber = " + articleNumber + "\n" +
                "Vendor = " + vendor + "\n" +
                "Name = " + name + "\n" +
                "Price = " + price + "\n";
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public double getPrice() {
        return price;
    }
}
