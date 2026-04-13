# Biblioteca JPA - Atividade Avaliativa

**Alunos:**  
- Ícaro Mac-Culloch  
- Ícaro Farias  

## Estrutura do projeto

- `src/main/java/br/com/biblioteca/model` → Classes JPA (Aluno, Emprestimo)  
- `src/main/java/br/com/biblioteca/dao` → EmprestimoDAO  
- `src/main/java/br/com/biblioteca/test` → TesteEmprestimoDAO  
- `src/main/resources/META-INF/persistence.xml` → Configuração do banco  

## Como executar

1. Criar banco MySQL chamado `biblioteca`  
2. Configurar usuário/senha no persistence.xml  
3. Executar a classe TesteEmprestimoDAO  

## Funcionalidades testadas

- CRUD de empréstimos  
- Busca por ID, todos, por nome do aluno  
