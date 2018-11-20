package com.example.myjpa.myenum;

public enum CompareEnum {
    GT("gt"),
    LT("lt"),
    EQ("eq");

    private String direction;

    CompareEnum(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
