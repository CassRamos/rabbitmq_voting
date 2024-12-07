package cass.bbb_rabbitmq.DTO;

import lombok.Getter;
import lombok.Setter;


public class VoteRequestDTO {
    private long candidateId;

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
    }
}
