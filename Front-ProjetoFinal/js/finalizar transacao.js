const fimDoar = document.getElementById("finalizar")

fimDoar.addEventListener('submit', event => { 
    event.preventDefault();

    const formData = new FormData(fimDoar);  
    const data = Object.fromEntries(formData);

    fetch(`http://localhost:8080/item-doado/${data.id_item}/finalizar-doacao`, {
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