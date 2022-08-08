-- Turma

INSERT (id, dias_da_semana, nome_turma, turno, instrutor_id) INTO turma
    VALUES (1, 'Segunda, terça', 'turma1', 'manhã', 1);

INSERT (id, dias_da_semana, nome_turma, turno, instrutor_id) INTO turma
    VALUES (2, 'terça, quarta', 'turma2', 'manhã', 1);

INSERT (id, dias_da_semana, nome_turma, turno, instrutor_id) INTO turma
    VALUES (3, 'quarta, quinta', 'turma3', 'manhã', 1);

INSERT (id, dias_da_semana, nome_turma, turno, instrutor_id) INTO turma
    VALUES (4, 'quinta, sexta', 'turma4', 'manhã', 1);


-- Usuário

INSERT (id, nome, cid, contato, cpf, data_nascimento, endereco, genero, idade, parentesco, responsavel, email, Instituição, senha, sobrenome, telefone, instrutor_id) INTO usuario
    VALUES (1, 'Maria', 'cid-10','(61) 2137-7445', '487.351.120-85', '06/26/89', 'Rua dos bobos, numero 0, 69151-320', 'feminino', 'pai', 'joão', 'email@email.com', 'ufcg', 'senha123', 'Costa', '', 1);
INSERT (id, nome, cid, contato, cpf, data_nascimento, endereco, genero, idade, parentesco, responsavel, email, Instituição, senha, sobrenome, telefone, instrutor_id) INTO usuario
    VALUES (2, 'João', 'cid-10','(68) 2846-5795', '118.318.430-13', '04/18/94', 'Rua de pedras, numero 1, 69100-036', 'masculino', 'mãe', 'maria', 'email@email.com', 'ufcg', 'senha123', 'Silva', '', 1);
INSERT (id, nome, cid, contato, cpf, data_nascimento, endereco, genero, idade, parentesco, responsavel, email, Instituição, senha, sobrenome, telefone, instrutor_id) INTO usuario
    VALUES (3, 'José', 'cid-10', '(45) 2141-4563', '998.662.670-67', '12/08/02', 'Rua dos bobos, numero 2, 58085-510', 'feminino', 'irmão', 'josé', 'email@emailcom', 'ufcg', 'senha123', 'Fernandes', '', 1);
INSERT (id, nome, cid, contato, cpf, data_nascimento, endereco, genero, idade, parentesco, responsavel, email, Instituição, senha, sobrenome, telefone, instrutor_id) INTO usuario
    VALUES (4, 'Mariana', 'cid-10','(95) 2676-1220', '726.561.580-87', '08/20/92', 'Rua de pedras, numero 3, 69915-678', 'masculino', 'avó', 'severina', 'email@email.com', 'ufcg', 'senha123', 'Almeida', '', 1);