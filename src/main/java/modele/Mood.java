package modele;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Mood {

    private long id;
    private int grade;
    private String comment;

    private boolean isPublic;
    private long memberId;
    private LocalDateTime date;


    public Mood(long id, int grade, String comment, boolean isPublic, long memberId, LocalDateTime date) {
        this.id = id;
        this.grade = grade;
        this.comment = comment;
        this.isPublic = isPublic;
        this.memberId  = memberId;
        this.date = date;
    }

    public Mood(int grade, String comment, boolean isPublic, long memberId, LocalDateTime date) {
        this.grade = grade;
        this.comment = comment;
        this.isPublic = isPublic;
        this.memberId  = memberId;
        this.date = date;
    }

    public Mood(Mood mood) {
        setId(mood.getId());
        setComment(mood.getComment());
        setDate(mood.getDate());
        setGrade(mood.getGrade());
        setPublic(mood.isPublic());
        setMemberId(mood.getMemberId());
    }

    public Mood() {

    }

    @Override
    public String toString() {
        return "ID : " + id +
                " | Grade : " + grade +
                " | Comment : " + comment +
                " | Is Public : " + isPublic +
                " | Member ID : " + memberId +
                " | Date : " + date + "\n";
    }

    public long getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public long getMemberId() {
        return memberId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}