package by.it_academy.jd2._107.storage.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class EntityMail {

    private String fromMail;

    private String toMail;

    private String text;

    private LocalDateTime createAt;

    public EntityMail() {
    }

    public EntityMail(String fromMail, String toMail, String text, LocalDateTime createAt) {
        this.fromMail = fromMail;
        this.toMail = toMail;
        this.text = text;
        this.createAt = createAt;
    }

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityMail that = (EntityMail) o;
        return Objects.equals(fromMail, that.fromMail) && Objects.equals(toMail, that.toMail) && Objects.equals(text, that.text) && Objects.equals(createAt, that.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromMail, toMail, text, createAt);
    }

    @Override
    public String toString() {
        return "EntityMail{" +
                "fromMail='" + fromMail + '\'' +
                ", toMail='" + toMail + '\'' +
                ", text='" + text + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
