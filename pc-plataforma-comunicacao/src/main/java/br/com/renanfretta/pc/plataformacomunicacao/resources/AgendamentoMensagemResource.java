package br.com.renanfretta.pc.plataformacomunicacao.resources;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemInputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemStatusOutputDTO;
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
		LOGGER.trace("AgendamentoMensagemResource/salvar( " + objectMapper.writeValueAsString(inputDTO) + ") foi chamado");
		AgendamentoMensagemOutputDTO outputDTO = service.save(inputDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(outputDTO);
	}
	
	@GetMapping(value = "/cancelar/{id}")
	public ResponseEntity<AgendamentoMensagemOutputDTO> cancelarById(@PathVariable Long id) throws ErroTratadoRestException {
		LOGGER.trace("AgendamentoMensagemResource/cancelarById(" + id + ") foi chamado");
		try {
			AgendamentoMensagemOutputDTO outputDTO = service.cancelarById(id);
			return ResponseEntity.ok(outputDTO);
		} catch (NoSuchElementException e) {
			LOGGER.warn("AgendamentoMensagemResource/cancelarById(" + id + ") NoSuchElementException");
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping(value = "/{id}/status")
	public ResponseEntity<AgendamentoMensagemStatusOutputDTO> statusById(@PathVariable Long id) {
		LOGGER.trace("AgendamentoMensagemResource/statusById(" + id + ") foi chamado");
		try {
			AgendamentoMensagemStatusOutputDTO outputDTO = service.statusById(id);
			return ResponseEntity.ok(outputDTO);
		} catch (NoSuchElementException e) {
			LOGGER.warn("AgendamentoMensagemResource/statusById(" + id + ") NoSuchElementException");
			return ResponseEntity.badRequest().build();
		}
	}

}
