package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class Random {

    static int random = ThreadLocalRandom.current().nextInt();

    public static String randomEmail(){
        return random +  "hakim@gmail.com";
    }
    public String randomCategory(){
        return "Set up Office" + + random;
    }

    public static String randomProduct(){
        return "Personal Computer" + + random;
    }

}
