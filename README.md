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
![image](https://user-images.githubusercontent.com/97555758/199359425-b9eb7cc2-1db2-4a8f-aa1b-7e37044d99cd.png)
+ metodo onde mostra em forma de tabelas os usuarios cadastrado contendo id, nome, email, telefone e pontos
![image](https://user-images.githubusercontent.com/97555758/199359495-bf39dbcb-476c-4e82-a336-35765b138d4f.png)
+ metodo onde ocorre o cadastro do item que será disponivel para doação com nome, descrição e a referencia da pessoa que esta doando
![image](https://user-images.githubusercontent.com/97555758/199359703-63df077a-a5b9-4493-9f3a-6f4aacd81d40.png)
+ metodo que onde é listado os item referente a situação podendo ser ABERTO, RESERVADO E FECHADO
![image](https://user-images.githubusercontent.com/97555758/199360049-700526f4-1042-47c3-8292-60efcf9b150c.png)
+ metodo onde acontece a reserva do item onde no campo a pessoa recebedora coloca seu id e pontua o dono do item em ate 50 pontos
![image](https://user-images.githubusercontent.com/97555758/199360476-d6d05a9d-7104-48d8-a179-290287960c1d.png)
+ metodo onde acontece a finalização do item onde no campo a pessoa doadora pontua a pessoa que recebeu o item em ate 50 pontos
![image](https://user-images.githubusercontent.com/97555758/199360614-45d62112-7d9e-42c5-bc6b-ddec0f07ffab.png)

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
