<h1>Back-end Developer Challenge</h1>

<h2>Contextualização</h2> 
<p>O presente Projecto espelha o desenvolvimento de uma API RESTful (HATEOS)  para a gestão de Países, utilizando a linguagem de programação Java e o Ecossistema Spring, tendo sido implementado o Sistema de Gestão de Base de Dados MySQL para a persistência de dados.</p> 
<p>De forma a manter consistente o código fonte e a arquitetura do banco de dados, foi implementado o mecanismo de migração de dados flyway.</p>
<p><strong>Nota: </strong> A API desenvolvida espelha todas constraints para ser considerada RESTful</p>

<h2>Mapeamento de URL</h2>

<table>
  <thead>
    <tr>
      <th>Descrição</th>
      <th>Método HTTP</th>
      <th>Parâmetro</th>
      <th>URL</th>
      <th>Exemplo</>
    </tr>
  </thead>
  <tbody>
     <tr>
       <td>Listar países</td>
       <td>GET</td>
       <td>---</td>
       <td>/paises</td>
       <td>http://localhost:8080/paises</td>
    </tr>
    <tr>
       <td>Listar países de com critério de ordenação</td>
       <td>GET</td>
       <td>sort</td>
       <td>/paises?sort={criterio}</td>
       <td>http://localhost:8080/paises?sort=capital</td>
    </tr>
    <tr>
       <td>Pesquisar por código</td>
       <td>GET</td>
       <td>---</td>
       <td>/paises/{codigo}</td>
       <td>http://localhost:8080/paises/2</td>
    </tr>
    <tr>
       <td>Registar novo país</td>
       <td>POST</td>
       <td>---</td>
       <td>/paises</td>
       <td>http://localhost:8080/paises <br><br> *É necessário passar o corpo da requisição com o tipo de contéudo application/json</td>
    </tr>
    <tr>
       <td>Actualizar</td>
       <td>PUT</td>
       <td>---</td>
       <td>/paises</td>
       <td>http://localhost:8080/paises <br><br> *É necessário passar o corpo da requisição com o tipo de contéudo application/json</td>
    </tr>
    <tr>
       <td>Remover</td>
       <td>DELETE</td>
       <td>---</td>
       <td>/paises/{codigo}</td>
       <td>http://localhost:8080/paises/12</td>
    </tr>
  </tbody>
<table>
