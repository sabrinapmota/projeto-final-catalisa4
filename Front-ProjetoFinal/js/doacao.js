const doar = document.getElementById("cadastro-doacao")

doar.addEventListener('submit', event => { 
    event.preventDefault();

    const formData = new FormData(doar);  
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8080/usuarios/item-doado", {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
        .then(data => console.log(data))
        .catch(error => console.log(error));
});

function msg() {
    alert("Salvo com sucesso!");
    window.location.reload(true);
  }
