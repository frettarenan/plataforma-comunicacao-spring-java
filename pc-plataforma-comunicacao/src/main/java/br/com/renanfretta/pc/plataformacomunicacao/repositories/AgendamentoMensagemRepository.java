package br.com.renanfretta.pc.plataformacomunicacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.renanfretta.pc.plataformacomunicacao.entities.AgendamentoMensagem;

@Repository
public interface AgendamentoMensagemRepository extends JpaRepository<AgendamentoMensagem, Long>, JpaSpecificationExecutor<AgendamentoMensagem>, QuerydslPredicateExecutor<AgendamentoMensagem> {

}
