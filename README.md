# Food Ordering System
Microservices with Clean and Hexagonal architectures, DDD, SAGA, Outbox, CQRS, Kafka, Kubernetes & GKE
![image](https://github.com/tutkuince/food-ordering-system/assets/33215575/760a61eb-711f-4d26-93d8-e59314fa2bf6)

## Order Service
![image](https://github.com/tutkuince/food-ordering-system/assets/33215575/3b15622c-0506-4f1b-96f5-1b397372e78f)

## Visualize The Module Dependecy on Order Service
![image](https://github.com/tutkuince/food-ordering-system/assets/33215575/5e7a2c2e-1eaf-4f77-8c79-cdd3250b1da8)

## Designing Order Service Domain Logic Components
![image](https://github.com/tutkuince/food-ordering-system/assets/33215575/98d4c84a-d4c5-487f-883d-837ea8f1bf7a)

## Order State Transitions
![image](https://github.com/tutkuince/food-ordering-system/assets/33215575/2ddde94b-108b-4397-9ec5-05967c373402)

## SAGA Pattern 
SAGA: Distributed long running transactions across services. Used for Long Lived Transactions (LLT).  First invented in a publication on 1987
- Chain of local ACID transactions to finalise a long running transaction across services.
- Compensating transactions: Rollback in case of failure
- Saga Step interface
![image](https://github.com/tutkuince/food-ordering-system/assets/33215575/da46f6e4-71b2-494b-b42e-7958f3782bfd)

## Outbox Pattern
Outbox: Help use of local ACID transactions to let consistent (eventual) distributed transactions.
It will complete SAGA in a safe and consistent way.
Persist events in local database automatically with ACID transaction
Read the events and publish
![image](https://github.com/tutkuince/food-ordering-system/assets/33215575/99a45587-1135-41fa-997a-0fe8fedeeacb)
