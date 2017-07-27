package example.entity;

public class ACC {

    private Long accId;

    private String guid;

    private String objectClassTerm;

    private String den;

    private Long basedAccId;

    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getObjectClassTerm() {
        return objectClassTerm;
    }

    public void setObjectClassTerm(String objectClassTerm) {
        this.objectClassTerm = objectClassTerm;
    }

    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public Long getBasedAccId() {
        return basedAccId;
    }

    public void setBasedAccId(Long basedAccId) {
        this.basedAccId = basedAccId;
    }
}
