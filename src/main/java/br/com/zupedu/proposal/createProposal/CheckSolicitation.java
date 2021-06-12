package br.com.zupedu.proposal.createProposal;

import br.com.zupedu.proposal.externalSystems.solicitations.ProposalSolicitationRequest;
import br.com.zupedu.proposal.externalSystems.solicitations.ProposalSolicitationResponse;
import br.com.zupedu.proposal.externalSystems.solicitations.SolicitationIntegration;
import feign.FeignException;
import org.springframework.stereotype.Component;

@Component
public class CheckSolicitation {

    public void check(SolicitationIntegration solicitationIntegration, Proposal proposal) {
        ProposalSolicitationRequest solicitation = new ProposalSolicitationRequest(proposal);

        try {
            ProposalSolicitationResponse response = solicitationIntegration.evaluate(solicitation);
            if (response.getResultadoSolicitacao().equals("SEM_RESTRICAO")) {
                proposal.setStatus(StatusSolicitation.ELEGIVEL);
            }
        } catch (FeignException e) {
            proposal.setStatus(StatusSolicitation.NAO_ELEGIVEL);
        }
    }
}
