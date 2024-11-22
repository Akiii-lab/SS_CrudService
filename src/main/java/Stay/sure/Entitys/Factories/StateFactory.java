package Stay.sure.Entitys.Factories;

import Stay.sure.Entitys.State;

public class StateFactory {

    public static State createState(Long id, String name) {
        return new State(id, name);
    }
}
