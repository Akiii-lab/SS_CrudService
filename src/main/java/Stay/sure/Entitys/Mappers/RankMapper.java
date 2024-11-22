package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.Rank;
import Stay.sure.Entitys.DTO.RankDTO;

public class RankMapper {

    public static RankDTO mapToDTO(Rank rank) {
        return new RankDTO(
                rank.getId(),
                rank.getName(),
                rank.getAssessment()
        );
    }

    public static Rank mapToEntity(RankDTO rankDTO) {
        return new Rank(
                rankDTO.id,
                rankDTO.name,
                rankDTO.assessment
        );
    }
}
