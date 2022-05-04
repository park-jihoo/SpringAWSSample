1. CRUD
   1. Web Layer
      1. 흔히 사용하는 Controller, JSP 등의 뷰 템플릿 영역
      2. 필터, 인터셉터, 컨트롤러 어드바이스 등 외부 요청과 응답에 대한 전반적인 영역을 이야기
   2. Service Layer
      1. @Service에 사용되는 서비스 영역
      2. Controller과 Dao의 중간 영역에서 이용됨
      3. @Transactional이 사용됨
   3. Repository Layer
      1. Database와 같은 데이터 저장소에 접근하는 영역
      2. DAO 영역이라고 이해하면 쉬움
   4. Dtos
      1. Dto(Data Transfer Object)는 계층 간의 데이터 교환을 위한 객체이며 Dtos는 이들의 영역을 의미
      2. 뷰 템플릿에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체 등이 이를 이야기함
   5. Domain Model
      1. 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화시킨 것
      2. @Entity가 사용된 영역을 도메인 모델이라고 함
      3. 데이터베이스의 테이블과 관계있을 필요는 없음
      4. VO와 같은 값 객체들도 이에 해당함