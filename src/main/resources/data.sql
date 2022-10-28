insert into usuario values ('rafaelronsonigaidzinski' ,'Administrador' ,'rafaelgaidzinski@yahoo.com' ,'Rafael Ronsoni Gaidzinski' ,'rafa2550' ,991723922);
insert into usuario values ('silvanaronsoni' ,'Gerente' ,'silvanaronsoni@gmail.com' ,'Silvana Ronsoni Gaidzinski' ,'sil1791' ,999715522);
insert into usuario values ('marcogaidzinski' ,'Gerente de TI' ,'marcogaidzinski@hotmail.com' ,'Marco Aurélio Gaidzinski' ,'mag1730' , 999572922);

insert into endereco values (default, 'Comerciário', '88802400', 'Criciúma', 'SC', '435', 'Rua Cecília Darós Casagrande');

insert into hotel values (30171991000117, 'contel@gmail.com', 'contel', 'contel.com.br', 999173091, 1);

insert into diaria values (default, 'Quartos de Solteiro', 200.00 , 250.00 , 150.00 , 200.00 , 250.00 , 150.00, 250.00);
insert into diaria values (default, 'Quartos de Casal', 225.00 , 275.00 , 175.00 , 225.00 , 275.00 , 175.00, 275.00);
insert into diaria values (default, 'Quartos Deluxe', 250.00 , 300.00 , 200.00 , 250.00 , 300.00 , 200.00, 300.00);
insert into diaria values (default, 'Quartos Premium', 275.00 , 325.00 , 225.00 , 275.00 , 325.00 , 225.00, 325.00);

insert into quarto values ('A-101', 0, 2, false, 1);

insert into hospede values (07073219998, '1991-10-30', 'rafaelgaidzinski@hotmail.com', 'Rafael Ronsoni Gaidzinski', 48991723912, 1);

insert into reserva (situacao_reserva, quantidade_hospedes, data_check_in_reserva, data_check_out_reserva, observacao_reserva, data_cadastro_reserva, quarto_numero_quarto, hospede_cpf_hospede)
		values ('Reservado', 2, '2022-10-24', '2022-10-25', 'Chega pela manhã', '2022-10-17', 'A-101', 7073219998);
		
insert into receita values (default, 'Hospedagem', null, 'Quarto A-101', 200.50, '2022-10-19', 1);
insert into receita values (default, 'Restaurante', '2022-10-18', 'Refrigerante', 5.50, '2022-10-18', null);