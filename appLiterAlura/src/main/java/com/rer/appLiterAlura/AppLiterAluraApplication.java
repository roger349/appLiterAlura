package com.rer.appLiterAlura;

import com.rer.appLiterAlura.Services.serviciosApiG;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AppLiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppLiterAluraApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        serviciosApiG serv=new serviciosApiG();
       /* Scanner sc=new Scanner(System.in);
        System.out.println("ingrese un titulo: ");
        String titulo=sc.nextLine();*/
        serv.datosLibApi();
    }
}
