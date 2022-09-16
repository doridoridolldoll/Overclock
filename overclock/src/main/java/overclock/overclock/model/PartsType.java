package overclock.overclock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PartsType {
    MB("메인보드"),
    CPU("CPU"),
    GPU("그래픽카드"),
    HDD("하드디스크"),
    PARTSETC("기타부품"),
    MOUSE("마우스"),
    KEYBOARD("키보드"),
    HEADSET("헤드셋"),
    DISPLAY("모니터"),
    DEVICE("주변기기");

    private String value;
    private String getValue() { return value;}
}
