package com.dinosaurio.turnero.repository.specification;


import com.dinosaurio.turnero.dto.TurnoFilterDTO;
import com.dinosaurio.turnero.entity.TurnoEntity;
import com.nimbusds.jose.util.IntegerUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TurnoSpecification {

    public Specification<TurnoEntity> getByFilters(TurnoFilterDTO turnoFilterDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(turnoFilterDTO.isEstado() == true ){
                predicates.add(
                        criteriaBuilder.equal(root.get("estado"),1)
                );
            }

            //Remove duplicates
            query.distinct(true);

            //Order resolver
            String orderByField = "fecha_alta";
            query.orderBy(
                    turnoFilterDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
