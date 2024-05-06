package net.consumer.repository;

import net.consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData,Long> {
}
