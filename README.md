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

### Requisitos atendidos:
✅ **Serviço de Restaunt expondo API que exibe suas respectivas promoções (Novo Requisito)**

✅ CRUD (create, read, update e delete) para a entidade Promotion

✅ Operações expostas via REST seguindo os padrões HTTP para request e response

✅ Rotas do CRUD exigindo o token gerado pelo auth

✅ Projeto seguindo o padrão de rotas e controllers para as operações

## 📌 Repositórios relacionados necessários para a execução
### vale-food-auth:
https://github.com/joseefrodriguesbr/vale-food-auth

### vale-food-promo-management:
https://github.com/joseefrodriguesbr/vale-food-promo-management

### vale-food-user-management:
https://github.com/joseefrodriguesbr/vale-food-user-management

## 📌 Detalhamento da solução

### ⚙️ Porta da API: 8081

### ⚙️ APIs para comunicação externa e cache:
```
vale-food.promo.url=http://localhost:8083/valefood/restaurants
vale-food.user.url=http://localhost:8080/valefood/restaurants
```

### ⚙️ Rotas:

🔐 **Rotas protegidas**:  
As rotas abaixo requerem autenticação JWT.  

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

🌐 **PUT /valefood/restaurants/:IdRestaurant**  
* **Descrição:** Atualiza um restaurante
* * **Parâmetro de rota:**  
  * **:IdRestaurant** : Id do restaurante a ser atualizado
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

🌐 **DELETE /valefood/restaurants/:IdRestaurant**  
* **Descrição:** deleta um restaurante.
* * **Parâmetro de rota:**  
  * **:IdRestaurant** : Id do restaurante a ser deletado


🌐 **GET /valefood/restaurants/52a2c945-11d0-40b9-85fd-739f537e02bd/promotions**  
* **Descrição:** Consulta promoções cadastradas para um restaurante.
* * **Parâmetro de rota:**  
  * **:IdUser** : Id do restaurante a consultar promoções
* **Resposta esperada(exemplo):**
``` 
[
    {
        "id": "e9203869-da78-4e09-8237-8c9bbc7aeb60",
        "name": "Descontos do Feriado",
        "description": "Descontos especiais em pratos selecionados para Feriado!",
        "restaurantId": "52a2c945-11d0-40b9-85fd-739f537e02bd",
        "restaurantName": "Restaurante Cozinha da Fazenda",
        "product": {
            "productId": "622fc20a-c7c4-4c3a-a266-9845481e69eb",
            "promotionalPrice": 2.5,
            "category": "Carnes",
            "productName": "Linguiça"
        }
    },
    {
        "id": "06bb002f-1f64-486d-a5e3-4e5f30b26983",
        "name": "Descontos do Final de semana",
        "description": "Descontos especiais em pratos selecionados para Final de semana!",
        "restaurantId": "52a2c945-11d0-40b9-85fd-739f537e02bd",
        "restaurantName": "Restaurante Cozinha da Fazenda",
        "product": {
            "productId": "8974a7c6-7046-40ac-8690-17e4a087b969",
            "promotionalPrice": 1.5,
            "category": "Carnes",
            "productName": "File"
        }
    }
]
``` 

🌐 **GET /valefood/restaurants**
* **Descrição:** Lista todos os restaurantes cadastrados
* **Resposta esperada(exemplo):**
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
* **Descrição:** Consulta uma restaurante por Id.
* * **Parâmetro de rota:**  
  * **:IdRestaurant** : Id do restaurant a ser consultado
* **Resposta esperada(exemplo):**
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
