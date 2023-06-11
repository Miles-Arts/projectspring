package com.springboot.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Rutas {


    private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    @GetMapping("/hola")
    String miPrimeraRuta() {
        return "Hola Spring Boot com Gradle  =) ";
    }

    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial) {
        return "Leyendo el libro: La Última Puerta; Con ID: " + id + ", editorial: " + editorial;
    }

    @GetMapping("/libro2/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String params, @RequestParam String editorial) {
        return "Libro: Programando con Java; Con ID: " + id + ", params: " + params + ", editorial: " + editorial;
    }

    @PostMapping("/libro")
    String guardarLibro(@RequestBody Map<String, Object> libro) {
        libro.keySet().forEach(llave -> {


            logger.debug("Llave {} valor {}", llave, libro.get(llave));
        });

        return "Libro guardado!!!";
    }

}
