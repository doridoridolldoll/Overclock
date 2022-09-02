package overclock.overclock.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BoardType {
    SALE("판매페이지"),
    MARKET("중고거래게시판");

    private String value;
}
