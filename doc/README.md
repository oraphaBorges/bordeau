# Bordeau

Como o arquivo do software foi maior que a capacidade máxima do moodle, será neceesário fazer um clone do projento no GitHub:

```git
git clone https://github.com/oraphaBorges/bordeau.git
```

## Programas e dependências
Para a execução do Bordeau é necessário ter instalado os seguintes softwares e dependencias nas versões indicadas ou superiores:

* Java 8
* IDE Eclipse
* Maven 3.4
* MySQL 5
* Servidor de Aplicação: Tomcat 9

### Guia de execução
Após a instalação dos softwares e dependências acima, para a execução completa do Bordeau é necessário seguir os seguintes passos:

* Abrir o MySQL e criar um banco de dados vazio com o comando:
  ```sql
  CREATE DATABASE bordeau;
  ```
* Importar o projeto para o Eclipse
* Clicar com o botão esquerdo do mouse, ir em `MAVEN` e depois em Update project, selecionar a opção `Force Update` e clicar em `Ok`.
* Depois na barra superior do Eclipse clicar me `Project` e depois em `Clean`

* Após vem a importação do servidor de aplicação, clicando com o botão esquerdo no projeto, `Run as`  depois em `Run Server` e selecionar a opção `Manually define a new server` , selecionar o Tomcat 9 e clicar em `Next`.
	* No botão `Browser` deve procurar a pasta em que foi baixado e descompactado o servidor de aplicação (O Tomcat ou o Wildfly) e clicar em `Next`
	* Por fim mover o projeto do Crossbox e mover para `Configured`  e clicar me `Finish`
* Agora na aba do Server, basta clicar em `Play` na aba `Server` e assim que o servidor terminar de dar o deploy na aplicação, quando aparecer a mensagem: 
``` java
INFO: Server startup in x ms
 ```
 * Por fim basta abrir o Navegador e abrir a página
``` html
http://localhost:8080/bordeau
 ```
