package com.example.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Board {
    private long id;
    private long memberId;
    private String content;
    private boolean show;
    private List<Reply> reply;

}
