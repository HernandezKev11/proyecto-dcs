package com.proyecto.dcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);

  }



  @Override
  public void run(String... args) {
    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS  solicitante(" +
            "id SERIAL,nombre VARCHAR(255),correo VARCHAR(255),autoBuscado VARCHAR(255),dineroEntregado VARCHAR(255),estadoSolicitud VARCHAR(255), fechaSolicitud timestamp)");

  }

}