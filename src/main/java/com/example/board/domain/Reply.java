package com.example.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Reply {
    private long id;
    private long memberId;
    private String text;
    private boolean show;

    private Board board;
}
