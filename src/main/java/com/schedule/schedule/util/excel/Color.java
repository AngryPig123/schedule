package com.schedule.schedule.util.excel;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * packageName    : com.schedule.schedule.util.excel
 * fileName       : Color
 * author         : AngryPig123
 * date           : 24. 12. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 29.        AngryPig123       최초 생성
 */
@Getter
@AllArgsConstructor
public enum Color {

    WHITE("#FFFFFF", "흰색"),
    BLACK("#000000", "검정색"),
    RED("#FF0000", "빨간색"),
    GREEN("#00FF00", "초록색"),
    BLUE("#0000FF", "파란색");

    private final String hexCode;
    private final String name;

    public static Predicate<Color> isEquals(String hexCode) {
        return color -> color.getHexCode().equals(hexCode);
    }

    public static Color lookup(String hexCode) {
        return Arrays.stream(Color.values())
                .filter(isEquals(hexCode))
                .findFirst()
                .orElse(null);
    }

    public static java.awt.Color hexToAwtColor(Color target) {
        if (target != null) {
            String hexCode = target.getHexCode();
            return new java.awt.Color(Integer.parseInt(hexCode.substring(1, 3), 16),
                    Integer.parseInt(hexCode.substring(3, 5), 16),
                    Integer.parseInt(hexCode.substring(5, 7), 16));
        }
        return null;
    }

}
