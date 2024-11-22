package Stay.sure.Entitys.Mappers;

import Stay.sure.Entitys.StockPile;
import Stay.sure.Entitys.DTO.StockPileDTO;

public class StockPileMapper {

    public static StockPileDTO mapToDTO(StockPile stockPile) {
        return new StockPileDTO(
                stockPile.getId(),
                stockPile.getId_room(),
                stockPile.getId_user(),
                stockPile.getDate_stockpile()
        );
    }

    public static StockPile mapToEntity(StockPileDTO stockPileDTO) {
        return new StockPile(
                stockPileDTO.id,
                stockPileDTO.id_room,
                stockPileDTO.id_user,
                stockPileDTO.date_stockpile
        );
    }
}
