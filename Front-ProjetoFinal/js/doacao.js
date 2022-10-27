const doacao = document.getElementById("cadastro-doacao")

doacao.addEventListener('submit', event => { 
    event.preventDefault();

    const formData = new FormData(doacao);  
    const data = Object.fromEntries(formData);

    console.log(data)

    fetch("http://localhost:8080/item-doado", {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
        .then(data => console.log(data))
        .catch(error => console.log(error));
});


