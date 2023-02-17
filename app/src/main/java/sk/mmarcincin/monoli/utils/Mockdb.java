package sk.mmarcincin.monoli.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;

import sk.mmarcincin.monoli.models.Litany;
import sk.mmarcincin.monoli.models.Novena;
import sk.mmarcincin.monoli.models.Prayer;

public class Mockdb {

    public ArrayList<Prayer> getMockPrayers(int number){
        ArrayList<Prayer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(getRandomPrayer(i));
        }
        return list;
    }
    public ArrayList<Novena> getMockNovenas(int number){
        ArrayList<Novena> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(getRandomNovena(i));
        }
        return list;
    }
    public ArrayList<Litany> getMockLitanies(int number){
        ArrayList<Litany> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(getRandomLitany(i));
        }
        return list;
    }

    private Prayer getRandomPrayer(int i){
        Prayer p  = new Prayer();
        p.setId( i + 100);
        p.setName("Modlitba c."+i);
        p.setText(repeater("Modlitby",i));
        p.setCategory(getRandomNumber(1,6));
        p.setOrder(i);
        p.setFavorite(false);
        p.setCustom(false);
        p.setCreatedAt(LocalDateTime.now());
        return p;
    }
    private Novena getRandomNovena(int i){
        Novena n = new Novena();
        n.setId( i + 500);
        n.setName("Novena c."+i);
        n.setIntro(repeater("UvoduNoveny",i));
        n.setDays(getRandomNovenaDays(9));
        n.setCategory(getRandomNumber(1,6));
        n.setOrder(i);
        n.setFavorite(false);
        n.setCustom(false);
        n.setCreatedAt(LocalDateTime.now());
        n.setLitanyId(i+1000);
        return n;
    }

    private ArrayList<String> getRandomNovenaDays(int i) {
        ArrayList<String> days = new ArrayList<String>();
        for (int j = 0; j < i; j++) {
            days.add(repeater(j+"denNoveny",10)+i);
        }
        return days;
    }

    private Litany getRandomLitany(int i){
        Litany l = new Litany();
        l.setId( i + 1000);
        l.setName("Litanie c."+i);
        l.setText(repeater("Litanii",i));
        l.setCategory(getRandomNumber(1,6));
        l.setOrder(i);
        l.setFavorite(false);
        l.setCustom(false);
        l.setCreatedAt(LocalDateTime.now());

        return l;
    }

    private String repeater(String s, int i){
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 10; j++) {
            sb.append("text");
            sb.append(s);
            sb.append(i);
        }
        return sb.toString();
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
