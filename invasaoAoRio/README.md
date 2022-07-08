# Projeto Invasão ao Rio de Janeiro
>O Jogo Invasão ao Rio de Janeiro é inspirado no modelo Plants vs Zombies, em que o jogador posiciona defesas para impedir o ataque inimigo. No caso do Invasão ao Rio de Janeiro, o jogador posiciona tanques de guerra para se defender de navios piratas, onde cada categoria de tanque e de navio possuem suas propriedades específicas, para os tanques é considerado a quantidade de tiros disponível e o dano que cada tiro causa em um navio, já para os navios é considerado a resistência aos tiros e a velocidade que ele anda no mapa.
O fluxo de jogo é simples, o jogo é inciado com 300 créditos e o jogador tem acesso a uma loja onde pode comprar três categorias de tanques de guerra, com cada tanque consumindo uma quantidade de créditos diferente. Uma vez que o jogador compra um tanque ele deve posicioná-lo em uma célula de terra que está vazia, ao fazer isso o tanque começa disparar tiros automaticamente em linha reta que atingem os navios que estão indo em direção as células de terra. Ao destruir um navio os créditos disponíveis aumentam.

# Equipe
* Giovanni Mesquita Micaroni 231702
* Jonathan do Ouro 248364
# Arquivo Executável do jogo
* [InvasãoAoRio](assets/InvasãoAoRio.jar)
* [InvasãoAoRio (Download)](https://drive.google.com/file/d/1t6f4L4nUpfXtKJUYKl2H6JAOP-ITxwBr/view?usp=sharing)
# Slides da Prévia
* [Slides da Prévia](assets/MC322-PropostaInicial.pptx)
* [Slides da Prévia (Apresentação)](https://docs.google.com/presentation/d/1VWDClihfaZlSJoE1NP40EWEMPne-HWDpHEoTdNXvNc4/edit?usp=sharing)

# Slides da Apresentação Final
* [Slides Finais](assets/MC322-SlidesFinais.pptx)
* [Slides Finais (Apresentação)](https://docs.google.com/presentation/d/1A17BexgyANxj-jKuBHobm8QDrC6Caz9vlF-jknswN2U/edit?usp=sharing) 

## Relatório de Evolução
O nosso projeto final utiliza o dessign pattern Model View Controller, todavia no começo do desenvolvimento não estávamos conseguindo organizar o projeto de tal forma que encaixa-se no design pattern, pois começamos o projeto sem utilizar componentes e a visualização do pattern ficava bastante bagunçada com as classes todas misturadas em uma única pasta. Além disso, não estavamos conseguindo utilizar as interfaces para comunicação entre classes de maneira correta, visto que a padronização de interface requerida e interface ofertada se encaixa melhor quando se utiliza componentes. Desta forma, reestruturamos o projeto para começar utilizar componentes.

![Arquitetura1](https://user-images.githubusercontent.com/102101030/178039047-137c4975-c7d1-4b9a-876a-a936924231bc.png)

Sendo o diagrama acima o primeiro esboço do projeto com componentes que se comunicam através de interfaces, mas este diagrama ainda não estava suficiente, pois faltava agrupar os componentes no pattern Model View Controller, para isso alteramos a estrutura de pastas do projeto como visto a baixo.

![pastas](https://user-images.githubusercontent.com/102101030/178039103-24221d74-eca3-496c-bb7e-6c804f1c123d.png)

Essa estrutura de pastas nos permitiu separar os elementos do jogo em componentes e agrupar eles de acordo com sua coesão entre si, assim deixando o projeto conforme o design pattern escolhido. 

# Destaques de Código

# Destaques de Orientação a Objetos

## Diagrama de Classes usada no destaque OO

![Celulas](https://user-images.githubusercontent.com/102101030/178052986-38c27cf0-cb7f-4b31-af5d-251ec1f04f1e.jpeg)

## Código do destaque de OO

~~~JAVA
public class Mapa implements IMapa{
	private ICelula[][] mapa;
	...
	public Mapa() {
		mapa = new ICelula[6][16];
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
			   if (j < 3)
				mapa[i][j] = new Terra();
			   else
				mapa[i][j] = new Agua();
			}
		}
	}
	...
}
~~~

# Destaques de Pattern

## Diagrama do Pattern

![observer](https://user-images.githubusercontent.com/102101030/178056439-2a832010-353e-49a2-af07-c499936bfddd.jpeg)

## Código do Pattern

~~~JAVA
public class Mapa implements IMapa{
    ...
    private IAtualizaTela atualizaTela;
    ...
    @Override
    public void connect(IAtualizaTela atualizaTela) {
	this.atualizaTela = atualizaTela;
    }
    @Override
    public void removerTanque(Tanque tanque) {
	mapa[tanque.getL()][tanque.getC()].removerElemento();
	atualizaTela.removerTanque(tanque);
    }
    ...
}
~~~
~~~JAVA
public class AtualizaTela implements IAtualizaTela{
    private IJanelaPadrao janela;
    public void connect(IJanelaPadrao janela) {
	this.janela = janela;
    }
    public void removerTanque(Tanque tanque) {
	janela.removerTanque(tanque);
    }
    ...
}
~~~
~~~JAVA
public class JanelaPadrao extends JFrame implements IJanelaPadrao {
    private Container contentPane;
    private ArrayList<Imagem> tanques;
    ...
    public void removerTanque(Tanque tanque){
        for(Imagem itanque: tanques){
            if(itanque.getL() == tanque.getL() && itanque.getC() == tanque.getC()){
                contentPane.remove(itanque);
                tanques.remove(itanque);
                break;
            }
        }
    }
   ...
}
~~~
> O paterrn destacado é o pattern Oberver, 

# Conclusões e Trabalhos Futuros

>Após o termino do nosso projeto, podemos dizer que atendemos a grande parte dos objetivos propostos por ele, como utilizar uma arquitetura bem planejada e que tira vantagem de ideias da orientação a objetos, como as interfaces e o polimorfismo, além dos design patterns. Também tivemos a oportunidade de utilizar o conceito de Threads, o que possibilitou o aprendizado de uma nova maneira de programar e colaborou para o funcionamento correto do jogo. Um ponto que, devido ao tempo curto, não recebeu a atenção necessária foi o plano de exceções. Devido à arquitetura montada pelo nosso grupo, no futuro poderíamos criar facilmente novos tipos de navios e de tanques, além de extender o total de ondas de navios e criar um boss final. Com esse projeto experienciamos na prática a importância de um bom planejamento e de uma arquitetura bem estruturada, que fazem toda a diferença em um projeto grande.

# Documentação dos Componentes

# Diagrama Geral da Arquitetura do Jogo
![Projeto Final POO 2022(1)](https://user-images.githubusercontent.com/69171865/178065976-8241e745-1356-4c8f-90b6-d58704878d70.jpeg)

>Comentando a arquitetura

## Diagrama Geral de Componentes

(IMAGEM DO DIAGRAMA)

## Componente `<Controle>`

> Tem o papel de posicionar os tanques de guerra no mapa e gerar os tiros dos tanques.

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `invasaoAoRio.src.invasaoAoRio.Controller.controle`
Autores | `<Jonathan do Ouro e Giovanni Mesquita>`
Interfaces | `<IRmapa> <IcontrolePropriedades>`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface Icontrole extends IRmapa, IcontrolePropriedades{
}
~~~

## Detalhamento das Interfaces

### Interface `<IRmapa>`

`<Permite um componente se conectar com o mapa>`

~~~JAVA
public interface IRmapa {
    public void connect(IMapa mapa);
}
~~~

Método | Objetivo
-------| --------
`IRmapa` | `conectar um objeto com o mapa`
