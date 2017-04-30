package com.cefothe;

import com.cefothe.entities.Animal;
import com.cefothe.entities.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class LifycycleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LifycycleApplication.class, args);
		Dog dog = context.getBean(Dog.class);
		((AbstractApplicationContext)context).close();
	}

	@Scope("prototype")
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Animal createDog(){
		return new Dog();
	}
}
