## Recursos utilizados

### Gerenciador de versão do java

[Sdkman](https://sdkman.io/) é um gerenciador de SDK's (Software Development Kit) que pode ser utilizado para instalar diferentes versões do Java e trocar facilmente de uma versão para a outra.
<br>Similar ao NVM para Node.
<br>versão do Java que utilizei: 8.0.422-tem

## Criação do projeto Maven

Recomendo criar um projeto com o Java 8, para não precisar mudar de versão para executar o Randoop e o EvoSuit. Além disso tive algumas dificuldades para gerar testes para pacotes com recursos de versões mais atuais do Java como Records por exemplo.

### versão do Maven utilizada

```bash
$ mvn -version
Apache Maven 3.6.3
```

### Criar projeto Maven simples com o mínimo necessário

```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=demo -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false
```

### Copiar arquivos necessários

Copie o [pom.xml](./pom.xml) desse projeto, alterando de acordo com o seu projeto os atributos de groupId, artifactId e name.
<br>
Copie os arquivos .jar [evosuite-1.0.6.jar](./evosuite-1.0.6.jar) e [randoop-all-4.3.3.jar](./randoop-all-4.3.3.jar) para a raiz do seu projeto.

## Rodando o Randoop

### Compilar e empacotar o projeto

```bash
mvn clean package
```

### Gerar testes com o Randoop para uma classe

```bash
java -Xmx3000m -classpath ./randoop-all-4.3.3.jar:./target/classes randoop.main.Main gentests --testclass=com.example.Conta --output-limit=100 --junit-output-dir=./src/test/java --junit-package-name=com.example
```

### Gerar testes com o Randoop para um pacote

```bash
java -Xmx3000m -classpath ./randoop-all-4.3.3.jar:./target/classes randoop.main.Main gentests --test-package=com.example --output-limit=100 --junit-output-dir=./src/test/java --junit-package-name=com.example
```

### executar testes gerados

```bash
mvn test
```

### Consultar documentação para adicionar novas flags

https://randoop.github.io/randoop/manual/index.html#command-line-options

## Rodando o EvoSuite

### Compilar e empacotar o projeto

```bash
mvn clean package
```

### Gerar testes com o EvoSuite para uma classe

```bash
java -jar ./evosuite-1.0.6.jar -class com.example.Conta -projectCP ./target/classes
```

### Gerar testes com o EvoSuite para um pacote

```bash
java -jar ./evosuite-1.0.6.jar -prefix com.example -projectCP ./target/classes
```

### Copiar testes gerados para diretório de testes do projeto

```bash
find ./evosuite-tests/com/example -type f -name "*.java" -exec cp {} ./src/test/java/com/example/ \;
```

### executar testes gerados

```bash
mvn test
```
