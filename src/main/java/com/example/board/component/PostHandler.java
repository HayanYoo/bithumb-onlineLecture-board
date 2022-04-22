package com.example.board.component;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class PostHandler {

    private final WebClient webClient;
    private final BoardService boardService;


    //1. 게시판 열람
    public Mono<ServerResponse> getBoard(ServerRequest serverRequest) {
        Mono<BoardDto> boardDto = boardService.getBoard(serverRequest)
                .map(BoardDto::new);

        return boardResponseOK(boardDto);
    }

    //2. 게시글 작성
    public Mono<ServerResponse> writeBoard(ServerRequest serverRequest) {
        Mono<BoardDto> boardDto = boardService.writeBoard(serverRequest)
                .map(BoardDto::new);

        return boardResponseOK(boardDto);
    }

    //3. 댓글 작성
    public Mono<ServerResponse> writeReply(ServerRequest serverRequest) {
        Mono<BoardDto> boardDto = boardService.writeReply(serverRequest)
                .map(BoardDto::new);

        return boardResponseOK(boardDto);
    }

    //4. 관리자 게시글 숨김 처리
    public Mono<ServerResponse> hideBoard(ServerRequest serverRequest) {
        Mono<BoardDto> boardDto = boardService.hideBoard(serverRequest)
                .map(BoardDto::new);

        return boardResponseOK(boardDto);
    }

    //5. 관리자 댓글 숨김 처리
    public Mono<ServerResponse> hideReply(ServerRequest serverRequest) {
        Mono<BoardDto> boardDto = boardService.hideReply(serverRequest)
                .map(BoardDto::new);

        return boardResponseOK(boardDto);
    }


    private Mono<ServerResponse> boardResponseOK(Mono<BoardDto> boardDto) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(boardDto, BoardDto.class);
    }

}
