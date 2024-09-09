package com.hanghae.market.dto.board.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateRequest {

    private int id;
    private String username;
    private String title;
    private String content;
    private int price;

    public BoardUpdateRequest() {

    }

    public BoardUpdateRequest(int id, String username, String title, String content, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }
}
