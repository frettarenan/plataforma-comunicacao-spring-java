package br.com.renanfretta.pc.plataformacomunicacao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.renanfretta.pc.plataformacomunicacao.dtos.agendamentomensagem.AgendamentoMensagemInputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.formatomensagem.FormatoMensagemOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.dtos.pessoa.PessoaOutputDTO;
import br.com.renanfretta.pc.plataformacomunicacao.entities.AgendamentoMensagem;
import br.com.renanfretta.pc.plataformacomunicacao.entities.FormatoMensagem;
import br.com.renanfretta.pc.plataformacomunicacao.entities.Pessoa;
import br.com.renanfretta.pc.plataformacomunicacao.repositories.AgendamentoMensagemRepository;
import br.com.renanfretta.pc.plataformacomunicacao.repositories.FormatoMensagemRepository;
import br.com.renanfretta.pc.plataformacomunicacao.repositories.PessoaRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@DisplayName("Agendamento mensagem endpoint tests")
public class AgendamentoMensagemEndpointTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AgendamentoMensagemRepository agendamentoMensagemRepository;
	
	@MockBean
	private PessoaRepository pessoaRepository;
	
	@MockBean
	private FormatoMensagemRepository formatoMensagemRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeAll
	private static void beforeAll() {
	}
	
	// FIXME: implementar todo o restante dos testes unitários

	@Nested
	@DisplayName("Method: POST Path: /agendamento-mensagem")
	class salvar {

		@Test
		@DisplayName("Salvo com sucesso")
		public void salvarSucesso() throws Exception {

			Date dataHoraAgendamento = new Date();
			dataHoraAgendamento = org.apache.commons.lang3.time.DateUtils.addMonths(dataHoraAgendamento, 3);

			AgendamentoMensagemInputDTO dtoInput = AgendamentoMensagemInputDTO.builder() //
					.dataHora(dataHoraAgendamento) //
					.pessoaDestinatario(PessoaOutputDTO.builder().id(1L).build()) //
					.formatoMensagem(FormatoMensagemOutputDTO.builder().id(1L).build()) //
					.mensagem("Feliz aniversário! Como forma de agradecimento, hoje você tem 10%, aproveite!!!")
					.build();
			
			Pessoa pessoa = Pessoa.builder().id(1L).nome("Pessoa de teste").celular("48999988887").email("pessoa@gmail.com").build();
			FormatoMensagem formatoMensagem = FormatoMensagem.builder().id(1L).nome("E-mail").build();
			
			AgendamentoMensagem agendamentoMensagemEntrada = AgendamentoMensagem.builder() //
					.dataHora(dataHoraAgendamento) //
					.pessoaDestinatario(pessoa) //
					.formatoMensagem(formatoMensagem) //
					.mensagem("Feliz aniversário! Como forma de agradecimento, hoje você tem 10%, aproveite!!!") //
					.build();
			
			AgendamentoMensagem agendamentoMensagemRetorno = AgendamentoMensagem.builder() //
					.id(1L) //
					.dataHora(dataHoraAgendamento) //
					.pessoaDestinatario(pessoa) //
					.formatoMensagem(formatoMensagem) //
					.mensagem("Feliz aniversário! Como forma de agradecimento, hoje você tem 10%, aproveite!!!") //
					.build();
			
			BDDMockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
			BDDMockito.when(formatoMensagemRepository.findById(1L)).thenReturn(Optional.of(formatoMensagem));
			
			BDDMockito.when(agendamentoMensagemRepository.findById(1L)).thenReturn(Optional.of(agendamentoMensagemRetorno));
			BDDMockito.when(agendamentoMensagemRepository.save(agendamentoMensagemEntrada)).thenReturn(agendamentoMensagemRetorno);

			mockMvc.perform(post("/agendamento-mensagem") //
					.contentType(MediaType.APPLICATION_JSON) //
					.content(objectMapper.writeValueAsString(dtoInput))) //
					.andExpect(status().isCreated()) //
					.andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
					.andExpect(jsonPath("$.id").value(1)) //
					.andExpect(jsonPath("$.mensagem").value("Feliz aniversário! Como forma de agradecimento, hoje você tem 10%, aproveite!!!")); //
		}

	}

}
