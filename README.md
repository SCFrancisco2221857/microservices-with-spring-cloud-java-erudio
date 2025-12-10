# microservices-with-spring-cloud-java-erudio

## Exchange Service database configuration

The `exchange-service` now ships with sensible defaults so it can start even if
`SPRING_DATASOURCE_*` variables are not provided. It will use the following
values unless they are overridden via environment variables:

- `SPRING_DATASOURCE_URL`:
  `jdbc:mysql://localhost:3306/exchange_service?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&enabledTLSProtocols=TLSv1.2`
- `SPRING_DATASOURCE_USERNAME`: `docker`
- `SPRING_DATASOURCE_PASSWORD`: `admin123`

When deploying to Kubernetes you can override these values with `kubectl`:

```bash
kubectl set env deployment/exchange-service \
  SPRING_DATASOURCE_URL="jdbc:mysql://<db-host>:3306/exchange_service?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&enabledTLSProtocols=TLSv1.2" \
  SPRING_DATASOURCE_USERNAME="docker" \
  SPRING_DATASOURCE_PASSWORD="admin123"
```

This avoids connection errors caused by missing credentials or JDBC parameters
when the deployment is first created.

## Como publicar e iniciar o Kubernetes rapidamente

1. **Garanta que o cluster está ativo** (Kind, Minikube ou outro):
   ```bash
   kubectl cluster-info
   kubectl get nodes
   ```

2. **Remova implantações/serviços antigos**, se existirem (evita o erro de recurso já existente):
   ```bash
   kubectl delete deployment exchange-service --ignore-not-found
   kubectl delete service exchange-service --ignore-not-found
   ```

3. **Crie a nova implantação** usando a imagem publicada:
   ```bash
   kubectl create deployment exchange-service --image=scfrancisco/exchange-service:kube-v1
   ```

4. **Configure variáveis de ambiente do banco** (ajuste host/credenciais conforme seu MySQL):
   ```bash
   kubectl set env deployment/exchange-service \
     SPRING_DATASOURCE_URL="jdbc:mysql://<ip-do-mysql>:3306/exchange_service?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&enabledTLSProtocols=TLSv1.2" \
     SPRING_DATASOURCE_USERNAME="docker" \
     SPRING_DATASOURCE_PASSWORD="admin123"
   ```

5. **Exponha a aplicação** com um Service do tipo `LoadBalancer`:
   ```bash
   kubectl expose deployment exchange-service --type=LoadBalancer --port=8000
   ```

6. **Acompanhe o rollout e logs** para validar se subiu corretamente:
   ```bash
   kubectl rollout status deployment/exchange-service
   kubectl logs -l app=exchange-service -f
   ```

> Se ocorrer erro de conexão com o banco, confirme se o host/IP do MySQL está
> acessível do cluster e se a porta 3306 está liberada.
