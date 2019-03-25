package study.basecamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.basecamp.entity.NumberEntity;

@Repository
public interface NumberRepository extends JpaRepository<NumberEntity, Integer> {
}
