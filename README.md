# Logus Retail Challenger
API Restful, criação de usuário

## Primeiros passos
Ao baixar o projeto, adicione ele a uma pasta e rode a ide apartir dessa pasta, para que o arquivo .metadatas possa ser criado.

## Corpo da requisição
Exemplo para criar um usuário novo.
O campos isDisabled foi feito imaginando que o front teria uma opção para selecionar se a conta está desabilitada,
se ele for como false ou sem a proprieda, a data de desativação ficará null, se ela for true, irá adicionar a data atual no banco.
```json
{
  "dcrUsuario": "Date",
  "dcrLogin": "LoginFosur",
  "dcrSenha": "meikai@1",
  "isDisabled": false
}
```

Adicione usuario e senha do banco de dados no .yml.


