package sk.mmarcincin.monoli.utils;

import java.util.Arrays;

public class UtilRunner {

    public static void main(String[] args) {
        Mockdb db = new Mockdb();
        System.out.println(Arrays.toString(db.getMockPrayers(50).toArray()));
    }
}
