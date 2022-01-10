package rs.edu.raf.userservice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.userservice.dto.CreateRankDto;
import rs.edu.raf.userservice.dto.RankDto;
import rs.edu.raf.userservice.dto.UpdateRankDto;
import rs.edu.raf.userservice.security.CheckSecurity;
import rs.edu.raf.userservice.service.RankService;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/rank")
public class RankController {

    private RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @ApiOperation(value = "Add rank")
    @PostMapping
    @CheckSecurity(roles = {"ROLE_MANAGER"})
    public ResponseEntity<RankDto> addRank(@RequestBody @Valid CreateRankDto createRankDto,@RequestHeader("authorization") String authorization) {
        return new ResponseEntity<>(rankService.addRank(createRankDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update rank")
    @PutMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_MANAGER"})
    public ResponseEntity<RankDto> updateRank(@PathVariable("id") Long id, @ApiIgnore Pageable pageable, @RequestBody @Valid UpdateRankDto updateRankDto, @RequestHeader("authorization") String authorization) {
        return new ResponseEntity<>(rankService.updateRank(id,updateRankDto), HttpStatus.OK);
    }

}
