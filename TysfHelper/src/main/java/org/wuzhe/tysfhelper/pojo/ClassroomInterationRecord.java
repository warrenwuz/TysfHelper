package org.wuzhe.tysfhelper.pojo;

/**
 * 班级互动记录
 */
public class ClassroomInterationRecord {
    private Long id;
    private String ciid;//互动ID
    private String cid;//互动班级
    private Boolean isEfficacy;//是否失效

    public ClassroomInterationRecord() {
        super();
    }

    public ClassroomInterationRecord(Long id, String ciid, String cid) {
        this.id = id;
        this.ciid = ciid;
        this.cid = cid;
    }

    public ClassroomInterationRecord(String ciid, Boolean isEfficacy) {
        this.ciid = ciid;
        this.isEfficacy = isEfficacy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiid() {
        return ciid;
    }

    public void setCiid(String ciid) {
        this.ciid = ciid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Boolean getEfficacy() {
        return isEfficacy;
    }

    public void setEfficacy(Boolean efficacy) {
        isEfficacy = efficacy;
    }
}
