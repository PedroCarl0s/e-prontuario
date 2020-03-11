
# e-Prontuário Eletrônico

![](https://img.shields.io/static/v1?label=docker&message=%20&logo=docker&logoColor=white&color=blue&labelColor=blue)
![](https://img.shields.io/static/v1?label=angular&message=%20&logo=angular&logoColor=red&color=42a1f5&labelColor=42a1f5)
![](https://img.shields.io/static/v1?label=spring&message=%20&logo=spring&color=5df07b&labelColor=5df07b)

## Como executar a API REST e o Banco de Dados MySQL

### Pré-requisitos
- [Docker](https://www.docker.com/)


### Passo a passo
1. Clonar este repositório:
`git clone https://github.com/dcx-cursos/projeto-avancado-group-1.git`

2. Entrar no diretório `e-prontuario`

3. Execute o comando `mvn clean package` para gerar o `.jar` ou avance para o passo 4, caso o arquivo `prontuario.jar`  esteja no diretório `e-prontuario/target`

3. Executar o banco de dados MySQL e o servidor da API REST, configurados no *docker-compose.yml*:
`docker-compose up`

4. Testar a API em algum software como  [Postman](https://www.postman.com/), [Insomnia](https://insomnia.rest/) ou na própria documentação do **Swagger** no endereço http://localhost:7070/swagger-ui.html


## OBSERVAÇÃO

 Caso queira executar o projeto em alguma **IDE**, é necessário realizar alguns ajustes após a execução do `docker-compose up`:
 
 1. Desligue o *contêineres* com `docker stop docker-spring docker-mysql`

 2. Execute somente o *contêiner* do MySQL com `docker start docker-mysql`

 3. Obtenha o **IP** do contêiner do MySQL  com `docker inspect docker-mysql`

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

# Apêndices

- [[PDF]](https://drive.google.com/file/d/1GYiQC-3XvjyK5aWb1DuUz7ZQ4m_LwhNx/view?usp=sharing) Modelo Relacional do **e-prontuario**


![enter image description here](https://imgur.com/9EEmYFD.png)


- Tutorial utilizado para conteinerizar com Docker: [Docker compose with MySQL and Spring Boot ](https://medium.com/@kewynakshlley/docker-compose-with-mysql-and-spring-boot-596471664494)