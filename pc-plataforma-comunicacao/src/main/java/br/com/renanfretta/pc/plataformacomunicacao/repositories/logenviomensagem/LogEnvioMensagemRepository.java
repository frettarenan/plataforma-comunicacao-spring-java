package br.com.renanfretta.pc.plataformacomunicacao.repositories.logenviomensagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.renanfretta.pc.plataformacomunicacao.entities.LogEnvioMensagem;

@Repository
public interface LogEnvioMensagemRepository extends LogEnvioMensagemRepositoryCustom, JpaRepository<LogEnvioMensagem, Long>, JpaSpecificationExecutor<LogEnvioMensagem>, QuerydslPredicateExecutor<LogEnvioMensagem> {

}
