
## Sobre
Esta é a resposta  de um teste prático com o objetivo de extrair informações de um documento PDF, foi realizado utilizando a linguagem de programação Java, a IDE Visual Studio Code e a biblioteca PDFBox.

##Estrutura de arquivos (vscode)
No Visual Studio Code, quando trabalhamos com Java, por padrão há duas pastas, onde:

- `src`: é a pasta que contém os recursos (classes e arquivo PDF)
- `lib`: é a pasta que contém as dependências. (PDFBox)

Enquanto os arquivos compilados são gerados automaticamente na pasta `bin`
para customizar a estrutura, abra `.vscode/settings.json` 

## Preparando ambiente

Antes de iniciar é necessário verificar se possui o JDK devidamente instalado, pode ser encontrado em https://www.oracle.com/br/java/technologies/downloads/

Também é preciso adicionar o arquivo JAR contido na pasta `lib` no projeto java, trata-se da biblioteca utilizada, PDFBox. Dependendo da IDE utilizada é feito de forma diferente, no vscode basta adicionar à pasta `lib` (Já está adicionado, ou seja só clonar ou baixar esse repositório) ou caso tenha problemas, ir na opção “Referenced libraries” e adicionar com o navegador de arquivos. O arquivo JAR pode ser encontrado na pasta citada e também existe a possibilidade de baixá-lo no site oficial https://pdfbox.apache.org/download.html a versão utilizada foi a PDFBox 3.0.0-alpha3. 

## Como funciona

Neste tópico explicarei as classes e a execução do código. Optei por manter o código de forma que fosse simples e evitando passos desnecessários que o deixariam maior e não agregaria para solução já que este responde o que foi pedido. Reconheço a possibilidade de alterar o tipo das variáveis ex: data, valor ou até mesmo dividi-las ex: número da conta e dígito porém optei por mantê-las em string já que não seriam utilizadas para nada além de ser imprimidas. 


# Classes

Foram feitas 5 classes e elas estão em seus arquivos específicos. Todas elas seguem o mesmo padrão, entrarei em detalhes apenas na classe App e Transaction pois o exemplo será similar para todas.

Account: contém os métodos e variáveis relacionados à conta debitada.
Payment: contém os métodos e variáveis relacionados ao pagamento.
Statement: contém os métodos e variáveis relacionados ao extrato.
Transaction: contém os métodos e variáveis relacionados à operação.
App: main, realiza a leitura do arquivo e chama utiliza de métodos de outras classes.

# Funcionamento

O




