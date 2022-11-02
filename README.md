# Projeto: Doação e recebimentos de items

# Sobre o projeto

Uma API desenvolvida como projeto final de prática de curso no programa de formação da Zup Innovation. Projetada com back-end e front-end.  Ela foi desenvolvida a partir da necessidade de pessoas que tenham dificuldade de encontrar alguém para doar seus itens que estão parados e também para as pessoas que não conseguem encontrar items com facilidade.

A API foi  pensada e desenvolvida na intenção de que as pessoas consigam uma forma que facilite a comunicação entre quem tem interesse comum no item de quem deseja 
doar, isso  sem muitas burocracias. O sistema contém o registro de seus usuários e meios de contato para que eles entrem num comum acordo sobre como finalizar a doação. 


# Funções do projeto

+ Cadastrar usuários que podem ser tanto doador quanto donatários;
+ Cadastrar os itens que deseja doar;
+ Reservar o item para que possa ter preferência; 
+ Deletar o item caso não queira mais passá-lo à frente;
+ Avaliar tanto a pessoa que doou quanto a pessoa que recebeu o item;
+ Métodos de pesquisa para saber dos produtos livres, reservados ou finalizados.

# Requisitos para consumo

+ Clonar repositório https://github.com/sabrinapmota/projeto-final-catalisa4
+ Utilizar uma IDE para rodar Spring Boot em java(recomendo intellij)
+ Criar um container para comunicar com o banco;
+ Utilizar um banco de dados relacional;
+ Utilizar o postman;

# Projeto em uso:
+ Método que cadastra o usuário com nome, email e telefone
![image](https://user-images.githubusercontent.com/97555758/199540213-8be66f7a-fc7b-4ae1-ba90-61fb9fc6fb70.png)
+ Método que  mostra em forma de tabelas os usuários cadastrados com id, nome, email, telefone e pontos
![image](https://user-images.githubusercontent.com/97555758/199540525-39d742ae-68a2-4928-a01f-075e9ff390ac.png)
+ Método que cadastra o item para ser doado com nome, descrição e a referência da pessoa que esta doando
![image](https://user-images.githubusercontent.com/97555758/199541005-1a4d3288-2918-4b5c-854a-35ef851e5ebb.png)
+ Método que listam os itens referente aos status que se encontram podendo ser ABERTO, RESERVADO E FECHADO
![image](https://user-images.githubusercontent.com/97555758/199541235-c000b6a7-b2e0-48f9-9fa4-70a2ec5e10bd.png)
+ Método que reserva o item e que também o donatário coloca seu id e pontua o doador do item em ate 50 pontos
![image](https://user-images.githubusercontent.com/97555758/199541760-de321710-49c2-487f-ae74-77da101a865d.png)
+ Método que finaliza o processo de doação e que a pessoa doadora pontua a pessoa que recebeu o item em ate 50 pontos
![image](https://user-images.githubusercontent.com/97555758/199541899-94bb5e5b-e263-4ba5-b843-5c6df5efd853.png)

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
+ P.O/ Mentores: Iris e Rafael.
