package Stay.sure.Entitys.Factories;

import Stay.sure.Entitys.Visit;

public class VisitFactory {

    public static Visit createVisit(Long id, Long id_checker, Long id_room) {
        return new Visit(id, id_checker, id_room);
    }
}
