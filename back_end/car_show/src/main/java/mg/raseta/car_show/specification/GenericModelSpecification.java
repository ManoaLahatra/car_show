package mg.raseta.car_show.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class GenericModelSpecification<T> {
    
    public Specification<T> hasString(String toFind, String fieldName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(fieldName), toFind);
    }
    
    public Specification<T> hasInteger(Integer id, String fieldName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(fieldName).get("id"), id);
    }

    public Specification<T> hasBoolean(Boolean status, String fieldName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(fieldName), status);
    }
    
}