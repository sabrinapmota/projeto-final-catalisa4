const form = document.getElementById("cadastro-users")

//table - trazer usuários cadastrados na tela
fetch("http://localhost:8080/usuarios").then((data)=>{
    return data.json();
  }).then((todosUsuarios) =>{
      let data1 = "";
      todosUsuarios.map((values) =>{
          data1 += `
          <tbody>
              <tr>
                  <th scope="row">${values.id} </td>
                  <td>${values.nomeUsuario}</td> 
                  <td>${values.dataNascimento}</td> 
                  <td>${values.cpf} </td>
                  <td>${values.email}</td> 
              </tr>
          </tbody>
          `
      })
      document.getElementById("usuarioDados").innerHTML = data1;
      console.log(todosUsuarios);
  })