package com.master.trainingcentermanagement;

import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class TrainingCenterManagementApplication implements CommandLineRunner {

	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TrainingCenterManagementApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

		if (userRepo.count() == 0){

			User user = User.builder()
					.firstname("mounir")
					.lastname("ayad")
					.email("mounir@admin.com")
					.phone("0682439559")
					.role(Role.ADMIN)
					.password(passwordEncoder.encode("00000000"))
					.active(true)
					.build();

			userRepo.save(user);
			System.out.println("ADMIN Account has been created successfully");
		}else {
			System.out.println("ADMIN is already exists");
		}


	}
}
