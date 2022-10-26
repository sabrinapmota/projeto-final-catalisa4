const form = document.getElementById("cadastro-doacao")

//table - trazer usuários cadastrados na tela
fetch("http://localhost:8080/item-doado").then((data)=>{
    return data.json();
  }).then((buscarTodos) =>{
      let data1 = "";
      todosUsuarios.map((values) =>{
          data1 += `
          <tbody>
              <tr>
                  <th scope="row">${values.id} </td>
                  <td>${values.nome}</td> 
                  <td>${values.descricao}</td> 
                  <td>${values.idPessoaDoadora} </td>
                  <td>${values.status}</td> 
                  <td>${values.dataInicio}</td> 
                  <td>${values.dataTermino}</td>
                  <td>${values.idPessoaRecebedora}</td>
                  <td>${values.pontosDoador}</td>
                  <td>${values.pontosRecebedor}</td>
              </tr>
          </tbody>
          `
      })
      document.getElementById("usuarioDados").innerHTML = data1;
      console.log(todosUsuarios);
  })