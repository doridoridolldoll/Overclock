package overclock.overclock.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberRole {

    USER("ROLE_USER", "일반회원"),
    ADMIN("ROLE_ADMIN", "관리자");

    private String key;
    private String value;

    private String getKey() {
        return key;
    }

    private String getValue() {
        return value;
    }
}
