# Spring-Crud-Manager

O projeto de um CRUD Manager envolve a criação de uma aplicação que permita realizar operações básicas em um banco de dados, como criar, ler, atualizar e excluir registros. O Spring, juntamente com o Spring Data JPA, facilita essa tarefa, fornecendo recursos para mapeamento de entidades, acesso ao banco de dados e controle de transações.

Visão geral dos componentes envolvidos:

<h1>Entidades:</h1>

A entidade "Evento" representa um evento e pode conter atributos como id, nome, data de início, data de término, local e coordenador do evento.
A entidade "Coordenador" representa um coordenador de evento e pode conter atributos como id, nome, email, telefone e cargo.
Essas entidades devem ser anotadas com as anotações do JPA para mapeamento das tabelas do banco de dados.
<h1>Repositórios:</h1>

Os repositórios são interfaces que estendem a interface JpaRepository fornecida pelo Spring Data JPA.
Para a entidade "Evento", Existe uma interface "EventRepository" que estende JpaRepository<Event, int>.
Para a entidade "Coordenador", Existe uma interface "CoordRepository" que estende JpaRepository<Coord, int>.
Esses repositórios fornecem métodos predefinidos para executar operações de CRUD no banco de dados.
<h1>Serviços:</h1>

Os serviços são responsáveis por implementar a lógica de negócios e atuar como intermediários entre os controladores e os repositórios.

<h1>Controladores:</h1>

Os controladores são responsáveis por lidar com as requisições HTTP e fornecer as respostas apropriadas.
A classe "EventController" define métodos para os endpoints relacionados aos eventos, como criar Evento, atualizar Evento, excluir Evento, etc.
A classe "CoordController" define métodos para os endpoints relacionados aos coordenadores, como criar coordenador, atualizar coordenador, excluir coordenador, etc.
<h1>Rotas:</h1>

As rotas definem os endpoints da API e as operações CRUD correspondentes.
Utilize anotações como @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping para mapear as rotas nos controladores.
Por exemplo, você pode definir uma rota "/eventos" para o EventController com diferentes métodos para criar, ler, atualizar e excluir eventos.
