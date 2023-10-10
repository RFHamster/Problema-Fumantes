# Problema-Fumantes

## Descrição do Problema na disciplina de Sistemas Operacionais

Faça um algoritmo que resolva o seguinte problema, usando threads e semáforos: “Três fumantes se encontram em uma sala com um vendedor de suprimentos para fumantes. Para preparar e usar um cigarro, cada fumante precisa de três ingredientes: tabaco, papel e fósforo, coisas que o vendedortem à vontade no estoque. Um fumante tem o seu próprio tabaco, o segundo tem seu próprio papel,e o outro tem seu próprio fósforo. A ação se inicia quando o vendedor coloca à venda doisingredientes na mesa, de forma a permitir que um dos fumantes execute esta prática dita como nãomuito saudável. Quando o tal fumante termina, ele acorda o vendedor, que escolhe então outros doisingredientes (aleatoriamente) e coloca a venda, portanto desbloqueando outro fumante.” OMinistério da Saúde adverte: Fumar faz mal à Saúde!

## Solução feita por mim

Resolvi esse problema de duas maneiras, ambas utilizando a linguagem Java. Primeiro defini 3 classes, a do vendedor, a do fumante e uma classe mesa que representa o local que ocorrerá o comércio dos itens do cigarro. O vendedor sorteia um número para definir quais elementos serão disponibilizados sendo:

0 -> papel e tabaco
1 -> papel e fósforo
2 -> tabaco e fósforo

Assim, sorteado o elemento ele fica disponível na mesa, onde um dos 3 fumantes irá pegá-lo (o fumante que precisa do item sorteado, também representado pelo número). Com os proodutos em mãos ele faz o seu cigarro, fuma por 3 segundos e acorda o vendedor, que fica nesse loop eternamente.

## 1 método na mesa

Primeiramente eu resolvi o problema utilizando métodos synchronized, onde os acessos para pegar e colocar elementos a mesa possuem uma "chave", e para acessar esses métodos, as Threads precisam esperar sua vez, a lógica é criada à partir dessa definição de synchronized e segue o padrão descrito acima

## 2 método na mesa

Outra maneira de resolver o problema é a utilização de semáforos, assim, ele irá fazer o mesmo controle dos métodos synchronized, e irá controlar o acesso das Threads aos métodos, fazendo com que elas sigam a lógica descrita na solução
