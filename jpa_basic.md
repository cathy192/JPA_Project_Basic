# 프로젝트 생성
- start.io로 프로젝트 생성
- ![alt](프로젝트생성.JPG)

## Lombok 추가
- Preferences -> plugin에서 롬복 설치 
- 임의의 테스트 클래스 만들고 @Getter, @Setter로 동작 확인
- ![alt](롬복hello.JPG)
- ![alt](helloMain.JPG)

## View 환경 설정

### Thypleaf
- 요즘 jpa 대신 프리마커, 그루비, thymleaf를 씀
- Thypleaf 장점
  - 마크업을 깨지 않고 그대로 사용 가능
  - 웹브라우저에 바로 열림
- thypleaf 단점
  - 태그를 정확히 닫아주지 않으면 에러가 났으나 3.0으로 업그레이드 되고 개선됨
  - 메뉴얼을 보고 해야하는 단점이 있으나 익숙해지면 편함

### View 테스트(랜더링)

- ![alt](helloController.JPG)
- return에 쓰여있는 "hello"는 자동으로 hello.html과 매핑됨
- data에 "Hello!"값을 넘긴다는 의미
- 
- ![alt](hello_html.JPG)
- 순수한 자바로 돌리면 "안녕하세요. 손님"이 출력되겠지만 Tomcat으로 돌리면 HelloController에서 값이 넘어와서 "안녕하세요. Hello!" 로 출력이 된다. 
  
- ![alt](Hello!.JPG)
- 위 기능은 스프링 부트 thymleaf가 실행하는 기능. 

- 정적 컨텐츠는 static에 넣어두고 랜더링할 컨텐츠는 templates에 넣어주는게 좋다.  
  
- 그런데 한번 랜더링 된 상태에서 hello.html을 고쳐도 잘 안바뀐다. 이럴 때는 gradle에 라이브라리 devtools를 추가해준다.
- ![alt](devtools.JPG)

### JPA와 DB 설정
- 
