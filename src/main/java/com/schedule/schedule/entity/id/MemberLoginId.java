package com.schedule.schedule.entity.id;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * packageName    : com.schedule.schedule.entity.id
 * fileName       : MemberId
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Alias("MemberLoginId")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberLoginId {

    private String id;

    public static MemberLoginId of(String id) {
        return new MemberLoginId(id);
    }

}
