package rs.edu.raf.userservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.edu.raf.userservice.domain.Client;
import rs.edu.raf.userservice.domain.Rank;
import rs.edu.raf.userservice.dto.ClientDto;
import rs.edu.raf.userservice.dto.CreateRankDto;
import rs.edu.raf.userservice.dto.RankDto;
import rs.edu.raf.userservice.dto.UpdateRankDto;
import rs.edu.raf.userservice.mapper.ClientMapper;
import rs.edu.raf.userservice.mapper.RankMapper;
import rs.edu.raf.userservice.repository.ClientRepository;
import rs.edu.raf.userservice.repository.RankRepository;
import rs.edu.raf.userservice.service.RankService;

@Service
@Transactional
public class RankServiceImpl implements RankService {

    private ClientRepository clientRepository;
    private RankRepository rankRepository;
    private ClientMapper clientMapper;
    private RankMapper rankMapper;

    public RankServiceImpl(ClientRepository clientRepository, RankRepository rankRepository, ClientMapper clientMapper, RankMapper rankMapper) {
        this.clientRepository = clientRepository;
        this.rankRepository = rankRepository;
        this.clientMapper = clientMapper;
        this.rankMapper = rankMapper;
    }



    @Override
    public RankDto addRank(CreateRankDto createRankDto) {
        Rank rank = rankMapper.createRankDtoToRank(createRankDto);
        rankRepository.save(rank);
        return rankMapper.rankToRankDto(rank);
    }

    @Override
    public RankDto updateRank(Long rankId, UpdateRankDto updateRankDto) {
        Rank rank = rankRepository.getById(rankId);
        rank.setMinReservation(updateRankDto.getMinReservation());
        rank.setMaxReservation(updateRankDto.getMaxReservation());
        rank.setDiscount(updateRankDto.getDiscount());
        rank.setName(updateRankDto.getName());
        rankRepository.save(rank);
        return rankMapper.rankToRankDto(rank);
    }
}
