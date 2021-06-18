package br.com.zupedu.proposal.config.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class ProposalMetrics {

    private final MeterRegistry meterRegistry;
    private Counter counterProposalsCreated;
    private Timer timerFindProposal;

    public ProposalMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.myAccountantAndTimer();
    }

    public void myAccountantAndTimer() {
        Collection<Tag> tags = new ArrayList<>();
        tags.add(Tag.of("emitter", "Proposal-Api"));
        tags.add(Tag.of("bank", "Zupbank"));

        this.counterProposalsCreated = this.meterRegistry.counter("created_proposal", tags);
        this.timerFindProposal = this.meterRegistry.timer("find_proposal", tags);
    }

    public void incrementProposalCreated() {
        counterProposalsCreated.increment();
    }

    public void timerFindProposalRecord(Duration duration) {
        this.timerFindProposal.record(duration);
    }
}
