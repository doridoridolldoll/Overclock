package overclock.overclock.entity;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import overclock.overclock.model.BoardType;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardTest {

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Board board = Board.builder()
                    .name("중고거래게시판ㅁㄴㅇ")
                    .boardType(BoardType.MARKET)
                    .build();
        });
    }

}