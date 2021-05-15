## MockMvc와 TestRestTemplate 차이점
- TestRestTemplate은 Servlet Container를 사용합니다. 그래서 마치 실제 서버가 동작하는 것처럼(물론 몇몇 빈은 Mock 객체로 대체될 수는 있습니다)
테스트를 수행할 수 있습니다. 또한, 테스트를 하는 관점도 서로 다릅니다.
MockMvc는 서버 입장에서 구현한 API를 통해 비지니스 로직이 문제없이 수행되는지 테스트를 할 수 있다면,
TestRestTemplate은 클라이언트 입장에서 RestTemplate을 사용하듯이 테스트를 수행할 수 있습니다.

## @DataJpaTest 
- 어노테이션은 JPA 관련 테스트 설정만 로드합니다. DataSource의 설정이 정상적인지, JPA를 사용하여 데이터를 제대로 생성, 수정, 삭제하는지 등의 테스트가 가능합니다. 그리고 가장 좋은점은.. 무려 내장형 데이터베이스를 사용하여 실제 데이터베이스를 사용하지 않고 테스트 데이터베이스로 테스트할 수 있는.. 개꿀같은 장점이 있습니다.

## @TestEntityManager
- JPA 테스트를 하기위한 대안으로써, 엔티티매니저의 기본적인 메소드를 제공함과 동시에 테스트하기 유용하다. 또한 헬퍼 메소드를 제공하는데 그에 따른 내용은 persist(), flush(), find() 등 이 존재한다.
  https://pasudo123.tistory.com/348