package com.hanghae.market.controller.board;

import com.hanghae.market.dto.board.request.BoardCreateRequest;
import com.hanghae.market.dto.board.response.BoardDeleteResponse;
import com.hanghae.market.dto.board.response.BoardResponse;
import com.hanghae.market.service.board.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/post")
    public BoardResponse createBoard(@RequestBody BoardCreateRequest request) {
        return boardService.createBoard(request);
    }

    @GetMapping("/post")
    public List<BoardResponse> getAllBoard() {
        return boardService.getAllBoard();
    }

    @PutMapping("/post/{id}")
    public BoardResponse updateBoard(@PathVariable int id, @RequestBody BoardCreateRequest request) {
        return boardService.updateBoard(id, request);
    }

    @DeleteMapping("/post/{id}")
    public BoardDeleteResponse deleteBoard(@PathVariable int id) {
        return new BoardDeleteResponse(boardService.deleteUser(id));
    }
}
