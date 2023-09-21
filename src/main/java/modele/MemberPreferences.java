package modele;

import java.io.Serializable;

public class MemberPreferences implements Serializable {
    private long id;
    private long memberId;
    private int mailingDateOption;
    private String mailingTimeOption; // Ajout de l'attribut mailingTimeOption

    public MemberPreferences() {}

    public MemberPreferences(long memberId, int mailingDateOption, String mailingTimeOption) {
        this.memberId = memberId;
        this.mailingDateOption = mailingDateOption;
        this.mailingTimeOption = mailingTimeOption;
    }

    // Getters et setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public int getMailingDateOption() {
        return mailingDateOption;
    }

    public void setMailingDateOption(int mailingDateOption) {
        this.mailingDateOption = mailingDateOption;
    }

    public String getMailingTimeOption() {
        return mailingTimeOption;
    }

    public void setMailingTimeOption(String mailingTimeOption) {
        this.mailingTimeOption = mailingTimeOption;
    }
}
