# SpringFrameWork


## 스프링 웹 개발 기초
- 정적 컨텐츠
- MVC와 템플릿 엔진
- API

## 정적 컨텐츠
- 스프링 부트 정적 컨텐츠 기능
```
<!DOCTYPE HTML>
<html>
<head>
 <title>static content</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
정적 컨텐츠 입니다.
</body>
</html>

```

## MVC와 템플릿 엔진
- MVC: Model, View, Controller
- Model 은 '데이터' 디자인을 담당 ex) 상품 목록, 주문 내역 등
- View 는 '실제로 사용자에게 보이는 페이지' 를 담당한다. ex) .JSP 파일들이 여기에 해당된다.
- Controller 는 사용자의 요청을 받고, 응답을 주는 로직을 담당한다. ex) GET, Post 등의 uri 매핑이 여기에 해당된다.
- 컨트롤러 중에서도, 맨 앞단에서 유저의 유청을 받는 컨트롤러를 프론트 컨트롤러라고 한다.
- 과정: 요청 -> 프론트 컨트롤러 -> 핸들러 매핑 -> 핸들러 어댑터 -> 컨트롤러 -> 로직 수행(서비스) -> 컨트롤러 -> 뷰 리졸버 -> 응답(jsp, html)


## 개발 현황
![h2](https://user-images.githubusercontent.com/49589578/125456970-c58e022b-ae6b-4a2b-891e-104f0a3b7b5d.JPG)
![static](https://user-images.githubusercontent.com/49589578/125456974-27f93350-d77a-41d5-912d-f0da8480824f.JPG)
![1](https://user-images.githubusercontent.com/49589578/125456976-fedf9fef-d819-40f5-8ca2-85c6a0143089.JPG)
![2](https://user-images.githubusercontent.com/49589578/125456977-55fda47d-c8d4-406d-b4d1-df5a03a071d4.JPG)

