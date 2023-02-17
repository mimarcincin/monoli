package sk.mmarcincin.monoli.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Novena {

    private int id;
    private String name;
    private String intro;
    private ArrayList<String> days;
    private int category;
    private int order;
    private boolean favorite;
    private boolean custom;
    private int litanyId;
    private LocalDateTime createdAt;

    public Novena(int id, String name, String intro, ArrayList<String> days, int category, int order, boolean favorite, boolean custom, int litanyId, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.days = days;
        this.category = category;
        this.order = order;
        this.favorite = favorite;
        this.custom = custom;
        this.litanyId = litanyId;
        this.createdAt = createdAt;
    }

    public Novena(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public void setDays(ArrayList<String> days) {
        this.days = days;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public int getLitanyId() {
        return litanyId;
    }

    public void setLitanyId(int litanyId) {
        this.litanyId = litanyId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
