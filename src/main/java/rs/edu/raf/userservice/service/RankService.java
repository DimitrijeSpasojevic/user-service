package rs.edu.raf.userservice.service;

import rs.edu.raf.userservice.dto.ClientDto;
import rs.edu.raf.userservice.dto.CreateRankDto;
import rs.edu.raf.userservice.dto.RankDto;
import rs.edu.raf.userservice.dto.UpdateRankDto;

public interface RankService {

    RankDto addRank(CreateRankDto createRankDto);

    RankDto updateRank(Long rankId, UpdateRankDto updateRankDto);
}
