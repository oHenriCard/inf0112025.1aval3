## AVALIAÇÃO III - PRÁTICA

#### Membros: 

Júlia Carvalho, Henrique Cardoso, Vítor Araújo 

### Padrões utilizados:

#### Q1 - State
A questão pedia para que o **comportamento do objeto mudasse de acordo com a fase da prova**, ou, mais especificamente, o estado em que o atleta da prova se encontrava. Então, o padrão escolhido foi o State pois ele permite que um objeto altere seu comportamento quando seu estado interno muda, fazendo com que o objeto pareça ter mudado de classe.

Em nosso State, as classes são:

```
FaseProvaState
```
Este representa a interface em comum que todos os estados devem implementar. Todas as outras classes como:
```
MomentoLargadaState
PistaState
PosProvaState
PreProvaState
```
São os states completos.

#### Q2 - Chain of Responsibility
A questão apontava como um problema o fato de que a classe **Apurador possuía uma abordagem monolítica**, pois ela estava dificultando a adaptação do apurador de acordo com as características da prova, categoria, etc. Então, ao aplicar o Chain of Responsibility, pudemos desacoplar o Apurador das regras individuais e transformar cada regra em um objeto manipulador em uma cadeia de objetos. 

Em nossa implementação, criamos a classe: 

```
RegraApuracao
```
Que é o nosso Handler abstrato, definindo todas as regras na cadeia. E, então, temos as classes concretas:

```
RegraVerificaChegada
RegraAplicaPenalidadeAtraso
RegraVerificaOrdemPrismas
RegraVerificaTempoMaximo
RegraVerificaTodosPrismasRegistrados
```
Que são nossos handlers concretos.

Para não aplicar diversos parâmetros e tornar a extensibilidade mais flexível, criamos um objeto contexto chamado `ApuracaoContexto`, o qual encapsula todos os dados e o estado de operação. Se uma nova regra de apuração precisar de um novo campo, basta apenas adicioná-lo nesta classe, sem precisar mudar todos os métodos de assinatura nas demais classes já existentes.  
