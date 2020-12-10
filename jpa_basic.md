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

## JPA와 DB 설정
- 먼저 앞서 생성한 H2와 연결하기위한 Yaml파일을 생성한다
- ![alt](yaml파일.JPG)
- 
- 위의 db와 함께 jpa로 다루기 위한 객체 member를 생성한다.
- ![alt](member.JPG)
- @Entity를 통해 JPA로 다룰 객체라는 것을 명시해 주고, @id, @Generated를 이용하면 DB매핑을 위해 사용함을 알린다.
- 또 lombok을 통해 쉽게 @Getter, @Setter로 접근할 수 있게되었다.

- ![alt](memberRepository.JPG)
- 이제 db에 저장하고 조회할 수 있도록 memberRepository를 생성한다. 
- EntityManager는 JPA로 동작하는데, 스프링부트에서 자동으로 생성되는 것으로 이를 가져와서 사용할 수 있다. 이를 통해 객체들을 다룰 수 있다.
- persist()는 db에 넣을 수 있도록 해주고, find()는 db에서 조회할 수 있도록 해준다. 

- ![alt](멤버연동테스트.JPG)
- 이제 제대로 매핑이 되는지 테스트하기위한 코드를 작성한다. 중요한 점은 @Transactional을 명시해주어야 JPA가 제대로 동작한 다는 것이다.
- 그러나 테스트 케이스에 Transactional이 있으면 성공하여도 rollback을 하기때문에 db에 반영되진않는다.@Rollback(False)를 써주면 반영된다. 

### 쿼리 남기기
- org.hibernate.type: trace를 yml에 추가하기
- 또는 p6spy 라이브러리를 추가