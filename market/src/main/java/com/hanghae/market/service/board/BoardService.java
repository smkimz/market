package com.hanghae.market.service.board;

import com.hanghae.market.domain.board.Board;
import com.hanghae.market.dto.board.request.BoardCreateRequest;
import com.hanghae.market.dto.board.response.BoardResponse;
import com.hanghae.market.repository.board.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public BoardResponse createBoard(BoardCreateRequest request) {
        Board board = boardRepository.save(new Board(request.getUsername(), request.getTitle(), request.getContent(), request.getPrice()));
        return new BoardResponse(board.getId(), board.getTitle(), board.getUsername(), board.getPrice());
    }

    @Transactional(readOnly = true)
    public List<BoardResponse> getAllBoard() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(board -> new BoardResponse(board.getId(), board.getTitle(), board.getUsername(), board.getPrice())).collect(Collectors.toList());
    }

    @Transactional
    public BoardResponse updateBoard(int id, BoardCreateRequest request) {
        Board board = new Board(id, request.getUsername(), request.getTitle(), request.getContent(), request.getPrice());
        boardRepository.save(board);
        return new BoardResponse(board.getId(), board.getTitle(), board.getUsername(), board.getPrice());
    }

    @Transactional
    public String deleteUser(int id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        boardRepository.delete(board);
        return "삭제완료";
    }
}

