# Secure Password 
Desafioda Backend Brasil pode ser acessado no [Github](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md).

O desafio visa  implementar um serviço que valide se uma senha é considerada segura com base em critérios pré-definidos.

## Endpoint
```bash
curl --request POST \
  --url http://localhost:8080/validate-password \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.0.0' \
  --data '{
	"password": ""
}'
```