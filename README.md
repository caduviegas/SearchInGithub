
# Desafio técnico para Desenvolvedor(a) Android.

## Regras Gerais

As regras são as seguintes:

- O candidato tem até 3 dias para entregar a implementação do desafio.
- Nenhuma alteração no projeto será permitida após a entrega, caso contrário o candidato será desclassificado.
- O projeto deve ser desenvolvido em Android navito (Kotlin).
- O projeto deve ser disponibilizado em um repositório git (Github, Bitbucket ou Gitlab) público.
- O projeto deve conter as instruções necessárias para realizar a execução do mesmo.
- O candidato pode utilizar bibliotecas open-source de terceiros.

## Desafio

O desafio consiste na implementação de uma aplicação Android que deverá consumir a API pública do GitHub.

A API disponibiliza informações sobre os usuários e seus repositórios.

URL da API: https://api.github.com

O aplicativo deverá permitir:
- listagem de usuários;
- busca de usuário por nome de usuário;
- visualização das informações de um usuário específico;
- e a listagem de seus repositórios.

## Descrição

A aplicação deverá consumir um serviço para realizar tais operações:

- Este endereço lista apenas alguns usuários. Isto pode servir como uma massa de dados para a tela de listagem dos usuários da aplicação.
Para listar os usuários, a aplicação deverá consumir o seguinte endereço:<br/>
https://api.github.com/users

- Para obter informações específicas de um usuário, basta acessar o seguinte endereço:<br/>
https://api.github.com/users/torvalds

- Para listar os repositórios de um usuário específico, a aplicação deverá acessar o seguinte endereço:<br/>
https://api.github.com/users/torvalds/repos

- Para obter mais informações sobre a API:<br/>
https://developer.github.com/v3/

## Dicas

É sempre bom avisar ao usuário quando uma operação está em andamento.

A API pode retornar erros, por isso pense em como apresentar isso ao usuário.

Faça testes automatizados.

Explore a API antes de começar qualquer coisa.

Tire um tempo para entender tudo e faça um planejamento. Um bom projeto é fruto de um bom planejamento

## :clipboard: Arquitetura

A arquitetura utilizada para organizar o app como um todo foi a Clean Architecture [^2]. O padrão arquitetural MVVM [^3] foi utilizado na camada de apresentação para desacoplar a view das regras da aplicação.


## :books: Bibliotecas

- Material 3 - construção do layout.
- Koin - injeção de dependência.
- Jetpack Navigation - navegação do app.
- Glide - carregamento assíncrono de imagens.
- Coroutines - processamento assíncrono.
- Retrofit - requisições HTTP.
- Timber - Registro de informações e depuração

## :camera_flash: Telas do app

<div style="display: flex;">
  <img src="/images/animacao.jpeg" style="width: 200px; height: 400px" alt="Animation" />
  <img src="/images/user.jpeg" style="width: 200px; height: 400px" alt="List Users" />
  <img src="/images/search.jpeg" style="width: 200px; height: 400px" alt="Search" />
  <img src="/images/details.jpeg" style="width: 200px; height: 400px" alt="Details" />
  <img src="/images/not_found.jpeg" style="width: 200px; height: 400px" alt="Not Found" />
</div>

## Melhorias Futuras do app
- Implementar Testes Unitários
- Implementar Github Actions
- Atualizar Layout de xml para Compose
- Criar uma tela de usuários favoritos
- Criar um banco de dados para favoritar usuários (Possivelmente utilizando a biblioteca Room)
