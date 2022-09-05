package overclock.overclock.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @CreatedDate
<<<<<<< HEAD
    @Column(updatable = false, insertable = true)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column
=======
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
>>>>>>> de3a84c347d4ddddbe39ccf93cc56fa2a7ce1b99
    private LocalDateTime modDate;
}
