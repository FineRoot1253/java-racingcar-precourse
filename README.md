# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

### 기능 구현 목록
- Model 구현
  - Request
    - 유저 레이서 입력 데이터 모델 (UserCarListRequest)
    - 유저 시도 횟수 입력 데이터 모델 (UserTrialRequest)
  - Response
    - 컴퓨터 레이싱 결과 출력 데이터 모델 (CarRacingResult)
  - Car
    - Car 객체 일급 컬렉션 데이터 모델 (RacingCarList)
    - 레이싱 카 데이터 모델 (Car)
- Service 구현
  - CarRacingService
    - 자동차 경주 로직 수행후 결과를 리턴 (CarRacingService)
- UI 구현
  - 레이싱 입출력 구현 (TrackView)
  - 기본 입출력 구현 (BasicView)