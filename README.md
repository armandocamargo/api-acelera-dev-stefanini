# API-ACELERA-DEV  

API-ACELERA-DEV é uma api desenvolvida no desafio do curso acelera dev disponibilizado pela Stefanini.

## Pré requisitos
Ter o java instalado na maquina e um banco de dados mysql

## Instalação
Após baixar ou clonar o repositorio entrar no arquivo application.properties e colocar as configurações do seu banco de dados conforme abaixo
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/NomeDoBancoDeDados
spring.datasource.username=UsuarioBancoDeDados
spring.datasource.password=SenhaBancoDeDados
```

## Usos

### GET
/clientes retorna as informações dos clientes em formato json com os seguintes dados: nome, data de nascimento, cpf e o cep.

/clientes/"cpf" retorna as informações dos clientes em formato json com os seguintes dados: nome, data de nascimento, cpf, cep, logradouro, bairro, localidade e UF.

/produtos retorna as informações dos produtos em formato json com os seguintes dados: codigo, nome e  o preço.


### POST
/estoque/"id" informar o id do produto e informar a quantidade e data de entrada do produto em formato json para dar entrada de mercadoria no estoque conforme exemplo abaixo:

```
{
    "quantidade" : "25",
    "dataEntradaProduto" : "31/01/2024"
}
```
## Collection Postman

https://api.postman.com/collections/10340717-05898356-8a80-42e0-bd42-63432a212925?access_key=PMAT-01HPPKQTYXR74MNRV8029RZBXF

<h4 align="center"> 
	🚧  API 🚀 Em construção...  🚧
</h4>

### Features

- [x] Listagem de usuário
- [x] Listagem de produtos
- [x] Cadastro de entrada produtos
- [ ] Listagem de pedidos
- [ ] Leitura de arquivo xslx
