package com.example.board.service;

import com.example.board.domain.Board;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Service
public interface BoardService {

    //1. 게시판 열람
    Mono<Board> getBoard(ServerRequest serverRequest);

    //2. 게시글 작성
    Mono<Board> writeBoard(ServerRequest serverRequest);

    //3. 댓글 작성
    Mono<Board> writeReply(ServerRequest serverRequest);

    //4. 관리자 게시글 숨김 처리
    Mono<Board> hideBoard(ServerRequest serverRequest);

    //5. 관리자 댓글 숨김 처리
    Mono<Board> hideReply(ServerRequest serverRequest);
}
