package mg.raseta.car_show.specification;

import mg.raseta.car_show.model.Car;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecification {

    public static Specification<Car> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Car> hasModel(String model) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("model"), model);
    }

    public static Specification<Car> hasPrice(Integer price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("price"), price);
    }

    public static Specification<Car> hasColor(String color) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("color"), color);
    }

    public static Specification<Car> hasPower(Integer power) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("power"), power);
    }

    public static Specification<Car> hasPlaceNumber(Integer placeNumber) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("placeNumber"), placeNumber);
    }

    public static Specification<Car> hasStatus(Boolean status) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Car> hasBrandId(Integer brandId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("brand").get("id"), brandId);
    }

    public static Specification<Car> hasCarTypeId(Integer carTypeId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("carTypes").get("id"), carTypeId);
    }

    public static Specification<Car> hasMotorTypeId(Integer motorTypeId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("motorTypes").get("id"), motorTypeId);
    }
}
