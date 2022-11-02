# Projeto: Doação e recebimentos de items

# Sobre o projeto

Uma api desenvolvida como um projeto final de pratica de curso no programa de formação da zup innovation feita em back-end e front-end, api desenvolvida para que pessoas que tenham dificuldade de achar pessoas para doar seus itens parados e para pessoas que não conseguem achar items com facilidade.

Api pensada e desenvolvida para que as pessoas consigam ter um meio que facilite a comunicação entre as pessoas que tem interesse em comum sobre o item que desejam
doar sem que tenha muitas burocracias, o sistema contem no registro de seus usuarios meios de contato para que eles possam entrar num comum acordo para efetuar a doação. 


# Funçoes do projeto

+ Cadastrar usuarios que podem tanto receber ou doar seus items
+ Cadastrar os item que deseja doar
+ Reservar o item para que possa ter preferencia 
+ deletar o item caso não queria mais passa-lo a frente
+ avaliar tanto a pessoa que doou quanto a pessoa que recebeu
+ metodos de pesquisa para saber dos produtos livre, reservados ou finalizados

# Requisitos para consumo

+ clonar repositorio https://github.com/sabrinapmota/projeto-final-catalisa4
+ ter uma ide para rodar Spring boot em java(recomendo intellij)
+ um container para comunicar com o banco
+ banco de dados relacional
+ postman

# projeto em uso
+ metodo onde tem o cadastro de usuario onde ele insere seu nome, email e telefone
![image](https://user-images.githubusercontent.com/97555758/199540213-8be66f7a-fc7b-4ae1-ba90-61fb9fc6fb70.png)
+ metodo onde mostra em forma de tabelas os usuarios cadastrado contendo id, nome, email, telefone e pontos
![image](https://user-images.githubusercontent.com/97555758/199540525-39d742ae-68a2-4928-a01f-075e9ff390ac.png)
+ metodo onde ocorre o cadastro do item que será disponivel para doação com nome, descrição e a referencia da pessoa que esta doando
![image](https://user-images.githubusercontent.com/97555758/199541005-1a4d3288-2918-4b5c-854a-35ef851e5ebb.png)
+ metodo que onde é listado os item referente a situação podendo ser ABERTO, RESERVADO E FECHADO
![image](https://user-images.githubusercontent.com/97555758/199541235-c000b6a7-b2e0-48f9-9fa4-70a2ec5e10bd.png)
+ metodo onde acontece a reserva do item onde no campo a pessoa recebedora coloca seu id e pontua o dono do item em ate 50 pontos
![image](https://user-images.githubusercontent.com/97555758/199541760-de321710-49c2-487f-ae74-77da101a865d.png)
+ metodo onde acontece a finalização do item onde no campo a pessoa doadora pontua a pessoa que recebeu o item em ate 50 pontos
![image](https://user-images.githubusercontent.com/97555758/199541899-94bb5e5b-e263-4ba5-b843-5c6df5efd853.png)

# Tecnologia utilizada

#Back-end:
+ Java
+ Spring Boot
+ Jpa/hibernate
+ Maven
+ Validacion
+ Spring Security
+ Docker
+ Pg Admin

#Front-end:
+ JS/HTML
+ Bootstrap

#Equipe:

+ Alunos/desenvolvedores: Sabrina, Max, Mauricio e William.
+ Tec Leader/Professores: Cryspim e Joyce.
+ Scrum Master/ Professora: Carol.
+ P.O/ Mentores: Iris e Rafael.
