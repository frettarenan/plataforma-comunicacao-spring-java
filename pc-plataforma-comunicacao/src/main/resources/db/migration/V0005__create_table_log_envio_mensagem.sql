CREATE TABLE `log_envio_mensagem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_hora` datetime(6) NOT NULL,
  `id_agendamento_mensagem` bigint(20) NOT NULL,  
  `mensagem_erro` text DEFAULT NULL,
  `enviada` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_log_envio_mensagem_agendamento_mensagem` (`id_agendamento_mensagem`),
  CONSTRAINT `FK_log_envio_mensagem_agendamento_mensagem` FOREIGN KEY (`id_agendamento_mensagem`) REFERENCES `agendamento_mensagem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
