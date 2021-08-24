package org.arun.springoauth.rest;

import java.util.Set;
import org.arun.springoauth.config.SecurityContextUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingRestController {

  @GetMapping("/hello")
  @PreAuthorize("hasAnyAuthority('ROLE_greeter')")  
  public ResponseEntity<String> hello(@RequestParam("name") String name) {

      System.out.println("==> GreetingRestController.hola: name=" + name);

      String suffix = name != null ? name : "world";
      String response = "Hello, " + suffix + "!";

      System.out.println("==> GreetingRestController.hola: response=" + response);
      return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/roles")
  // ESTO LO DEJO SIN SEGURIZAR
  //@PreAuthorize("hasAnyAuthority('ROLE_USER')")
  public ResponseEntity<Set<String>> getAuthorizedUserRoles() {
    System.out.println(" ==> GreetingRestController.getAuthorizedUserRoles! ");
    
    return ResponseEntity.ok(SecurityContextUtils.getUserRoles());
  }
}
