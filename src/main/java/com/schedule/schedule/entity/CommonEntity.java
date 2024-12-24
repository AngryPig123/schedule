package com.schedule.schedule.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * packageName    : com.schedule.schedule.entity
 * fileName       : CommonEntity
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Getter
@Setter
public abstract class CommonEntity {

    protected Long createdBy;
    protected LocalDateTime createAt;
    protected Long lastModifiedBy;
    protected LocalDateTime lastModifiedAt;

}
