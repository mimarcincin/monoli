package sk.mmarcincin.monoli.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
@Entity
public class Prayer {
    @PrimaryKey
    private int id;
    private String name;
    private String text;
    private int category;
    private int order;
    private boolean favorite;
    private boolean custom;
    private LocalDateTime createdAt;

    public Prayer(int id, String name, String text, int category, int order, boolean favorite, boolean custom, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.category = category;
        this.order = order;
        this.favorite = favorite;
        this.custom = custom;
        this.createdAt = createdAt;
    }

    public Prayer() {

    }

    @Override
    public String toString() {
        return "Prayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", category=" + category +
                ", order=" + order +
                ", favorite=" + favorite +
                ", custom=" + custom +
                ", createdAt=" + createdAt +
                '}';
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
