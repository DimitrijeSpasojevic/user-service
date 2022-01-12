package rs.edu.raf.userservice.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.userservice.dto.*;
import rs.edu.raf.userservice.security.CheckSecurity;
import rs.edu.raf.userservice.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get All clients")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})

    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<Page<ClientDto>> findAllClients(Pageable pageable, @RequestHeader("authorization") String authorization){
        return new ResponseEntity<>(userService.findAllClients(pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Register client user")
    @PostMapping("/register/client")
    public ResponseEntity<ClientDto> registerClient(@RequestBody @Valid CreateClientDto createClientDto) {
        return new ResponseEntity<>(userService.registerClient(createClientDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Register manager user")
    @PostMapping("register/manager")
    public ResponseEntity<ManagerDto> registerManager(@RequestBody @Valid CreateManagerDto createManagerDto) {
        return new ResponseEntity<>(userService.registerManager(createManagerDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Login user")
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginManager(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }

    @ApiOperation("Update atributes")
    @PutMapping("/edit")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER"})
    public ResponseEntity<ClientDto> editProfile(@RequestBody @Valid UpdateClientDto updateClientDto, @RequestHeader("authorization") String authorization) {
        return new ResponseEntity<>(userService.editProfile(authorization , updateClientDto), HttpStatus.OK);
    }
    @ApiOperation("Validate user")
    @GetMapping("validate/{id}")
    public ResponseEntity<Long> confirmEmailValidation(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.confirmEmailValidation(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/reservation")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER"})
    public ResponseEntity<Long> addReservation(@PathVariable("id") Long clientId, @RequestHeader("authorization") String authorization) {
        return new ResponseEntity<>(userService.addReservation(clientId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/reservation")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER"})
    public ResponseEntity<Long> deleteReservation(@PathVariable("id") Long clientId, @RequestHeader("authorization") String authorization) {
        return new ResponseEntity<>(userService.deleteReservation(clientId), HttpStatus.OK);
    }

    @GetMapping("/{id}/rank")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER"})
    public ResponseEntity<RankDto> getRankForClient(@PathVariable("id") Long userId, @RequestHeader("authorization") String authorization){
        return new ResponseEntity<>(userService.getRankForClient(userId),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_CLIENT", "ROLE_MANAGER"})
    public ResponseEntity<ClientDto> getClient(@PathVariable("id") Long clientId, @RequestHeader("authorization") String authorization){
        return new ResponseEntity<>(userService.getClient(clientId),HttpStatus.OK);
    }

}
