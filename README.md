## MockMvc와 TestRestTemplate 차이점
TestRestTemplate은 Servlet Container를 사용합니다. 그래서 마치 실제 서버가 동작하는 것처럼(물론 몇몇 빈은 Mock 객체로 대체될 수는 있습니다)
테스트를 수행할 수 있습니다. 또한, 테스트를 하는 관점도 서로 다릅니다. 
MockMvc는 서버 입장에서 구현한 API를 통해 비지니스 로직이 문제없이 수행되는지 테스트를 할 수 있다면, 
TestRestTemplate은 클라이언트 입장에서 RestTemplate을 사용하듯이 테스트를 수행할 수 있습니다.