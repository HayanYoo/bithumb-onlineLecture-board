package com.example.board.dto;

import com.example.board.domain.Board;
import com.example.board.domain.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BoardDto {
    private long id;
    private long memberId;
    private String content;
    private boolean show;
    private List<Reply> reply;


    public BoardDto(Board board){
        this.id = board.getId();
        this.memberId = board.getMemberId();
        this.content = board.getContent();
        this.show = board.isShow();
        this.reply = board.getReply();
    }

}
