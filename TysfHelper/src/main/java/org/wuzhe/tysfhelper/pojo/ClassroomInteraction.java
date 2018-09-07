package org.wuzhe.tysfhelper.pojo;

import java.sql.Timestamp;
import java.util.List;

/**
 * 课堂互动实体类
 *
 * @author wuzhe
 */
public class ClassroomInteraction {
    private String ciid;//互动ID
    private String ciname;//互动主题
    private Timestamp citimestamp;//课堂互动发布时间
    private List<Question> questions;//互动试题
    private int classroomInteractionType;//互动问题类型
    private String tid;//老师Id

    public ClassroomInteraction() {
        super();
    }

    public ClassroomInteraction(String ciid, String ciname, Timestamp citimestamp, List<Question> questions, int classroomInteractionType, String tid) {
        this.ciid = ciid;
        this.ciname = ciname;
        this.citimestamp = citimestamp;
        this.questions = questions;
        this.classroomInteractionType = classroomInteractionType;
        this.tid = tid;
    }

    public String getCiid() {
        return ciid;
    }

    public void setCiid(String ciid) {
        this.ciid = ciid;
    }

    public String getCiname() {
        return ciname;
    }

    public void setCiname(String ciname) {
        this.ciname = ciname;
    }

    public Timestamp getCitimestamp() {
        return citimestamp;
    }

    public void setCitimestamp(Timestamp citimestamp) {
        this.citimestamp = citimestamp;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getClassroomInteractionType() {
        return classroomInteractionType;
    }

    public void setClassroomInteractionType(int classroomInteractionType) {
        this.classroomInteractionType = classroomInteractionType;
    }

    public String getTid() { return tid; }

    public void setTid(String tid) { this.tid = tid; }
}
