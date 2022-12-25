# Teste Modelmapper

Aplicação de teste para a criação de dois tipos de mapeamento de propriedades diferentes de uma mesma classe.

## Tabela de conteúdos

## Features

- [x] Configuração de dois tipos de mapeamento diferentes a partir de uma unica classe.
  - [x] De Conta para ContaPagamento
  - [x] De Conta para ContaCorrente

## Contrato da API

<details>
  <summary>Arquivo para criar a API no Swagger</summary>

```json
{
  "openapi": "3.0.1",
  "info": {
    "title": "Teste Modelmapper",
    "description": "Aplicação de teste para a criação de dois tipos de mapeamento de propriedades diferentes de uma mesma classe.",
    "contact": {
      "name": "gasfgrv",
      "url": "https://github.com/gasfgrv",
      "email": "gustavo_almeida11@hotmail.com"
    },
    "license": {
      "name": "Apache License Version 2.0",
      "url": "https://www.apache.org/licenses/LICENSE-2.0"
    },
    "version": "v1"
  },
  "servers": [
    {
      "url": "http://localhost:8080/",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/conta/pagamento": {
      "get": {
        "tags": [
          "conta-pagamento"
        ],
        "operationId": "testeContaPagamento",
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/ContaDTO"
                }
              }
            }
          }
        }
      }
    },
    "/conta/corrente": {
      "get": {
        "tags": [
          "conta-corrente"
        ],
        "operationId": "testeContaCorrente",
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/ContaDTO"
                }
              }
            }
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "ContaDTO": {
        "type": "object",
        "properties": {
          "agencia": {
            "type": "string"
          },
          "numeroConta": {
            "type": "string"
          },
          "digito": {
            "type": "string"
          }
        }
      }
    }
  }
}
```

</details>

## Endpoints da aplicação

<details>
  <summary>Documentação dos endpoints</summary>

**[GET] /conta/pagamento**

| Code | Description |
|------|-------------|
| 200  | OK          |

**[GET] /conta/corrente**

| Code | Description |
|------|-------------|
| 200  | OK          |

</details>

## Como rodar a aplicação

Rodar os seguintes comandos:

```shell
# Baixa a imagem
docker pull gustosilva/teste-modelmapper

# Roda o container
docker run -d -p 8080:8080 gustosilva/teste-modelmapper

# Mostra os logs
docker container logs --follow <id_container>
```
**Teste dos Endpoints**

[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=teste-modelmapper&uri=https%3A%2F%2Fgithub.com%2Fgasfgrv%2Fteste-modelmapper%2Fraw%2Fmaster%2Fcollection.json)

## Tecnologias utilizadas

Projeto feito usando Java 17 e Maven 3.8 como ferramenta de build.

## Dependencias

* spring-boot-starter-web
* modelmapper
* lombok
* spring-boot-starter-test
* springdoc-openapi-ui

### Licença

[Apache License Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)

### Autor

<div style="display: flex; justify-content: flex-start; gap: 15px;">
  <div>
    <img style="border-radius: 10%" src="https://avatars.githubusercontent.com/u/34608751?v=4" width="100px;" alt=""/>
  </div>
  <div>
    <p>Feito por Gustavo Silva:</p>
    <a href="https://www.linkedin.com/in/gustavo-silva-69b84a15b/"><img src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" height=25></a>
    <a href="https://discordapp.com/users/616994765065420801"><img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white" height=25></a>
    <a href="mailto:gustavoalmeidasilva41@gmail.com"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" height=25></a>
    <a href="mailto:gustavo_almeida11@hotmail.com"><img src="https://img.shields.io/badge/Microsoft_Outlook-0078D4?style=for-the-badge&logo=microsoft-outlook&logoColor=white" height=25></a>
  </div>
</div>