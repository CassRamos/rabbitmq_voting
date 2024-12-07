package cass.bbb_rabbitmq.service;

import cass.bbb_rabbitmq.DTO.VoteRequestDTO;
import cass.bbb_rabbitmq.entity.Candidate;
import cass.bbb_rabbitmq.entity.Vote;
import cass.bbb_rabbitmq.repository.VoteRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final RabbitTemplate rabbitTemplate;
    private final VoteRepository voteRepository;

    public VoteService(RabbitTemplate rabbitTemplate, VoteRepository voteRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.voteRepository = voteRepository;
    }

    public void processVote(VoteRequestDTO request) {
        rabbitTemplate.convertAndSend("process-vote.ex", "", request);
    }

    public void saveVote(VoteRequestDTO request) {
        Vote vote = new Vote();
        vote.setCandidate(new Candidate(request.getCandidateId()));

        voteRepository.save(vote);

    }
}
