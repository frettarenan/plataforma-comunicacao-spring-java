package br.com.renanfretta.pc.plataformacomunicacao.configs;

import org.springframework.stereotype.Component;

import br.com.renanfretta.pc.commons.configs.OrikaMapperBase;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemInputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.formatomensagem.FormatoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.pessoa.PessoaOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.entities.AgendamentoMensagem;
import br.com.renanfretta.pc.plataformacomunicacao.entities.FormatoMensagem;
import br.com.renanfretta.pc.plataformacomunicacao.entities.Pessoa;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class OrikaMapper extends OrikaMapperBase {

	public OrikaMapper() {
		if (mapperFacade != null)
			return;

		MapperFactory factory = new DefaultMapperFactory.Builder().build();

		factory.classMap(AgendamentoMensagem.class, AgendamentoMensagemInputDTO.class) //
				.constructorA().constructorB().mapNulls(true).mapNullsInReverse(true) //
				.byDefault().register();

		factory.classMap(AgendamentoMensagem.class, AgendamentoMensagemOutputDTO.class) //
				.constructorA().constructorB().mapNulls(true).mapNullsInReverse(true) //
				.byDefault().register();

		factory.classMap(Pessoa.class, PessoaOutputDTO.class) //
				.constructorA().constructorB().mapNulls(true).mapNullsInReverse(true) //
				.byDefault().register();

		factory.classMap(FormatoMensagem.class, FormatoMensagemOutputDTO.class) //
				.constructorA().constructorB().mapNulls(true).mapNullsInReverse(true) //
				.byDefault().register();

		mapperFacade = factory.getMapperFacade();
	}

}
