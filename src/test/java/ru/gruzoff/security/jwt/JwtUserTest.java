package ru.gruzoff.security.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class JwtUserTest {
    @Test
    public void testConstructor() {
        ArrayList<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        JwtUser actualJwtUser = new JwtUser("janedoe", "iloveyou", grantedAuthorityList);
        assertSame(grantedAuthorityList, actualJwtUser.getAuthorities());
        assertEquals("iloveyou", actualJwtUser.getPassword());
        assertEquals("janedoe", actualJwtUser.getUsername());
        assertTrue(actualJwtUser.isAccountNonExpired());
        assertTrue(actualJwtUser.isAccountNonLocked());
        assertTrue(actualJwtUser.isCredentialsNonExpired());
        assertTrue(actualJwtUser.isEnabled());
    }

    @Test
    public void testConstructor2() {
        JwtUser actualJwtUser = new JwtUser("janedoe", "iloveyou", new SimpleGrantedAuthority("Role"));
        assertEquals(1, actualJwtUser.getAuthorities().size());
        assertEquals("iloveyou", actualJwtUser.getPassword());
        assertEquals("janedoe", actualJwtUser.getUsername());
    }
}

