package br.com.renanfretta.pc.plataformacomunicacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.renanfretta.pc.plataformacomunicacao.entities.FormatoMensagem;

@Repository
public interface FormatoMensagemRepository extends JpaRepository<FormatoMensagem, Long>, JpaSpecificationExecutor<FormatoMensagem>, QuerydslPredicateExecutor<FormatoMensagem> {

}
