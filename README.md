# Loan Availability API

## Descrição do Projeto

Esta é uma API REST que valida os empréstimos disponíveis para um cliente de acordo com variáveis essenciais como **idade**, **salário** e **localização**. A API foi desenvolvida em **Java 17** utilizando o **Spring Boot**.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

- **DTO**: Classes que transportam dados entre processos. Utilizei DTOs tanto para encapsular o cliente que será validado quanto para o corpo da resposta de sucesso.
- **Controller**: Gerencia as requisições HTTP e direciona as chamadas para os serviços apropriados.
- **Model**: Classes que representam as entidades principais do sistema.
- **Service**: Contém a lógica de negócio, incluindo a validação dos empréstimos disponíveis.

## Requisitos
A validação dos empréstimos considera os seguintes requisitos:

- Conceder o empréstimo **pessoal** se o salário do cliente for igual ou inferior a R$ 3000.
- Conceder o empréstimo **pessoal** se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).
- Conceder o empréstimo **consignado** se o salário do cliente for igual ou superior a R$ 5000.
- Conceder o empréstimo com **garantia** se o salário do cliente for igual ou inferior a R$ 3000.
- Conceder o empréstimo com **garantia** se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).

## Endpoint

### `POST /customer-loans`

**Descrição**: Verifica os dados do cliente e retonar os empréstimos disponíveis.

**Corpo da Requisição**:
```json
{
    "age": 26,
    "cpf": "275.484.389-23",
    "name": "Vuxaywua Zukiagou",
    "income": 7000.00,
    "location": "SP"
}
```
**Validação dos Valores**:
- **age**: `Não pode ser nulo e deve ser >= 18.`
- **cpf**: `Deve ser um CPF válido, contendo 11 dígitos e podendo ter ou não pontuação. Ex: xxx.xxx.xxx-xx ou xxxXXXxxxXX`
- **name**: `Não pode ser nulo, não pode ser vazio e nem conter apenas espaços em branco.`
- **income**: `Não pode ser nulo e deve ser >= 1000`
- **location**: `Não pode ser nulo, não pode ser vazio e nem conter apenas espaços em branco.`

## Resposta
- **200: OK** se o corpo da requisição estiver de acordo com as validações.
```json
{
    "customer": "Vuxaywua Zukiagou",
    "loans": [
        {
          "type": "CONSIGNMENT",
          "interestRate": 2.0
        }
    ]
}
```
- **400: BAD REQUEST** se o corpo da requisição não estiver de acordo com as validações.
  
# Como Executar o Projeto

Para executar este projeto na sua máquina local, siga os passos abaixo:

## Pré-requisitos

- Java 17 instalado.
- Maven (ou Gradle) para gerenciamento de dependências.
- IDE (como IntelliJ IDEA ou Eclipse) para desenvolvimento.

## Passos

1. Clone o repositório:

```bash
git clone https://github.com/5alomao/loan-availability-api.git
cd loan-availability-api
```

2. Navegue até a pasta do projeto.

3. Execute o projeto com **Maven** ou **Gradle**
- Maven: `mvn spring-boot:run`
- Gradle: `gradle bootRun`

## Testes

Sinta-se à vontade para testar a API utilizando ferramentas como Postman, Insomnia ou cURL.

