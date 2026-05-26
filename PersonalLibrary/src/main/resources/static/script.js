const API = "http://localhost:8080/livros";

async function listarLivros(){

    const resposta = await fetch(API);

    const livros = await resposta.json();

    const lista = document.getElementById("listaLivros");

    lista.innerHTML = "";

    livros.forEach(livro => {

        lista.innerHTML += `
            <div class="card">

                <h2>${livro.nomeLivro}</h2>

                <p><strong>Páginas:</strong> ${livro.paginas}</p>

                <p><strong>Nota:</strong> ${livro.avaliacao}/10</p>

                <p>${livro.avaliacaoEscrita}</p>

                <div class="botoes">

             <a href="Livro.html?id=${livro.id}">
                <button>Ver Livro</button>
            </a>

            <a href="EditarLivro.html?id=${livro.id}">
                <button>Editar</button>
            </a>

            <button onclick="deletarLivro(${livro.id})">
                Deletar
            </button>

            </div>

            </div>
        `;
    });
}

async function deletarLivro(id){

    const confirmar = confirm(
        "Deseja realmente deletar este livro?"
    );

    if(!confirmar){
        return;
    }

    await fetch(`${API}/${id}`, {

        method: "DELETE"
    });

    listarLivros();
}

listarLivros();