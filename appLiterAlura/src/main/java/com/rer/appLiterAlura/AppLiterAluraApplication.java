package com.rer.appLiterAlura;

import com.rer.appLiterAlura.MenuLibro.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppLiterAluraApplication implements CommandLineRunner {
    @Autowired
    private Menu menu;
    public static void main(String[] args) {SpringApplication.run(AppLiterAluraApplication.class, args); }

    @Override
    public void run(String... args) throws Exception {
            menu.menuOpciones();
    }

}

