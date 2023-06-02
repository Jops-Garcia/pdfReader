
# Sobre
Esta é a resposta  de um teste prático com o objetivo de extrair informações de um documento PDF, foi realizado utilizando a linguagem de programação Java, a IDE Visual Studio Code e a biblioteca PDFBox.

# Estrutura de arquivos (vscode)
No Visual Studio Code, quando trabalhamos com Java, por padrão há duas pastas, onde:

- `src`: é a pasta que contém os recursos (classes e arquivo PDF)
- `lib`: é a pasta que contém as dependências. (PDFBox)

Enquanto os arquivos compilados são gerados automaticamente na pasta `bin`
para customizar a estrutura, abra `.vscode/settings.json` 

# Preparando ambiente

Antes de iniciar é necessário verificar se possui o JDK devidamente instalado, pode ser encontrado em https://www.oracle.com/br/java/technologies/downloads/

Também é preciso adicionar o arquivo JAR contido na pasta `lib` no projeto java, trata-se da biblioteca utilizada, PDFBox. Dependendo da IDE utilizada é feito de forma diferente, no vscode basta adicionar à pasta `lib` (Já está adicionado, ou seja só clonar ou baixar esse repositório) ou caso tenha problemas, ir na opção “Referenced libraries” e adicionar com o navegador de arquivos. O arquivo JAR pode ser encontrado na pasta citada e também existe a possibilidade de baixá-lo no site oficial https://pdfbox.apache.org/download.html a versão utilizada foi a PDFBox 3.0.0-alpha3. 

# Como funciona

Neste tópico explicarei as classes e a execução do código. Optei por manter o código de forma que fosse simples e evitando passos desnecessários que o deixariam maior e não agregaria para solução já que este responde o que foi pedido. Reconheço a possibilidade de alterar o tipo das variáveis ex: data, valor ou até mesmo dividi-las ex: número da conta e dígito porém optei por mantê-las em string já que não seriam utilizadas para nada além de ser imprimidas. 


## Classes

Foram feitas 5 classes e elas estão em seus arquivos específicos. Todas elas seguem o mesmo padrão, entrarei em detalhes apenas na classe App e Transaction pois o exemplo será similar para todas.

Account: contém os métodos e variáveis relacionados à conta debitada.
Payment: contém os métodos e variáveis relacionados ao pagamento.
Statement: contém os métodos e variáveis relacionados ao extrato.
Transaction: contém os métodos e variáveis relacionados à operação.
App: main, realiza a leitura do arquivo e chama utiliza de métodos de outras classes.

## Funcionamento

O programa inicia pegando o diretório atual, portanto ***NÃO REMOVA DA PASTA SRC*** sem que seja alterado o diretório na variável “mydir”, é recomendado que o documento esteja ***JUNTO COM AS CLASSES***, caso haja alguma alteração há necessidade de alterar no código, segue a imagem em exemplo.

![image](https://github.com/Jops-Garcia/pdfReader/assets/56653059/22bcc89b-cb80-48cc-b482-d214fac60591)

utilizando a biblioteca PDFBox o arquivo é lido e percorrido linha por linha, chamando os métodos de busca de cada classe passando a linha como argumento para verificar se há a existência dos dados requeridos.

![image](https://github.com/Jops-Garcia/pdfReader/assets/56653059/bd159656-126e-433b-b3eb-8d560329a310)


Após entrar no método, em casos que possuem mais que um dado, a linha lida é encaminhada novamente para outros métodos, desta vez específicos para encontrar o necessário 

![image](https://github.com/Jops-Garcia/pdfReader/assets/56653059/b397c36c-26cf-4fd1-a7b5-89c5b5f57698)

Ele verifica se já foi encontrada a variável desejada, se não, prossegue com a busca, quando encontrado, seta a variável que auxilia na validação se o dado já foi preenchido então edita (removendo espaços desnecessários e em alguns casos o resto da string) e atribui o texto à variável.

![image](https://github.com/Jops-Garcia/pdfReader/assets/56653059/8a33e953-5df4-425c-bfa2-f3c1c97de174)

Após percorrer todo o documento, ocorre a impressão dos dados encontrados 

![image](https://github.com/Jops-Garcia/pdfReader/assets/56653059/ad8f4f38-7ba6-4ec8-b4f8-d685169e95a9)





