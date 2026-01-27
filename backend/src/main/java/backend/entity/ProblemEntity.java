package backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ProblemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProb_num() {
        return prob_num;
    }

    public void setProb_num(int prob_num) {
        this.prob_num = prob_num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private int user_id;
    private int prob_num;
    private String url;
    private int interval;
    private LocalDate date;

    public ProblemEntity() {}
}
