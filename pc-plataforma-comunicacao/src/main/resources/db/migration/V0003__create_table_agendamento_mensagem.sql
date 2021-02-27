CREATE TABLE `agendamento_mensagem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_hora_criacao` datetime(6) NOT NULL,
  `data_hora` datetime(6) NOT NULL,
  `mensagem` varchar(255) NOT NULL,
  `id_formato_mensagem` bigint(20) NOT NULL,
  `id_pessoa_destinatario` bigint(20) NOT NULL,
  `data_hora_cancelamento` datetime(6) DEFAULT NULL,
  `cancelado` bit(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_agendamento_mensagem_formato_mensagem` (`id_formato_mensagem`),
  KEY `FK_agendamento_mensagem_pessoa_destinatario` (`id_pessoa_destinatario`),
  CONSTRAINT `FK_agendamento_mensagem_formato_mensagem` FOREIGN KEY (`id_formato_mensagem`) REFERENCES `formato_mensagem` (`id`),
  CONSTRAINT `FK_agendamento_mensagem_pessoa_destinatario` FOREIGN KEY (`id_pessoa_destinatario`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
