package pl.lodz.uni.math.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {


	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
	
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		boolean enabled;
		boolean accountNonLocked;
			enabled = true;
			accountNonLocked = true;

		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;

		return new User("user", "user",
				enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authList);
	}


}
