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
