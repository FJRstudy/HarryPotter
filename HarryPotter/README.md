# Sobre

Foi desenvolvido um CRUD para manipulação dos dados dos personagens de Harry Potter com as seiguintes opções:

- Criar (Cadastrar) um novo personagem
- Atualizar um único personagem
- Ler um único ou vários personagens e podendo ser filtrado pela casa
- Deletar um único personagem

Além de se conectar com uma API externa para validar se a casa que o usuário informou é válida

Tecnologias utilizadas:<br/><br/>

MySql (8.0.26)<br/>
Java 8 <br/>
Maven <br/>
Spring boot dev tools<br/>
Spring Boot <br/>
Spring JPA <br/>

#Rodando o projeto:<br/><br/>
Antes de iniciarmos a aplicação, precisamos primeiramente do banco de dados, neste caso o **MySql v8.0.26**, você irá instalar esse banco em sua máquina com as seguintes configurações user: root, senha:admin


Com  DB em execução você precisará agora do **Maven** instalado na sua máquina para gerarmos o nosso build executando o comando:

```
mvn clean install
```

Irá jerá um arquivo **.jar** na pasta **target**.
Para testar execute este aquivo e execute essas requisições rest para as url's:<br/>

**Para pesquisar os perssonagens com o filtro das casas:**

```
GET http://localhost:8080/characters?house={string}
```

**Para pesquisar os perssonagens pelo seu id:**

```
GET http://localhost:8080/characters/{id}
```

**Para deletar o perssonagem pelo seu id:**

```
DELET http://localhost:8080/characters/{id}
```

**Para criar o perssonagem:**

```
POST http://localhost:8080/characters
body {
	"name": string,
	"role":string,
	"house": string,
	"patronus":string
}

```

**Para atualizar o perssonagem:**

```
PUT http://localhost:8080/characters
body {
	"name": string,
	"role":string,
	"house": string,
	"patronus": string
}
```



