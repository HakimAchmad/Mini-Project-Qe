package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
    static int random = ThreadLocalRandom.current().nextInt();

    public static String randomEmail(){
        return random +  "hakim@gmail.com";
    }
}
