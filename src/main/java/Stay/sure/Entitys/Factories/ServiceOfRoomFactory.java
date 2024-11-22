package Stay.sure.Entitys.Factories;

import Stay.sure.Entitys.ServiceOfRoom;

public class ServiceOfRoomFactory {

    public static ServiceOfRoom createServiceOfRoom(Long id, String name) {
        return new ServiceOfRoom(id, name);
    }
}
