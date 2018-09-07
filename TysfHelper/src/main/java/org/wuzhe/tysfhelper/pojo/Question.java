package org.wuzhe.tysfhelper.pojo;

import java.util.List;

//互动选择试题
public class Question {
    private Long id;
    private String questionContent;
    private  String ciid;//互动ID
    private List<Option> options;//问题选项
    private Option correctOption;//正确答案
    private int questionType;
    public Question() {
        super();
    }

    public Question(Long id, String questionContent, String ciid, List<Option> options, Option correctOption, int questionType) {
        this.id = id;
        this.questionContent = questionContent;
        this.ciid = ciid;
        this.options = options;
        this.correctOption = correctOption;
        this.questionType = questionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getCiid() {
        return ciid;
    }

    public void setCiid(String ciid) {
        this.ciid = ciid;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Option getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(Option correctOption) {
        this.correctOption = correctOption;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }
}
