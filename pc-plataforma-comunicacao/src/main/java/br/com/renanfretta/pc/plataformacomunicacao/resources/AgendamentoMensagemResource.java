package br.com.renanfretta.pc.plataformacomunicacao.resources;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemInputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.exceptions.ErroTratadoRestException;
import br.com.renanfretta.pc.plataformacomunicacao.services.AgendamentoMensagemService;

@RestController
@RequestMapping(value = "/agendamento-mensagem")
public class AgendamentoMensagemResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(AgendamentoMensagemResource.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AgendamentoMensagemService service;

	@PostMapping
	public ResponseEntity<AgendamentoMensagemOutputDTO> salvar(@Valid @RequestBody AgendamentoMensagemInputDTO inputDTO) throws JsonProcessingException, ErroTratadoRestException {
		LOGGER.trace("PautaResource/salvar( " + objectMapper.writeValueAsString(inputDTO) + ") foi chamado");
		AgendamentoMensagemOutputDTO outputDTO = service.save(inputDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(outputDTO);
	}

}
