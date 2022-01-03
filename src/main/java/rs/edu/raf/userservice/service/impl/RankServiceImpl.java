package rs.edu.raf.userservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.edu.raf.userservice.dto.ClientDto;
import rs.edu.raf.userservice.dto.CreateRankDto;
import rs.edu.raf.userservice.dto.RankDto;
import rs.edu.raf.userservice.dto.UpdateRankDto;
import rs.edu.raf.userservice.service.RankService;

@Service
@Transactional
public class RankServiceImpl implements RankService {
    @Override
    public ClientDto setRankForClient(RankDto rankDto, Long clientId) {
        return null;
    }

    @Override
    public RankDto addRank(CreateRankDto createRankDto) {
        return null;
    }

    @Override
    public RankDto updateRank(Long rankId, UpdateRankDto updateRankDto) {
        return null;
    }
}
