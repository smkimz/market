package com.hanghae.market.dto.board.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateRequest {

    private String username;
    private String title;
    private String content;
    private int price;

    public BoardCreateRequest() {

    }

    public BoardCreateRequest(String username, String title, String content, int price) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

}
