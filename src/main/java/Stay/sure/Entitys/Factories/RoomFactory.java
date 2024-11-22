package Stay.sure.Entitys.Factories;

import Stay.sure.Entitys.Room;

public class RoomFactory {

    public static Room createRoom(Long id, String lugar, Integer tamanio, Long id_Lesse) {
        return new Room(id, lugar, tamanio, id_Lesse);
    }
}
