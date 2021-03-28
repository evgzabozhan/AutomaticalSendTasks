package api.trello;

import java.util.Objects;

public class Card {

    private String id;
    private String dateLastActivity;
    private String desc;
    private String name;

    public Card(String id, String dateLastActivity, String desc, String name) {
        this.id = id;
        this.dateLastActivity = dateLastActivity;
        this.desc = desc;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(dateLastActivity, card.dateLastActivity) && Objects.equals(desc, card.desc) && Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateLastActivity, desc, name);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", dateLastActivity='" + dateLastActivity + '\'' +
                ", desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
