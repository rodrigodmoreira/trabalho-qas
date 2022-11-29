# Sistema Honest Guides
Alunos:
- Rodrigo Dias Moreira
- Vitor Gomes Soares Lins Peixoto

O software tem por objetivo gerenciar relatórios e estatísticas de compatibilidade de jogos no Linux. Os usuários têm cadastro livre, com permissões para criar novos registros de jogos/relatórios/guias de instalação; categorizar e buscar jogos/relatórios/guias por plataforma de venda; ferramenta de compatibilização; nível de compatibilidade; versão/distribuição Linux.

## Especificação
A especificação completa do sistema criada na primeira etapa do trabalho pode ser acessada [aqui](https://docs.google.com/document/d/1cvXNU5HCZ3ZN7apiE12uJ2RJHAedvBXSu_MZwSucGS8/edit).

## Desenho
O diagrama criado na etapa de desenho do sistema pode ser acessado [aqui](https://app.diagrams.net/#G1KxdwhpijJXzY2_Z0ExcMEq6OAmqaPoJt).

## Implementação
O sistema foi implementado dentro dos pacotes ``model`` e ``repositories``. A classe ``Main`` oferece métodos que 
simulam comportamentos da aplicação para simplificar os testes e o entendimento de cada funcionalidade. Ao executá-la, 
uma sequência de exemplos das funcionalidades do sistema serão executados e os resultados serão impressos na saída padrão.