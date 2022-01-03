package rs.edu.raf.userservice.mapper;

import org.springframework.stereotype.Component;
import rs.edu.raf.userservice.domain.Rank;
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
}
