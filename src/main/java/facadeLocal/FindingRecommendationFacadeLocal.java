package facadeLocal;

import entity.FindingRecommendation;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface FindingRecommendationFacadeLocal {

    void create(FindingRecommendation findingRecommendation);

    FindingRecommendation edit(FindingRecommendation findingRecommendation);

    void remove(FindingRecommendation findingRecommendation);

    FindingRecommendation find(Long id);

    List<FindingRecommendation> findAll();
}
