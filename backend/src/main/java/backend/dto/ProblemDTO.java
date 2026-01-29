package backend.dto;

public class ProblemDTO {

private int prob_no;
private String url;
private String prob_name;

    public String getProb_name() {
        return prob_name;
    }

    public void setProb_name(String prob_name) {
        this.prob_name = prob_name;
    }

    public int getProb_no() {
        return prob_no;
    }

    public void setProb_no(int prob_no) {
        this.prob_no = prob_no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
