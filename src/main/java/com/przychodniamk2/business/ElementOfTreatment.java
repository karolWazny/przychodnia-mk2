package com.przychodniamk2.business;

public class ElementOfTreatment {
    private Integer id;
    private String description;
    private String code;

    public ElementOfTreatment(Integer id, String description, String code) {
        this.id = id;
        this.description = description;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
