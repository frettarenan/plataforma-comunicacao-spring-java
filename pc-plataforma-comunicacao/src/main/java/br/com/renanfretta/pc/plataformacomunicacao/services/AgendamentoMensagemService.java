package br.com.renanfretta.pc.plataformacomunicacao.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.renanfretta.pc.plataformacomunicacao.configs.MessagesProperty;
import br.com.renanfretta.pc.plataformacomunicacao.configs.OrikaMapper;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemInputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.entities.AgendamentoMensagem;
import br.com.renanfretta.pc.plataformacomunicacao.enums.MessagesPropertyEnum;
import br.com.renanfretta.pc.plataformacomunicacao.exceptions.ErroTratadoRestException;
import br.com.renanfretta.pc.plataformacomunicacao.repositories.AgendamentoMensagemRepository;

@Service
@Validated
public class AgendamentoMensagemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AgendamentoMensagemService.class);
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private OrikaMapper orikaMapper;
	
	@Autowired
	private MessagesProperty messagesProperty;
	
	@Autowired
	private AgendamentoMensagemRepository repository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private FormatoMensagemService formatoMensagemService;
	
	private AgendamentoMensagemOutputDTO findById(Long id) throws ErroTratadoRestException {
		AgendamentoMensagem entity = repository.findById(id).orElseThrow(() -> new ErroTratadoRestException(messagesProperty.getMessage(MessagesPropertyEnum.ERRO__REGISTRO_NAO_ENCONTRADO_ENTIDADE_AGENDAMENTO_MENSAGEM)));
		LOGGER.trace("AgendamentoMensagemRepository/findById(" + id + ") teve êxito");
		AgendamentoMensagemOutputDTO dto = orikaMapper.map(entity, AgendamentoMensagemOutputDTO.class);
		return dto;
	}

	public AgendamentoMensagemOutputDTO save(AgendamentoMensagemInputDTO inputDTO) throws JsonProcessingException, ErroTratadoRestException {
		
		// Pessoa é válida?
		pessoaService.findById(inputDTO.getPessoaDestinatario().getId());
		
		// Formato mensagem é valido?
		formatoMensagemService.findById(inputDTO.getFormatoMensagem().getId());
		
		AgendamentoMensagem entity = orikaMapper.map(inputDTO, AgendamentoMensagem.class);
		entity = repository.save(entity);
		LOGGER.trace("AgendamentoMensagemRepository/save(" + objectMapper.writeValueAsString(entity) + ") teve êxito");
		AgendamentoMensagemOutputDTO outputDTO = findById(entity.getId());
		return outputDTO;
	}

}
