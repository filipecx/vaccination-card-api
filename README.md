# 🐶 🐱 Carteira de Vacinação de Pets 🐾 💉 

## Descrição

Uma aplicação web para gerenciar o histórico de imunização dos bichinhos de estimação! Utilizado Java Spring, e PostgreSQL. Tentei aplicar conceitos aprendidos de Arquitetura limpa e DDD, e também conta com testes unitários.


## Requisitos Funcionais 

- O usuário deve poder cadastrar um ou mais pets
- O usuário deve poder registrar vacinações para o pet selecionado
- O usuário deve poder ver as vacinações registradas do pet selecionado
- O usuário deve poder ver quais são as próximas doses de reforço que o pet selecionado deve tomar
- O usuário deve poder ver quais vacinas o pet não precisa mais tomar

## Tecnologias Utilizadas

- **Java**
- **Spring**
- **PostgreSQL**

## 📂 Estrutura do Projeto

```
📁 vaccination_card_api
├── 📁 Core
    ├── 📁 Pet
        ├── 📁 DTO
        ├── 📁 Exception
        ├── 📁 Repository
        ├── 📁 Services
        ├── 📁 UseCases
        ├── 📄  Pet.java
    ├── 📁 Vaccination
├── 📁 Infratructure  
└── 📁 test  
```

## Documentação da API


### Tecnologias  
✅ Java • ✅ Spring • ✅ PostgreSQL 

### Endpoints

| Método | Rota                  | Ação                | Body/Params                      | Status        |
|--------|-----------------------|---------------------|----------------------------------|---------------|
| `POST` | `/pets`              | Adiciona pet  | `{ "name": "Shoyu", "image_url": url }` | `201 Created` |
| `GET`  | `/pets`              | Lista pets         | -                                  | `200 OK`      |
| `PUT`  | `/pets/{id}` | Atualiza info pet | `{ "name": "Teryaki", "image_url": url }`   | `200 OK`      |
| `DELETE` | `/pets/{id}`        | Remove pet         | -                                 | `204 No Content` |
| `GET`  | `/pets/{id}`          | Mostra pet         | -                                 | `200 OK`      |
| `PATCH`  | `/pets/{id}`        | Atualiza se pet está ativo |    `true`                 | `200 OK`      |
| `GET`  | `/pets/actives`       | Lista todos pets ativos         | -                    | `200 OK`      |


### Exemplos

**POST /items**  
Request:
```json
{ 
    "name": "Arroz", 
    "quantity": 2 
}
```  
`Response (201)`:
```json
{ 
    "id": 1, 
    "name": "Arroz", 
    "quantity": 2, 
    "purchased": false 
}
```

**GET /items**  
`Response (200)`:
```json
[
  { 
    "id": 1, 
    "name": "Arroz", 
    "quantity": 2, 
    "purchased": false 
    },
  { 
    "id": 2, 
    "name": "Feijão", 
    "quantity": 1, 
    "purchased": true 
    }
]
```

**PUT /items/1/purchased**  
Request:
```json
{ 
    "purchased": true 
}
```  
`Response (200)`:
```json
{ 
    "id": 1, 
    "name": "Arroz", 
    "quantity": 2, 
    "purchased": true 
}
```

**DELETE /items/1**  
Response: `204 No Content`

### Erros Comuns

| Código | Mensagem                     | Causa                  |
|--------|------------------------------|------------------------|
| `400`  | Campo 'name' é obrigatório   | Nome ausente           |
| `404`  | Item não encontrado          | ID inválido            |
| `500`  | Erro no LocalStorage         | Falha no armazenamento |

**Exemplo de Erro 400**  
```json
{
  "status": 400,
  "error": "Bad Request",
  "message": "Campo 'name' é obrigatório",
  "timestamp": "2025-03-18T10:16:00Z"
}
```

### 📦 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/lista-de-compras.git
   ```
2. Navegue até a pasta do projeto:
   ```bash
   cd lista-de-compras
   ```
3. Abra o **index.html** no navegador.

### 📖 Uso

1. Digite o nome de um item no campo de entrada.
2. Clique no botão **Adicionar** para incluí-lo na lista.
3. Clique no nome do item para marcá-lo como **comprado**.
4. Clique no **botão vermelho (❌)** para remover um item.
5. Os itens serão salvos automaticamente no navegador.

## 📌 Estrutura dos Dados (Simulando API REST)

Embora a aplicação não tenha backend na V1, simulamos os seguintes endpoint:

| **Método** | **Rota**      | **Descrição**               |
|------------|--------------|-----------------------------|
| **POST**   | `/items`      | Adiciona um novo item       |
| **GET**    | `/items`      | Retorna todos os itens      |
| **PUT**    | `/items/{id}` | Marca um item como comprado|
| **DELETE** | `/items/{id}` | Remove um item da lista    |

### 🛑 Tratamento de Erros

| **Código** | **Mensagem**              |
| ---------- | ------------------------- |
| 400        | "Item não pode ser vazio" |
| 404        | "Item não encontrado"     |

### 🚀 Próximos Passos

- Adicionar integração com Backend para persistência de dados;
- Adicionar opção de Login caso o usuário deseje;
- Adicionar usabilidade para computadores e tablets.

### 🎓 Principais Aprendizados

- Uso do LocalStorage para persistência de dados sem backend.
- Manipulação do DOM com JavaScript puro para criar uma interface interativa.
- Importância da responsividade para garantir uma boa experiência em dispositivos móveis.
- Estruturação de um projeto simples, mas funcional, com HTML, CSS e JS.


Por Angie Hempkmeier ❤️ 
 