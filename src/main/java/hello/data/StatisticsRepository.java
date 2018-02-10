package hello.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StatisticsRepository extends CrudRepository<HashtagsHits, Long> {

    List<HashtagsHits> findByHashTag(String hashTag);
}