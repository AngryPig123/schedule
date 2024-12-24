package com.schedule.schedule.security;

import com.schedule.schedule.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDetails implements UserDetails {

    private Member member;

    private MemberDetails(Member member) {
        this.member = member;
    }

    public static MemberDetails init(Member member) {
        return new MemberDetails(member);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(admin(), member(), guest(), anonymous());
    }

    @Override
    public String getPassword() {
        return member.getPassword().getPassword();
    }

    @Override
    public String getUsername() {
        return member.getName().fullName();
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
