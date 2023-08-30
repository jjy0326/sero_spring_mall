# sero_spring_mall
4번째 미니 프로젝트

## ✨ 목표
기존의 코드를 SPRING으로 변환
git branch 사용하여 협업

## ✨ 역할 분담
### 1. 전준형 - Product, Mainpage, Admin
![mainpage](https://github.com/jjy0326/sero_spring_mall/assets/102834723/ba1d4538-2d9d-4bca-af66-e98b9ad86398) <br>
![adminorder](https://github.com/jjy0326/sero_spring_mall/assets/102834723/6bb7492d-e3b7-4dce-af33-acbc3ddca7b2) <br>
![admi4](https://github.com/jjy0326/sero_spring_mall/assets/102834723/2c34c251-0a16-4725-b6c1-55abd2d21ebc) <br>
### 2. 김효경 - Member
![login](https://github.com/jjy0326/sero_spring_mall/assets/102834723/7bb16ac4-f1ca-407e-bd73-336d83fa8b67)
### 3. 명원식 - Admin
![admin1](https://github.com/jjy0326/sero_spring_mall/assets/102834723/8a71ebf2-9f41-4c33-ba07-382d7fa7f4d1) <br>
![admin2](https://github.com/jjy0326/sero_spring_mall/assets/102834723/ade04f7c-f206-438b-bb11-a065c7b14336)
### 4. 문효주 - Mypage, QnA
![qna_mypage](https://github.com/jjy0326/sero_spring_mall/assets/102834723/54d65941-5788-415d-a9b9-cfd2ae52c1dc)

## ✨ 기존 코드와 달라진 점
### 1. Mybatis 사용하면서 DAO쪽 코드가 간결해짐
#### pom.xml
![mybatis](https://github.com/jjy0326/sero_spring_mall/assets/102834723/1afc177e-3e92-4d14-ad6a-5ebc712052c1)
#### jdbc.properties
![properties](https://github.com/jjy0326/sero_spring_mall/assets/102834723/f9bce6e5-46ca-4d79-8354-dccdf9216fab)
#### 기존 코드
![originaldao](https://github.com/jjy0326/sero_spring_mall/assets/102834723/2305a81a-33c9-4936-8ecc-4419a180fafd)
#### Mybatis 사용한 코드
![modifycode](https://github.com/jjy0326/sero_spring_mall/assets/102834723/be4ff49d-0d39-4901-b5ee-03de3b1c5aad)
### 2. 애너테이션(@) 사용
![annotation](https://github.com/jjy0326/sero_spring_mall/assets/102834723/516af7b6-d659-4ba8-bf0c-a2bc9ce79f58)
### 3. System.out.println() 대신 로그 사용
![log](https://github.com/jjy0326/sero_spring_mall/assets/102834723/01202fb7-2bf3-47d9-9cbe-8ae14c7ce4a9)
#### 콘솔 창
![log_result](https://github.com/jjy0326/sero_spring_mall/assets/102834723/8278e1d2-5acc-4911-8ca9-48ea2fb28672)

## ✨ 아쉬운 점
#### 1. 깃을 충분히 공부하지 못해 깃으로 인해 발생한 오류 해결에 많은 시간을 소요함
#### 2. 익숙하지 않은 쿼리로 인해 어려움을 겪음
![sql error](https://github.com/jjy0326/sero_spring_mall/assets/102834723/672eefb8-070e-4d01-8c81-2ef34fc19d33)
#### 3. 시간이 부족하여 @ResponseBody 와 @RestController를 사용하여 RESTful한 코드를 만들지 못해 아쉬움 
