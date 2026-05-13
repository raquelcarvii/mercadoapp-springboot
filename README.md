# MercadoApp - API REST

API REST desenvolvida em Spring Boot que simula um sistema de mercado, permitindo o cadastro de produtos e clientes, além da realização de vendas com validação de saldo e estoque.

## Tecnologias

- Java 17
- Spring Boot 4
- Spring Data JPA
- H2 Database (em memória)
- Lombok
- Maven

## Como rodar

1. Clone o repositório:
```bash
git clone https://github.com/raquelcarvii/mercadoapp-springboot
```

2. Entre na pasta do projeto:
```bash
cd mercadoapp-springboot
```

3. Rode o projeto:
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

### Produtos
- `GET /produtos` - Lista todos os produtos
- `POST /produtos` - Cadastra um novo produto
- `PUT /produtos/{id}` - Atualiza um produto
- `DELETE /produtos/{id}` - Remove um produto

### Clientes
- `GET /clientes` - Lista todos os clientes
- `POST /clientes` - Cadastra um novo cliente
- `PUT /clientes/{id}` - Atualiza um cliente
- `DELETE /clientes/{id}` - Remove um cliente

### Vendas
- `POST /vendas` - Realiza uma venda

## Exemplos de uso

### Cadastrar produto
```json
POST /produtos
{
  "nome": "Banana",
  "preco": 5.00,
  "estoque": 20
}
```

### Cadastrar cliente
```json
POST /clientes
{
  "nome": "Ana Vieira",
  "email": "ana@email.com",
  "saldo": 120.00
}
```

### Realizar venda
```json
POST /vendas
{
  "clienteId": 1,
  "produtoId": 1,
  "quantidade": 2
}
```

## Estrutura do projeto

```
src/main/java/com/mercado/mercadoapp
├── controller    # Endpoints REST
├── dto           # Objetos de transferência
├── entity        # Entidades JPA 
├── repository    # Acesso ao banco de dados
└── service       # Regras de negócio
```

## Autor

Raquel Carvalho