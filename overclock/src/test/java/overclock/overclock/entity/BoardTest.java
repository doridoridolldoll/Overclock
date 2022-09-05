package overclock.overclock.entity;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.model.BoardType;
import overclock.overclock.repository.BoardRepository;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Board board = Board.builder()
                    .boardType(BoardType.MARKET)
                    .build();
            boardRepository.save(board);
        });
    }

}