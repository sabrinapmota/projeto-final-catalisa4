const doar = document.getElementById("cadastro-doacao")

fetch("http://localhost:8080/item-doado").then((data)=>{
    return data.json();
  }).then((mostrarItems) =>{
      let data1 = "";
      mostrarItems.map((values) =>{
          data1 += `
          <tbody>
              <tr align="center">
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
      document.getElementById("ItensDados").innerHTML = data1;
      console.log(mostrarItems);
  })