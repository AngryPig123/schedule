package com.schedule.schedule.entity;

import lombok.Getter;

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
public abstract class CommonEntity {

    protected String createId;
    protected LocalDateTime createDate;
    protected String modifyId;
    protected LocalDateTime modifyDate;

    protected CommonEntity() {
        this.createDate = LocalDateTime.now();
    }

}
