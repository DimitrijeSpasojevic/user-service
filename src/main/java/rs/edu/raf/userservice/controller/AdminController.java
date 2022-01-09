package rs.edu.raf.userservice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.userservice.dto.ClientDto;
import rs.edu.raf.userservice.dto.CreateClientDto;
import rs.edu.raf.userservice.dto.UpdateClientDto;
import rs.edu.raf.userservice.secutiry.CheckSecurity;
import rs.edu.raf.userservice.service.AdminService;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ApiOperation(value = "deny access")
    @PutMapping("/deny/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<ClientDto> denyAccess(@PathVariable("id") Long id, @ApiIgnore Pageable pageable) {
        return new ResponseEntity<>(adminService.denyAccess(id), HttpStatus.OK);
    }

    @ApiOperation(value = "allow access")
    @PutMapping("/allow/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<ClientDto> allowAccess(@PathVariable("id") Long id, @ApiIgnore Pageable pageable) {
        return new ResponseEntity<>(adminService.allowAccess(id), HttpStatus.OK);
    }

}
