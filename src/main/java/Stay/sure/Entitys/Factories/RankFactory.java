package Stay.sure.Entitys.Factories;

import Stay.sure.Entitys.Rank;

public class RankFactory {

    public static Rank createRank(Long id, String name, Float assessment) {
        return new Rank(id, name, assessment);
    }
}
