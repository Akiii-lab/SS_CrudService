package Stay.sure.Entitys.Factories;

import Stay.sure.Entitys.ServicesOfRoom;

public class ServiciesOfRoomFactory {

    public static ServicesOfRoom createServiciesOfRoom(Long id, Long id_room, Long id_service) {
        return new ServicesOfRoom(id, id_room, id_service);
    }
}
