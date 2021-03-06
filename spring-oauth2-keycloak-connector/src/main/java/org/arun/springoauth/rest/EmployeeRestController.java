package org.arun.springoauth.rest;

import java.util.Set;
import org.arun.springoauth.config.SecurityContextUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {

  @GetMapping(path = "/username")
  //@PreAuthorize("hasAnyAuthority('ROLE_USER')")
  @PreAuthorize("hasAnyAuthority('ROLE_greeter')")  
  public ResponseEntity<String> getAuthorizedUserName() {
    System.out.println(" ==> Entró en getAuthorizedUserName! ");
    return ResponseEntity.ok(SecurityContextUtils.getUserName());
  }

  @GetMapping(path = "/roles")
  //@PreAuthorize("hasAnyAuthority('ROLE_USER')")
  public ResponseEntity<Set<String>> getAuthorizedUserRoles() {
    System.out.println(" ==> Entró en getAuthorizedUserRoles! ");
    return ResponseEntity.ok(SecurityContextUtils.getUserRoles());
  }
}
