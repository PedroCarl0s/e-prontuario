
# e-Prontuário Eletrônico


## Como executar a API REST e o Banco de Dados MySQL

### Pré-requisitos
- [Docker](https://www.docker.com/)


### Passo a passo
1. Clonar este repositório:
`git clone https://github.com/dcx-cursos/projeto-avancado-group-1.git`

2. Entrar no diretório `e-prontuario`

3. Execute o comando `mvn clean package` para gerar o `.jar` ou avance para o passo 4

3. Executar o banco de dados MySQL e o servidor da API REST, configurados no *docker-compose.yml*:
`docker-compose up`

4. Testar a API em algum software como  [Postman](https://www.postman.com/), [Insomnia](https://insomnia.rest/) ou na própria documentação do **Swagger** no endereço http://localhost:7070/swagger-ui.html


## OBSERVAÇÃO

 Caso queira executar o projeto em alguma **IDE**, é necessário realizar alguns ajustes após a execução do `docker-compose up`:
 
 1. Desligue o *contêineres* com `docker stop docker-spring docker-mysql`

 2. Execute somente o *contêiner* do MySQL com `docker start docker-mysql`

 3. Obtenha o **IP** do contêiner* do MySQL  com `docker inspect docker-mysql`

> **PS.:** Será retornado um JSON, e no fim dele, copie o endereço da linha **IPAdress**  (nesse caso, 172.23.0.2)

```
		[...]
                    "Gateway": "xxxx",
		            "IPAddress": "172.23.0.2",
                    "IPPrefixLen": xxxx,
                    "IPv6Gateway": "",
                    "GlobalIPv6Address": "xxxx",
                    "GlobalIPv6PrefixLen": xxxx,
                    "MacAddress": "xxxx",
                    "DriverOpts": xxxx
                }
		[...]
```

 4. Abra o arquivo *application.properties* (`projeto-avancado-group-1/e-prontuario/src/main/resources`)

 5. Edite a linha `spring.datasource.url`

**ANTES**
```properties
spring.datasource.url=jdbc:mysql://mysql-service:3306/prontuario
```

**DEPOIS**
```properties
spring.datasource.url=jdbc:mysql://172.23.0.2:3306/prontuario
```
> **Lembrete.:** O *IP* `172.23.0.2` foi encontrado na seção 3 (Obtenha o IP do *contêiner* do MySQL ...)


 6. Execute o projeto na sua IDE
 
---

# Links Externos

- Tutorial utilizado para conteinerizar com Docker: [Docker compose with MySQL and Spring Boot ](https://medium.com/@kewynakshlley/docker-compose-with-mysql-and-spring-boot-596471664494)