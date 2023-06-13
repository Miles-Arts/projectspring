package com.springboot.project;

import com.springboot.project.models.Libro;
import com.springboot.project.models.Producto;
import com.springboot.project.models.UserData;
import com.springboot.project.myBeans.MyBean;
import com.springboot.project.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.error.MarkedYAMLException;

import java.util.List;
import java.util.Map;

@RestController
public class Rutas {

    private OrderService orderService;
    private MyBean myBean;

    public Rutas (OrderService orderService, MyBean myBean) {
        this.orderService = orderService;
    }

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
    String guardarLibro(@RequestBody Libro libro) {
            logger.debug("Libro {} editorial {}", libro.nombre, libro.editorial);

            if (libro.nombre == null) throw new IllegalArgumentException("No hay libro ");

        return "Libro guardado!!!";
    }

    @GetMapping("/saludar")
    //@ResponseStatus(value = HttpStatus.OK)
    //@ResponseStatus(value = HttpStatus.ACCEPTED)
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida la ruta 2 de la API")
    String miSegundaRutaConStatus() {
        return "Aprendiendo Status, HTTP en Spring Boot";

    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar) {
        if (lugar.equals("granja")) {
        return ResponseEntity.status(HttpStatus.OK).body("Caballo, Vaca, Oveje, Gallina");
        } else if (lugar.equals("selva")) {
            return ResponseEntity.status(HttpStatus.OK).body("Mono, Gorilla, Puma");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lugar no válido");
        }
    }

    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero) {
        throw new NullPointerException("----Error de excepción revisar los carácteres y/o información no relevante para el CLIENTE----");
    }

    @GetMapping("/userData")
    public ResponseEntity<String> getUserData() {
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body("{\"name\": \"Mary\"}");
    }

    @GetMapping("/userData/v2")
    public  Map<String, Map<String, Object>> getUserDataV2() {
        return Map.of("user", Map.of("name" , "Mary", "age", 23 ));
    }

    @GetMapping("/userData/v3")
    public UserData getUserDataV3( ) {

        return new UserData("Mary", 23, "Avenida 123");
//        var userData = new UserData("mary", 23);
    }

    @PostMapping("/order")
    public String createOrder(@RequestBody List<Producto> products) {
        orderService.saveOrder(products);
        return "Productos guardados";
    }

}
