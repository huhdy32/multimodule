# multimodule
멀티 모듈 설계 이야기 with Spring, Gradle

https://techblog.woowahan.com/2637/


전체 API를 포함하여 모놀리식 실행 : 
```./gradlew :api:bootRun```

계졍 관련 API 만 실행 
```./gradlew :api-account:bootRun```

board 관련 API만 실행
```./gradlew :api-board:bootRun```

새로운 도메인이 생길때마다, 하위 도메인 모듈을 의존하고, 조합함으로써 프로젝트 고도화