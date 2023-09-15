package modele;

import java.io.Serializable;

public class MemberPreferences implements Serializable {
    private long id;
    private long memberId;
    private int mailingDateOption;

    public MemberPreferences() {}

    public MemberPreferences(long memberId, int mailingDateOption) {
        this.memberId = memberId;
        this.mailingDateOption = mailingDateOption;
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
}
