# Commit Message Convention
> 커밋 작성 시 해당 문서를 참고 바람
## Commit Message Structure
    commit type: subject //제목 --require
    
    body // 본문 --optional
    
    footer //꼬리말 --optional

* commit type: 어떤 의도로 커밋했는지를 명시 (ex. feat, fix...)
* subject: 코드 변경사항에 대한 짧은 요약
* body: 상세한 설명이 필요한 경우 작성
* footer: issue tracker id를 작성하고 싶은 경우 작성

## Commit type(필수 작성)

### 자주 사용하는 태그
* Feat : 새로운 기능을 추가하는 경우
* Fix : 버그를 고친경우
* Docs : 문서를 수정한 경우
* Style : 코드 포맷 변경, 세미콜론 누락, 코드 수정이 없는경우
* Refactor : 코드 리펙토링
* Test : 테스트 코드. 리펙토링 테스트 코드를 추가했을 때
* Chore : 빌드 업무 수정, 패키지 매니저 수정
* Design : CSS 등 사용자가 UI 디자인을 변경했을 때
* Rename : 파일명(or 폴더명) 을 수정한 경우
* Remove : 코드(파일) 의 삭제가 있을 때. "Clean", "Eliminate" 를 사용하기도 함

### 기타 태그 타입
* Add : 코드나 테스트, 예제, 문서등의 추가 생성이 있는경우- Improve : 향상이 있는 경우. 호환성, 검증 기능, 접근성 등이 될수 있습니다.
* Implement : 코드가 추가된 정도보다 더 주목할만한 구현체를 완성시켰을 때
* Move : 코드의 이동이 있는경우
* Updated : 계정이나 버전 업데이트가 있을 때 사용. 주로 코드보다는 문서나, 리소스, 라이브러리등에 사용합니다.
* Comment : 필요한 주석 추가 및 변경

## Subject(필수 작성)
> 영어로 작성하며 동사 원형을 시작으로 작성한다.
> 대문자로 시작한다.
> 마침표 및 특수기호는 사용하지 않는다.
> 짧고 간결하게 작성한다.

ex) add getMember method to Member class

## 본문(선택 사항)
> 한글로 작성하며 변경 이유를 상세히 설명한다.

## 꼬리말(선택사항)
> 이슈 번호를 넣을 때 사용

## 예시
    Feat: Add getMember method to Member class
    
    사용자 조회 기능을 위해 getMember 메서드를 Member class에 추가
    
    DO-1324