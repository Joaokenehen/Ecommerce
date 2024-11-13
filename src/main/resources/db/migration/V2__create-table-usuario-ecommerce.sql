create table usuarios (
                          usuario_id int primary key auto_increment,
                          nome_completo varchar(80) not null,
                          genero enum('Masculino', 'Feminino'),
                          data_cadastro timestamp default CURRENT_TIMESTAMP,
                          pais varchar(40),
                          cidade varchar(60),
                          endereco_linha varchar(225)
);