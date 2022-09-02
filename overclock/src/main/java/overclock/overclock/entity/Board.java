package overclock.overclock.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import overclock.overclock.model.BoardType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private String id;

    @Column(name = "board_name", nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardType boardType;

    public Board(String name, BoardType boardType) {
        this.name = name;
        this.boardType = boardType;
    }
}
