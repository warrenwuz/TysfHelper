package org.wuzhe.tysfhelper.pojo;

public class Option {
    private Long id;
    private String optionContent;
    private Long questionId;

    public Option() {
        super();
    }

    public Option(Long id) {
        this.id = id;
    }

    public Option(String optionContent, Long questionId) {
        this.optionContent = optionContent;
        this.questionId = questionId;
    }

    public Option(Long id, String optionContent) {
        this.id = id;
        this.optionContent = optionContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }
}
