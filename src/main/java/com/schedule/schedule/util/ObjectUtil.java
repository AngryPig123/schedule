package com.schedule.schedule.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;


/**
 * packageName    : com.schedule.schedule.util
 * fileName       : ObjectUtil
 * author         : AngryPig123
 * date           : 24. 12. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 18.        AngryPig123       최초 생성
 */
@Slf4j
public class ObjectUtil {

    static void defaultCopyObject(Object resource, Object target) {
        BeanUtils.copyProperties(resource, target);
    }

}
