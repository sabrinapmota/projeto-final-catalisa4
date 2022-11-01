# Projeto: Doação e recebimentos de items

# Sobre o projeto

Uma api desenvolvida como um projeto final de prática de curso no programa de formação da Zup Innovation feita em back-end e front-end. A api foi desenvolvida para que pessoas que tenham dificuldades em encontrar pessoas para doar seus itens parados e para pessoas que precisam e não conseguem encontrar items com facilidade.

Api pensada e desenvolvida para que as pessoas consigam ter um meio que facilite a comunicação entre doador e donatário que tenham interesse em comum sobre o item, sem haver muitas burocracias.
O sistema contém no registro de seus usuários os meios de contato, email e telefone,  para que possam entrar em acordo para finalizar a doação. 


# Funções do projeto

+ Cadastrar usuários, sendo doador ou donatário;
+ Cadastrar os itens que deseja doar;
+ Reservar o item para que possa ter preferência; 
+ Deletar o item caso não queria mais passá-lo adiante;
+ Avaliar tanto a pessoa que doou quanto a pessoa que recebeu;
+ Métodos de pesquisa para saber se os produtos encontra-se livres, reservados ou finalizados.

# Requisitos para consumo

+ Clonar repositório https://github.com/sabrinapmota/projeto-final-catalisa4 ;
+ Utilizar  uma IDE para rodar Spring Boot em java(recomendo intellij);
+ Utilizar a versão 11 do SDK;
+ Criar um container para comunicar com o banco;
+ Banco de dados relacional;
+ Postman.

# Projeto em uso

+ Método de cadastro de usuário onde insere o nome, email e telefone.
![image](https://user-images.githubusercontent.com/97555758/198348806-a229c631-2291-44ca-87b8-4a16ea06d88b.png)
+ Método que mostra, em forma de tabelas, os usuários cadastrados contendo id, nome, email, telefone e pontos;
![image](https://user-images.githubusercontent.com/97555758/198348998-d5e5b2f9-5ab7-42d2-8e9a-468f0bd8a725.png)
+ Método de cadastro do item que será doado cotendo nome, descrição e a referêcia da pessoa que está doando;
![image](https://user-images.githubusercontent.com/97555758/198349658-de400288-7f53-477c-b0c8-cc8d7f568390.png)
+ Método para listar,  por status,  os itens na condição de ABERTO, RESERVADO E FECHADO;
![image](https://user-images.githubusercontent.com/97555758/198349813-b7b23399-75ba-42f4-af95-2908a1f50348.png)
+ Método para reservar o item. A pessoa recebedora coloca seu id e pontua o doador do item em ate 50 pontos;
![image](https://user-images.githubusercontent.com/97555758/198350121-a4dd0199-8a50-4daf-beee-7773af660663.png)
+ Método para finalizar a doação. O doador pontua a pessoa que recebeu o item em ate 50 pontos;
![image](https://user-images.githubusercontent.com/97555758/198350166-a3bd4c42-d5cd-4024-b797-c2f9737d1b81.png)



# Tecnologia utilizada

#Back-end:
+ Java
+ Spring Boot
+ Jpa/hibernate
+ Maven
+ Validation
+ Spring Security
+ Docker
+ Pg Admin

#Front-end:
+ JS/HTML
+ Bootstrap

#Equipe:

+ Alunos/desenvolvedores: Sabrina, Max, Mauricio e William.
+ Tech Lead/Professores: Crispim e Joyce.
+ Scrum Master/ Professora: Carol.
+ P.O./ Mentores: Iris e Rafael.
