package Stay.sure.Entitys.Factories;

import java.util.Date;

import Stay.sure.Entitys.StockPile;

public class StockPileFactory {

    public static StockPile createStockPile(Long id, Long id_room, Long id_user,Date date_stockpile) {
        return new StockPile(id, id_room, id_user, date_stockpile);
    }
}
