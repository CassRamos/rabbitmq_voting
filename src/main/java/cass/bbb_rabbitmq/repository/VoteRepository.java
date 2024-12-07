package cass.bbb_rabbitmq.repository;

import cass.bbb_rabbitmq.entity.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {
}
