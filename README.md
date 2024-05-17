# Balanceamento de carga do lado do cliente com Spring Cloud LoadBalancer.

Processo de criação de microsserviços com balanceamento de carga.

Aplicativo de microsserviço que usa Spring Cloud LoadBalancer para fornecer balanceamento de carga do lado do cliente em chamadas para outro microsserviço.

# Testando o balanceador de carga

A listagem a seguir mostra como executar o serviço `api-say-hello` com Maven:

```shell
mvn spring-boot:run
```
Para obter balanceamento de carga, você precisa de dois servidores executando instâncias separadas do mesmo aplicativo. Você pode conseguir isso executando uma segunda instância do serviço `api-say-hello` em uma porta diferente. Usamos a porta `8191` para este exemplo.

Para fazer isso com o Maven, abra um novo terminal e execute os seguintes comandos:

```shell
export SERVER_PORT=8191
mvn spring-boot:run
```

```shell
export SERVER_PORT=8192
mvn spring-boot:run
```

```shell
export SERVER_PORT=8193
mvn spring-boot:run
```

Então você pode iniciar o serviço `api-user`. Neste ponto, você deve ter três terminais: dois para duas instâncias `api-say-hello` e um para `api-user`. Então você pode acessar [localhost:8881/hi](localhost:8881/hi) e observar as instâncias `api-say-hello`.

Suas solicitações ao serviço `api-user` devem resultar em chamadas distribuídas pelas instâncias `api-say-hello` em execução no modo round-robin.

# Teste

Para executar os testes, execute `test.sh`. Serão executados 10 interações.

Para aumentar as interações, passar por parâmetro: `test.sh 100`
