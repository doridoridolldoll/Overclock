package overclock.overclock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BoardType {
    SALE("판매페이지"),
    PARTS("부품페이지"),
    MARKET("중고거래게시판");
    private String value;
    private String getValue() { return value;}
}
