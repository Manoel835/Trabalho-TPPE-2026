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



## Tecnologias Utilizadas

Para atender aos requisitos da disciplina, este projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Linguagem Orientada a Objetos:** Java (Compatível com Java 8 ou superior)
- **Framework de Testes Unitários:** JUnit 5 (Jupiter) — versão 5.14.3
- **Ambiente/IDE Padrão:** Eclipse IDE (Projeto contém os arquivos nativos `.classpath` e `.project`)

---

## ⚙️ Instruções de Execução dos Testes

A execução é feita de forma nativa pela IDE. Recomendamos o uso do **Eclipse IDE** para a melhor experiência "plug and play".

### Executando pelo Eclipse (Recomendado)

1. Clone este repositório para a sua máquina local:

   git clone [https://github.com/Manoel835/Trabalho-TPPE-2026](https://github.com/Manoel835/Trabalho-TPPE-2026)
   
3. Abra o Eclipse e vá no menu **File** > **Import...**
4. Na janela que abrir, expanda a pasta **General** e selecione **Existing Projects into Workspace**. Clique em *Next*.
5. Em *Select root directory*, clique em **Browse...**, selecione a pasta raiz do projeto clonado e clique em **Finish**. O Eclipse fará a configuração automaticamente lendo o arquivo `.classpath`.
6. **Para rodar todos os casos de uma vez (recomendado):** no *Package Explorer*, abra a pasta `test` > pacote `br.unb.tppe` e clique com o botão direito na classe de suíte **`AllTests.java`**.
7. Selecione **Run As** > **JUnit Test**.
8. Uma aba do JUnit se abrirá com o título *"Deduplicacao de Autores - Todos os Casos"*, executando os testes dos 5 casos (`caso1` a `caso5`) e exibindo a barra verde que confirma o sucesso das validações.

> Alternativamente, é possível rodar individualmente cada classe de teste (ou a pasta `test` inteira) via **Run As > JUnit Test**.

