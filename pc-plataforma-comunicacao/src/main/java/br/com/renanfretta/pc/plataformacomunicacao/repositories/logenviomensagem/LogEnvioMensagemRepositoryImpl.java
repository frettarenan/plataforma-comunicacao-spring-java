package br.com.renanfretta.pc.plataformacomunicacao.repositories.logenviomensagem;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.renanfretta.pc.plataformacomunicacao.entities.QAgendamentoMensagem;
import br.com.renanfretta.pc.plataformacomunicacao.entities.QLogEnvioMensagem;

@Repository
public class LogEnvioMensagemRepositoryImpl implements LogEnvioMensagemRepositoryCustom {

	@Autowired
	private EntityManager em;
	
	private static final QAgendamentoMensagem _agendamentoMensagem = QAgendamentoMensagem.agendamentoMensagem;
	private static final QLogEnvioMensagem _logEnvioMensagem = QLogEnvioMensagem.logEnvioMensagem;

	@Override
	public Long countMensagensEnviadasByIdAgendamentoMensagem(Long idAgendamentoMensagem) {
		JPAQuery<Long> query = new JPAQuery<>(em);

		query.select(_logEnvioMensagem.count());
		query.from(_logEnvioMensagem);
		query.join(_logEnvioMensagem.agendamentoMensagem, _agendamentoMensagem);
		query.where(_agendamentoMensagem.id.eq(idAgendamentoMensagem));
		query.where(_logEnvioMensagem.enviada.eq(true));

		return query.fetchOne();
	}

	@Override
	public Long countMensagensErroEnvioByIdAgendamentoMensagem(Long idAgendamentoMensagem) {
		JPAQuery<Long> query = new JPAQuery<>(em);

		query.select(_logEnvioMensagem.count());
		query.from(_logEnvioMensagem);
		query.join(_logEnvioMensagem.agendamentoMensagem, _agendamentoMensagem);
		query.where(_agendamentoMensagem.id.eq(idAgendamentoMensagem));
		query.where(_logEnvioMensagem.enviada.eq(false));

		return query.fetchOne();
	}

}
