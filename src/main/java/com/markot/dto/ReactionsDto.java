package com.markot.dto;

public class ReactionsDto {
    private Integer id;

    private Integer amountOfViews;

    private Integer amountOfEmojis;

    public ReactionsDto(Integer id, Integer amountOfViews, Integer amountOfEmojis) {
        this.id = id;
        this.amountOfViews = amountOfViews;
        this.amountOfEmojis = amountOfEmojis;
    }

    public ReactionsDto(Integer amountOfViews, Integer amountOfEmojis) {
        this.amountOfViews = amountOfViews;
        this.amountOfEmojis = amountOfEmojis;
    }

    public ReactionsDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmountOfViews() {
        return amountOfViews;
    }

    public void setAmountOfViews(Integer amountOfViews) {
        this.amountOfViews = amountOfViews;
    }

    public Integer getAmountOfEmojis() {
        return amountOfEmojis;
    }

    public void setAmountOfEmojis(Integer amountOfEmojis) {
        this.amountOfEmojis = amountOfEmojis;
    }
}

