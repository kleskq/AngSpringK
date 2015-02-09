package pl.lodz.uni.math.api.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.lodz.uni.math.api.persistence.dao.UserDao;
import pl.lodz.uni.math.api.persistence.dao.pojo.User;
import pl.lodz.uni.math.api.persistence.dao.pojo.UserRole;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User domainUser = userDao.getUser(login);

		if (domainUser == null) {
			throw new UsernameNotFoundException("login");
		}
		
		boolean enabled;
		boolean accountNonLocked;
		if (domainUser.getEnabled() == 1) {
			enabled = true;
			accountNonLocked = true;
		} else {
			enabled = false;
			accountNonLocked = false;
		}
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;

		return new org.springframework.security.core.userdetails.User(domainUser.getUserName(), domainUser.getPassword(),
				enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(domainUser.getUserRoles()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Set<UserRole> set) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		for (UserRole userRole : set) {
			authList.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return authList;
	}

}
