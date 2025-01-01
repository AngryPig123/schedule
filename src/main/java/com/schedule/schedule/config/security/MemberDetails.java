package com.schedule.schedule.config.security;

import com.schedule.schedule.constants.PasswordEncryptType;
import com.schedule.schedule.entity.Member;
import com.schedule.schedule.entity.MemberDetail;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * packageName    : com.schedule.schedule.security
 * fileName       : MemberDetails
 * author         : AngryPig123
 * date           : 24. 12. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 22.        AngryPig123       최초 생성
 */
@Getter
@ToString
public class MemberDetails implements UserDetails {

    private final Member member;

    private final MemberDetail memberDetail;

    private MemberDetails(Member member, MemberDetail memberDetail) {
        this.memberDetail = memberDetail;
        this.member = member;
    }

    public static MemberDetails init(Member member, MemberDetail memberDetail) {
        return new MemberDetails(member, memberDetail);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(admin(), member(), guest(), anonymous());
    }

    @Override
    public String getPassword() {
        return member.getPassword().getPassword();
    }

    public PasswordEncryptType getEncryptType() {
        return member.getPassword().getEncryptType();
    }

    @Override
    public String getUsername() {
        return member.getName().fullName();
    }

    @Override
    public boolean isEnabled() {
        return this.member.getPassword().getLockCount() < 5;
    }

    public Long getMemberId() {
        return this.member.getMemberId();
    }

    private SimpleGrantedAuthority admin() {
        return new SimpleGrantedAuthority("ROLE_ADMIN");
    }

    private SimpleGrantedAuthority member() {
        return new SimpleGrantedAuthority("ROLE_MEMBER");
    }

    private SimpleGrantedAuthority guest() {
        return new SimpleGrantedAuthority("ROLE_GUEST");
    }

    private SimpleGrantedAuthority anonymous() {
        return new SimpleGrantedAuthority("ROLE_ANONYMOUS");
    }

}
