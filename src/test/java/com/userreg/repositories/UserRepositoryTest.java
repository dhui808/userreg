package com.userreg.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.userreg.entities.UserEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository userRepository;
	
	@Test
	public void whenSavingUser_thenCorrect() {
		UserEntity user = new UserEntity();
		user.setAddress("1 Yong St Toronto ON N7T2S6");
		user.setEmail("danny.hui@accenture.com");
		user.setFirstName("Danny");
		user.setLastName("Hui");
		user.setMobile("6478804043");
		user.setTelephone("4161234567");
		user.setUserName("dannyhui");
		user  = userRepository.save(user);

	    assertThat(user.getUserName()).isEqualTo("dannyhui");
	    assertThat(user.getUserId()).isGreaterThan(0);
	}
}
