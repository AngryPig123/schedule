package com.schedule.schedule.entity;

import com.schedule.schedule.vo.MyDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * packageName    : com.schedule.schedule.entity
 * fileName       : MemberDetail
 * author         : AngryPig123
 * date           : 24. 12. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 24.        AngryPig123       최초 생성
 */
@Alias("MemberDetail")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDetail extends CommonEntity {

    private String memberId;
    private String gender;
    private MyDate myDateOfBirth;
    private String occupation;
    private String companyName;
    private String profileImagePath;
    private String socialMediaLink;
    private String memberBio;

    private MemberDetail(String memberId, String gender, MyDate myDateOfBirth, String occupation, String companyName, String profileImagePath, String socialMediaLink, String memberBio) {
        this.memberId = memberId;
        this.gender = gender;
        this.myDateOfBirth = myDateOfBirth;
        this.occupation = occupation;
        this.companyName = companyName;
        this.profileImagePath = profileImagePath;
        this.socialMediaLink = socialMediaLink;
        this.memberBio = memberBio;
    }

    public static MemberDetail from(String memberId, String gender, MyDate myDateOfBirth, String occupation, String companyName, String profileImagePath, String socialMediaLink, String memberBio) {
        return new MemberDetail(memberId, gender, myDateOfBirth, occupation, companyName, profileImagePath, socialMediaLink, memberBio);
    }

}
