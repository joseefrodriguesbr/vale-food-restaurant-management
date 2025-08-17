# Projeto Final da Disciplina

# Pós-Graduação em Desenvolvimento Mobile e Cloud Computing – Inatel
## Desenvolvimento de Web Services com segurança em Java no Google App Engine

## Projeto Final da Disciplina
Implementação de uma aplicação Spring boot para cadastros de restaurantes;

### 👤 Autor: 
José Enderson Ferreira Rodrigues   
jose.rodrigues@pg.inatel.br, jose.e.f.rodrigues.br@gmail.com

## 📌 Implementação
Microserviço em Java/Spring Boot que expõe um CRUD (create, read, update e delete) para a entidade Restaurant.

## 📌 Repositórios relacionados
### vale-food-auth:
https://github.com/joseefrodriguesbr/vale-food-auth

### vale-food-promo-management:
https://github.com/joseefrodriguesbr/vale-food-promo-management

### vale-food-user-management:
https://github.com/joseefrodriguesbr/vale-food-user-management

## 📌 Detalhamento da solução

### ⚙️ Porta da API: 8081

### ⚙️ Variáveis importantes em application.properties:
```
spring.application.name=vfr
spring.profiles.active=test

vale-food.auth.public.key=MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxbXU19tFxq/ApYNsZTuaNa2zoCJ/XPive7eyrwKJVdKobopg1lpAO0jcIKZy+jtYVo2GIVAAvqeaAS4ipdTfifgmsfM7oIzII4Z+YaDCnrVrXo3yWbIbXB1a6kRYXgrwmp7ev3j/TmX2CPjcAM32kAhF//oRsHVCWrf4LPgCis+c2q41KZFsHCO/ze4VYBtL15jeIuwl9VdUrLz+19+FLLUUyI1S4Yig2rL78MFgnbbyMToJEMZ9dJuUBVVVPMaujtFwrPvG5kMRZ49elV0YDfUojnsf1rstMwPNCwwm1Sb30z+Kb6+RY/2DLZ27bghqa4cl/3Un2sREnWma76ZVNwIDAQAB
vale-food.jwt.custom.issuer=dm111-2025


vale-food.gae.project-id=dm111-vale-food
vale-food.gae.users.topic-name=users
vale-food.gae.users.subscription-name=users-subscription

vale-food.promo.url=http://localhost:8083/valefood/restaurants
vale-food.user.url=http://localhost:8080/valefood/restaurants

server.port=8081

```

### ⚙️ Rotas:

🔐 **Rotas protegidas** (com JWT via AuthController.verificaJWT):  
As rotas abaixo estão dentro do prefixo /estoque, e requerem autenticação JWT.  

🌐 **POST /valefood/restaurants**  
* **Descrição:** Insere uma novo restaurante.  
* **Body esperado(exemplo):**
```
{
    "name":"Restaurante Cozinha da Fazenda",
    "address":"Rua P Vargas",
    "userId":"e5867d22-87af-434e-a3bd-3ecf1d15f8cc",
    "categories":["Carnes"],
    "products":[
        {
       "name":"File",
       "description":"Descrição",
       "category":"Carnes",
       "price":8.45
       },
       {
       "name":"Linguiça",
       "description":"Descrição",
       "category":"Carnes",
       "price":5.45
       }
    ]
}
```

🌐 **PUT /valefood/restaurants/:IdUser**  
* **Descrição:** Atualiza um usuário
* * **Parâmetro de rota:**  
  * **:IdPromocao** : Id do usuário a ser atualizado
* **Body esperado(exemplo):**
```
{
    "name":"Restaurante Cozinha da Fazenda",
    "address":"Rua P Vargas",
    "userId":"abff943a-c356-47d5-ac2b-460a7f4ab956",
    "categories":["Carnes, Bebidas"],
    "products":[
        {
       "name":"File",
       "description":"Descrição",
       "category":"Carnes",
       "price":25.45
       },
       {
       "name":"Linguiça",
       "description":"Descrição",
       "category":"Carnes",
       "price":5.45
       }
    ]
}
```

🌐 **DELETE /valefood/restaurants/:IdUser**  
* **Descrição:** deleta um usuário.
* * **Parâmetro de rota:**  
  * **:IdPromocao** : Id do usuário a ser deletado


🌐 **GET /valefood/restaurants/:IdUser/recommmendedpromotions**  
* **Descrição:** Consulta promoções recomendadas para usuário informado.
* * **Parâmetro de rota:**  
  * **:IdUser** : Id do usuário a filtrar promoções recomendadas de acordo com as preferências 
* **Body esperado(exemplo):**
``` 
[
    {
        "id": "9bf8a0f6-ac52-422a-982d-55284f423d96",
        "name": "Descontos do Feriado",
        "description": "Descontos especiais em pratos selecionados para Feriado!",
        "restaurantId": "Pizzaria",
        "restaurantName": "cad9771d-29e6-4d8c-8dfb-bb678e32d088",
        "product": {
            "productId": "713980f5-2e6f-410a-a064-ea457b3da38e",
            "promotionalPrice": 2.5,
            "category": "Massas",
            "productName": "Macarronada"
        }
    },
    {
        "id": "e04b71e9-343d-4140-828a-cbcf9cc5fde1",
        "name": "Descontos do Final de semana",
        "description": "Descontos especiais em pratos selecionados para Final de semana!",
        "restaurantId": "Restaurante Cozinha da Fazenda",
        "restaurantName": "52a2c945-11d0-40b9-85fd-739f537e02bd",
        "product": {
            "productId": "8974a7c6-7046-40ac-8690-17e4a087b969",
            "promotionalPrice": 1.5,
            "category": "Carnes",
            "productName": "File"
        }
    },
    {
        "id": "2e2db2f4-2cf8-4944-9619-daefce02bbf6",
        "name": "Descontos do Feriado",
        "description": "Descontos especiais em pratos selecionados para Feriado!",
        "restaurantId": "Restaurante Cozinha da Fazenda",
        "restaurantName": "52a2c945-11d0-40b9-85fd-739f537e02bd",
        "product": {
            "productId": "622fc20a-c7c4-4c3a-a266-9845481e69eb",
            "promotionalPrice": 2.5,
            "category": "Carnes",
            "productName": "Linguiça"
        }
    }
]
``` 

🌐 **GET /valefood/restaurants**
* **Descrição:** Lista todos os restaurantes cadastrados
* **Body esperado(exemplo):**
```
[
    {
        "id": "dc9d1385-902a-4986-90f4-071e5b2d6030",
        "name": "Restaurante Cozinha da Fazenda",
        "address": "Rua P Vargas",
        "userId": "abff943a-c356-47d5-ac2b-460a7f4ab956",
        "categories": [
            "Carnes"
        ],
        "products": [
            {
                "id": "cdade893-facd-4b8d-af83-a05c01a734a2",
                "name": "File",
                "description": "Descrição",
                "category": "Carnes",
                "price": 8.45
            },
            {
                "id": "b746f324-f975-4a62-984a-9e371620a82a",
                "name": "Linguiça",
                "description": "Descrição",
                "category": "Carnes",
                "price": 5.45
            }
        ]
    },
    {
        "id": "b166a38b-5c7d-4fb4-995a-6151a046c90d",
        "name": "Pizzaria",
        "address": "Rua Central",
        "userId": "abff943a-c356-47d5-ac2b-460a7f4ab956",
        "categories": [
            "Pizza",
            "Massas"
        ],
        "products": [
            {
                "id": "fbd0d30c-1b2a-4284-8607-92aeae2e0109",
                "name": "Pizza Mussarela",
                "description": "Pizza Mussarela",
                "category": "Pizza",
                "price": 25.0
            },
            {
                "id": "8244402e-6a76-420e-a5c7-823fedcab05a",
                "name": "Macarronada",
                "description": "Macarronada da casa",
                "category": "Massas",
                "price": 34.5
            }
        ]
    }
]
```

🌐 **GET /valefood/restaurants/:IdRestaurant**  
* **Descrição:** Consulta uma usuário por Id.
* * **Parâmetro de rota:**  
  * **:IdRestaurant** : Id do restaurant a ser consultado
* **Body esperado(exemplo):**
```
{
    "id": "dc9d1385-902a-4986-90f4-071e5b2d6030",
    "name": "Restaurante Cozinha da Fazenda",
    "address": "Rua P Vargas",
    "userId": "abff943a-c356-47d5-ac2b-460a7f4ab956",
    "categories": [
        "Carnes"
    ],
    "products": [
        {
            "id": "cdade893-facd-4b8d-af83-a05c01a734a2",
            "name": "File",
            "description": "Descrição",
            "category": "Carnes",
            "price": 8.45
        },
        {
            "id": "b746f324-f975-4a62-984a-9e371620a82a",
            "name": "Linguiça",
            "description": "Descrição",
            "category": "Carnes",
            "price": 5.45
        }
    ]
}
```

## 🛠️ IDE
- **Eclipse IDE for Enterprise Java and Web Developers - Version: 2025-03 (4.35.0) Build id: 20250306-0812**

## 💻 Linguagem
- **Java(Spring Boot)**
