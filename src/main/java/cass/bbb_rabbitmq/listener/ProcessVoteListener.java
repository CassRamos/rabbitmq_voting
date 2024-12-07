package cass.bbb_rabbitmq.listener;


import cass.bbb_rabbitmq.DTO.VoteRequestDTO;
import cass.bbb_rabbitmq.service.VoteService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProcessVoteListener {


    private final VoteService voteService;

    ProcessVoteListener(VoteService voteService) {
        this.voteService = voteService;
    }

    @RabbitListener(queues = "process-vote.queue")
    public void processVote(VoteRequestDTO request){
        voteService.saveVote(request);
    }
}
