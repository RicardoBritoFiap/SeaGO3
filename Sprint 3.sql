CREATE TABLE USERS(
    id NUMBER PRIMARY KEY,
    username VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) NOT NULL UNIQUE,
    cnpj VARCHAR2(14) NOT NULL UNIQUE,
    password VARCHAR2(100) NOT NULL
);


CREATE TABLE DADOS(
    id NUMBER PRIMARY KEY,
    faturamento VARCHAR2(100) NOT NULL,
    fluxo_vendas VARCHAR2(100) NOT NULL,
    clientes VARCHAR2(100) NOT NULL,
    acessos_plataforma VARCHAR2(100) NOT NULL,
    users_id NUMBER,
    CONSTRAINT fk_users_dados FOREIGN KEY (users_id) REFERENCES USERS(id)
);

ALTER TABLE DADOS DROP CONSTRAINT FK_USERS_DADOS;

ALTER TABLE DADOS
ADD CONSTRAINT FK_USERS_DADOS
FOREIGN KEY (users_id) REFERENCES USERS(id)
ON DELETE CASCADE;

-- Inserts para UserModel
INSERT INTO users (id, username, email, cnpj, password) VALUES (1, 'empresa1', 'empresa1@email.com', '12345678000101', 'senha123');
INSERT INTO users (id, username, email, cnpj, password) VALUES (2, 'empresa2', 'empresa2@email.com', '98765432000109', 'senha456');
INSERT INTO users (id, username, email, cnpj, password) VALUES (3, 'empresa3', 'empresa3@email.com', '56789012000155', 'senha789');

-- Inserts para DadosModel
INSERT INTO dados (id, faturamento, fluxo_vendas, clientes, acessos_platadorma, usermodel_id) 
VALUES (1, '500000', '200 vendas/mês', '300 clientes', '1000 acessos/mês', 1);

INSERT INTO dados (id, faturamento, fluxo_vendas, clientes, acessos_platadorma, usermodel_id) 
VALUES (2, '750000', '300 vendas/mês', '400 clientes', '1500 acessos/mês', 2);

INSERT INTO dados (id, faturamento, fluxo_vendas, clientes, acessos_platadorma, usermodel_id) 
VALUES (3, '600000', '250 vendas/mês', '350 clientes', '1200 acessos/mês', 3);


