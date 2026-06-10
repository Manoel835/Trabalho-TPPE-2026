# Trabalho Prático 1

## Integrantes da Equipe

| Matrícula | Aluno |
| :-------: | :--- | 
| 222024283 | Caio Mesquita |
| 202016266 | Gabriel Marques de Souza |
| 211041240 | Manoel Felipe Teixeira |
| 180100271 | Emivalto da Costa | 
| 211031870 | Vinicius Eduardo Muniz |

## Sobre o Projeto

Este projeto é referente ao **Trabalho Prático 1** da disciplina de Técnicas de Programação para Plataformas Emergentes (TPPE) da Universidade de Brasília (UnB). 

O objetivo principal do sistema é realizar a **curadoria e deduplicação de dados em repositórios de informações científicas**. Em cenários reais, a integração de dados de diferentes indexadores e fontes autodeclaratórias acaba gerando duplicidades e inconsistências nas representações dos autores. Este projeto resolve esse problema unificando os registros para um "padrão-ouro".

O desenvolvimento do código e das validações é feito estritamente utilizando a técnica de **Test-Driven Development (TDD)**.

### Objetivos Específicos e Casos de Tratamento
A aplicação implementa os testes unitários e a lógica de unificação para resolver os 5 casos principais de inconsistência de registros:

-  **Caso 1:** Correção de diferenças tipográficas e de grafia (ex: padronização de acentuação e caracteres como apóstrofos).
-  **Caso 2:** Unificação de ocorrências de "sobrenome + iniciais" (com ou sem ponto) para a versão do nome completo do autor.
-  **Caso 3:** Restauração das partículas "de" quando omitidas e padronização do uso de pontos em abreviações opcionais.
-  **Caso 4:** Desmembramento de iniciais agrupadas junto ao sobrenome, prevalecendo sempre a forma extensa do nome.
-  **Caso 5:** Agrupamento de registros com IDs diferentes para o mesmo autor, utilizando sempre o ID de menor valor como identificador único na deduplicação.
