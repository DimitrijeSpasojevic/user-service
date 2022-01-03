package rs.edu.raf.userservice.mapper;

import org.springframework.stereotype.Component;
import rs.edu.raf.userservice.domain.Rank;
import rs.edu.raf.userservice.dto.CreateRankDto;
import rs.edu.raf.userservice.dto.RankDto;

@Component
public class RankMapper {

    public RankDto rankToRankDto(Rank rank){
        RankDto rankDto = new RankDto();
        rankDto.setDiscount(rank.getDiscount());
        rankDto.setId(rank.getId());
        rankDto.setMaxReservation(rank.getMaxReservation());
        rankDto.setMinReservation(rank.getMinReservation());
        rankDto.setName(rank.getName());
        return rankDto;
    }

    public Rank createRankDtoToRank(CreateRankDto createRankDto){
        Rank rank = new Rank();
        rank.setName(createRankDto.getName());
        rank.setDiscount(createRankDto.getDiscount());
        rank.setMinReservation(createRankDto.getMinReservation());
        rank.setMaxReservation(createRankDto.getMaxReservation());
        return rank;
    }
}
