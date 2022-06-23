package ma.restos1.res;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ma.restos1.res.entities.Tables_Restos;
import ma.restos1.res.repository.TablesRepository;

@SpringBootApplication
public class Restos1Application implements CommandLineRunner {
	@Autowired
	TablesRepository tableRepository;
	public static void main(String[] args) {
		SpringApplication.run(Restos1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Done");
	}

}
