package com.schedule.schedule.constants;

/**
 * packageName    : com.schedule.schedule.constants
 * fileName       : CommonConstants
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
public class CommonConstants {
    //  BASE
    public static String TRUE_STRING = "Y";
    public static String FALSE_STRING = "N";
    public static int PASSWORD_LOCK_COUNT = 5;

    //  JWT
    public static final String JWT_HEADER = "Authorization";
    public static final String ISSUER = "ANGRY_PIG";
    public static final String ACCESS_TOKEN_SUBJECT = "access_token";
    public static final String REFRESH_TOKEN_SUBJECT = "refresh_token";
    public static final Long ACCESS_TOKEN_EXPIRES_IN = 10L;
    public static final Long REFRESH_TOKEN_EXPIRES_IN = 60L;

}
